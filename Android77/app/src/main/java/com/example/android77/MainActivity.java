package com.example.android77;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Environment;
import android.view.View;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    //  public class storage {

    // FORWARD MOVE, BACK MOVE READING FUNCTIONS FOR REPLAY   -- READ
    // RECORDING MOVES, REVERT FOR CURRENT GAME               -- WRITE

    public static final String DIR = "";
    public static class utility {
        public static int compareDates(String x, String y) {
            // MM/DD/YYYY
            // return: -1 less than, 1 greater than, 0 equal
            if(x.compareTo(y) == 0) return 0;
            int x_mm = Integer.parseInt(x.substring(0, 2));
            int x_dd = Integer.parseInt(x.substring(3, 5));
            int x_yy = Integer.parseInt(x.substring(6, 10));
            int y_mm = Integer.parseInt(y.substring(0, 2));
            int y_dd = Integer.parseInt(y.substring(3, 5));
            int y_yy = Integer.parseInt(y.substring(6, 10));
            boolean mm_greater = y_mm < x_mm;
            boolean dd_greater = y_dd < x_dd;
            boolean yy_greater = y_yy < x_yy;
            boolean mm_equals = y_mm == x_mm;
            boolean yy_equals = y_yy == x_yy;
            if(yy_equals) {
                if(mm_equals) {
                    if(dd_greater) return 1;
                    else return -1;
                }
                if(mm_greater) return 1;
                return -1;
            }
            if(yy_greater) return 1;
            return -1;
        }
        public static ArrayList<saved_game> insertByDate(boolean G2L, ArrayList<saved_game> initial, saved_game insert) {
            //System.out.println("INSERTING " + insert.getName());
            int initial_length = initial.size();
            if(initial_length == 0) {
                initial.add(0, insert);
                //     System.out.println("INSERTING " + insert.getName() + " AT INDEX 0");
                return initial;
            }
            int mode = 1;
            if(!G2L) mode = -1;
            for(int index = 0; index < initial_length; index++) {
                int comparison = compareDates(initial.get(index).getDate(), insert.getDate());
                if(comparison == mode) {
                    initial.add(index, insert);
                    //   System.out.println("INSERTING " + insert.getName() + " AT INDEX " + index);
                    break;
                }
                if(index == initial_length - 1) initial.add(insert);
            }
            return initial;

        }
        public static ArrayList<saved_game> sortDate(ArrayList<saved_game> x, boolean G2L) {
            ArrayList<saved_game> new_list = new ArrayList<saved_game>();
            int length = x.size();
            for(int i = 0; i < length; i++) {
                new_list = insertByDate(G2L, new_list, x.get(i));
            }
            return new_list;
        }

        public static int compareStrings(String x, String y) {
            int x_len = x.length();
            int y_len = y.length();
            int size = 0;
            if(x_len < y_len) size = x_len;
            else size = y_len;
            for(int i = 0; i < size; i++) {
                String sub_x = x.substring(i, i + 1);
                String sub_y = y.substring(i, i + 1);
                int compare = sub_x.compareTo(sub_y);
                if(compare == 0) continue;
                boolean same_letter = (sub_x.toLowerCase().compareTo(sub_y.toLowerCase()) == 0);
                if(!same_letter) {
                    String sub_x_low = sub_x.toLowerCase();
                    String sub_y_low = sub_y.toLowerCase();
                    int lower_compare = sub_x_low.compareTo(sub_y_low);
                    if(lower_compare < 0) return -1;
                    if(lower_compare > 0) return 1;
                }
            }
            if(x_len == y_len) return 0;
            if(x_len < y_len) return 1;
            return -1;
        }
        public static ArrayList<saved_game> insertByName(boolean G2L, ArrayList<saved_game> initial, saved_game insert) {
            // System.out.println("INSERTING " + insert.getName());
            int length = initial.size();
            if(length == 0) {
                initial.add(0, insert);
                //  System.out.println("AUTO INSERTING " + insert.getName() + " AT INDEX 0");
                return initial;
            }
            int mode = 1;
            if(G2L) mode = -1;
            for(int i = 0; i < length; i++) {
                int comparison = compareStrings(insert.getName(), initial.get(i).getName());
                //   System.out.println("COMPARISON RESULT FOR INDEX " + i + ": " + comparison);
                if(comparison == mode) {
                    initial.add(i, insert);
                    //   System.out.println("INSERTING " + insert.getName() + " AT INDEX " + i);
                    break;
                }
                if(i == length - 1) {
                    initial.add(insert);
                    //  System.out.println("INSERTING AT LAST INDEX: " + insert.getName() + ", AT INDEX " + (initial.size() - 1));
                }
            }
            return initial;
        }
        public static ArrayList<saved_game> sortName(ArrayList<saved_game> x, boolean G2L) {
            ArrayList<saved_game> new_list = new ArrayList<saved_game>();
            int length = x.size();
            for(int i = 0; i < length; i++) {
                new_list = insertByName(G2L, new_list, x.get(i));
            }
            return new_list;
        }

        public boolean exists(ArrayList<saved_game> list, saved_game x) {
            return list.contains(x);
        }
    }

    public static class saved_game extends utility implements Serializable { // object that is passed to game screen
        String name, date;
        public ArrayList<String> moves = new ArrayList<String>();
        int move_index = 0;
        boolean start, end;

        public saved_game(String name, ArrayList<String> moves) {
            this.name = name;
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            this.date = formatter.format(date); // MM/DD/YYYY
            this.moves.addAll(moves); // [xy,xy:wN] - 10
            this.move_index = 0;
            this.start = true;
            this.end = false;
            if(this.moves.size() == 1) this.end = true;
        }

        public saved_game(String name, String date, ArrayList<String> moves) {
            this.name = name;
            this.date = date; // MM/DD/YYYY
            this.moves.addAll(moves); // [xy,xy:wN] - 10
            this.move_index = 0;
            this.start = true;
            this.end = false;
            if(this.moves.size() == 1) this.end = true;
        }

        public String getName() {
            return this.name;
        }
        public String getDate() {
            return this.date;
        }
        public ArrayList<String> getMoves() {
            return moves;
        }

        public int getStartX() {
            return Integer.parseInt(this.moves.get(move_index).substring(1, 2));
        }
        public int getStartY() {
            return Integer.parseInt(this.moves.get(move_index).substring(2, 3));
        }
        public int getFinalX() {
            return Integer.parseInt(this.moves.get(move_index).substring(4, 5));
        }
        public int getFinalY() {
            return Integer.parseInt(this.moves.get(move_index).substring(5, 6));
        }
        public String getDeleted() { //[xy,xy:"",xy]
            return this.moves.get(move_index).substring(7, 9);
        }
        public int getDeletedX() {
            return Integer.parseInt(this.moves.get(move_index).substring(10, 11));
        }
        public int getDeletedY() {
            return Integer.parseInt(this.moves.get(move_index).substring(11, 12));
        }
        public String getPromotion(){
            return this.moves.get(move_index).substring(13,14);
        }
        public String getMove() {
            return this.moves.get(move_index);
        }

        public boolean incrementMove() {
            if(this.end) return false;
            boolean status = true;
            if(this.move_index == this.moves.size() - 1) {
                status = false;
                this.end = true;
            } else {
                this.start = false;
            }
            this.move_index++;
            return status;
        }
        public boolean decrementMove() {
            if(this.start) return false;
            if(this.move_index == 0) {
                this.start = true;
                return false;
            }
            this.end = false;
            this.move_index--;
            return true;
        }
        public void resetMove() {
            this.move_index = 0;
            this.start = true;
            this.end = false;
            if(this.moves.size() == 1) this.end = true;
        }

        public String toString() {
            return "[" + this.getDate() + "]  " + this.getName();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView scrollForMore = findViewById(R.id.scrollForMore);

        ListView listview = (ListView) findViewById(R.id.SAVED_GAMES);

        String path = "/data/data/com.example.android77/FileStorage";

        ArrayList<String> files = null;
        File file = new File(path);
        try{
            if(file.mkdir()) {
                System.out.println("Directory created");
            } else {
                System.out.println("Directory is not created");
            }
//            ArrayList<String> files = new ArrayList<String>(Arrays.asList(file.list()));
            files = new ArrayList<String>(Arrays.asList(file.list()));
            if(files.size() > 4){
                scrollForMore.setText("Scroll For More");
            }

        }catch (NullPointerException e){

        }catch(Exception e){
            e.printStackTrace();
        }

        ArrayList<String> moves;
        saved_game test;
        Scanner scanner = null;
        int i = 0;
        ArrayList<saved_game> saved_games = new ArrayList<saved_game>();

        for (String scanFile : files) {
            try {
//                scanner = new Scanner(new File(path + "/" + files.get(i)));
                scanner = new Scanner(new File(path + "/" + scanFile));

                moves = new ArrayList<String>();

                while (scanner.hasNext()) {
                    moves.add(scanner.next());
                }

                String name = moves.get(0);
                moves.remove(0);
                String date = moves.get(0);
                moves.remove(0);

                test = new saved_game(name, date, moves);

                saved_games.add(test);

                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            i++;
        }

        System.out.println("This is the saved game"+ saved_games);
      //  ListView listview = (ListView) findViewById(R.id.SAVED_GAMES);
        ArrayAdapter<saved_game> saved_adapter = new ArrayAdapter<saved_game>(this, android.R.layout.simple_list_item_1, saved_games);
        listview.setAdapter(saved_adapter);
        saved_adapter.notifyDataSetChanged();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // FORMAT IS: [xy,xy:""]
                //ArrayList<saved_game> = ;//
                rewindGame((saved_game) listview.getItemAtPosition(i));
            }
        });

/////////////////////////////////////////////////////////////////////////////////////////
//        ArrayList<saved_game> saved_games = new ArrayList<saved_game>();
//        ArrayList<String> moves = new ArrayList<String>();
//        moves.add("[41,43:'',88]");
//        moves.add("[67,75:'',88]");
//        moves.add("[30,63:'',88]");
//        moves.add("[75,63:wQ,63]");
//        saved_game test = new saved_game("tester_name", moves);
//        saved_games.add(test);
//        ListView listview = (ListView) findViewById(R.id.SAVED_GAMES);
//        ArrayAdapter<saved_game> saved_adapter = new ArrayAdapter<saved_game>(this, android.R.layout.simple_list_item_1, saved_games);
//        listview.setAdapter(saved_adapter);
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                // FORMAT IS: [xy,xy:""]
//                //ArrayList<saved_game> = ;//
//                rewindGame((saved_game) listview.getItemAtPosition(i));
//            }
//        });

/////////////////////////////////////////////////////////////////////////////////////////////

    }

    /*
    public ArrayList<String> moves = new ArrayList<>();
    public void saveGame() {
           String file_name;
    }
*/

    public void sortList(View v) {
        CheckBox AtoZ = findViewById(R.id.AtoZ);
        CheckBox ZtoA = findViewById(R.id.ZtoA);
        CheckBox earliestDate = findViewById(R.id.earliestDate);
        CheckBox latestDate = findViewById(R.id.latestDate);

        boolean AtoZ_check = AtoZ.isChecked();
        boolean ZtoA_check = ZtoA.isChecked();
        boolean earliestDate_check = earliestDate.isChecked();
        boolean latestDate_check = latestDate.isChecked();
        if((AtoZ_check || ZtoA_check || earliestDate_check || latestDate_check) != true) return;

        ListView listview = (ListView) findViewById(R.id.SAVED_GAMES);
        ArrayList<saved_game> search_list = new ArrayList<saved_game>();
        int length = listview.getAdapter().getCount();
        System.out.println(length);
        for(int i = 0; i < length; i++) search_list.add((saved_game) listview.getAdapter().getItem(i));
        listview.setAdapter(null);
        System.out.println(search_list);
        if(AtoZ_check) search_list = utility.sortName(search_list, true);
        if(ZtoA_check) search_list = utility.sortName(search_list, false);
        if(earliestDate_check) search_list = utility.sortDate(search_list, true);
        if(latestDate_check) search_list = utility.sortDate(search_list, false);

        ArrayAdapter<saved_game> search_adapter = new ArrayAdapter<saved_game>(this, android.R.layout.simple_list_item_1, search_list);
        listview.setAdapter(search_adapter);
        search_adapter.notifyDataSetChanged();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // FORMAT IS: [xy,xy:""]
                //ArrayList<saved_game> = ;//
                rewindGame((saved_game) listview.getItemAtPosition(i));
            }
        });

    }


    public void AtoZ(View v) {

        CheckBox AtoZ = findViewById(R.id.AtoZ);
        CheckBox ZtoA = findViewById(R.id.ZtoA);
        CheckBox earliestDate = findViewById(R.id.earliestDate);
        CheckBox latestDate = findViewById(R.id.latestDate);

        ZtoA.setChecked(false);
        earliestDate.setChecked(false);
        latestDate.setChecked(false);

        boolean state = AtoZ.isChecked();
        earliestDate.setEnabled(!state);
        latestDate.setEnabled(!state);
    }

    public void ZtoA(View v) {
        CheckBox AtoZ = findViewById(R.id.AtoZ);
        CheckBox ZtoA = findViewById(R.id.ZtoA);
        CheckBox earliestDate = findViewById(R.id.earliestDate);
        CheckBox latestDate = findViewById(R.id.latestDate);

        AtoZ.setChecked(false);
        earliestDate.setChecked(false);
        latestDate.setChecked(false);

        boolean state = ZtoA.isChecked();
        earliestDate.setEnabled(!state);
        latestDate.setEnabled(!state);
    }
    public void earliestDate(View v) {
        CheckBox AtoZ = findViewById(R.id.AtoZ);
        CheckBox ZtoA = findViewById(R.id.ZtoA);
        CheckBox earliestDate = findViewById(R.id.earliestDate);
        CheckBox latestDate = findViewById(R.id.latestDate);

        latestDate.setChecked(false);
        AtoZ.setChecked(false);
        ZtoA.setChecked(false);

        boolean state = earliestDate.isChecked();
        AtoZ.setEnabled(!state);
        ZtoA.setEnabled(!state);
    }
    public void latestDate(View v) {
        CheckBox AtoZ = findViewById(R.id.AtoZ);
        CheckBox ZtoA = findViewById(R.id.ZtoA);
        CheckBox earliestDate = findViewById(R.id.earliestDate);
        CheckBox latestDate = findViewById(R.id.latestDate);

        earliestDate.setChecked(false);
        AtoZ.setChecked(false);
        ZtoA.setChecked(false);

        boolean state = latestDate.isChecked();
        AtoZ.setEnabled(!state);
        ZtoA.setEnabled(!state);
    }



    public void rewindGame(saved_game pass) {
        Intent rewind = new Intent(this, rewind.class);
        rewind.putExtra("pass", pass);
        startActivity(rewind);
    }

    public void runNewGame(View v) {
        System.out.println("in method");
        Intent new_game = new Intent(this, game.class);
        startActivity(new_game);
    }
}