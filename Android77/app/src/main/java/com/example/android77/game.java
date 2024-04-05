package com.example.android77;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class game extends AppCompatActivity {

    /**
     * A 8x8 array is created for the chess board
     */
    private static Pieces[][] board = new Pieces[8][8];


    public Player whitePlayer = new Player("White Player", true,false);
    public Player blackPlayer = new Player("Black Player", false,false);

    public ArrayList<Pieces> fileSystemArray = new ArrayList<Pieces>();
    public ArrayList<String> stringFileSystemArray = new ArrayList<String>();

    /**
     * Position of both white and black king pieces stored
     */
    public static int whiteKingPositionX;
    public static int whiteKingPositionY;
    public static int blackKingPositionX;
    public static int blackKingPositionY;

    boolean isInCheck;

    public static String[] undoStoragePosition = new String[6];
    public static Pieces[] undoStoragePieces = new Pieces[2];

    private static Pieces[][] undoBoard;

//    public String letter = "Q";


    ////////////////////////FINAL VERSION setBoard()///////////////////////////////////////////
    /*
    ////////////////////////FINAL VERSION///////////////////////////////////////////
    public static void setBoard() {


        board[0][1] = new Pawn("White Pawn", "wp", "White", true, false, false);
        board[1][1] = new Pawn("White Pawn", "wp", "White", true, false, false);
        board[2][1] = new Pawn("White Pawn", "wp", "White", true, false, false);
        board[3][1] = new Pawn("White Pawn", "wp", "White", true, false, false);
        board[4][1] = new Pawn("White Pawn", "wp", "White", true, false, false);
        board[5][1] = new Pawn("White Pawn", "wp", "White", true, false, false);
        board[6][1] = new Pawn("White Pawn", "wp", "White", true, false, false);
        board[7][1] = new Pawn("White Pawn", "wp", "White", true, false, false);


        board[0][0] = new Rook("White Rook", "wR", "White", true);
        board[1][0] = new Knight("White Knight", "wN", "White");
        board[2][0] = new Bishop("White Bishop", "wB", "White");
        board[3][0] = new Queen("White Queen", "wQ", "White");
        board[4][0] = new King("White King", "wK", "White", true,4,0);
        board[5][0] = new Bishop("White Bishop", "wB", "White");
        board[6][0] = new Knight("White Knight", "wN", "White");
        board[7][0] = new Rook("White Rook", "wR", "White", true);



        board[0][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);
        board[1][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);
        board[2][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);
        board[3][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);
        board[4][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);
        board[5][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);
        board[6][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);
        board[7][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);


        board[0][7] = new Rook("Black Rook", "bR", "Black", true);
        board[1][7] = new Knight("Black Knight", "bN", "Black");
        board[2][7] = new Bishop("Black Bishop", "bB", "Black");
        board[3][7] = new Queen("Black Queen", "bQ", "Black");
        board[4][7] = new King("Black King", "bK", "Black",true,4,7);
        board[5][7] = new Bishop("Black Bishop", "bB", "Black");
        board[6][7] = new Knight("Black Knight", "bN", "Black");
        board[7][7] = new Rook("Black Rook", "bR", "Black",true);



    }
    */

    /////////////This setBoard() is for testing. Above is the final Version//////////////////////////////
    public static void setBoard() {


        board[0][1] = new Pawn("White Pawn", "wp", "White", true, false, false);
        board[1][1] = new Pawn("White Pawn", "wp", "White", true, false, false);
        board[2][1] = new Pawn("White Pawn", "wp", "White", true, false, false);
        board[3][1] = new Pawn("White Pawn", "wp", "White", true, false, false);
        board[4][1] = new Pawn("White Pawn", "wp", "White", true, false, false);
        board[5][1] = new Pawn("White Pawn", "wp", "White", true, false, false);
        board[6][1] = new Pawn("White Pawn", "wp", "White", true, false, false);
        board[7][1] = new Pawn("White Pawn", "wp", "White", true, false, false);



        board[0][0] = new Rook("White Rook", "wR", "White", true);
        board[1][0] = new Knight("White Knight", "wN", "White");
        board[2][0] = new Bishop("White Bishop", "wB", "White");
        board[3][0] = new Queen("White Queen", "wQ", "White");
        board[4][0] = new King("White King", "wK", "White", true,4,0);
        board[5][0] = new Bishop("White Bishop", "wB", "White");
        board[6][0] = new Knight("White Knight", "wN", "White");
        board[7][0] = new Rook("White Rook", "wR", "White", true);



        board[0][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);
        board[1][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);
        board[2][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);
        board[3][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);
        board[4][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);
        board[5][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);
        board[6][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);
        board[7][6] = new Pawn("Black Pawn", "bp","Black", true, false, false);




        board[0][7] = new Rook("Black Rook", "bR", "Black", true);
        board[1][7] = new Knight("Black Knight", "bN", "Black");
        board[2][7] = new Bishop("Black Bishop", "bB", "Black");
        board[3][7] = new Queen("Black Queen", "bQ", "Black");
        board[4][7] = new King("Black King", "bK", "Black",true,4,7);
        board[5][7] = new Bishop("Black Bishop", "bB", "Black");
        board[6][7] = new Knight("Black Knight", "bN", "Black");
        board[7][7] = new Rook("Black Rook", "bR", "Black",true);


//        board[0][0] = new Rook("White Rook", "wR", "White", true);
//
//        board[4][0] = new King("White King", "wK", "White", true,4,0);
//
//        board[7][0] = new Rook("White Rook", "wR", "White", true);
//
//        board[0][7] = new Rook("Black Rook", "bR", "Black", true);

//        board[0][0] = new Pawn("White Pawn", "wp", "White", true, false, false);

//        board[4][7] = new King("Black King", "bK", "Black",true,4,7);
//
//        board[7][7] = new Rook("Black Rook", "bR", "Black",true);

//        board[0][6] = new Pawn("White Pawn", "wp", "White", true, false, false);
//        board[1][6] = new Pawn("White Pawn", "wp", "White", true, false, false);
//        board[2][6] = new Pawn("White Pawn", "wp", "White", true, false, false);
//        board[3][6] = new Pawn("White Pawn", "wp", "White", true, false, false);
////        board[4][6] = new Pawn("White Pawn", "wp", "White", true, false, false);
//        board[5][6] = new Pawn("White Pawn", "wp", "White", true, false, false);
//        board[6][6] = new Pawn("White Pawn", "wp", "White", true, false, false);
//        board[7][6] = new Pawn("White Pawn", "wp", "White", true, false, false);

    }



    //Final Version

    /**
     * This draws out the board with abbreviations, hashtags, and numbers
     */
    public static void drawBoard() {
        int x = 8;


        int boardSquares = 0;

        for(int j = 7; j >= 0; j--){
            for(int i = 0; i < 8; i++){

                //checks for pieces on the board
                if(board[i][j] != null){
                    System.out.print(board[i][j].abbreviation + " ");
                    boardSquares++;
                }else {
                    if(j % 2 == 0) {
                        System.out.print((boardSquares %2) == 0 ? "## " : "   ");
                    }else {
                        System.out.print((boardSquares %2) == 0 ? "   " : "## ");
                    }

                    boardSquares++;
                }

                //prints numbers on the right side of the board
                if(i == 7){
                    System.out.println(x);
                    x--;
                }

            }

        }
        System.out.print(" a " +  " b " +  " c " +" d " +   " e " +  " f " +  " g " + " h ");

        System.out.println("\n");
        System.out.println("\n");
    }

    public static void drawCopyBoard() {
        int x = 8;


        int boardSquares = 0;

        for(int j = 7; j >= 0; j--){
            for(int i = 0; i < 8; i++){

                //checks for pieces on the board
                if(undoBoard[i][j] != null){
                    System.out.print(undoBoard[i][j].abbreviation + " ");
                    boardSquares++;
                }else {
                    if(j % 2 == 0) {
                        System.out.print((boardSquares %2) == 0 ? "## " : "   ");
                    }else {
                        System.out.print((boardSquares %2) == 0 ? "   " : "## ");
                    }

                    boardSquares++;
                }

                //prints numbers on the right side of the board
                if(i == 7){
                    System.out.println(x);
                    x--;
                }

            }

        }
        System.out.print(" a " +  " b " +  " c " +" d " +   " e " +  " f " +  " g " + " h ");

        System.out.println("\n");
        System.out.println("\n");
    }

    public static Pieces[][] makeCopyOfBoard(){

        Pieces[][] temporaryBoard = new Pieces[8][8];

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){

                if(board[i][j] instanceof Pawn){
                    temporaryBoard[i][j] = new Pawn(board[i][j].name, board[i][j].abbreviation, board[i][j].color, ((Pawn) board[i][j]).firstMove, ((Pawn) board[i][j]).potentialEnPassant, ((Pawn) board[i][j]).enPassantAvailable);

                }else if(board[i][j] instanceof Rook){
                    temporaryBoard[i][j] = new Rook(board[i][j].name, board[i][j].abbreviation, board[i][j].color , ((Rook) board[i][j]).firstMove);

                }else if(board[i][j] instanceof Bishop){
                    temporaryBoard[i][j] = new Bishop(board[i][j].name , board[i][j].abbreviation, board[i][j].color);

                }else if(board[i][j] instanceof Knight){
                    temporaryBoard[i][j] = new Knight(board[i][j].name, board[i][j].abbreviation, board[i][j].color);

                }else if(board[i][j] instanceof Queen){
                    temporaryBoard[i][j] = new Queen(board[i][j].name, board[i][j].abbreviation, board[i][j].color);

                }else if(board[i][j] instanceof King){
                    temporaryBoard[i][j] = new King(board[i][j].name, board[i][j].abbreviation, board[i][j].color, ((King) board[i][j]).firstMove, ((King) board[i][j]).kingsX, ((King) board[i][j]).kingsY);
                }
            }
        }

        return temporaryBoard;
    }



    public void drawAndroidBoard(){
        TextView textView;
        Drawable drawable;

//        int pawnLeft = 20;
//        int pawnTop = 0;
//        int pawnRight = 60;
//        int pawnBottom = 60;


        int left = 20;
        int top = 0;
        int right = 70;
        int bottom = 80;


        for(int j = 7; j >= 0; j--){
            for(int i = 0; i < 8; i++){

                if(getDrawable(i, j) != 0){
                    textView = findViewById(getBoardID(i, j));
                    drawable = ResourcesCompat.getDrawable(getResources(), getDrawable(i, j), null);
                    drawable.setBounds(left,top,right,bottom);
                    textView.setCompoundDrawables( drawable, null, null,  null );

                }

            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Home");

        actionBar.setHomeAsUpIndicator(R.drawable.arrow_back_home);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


//
        Button saveButton =findViewById(R.id.saveButton);

        Button undoButton = findViewById(R.id.undoButton);
        Button forwardButton = findViewById(R.id.forwardButton);
        forwardButton.setEnabled(false);
        undoButton.setEnabled(false);
        isInCheck = false;

        whiteKingPositionX = 4;
        whiteKingPositionY = 0;
        blackKingPositionX = 4;
        blackKingPositionY = 7;

//        TextView checkCheckMateTextView = findViewById(R.id.checkCheckMateTextView);
//        checkCheckMateTextView.setText("Check");

        TextView playerTurn = findViewById(R.id.playerTurn);

        playerTurn.setText("White Player Turn");

        setBoard();
        drawBoard();
        drawAndroidBoard();

        TextView disableNullSquares;
        for(int j = 7; j >= 0; j--){
            for(int i = 0; i < 8; i++){
                if(board[i][j] == null){
                    disableNullSquares = findViewById(getBoardID(i, j));
                    disableNullSquares.setEnabled(false);
                    disableNullSquares.setTextColor(Color.argb(0, 255, 0, 0));
                }
            }
        }


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//                this.finish();
//                onBackPressed();
                for(int j = 7; j >= 0; j--) {
                    for (int i = 0; i < 8; i++) {
                        board[i][j] = null;
                    }
                }
                setBoard();
                stringFileSystemArray.removeAll(stringFileSystemArray);
                startActivity(new Intent(game.this, MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void home(View view){
//        TextView textView;
//        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        for(int j = 7; j >= 0; j--) {
            for (int i = 0; i < 8; i++) {
                board[i][j] = null;
            }
        }
        setBoard();
        stringFileSystemArray.removeAll(stringFileSystemArray);
        startActivity(new Intent(game.this, MainActivity.class));

    }

    public int getBoardID(int i , int j){
        int squareID = 0;

        if(i == 0 && j == 7){
            return R.id.square07;
        }else if(i == 1 && j == 7){
            return R.id.square17;
        }else if(i == 2 && j == 7){
            return R.id.square27;
        }else if(i == 3 && j == 7){
            return R.id.square37;
        }else if(i == 4 && j == 7){
            return R.id.square47;
        }else if(i == 5 && j == 7){
            return R.id.square57;
        }else if(i == 6 && j == 7){
            return R.id.square67;
        }else if(i == 7 && j == 7){
            return R.id.square77;
        }else if(i == 0 && j == 6){
            return R.id.square06;
        }else if(i == 1 && j == 6){
            return R.id.square16;
        }else if(i == 2 && j == 6){
            return R.id.square26;
        }else if(i == 3 && j == 6){
            return R.id.square36;
        }else if(i == 4 && j == 6){
            return R.id.square46;
        }else if(i == 5 && j == 6){
            return R.id.square56;
        }else if(i == 6 && j == 6){
            return R.id.square66;
        }else if(i == 7 && j == 6){
            return R.id.square76;
        }else



        if(i == 0 && j == 5){
            return R.id.square05;
        }else if(i == 1 && j == 5){
            return R.id.square15;
        }else if(i == 2 && j == 5){
            return R.id.square25;
        }else if(i == 3 && j == 5){
            return R.id.square35;
        }else if(i == 4 && j == 5){
            return R.id.square45;
        }else if(i == 5 && j == 5){
            return R.id.square55;
        }else if(i == 6 && j == 5){
            return R.id.square65;
        }else if(i == 7 && j == 5){
            return R.id.square75;
        }else if(i == 0 && j == 4){
            return R.id.square04;
        }else if(i == 1 && j == 4){
            return R.id.square14;
        }else if(i == 2 && j == 4){
            return R.id.square24;
        }else if(i == 3 && j == 4){
            return R.id.square34;
        }else if(i == 4 && j == 4){
            return R.id.square44;
        }else if(i == 5 && j == 4){
            return R.id.square54;
        }else if(i == 6 && j == 4){
            return R.id.square64;
        }else if(i == 7 && j == 4){
            return R.id.square74;
        }else

        if(i == 0 && j == 3){
            return R.id.square03;
        }else if(i == 1 && j == 3){
            return R.id.square13;
        }else if(i == 2 && j == 3){
            return R.id.square23;
        }else if(i == 3 && j == 3){
            return R.id.square33;
        }else if(i == 4 && j == 3){
            return R.id.square43;
        }else if(i == 5 && j == 3){
            return R.id.square53;
        }else if(i == 6 && j == 3){
            return R.id.square63;
        }else if(i == 7 && j == 3){
            return R.id.square73;
        }else if(i == 0 && j == 2){
            return R.id.square02;
        }else if(i == 1 && j == 2){
            return R.id.square12;
        }else if(i == 2 && j == 2){
            return R.id.square22;
        }else if(i == 3 && j == 2){
            return R.id.square32;
        }else if(i == 4 && j == 2){
            return R.id.square42;
        }else if(i == 5 && j == 2){
            return R.id.square52;
        }else if(i == 6 && j == 2){
            return R.id.square62;
        }else if(i == 7 && j == 2){
            return R.id.square72;
        }else

        if(i == 0 && j == 1){
            return R.id.square01;
        }else if(i == 1 && j == 1){
            return R.id.square11;
        }else if(i == 2 && j == 1){
            return R.id.square21;
        }else if(i == 3 && j == 1){
            return R.id.square31;
        }else if(i == 4 && j == 1){
            return R.id.square41;
        }else if(i == 5 && j == 1){
            return R.id.square51;
        }else if(i == 6 && j == 1){
            return R.id.square61;
        }else if(i == 7 && j == 1){
            return R.id.square71;
        }else if(i == 0 && j == 0){
            return R.id.square00;
        }else if(i == 1 && j == 0){
            return R.id.square10;
        }else if(i == 2 && j == 0){
            return R.id.square20;
        }else if(i == 3 && j == 0){
            return R.id.square30;
        }else if(i == 4 && j == 0){
            return R.id.square40;
        }else if(i == 5 && j == 0){
            return R.id.square50;
        }else if(i == 6 && j == 0){
            return R.id.square60;
        }else if(i == 7 && j == 0){
            return R.id.square70;
        }

        return squareID;


    }

    public int[] clickedPosition(int rID){
        int[] position = new int[2];

        if(rID == R.id.square00){
            position[0] = 0;
            position[1] = 0;
        }else if(rID == R.id.square10){
            position[0] = 1;
            position[1] = 0;
        }else if(rID == R.id.square20){
            position[0] = 2;
            position[1] = 0;
        }else if(rID == R.id.square30){
            position[0] = 3;
            position[1] = 0;
        }else if(rID == R.id.square40){
            position[0] = 4;
            position[1] = 0;
        }else if(rID == R.id.square50){
            position[0] = 5;
            position[1] = 0;
        }else if(rID == R.id.square60){
            position[0] = 6;
            position[1] = 0;
        }else if(rID == R.id.square70){
            position[0] = 7;
            position[1] = 0;
        }

        ////////

        if(rID == R.id.square01){
            position[0] = 0;
            position[1] = 1;
        }else if(rID == R.id.square11){
            position[0] = 1;
            position[1] = 1;
        }else if(rID == R.id.square21){
            position[0] = 2;
            position[1] = 1;
        }else if(rID == R.id.square31){
            position[0] = 3;
            position[1] = 1;
        }else if(rID == R.id.square41){
            position[0] = 4;
            position[1] = 1;
        }else if(rID == R.id.square51){
            position[0] = 5;
            position[1] = 1;
        }else if(rID == R.id.square61){
            position[0] = 6;
            position[1] = 1;
        }else if(rID == R.id.square71){
            position[0] = 7;
            position[1] = 1;
        }

        ////////

        if(rID == R.id.square02){
            position[0] = 0;
            position[1] = 2;
        }else if(rID == R.id.square12){
            position[0] = 1;
            position[1] = 2;
        }else if(rID == R.id.square22){
            position[0] = 2;
            position[1] = 2;
        }else if(rID == R.id.square32){
            position[0] = 3;
            position[1] = 2;
        }else if(rID == R.id.square42){
            position[0] = 4;
            position[1] = 2;
        }else if(rID == R.id.square52){
            position[0] = 5;
            position[1] = 2;
        }else if(rID == R.id.square62){
            position[0] = 6;
            position[1] = 2;
        }else if(rID == R.id.square72){
            position[0] = 7;
            position[1] = 2;
        }

        ////////

        if(rID == R.id.square03){
            position[0] = 0;
            position[1] = 3;
        }else if(rID == R.id.square13){
            position[0] = 1;
            position[1] = 3;
        }else if(rID == R.id.square23){
            position[0] = 2;
            position[1] = 3;
        }else if(rID == R.id.square33){
            position[0] = 3;
            position[1] = 3;
        }else if(rID == R.id.square43){
            position[0] = 4;
            position[1] = 3;
        }else if(rID == R.id.square53){
            position[0] = 5;
            position[1] = 3;
        }else if(rID == R.id.square63){
            position[0] = 6;
            position[1] = 3;
        }else if(rID == R.id.square73){
            position[0] = 7;
            position[1] = 3;
        }

        ////////

        if(rID == R.id.square04){
            position[0] = 0;
            position[1] = 4;
        }else if(rID == R.id.square14){
            position[0] = 1;
            position[1] = 4;
        }else if(rID == R.id.square24){
            position[0] = 2;
            position[1] = 4;
        }else if(rID == R.id.square34){
            position[0] = 3;
            position[1] = 4;
        }else if(rID == R.id.square44){
            position[0] = 4;
            position[1] = 4;
        }else if(rID == R.id.square54){
            position[0] = 5;
            position[1] = 4;
        }else if(rID == R.id.square64){
            position[0] = 6;
            position[1] = 4;
        }else if(rID == R.id.square74){
            position[0] = 7;
            position[1] = 4;
        }

        ////////

        if(rID == R.id.square05){
            position[0] = 0;
            position[1] = 5;
        }else if(rID == R.id.square15){
            position[0] = 1;
            position[1] = 5;
        }else if(rID == R.id.square25){
            position[0] = 2;
            position[1] = 5;
        }else if(rID == R.id.square35){
            position[0] = 3;
            position[1] = 5;
        }else if(rID == R.id.square45){
            position[0] = 4;
            position[1] = 5;
        }else if(rID == R.id.square55){
            position[0] = 5;
            position[1] = 5;
        }else if(rID == R.id.square65){
            position[0] = 6;
            position[1] = 5;
        }else if(rID == R.id.square75){
            position[0] = 7;
            position[1] = 5;
        }

        ////////

        if(rID == R.id.square06){
            position[0] = 0;
            position[1] = 6;
        }else if(rID == R.id.square16){
            position[0] = 1;
            position[1] = 6;
        }else if(rID == R.id.square26){
            position[0] = 2;
            position[1] = 6;
        }else if(rID == R.id.square36){
            position[0] = 3;
            position[1] = 6;
        }else if(rID == R.id.square46){
            position[0] = 4;
            position[1] = 6;
        }else if(rID == R.id.square56){
            position[0] = 5;
            position[1] = 6;
        }else if(rID == R.id.square66){
            position[0] = 6;
            position[1] = 6;
        }else if(rID == R.id.square76){
            position[0] = 7;
            position[1] = 6;
        }

        ////////

        if(rID == R.id.square07){
            position[0] = 0;
            position[1] = 7;
        }else if(rID == R.id.square17){
            position[0] = 1;
            position[1] = 7;
        }else if(rID == R.id.square27){
            position[0] = 2;
            position[1] = 7;
        }else if(rID == R.id.square37){
            position[0] = 3;
            position[1] = 7;
        }else if(rID == R.id.square47){
            position[0] = 4;
            position[1] = 7;
        }else if(rID == R.id.square57){
            position[0] = 5;
            position[1] = 7;
        }else if(rID == R.id.square67){
            position[0] = 6;
            position[1] = 7;
        }else if(rID == R.id.square77){
            position[0] = 7;
            position[1] = 7;
        }


        return position;
    }

    public int getDrawable(int i, int j){
        int rDrawable = 0;

        if(board[i][j] != null && board[i][j].name.equals("Black Pawn")){
            rDrawable = R.drawable.blackpawn;
        } else if(board[i][j] != null && board[i][j].name.equals("Black Rook")){
            rDrawable = R.drawable.blackrook;
        }else if(board[i][j] != null && board[i][j].name.equals("Black Knight")){
            rDrawable = R.drawable.blackknight;
        }else if(board[i][j] != null && board[i][j].name.equals("Black Bishop")){
            rDrawable = R.drawable.blackbishop;
        }else if(board[i][j] != null && board[i][j].name.equals("Black Queen")){
            rDrawable = R.drawable.blackqueen;
        }else if(board[i][j] != null && board[i][j].name.equals("Black King")){
            rDrawable = R.drawable.blackking;
        }else if(board[i][j] != null && board[i][j].name.equals("White Pawn")){
            rDrawable = R.drawable.whitepawn;
        } else if(board[i][j] != null && board[i][j].name.equals("White Rook")){
            rDrawable = R.drawable.whiterook;
        }else if(board[i][j] != null && board[i][j].name.equals("White Knight")){
            rDrawable = R.drawable.whiteknight;
        }else if(board[i][j] != null && board[i][j].name.equals("White Bishop")){
            rDrawable = R.drawable.whitebishop;
        }else if(board[i][j] != null && board[i][j].name.equals("White Queen")){
            rDrawable = R.drawable.whitequeen;
        }else if(board[i][j] != null && board[i][j].name.equals("White King")){
            rDrawable = R.drawable.whiteking;
        }
        else{
            //System.out.println("The position is null");
            rDrawable = 0;
        }


        return rDrawable;
    }



    public  boolean gameOver(View view){

        TextView textView;
        TextView whichPlayerMove = findViewById(R.id.playerTurn);
        TextView playerTurnTextBox = findViewById(R.id.playerTurn);
        Button resignButton = findViewById(R.id.resignButton);
        Button drawButton = findViewById(R.id.drawButton);
        Button undoButton = findViewById(R.id.undoButton);
        Switch aiSwitchBox = findViewById(R.id.aiSwitchBox);
        Button forwardButton = findViewById(R.id.forwardButton);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final Button save = new Button(this);
        final Button cancel = new Button(this);
        final TextView text = new TextView(this);

        if(whichPlayerMove.getText().equals("White Player Turn")){
            text.setText("Black Wins!\nGame Over!");
            text.setTextSize(30);
            text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            text.setTextColor(Color.RED);
            playerTurnTextBox.setText("Black Wins!");
            playerTurnTextBox.setTextColor(getResources().getColor(R.color.illegalMove));

        }else{
            text.setText("White Wins!\nGame Over!");
            text.setTextSize(30);
            text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            text.setTextColor(Color.RED);
            playerTurnTextBox.setText("White Wins!");
            playerTurnTextBox.setTextColor(getResources().getColor(R.color.illegalMove));
        }

        resignButton.setEnabled(false);
        drawButton.setEnabled(false);
        undoButton.setEnabled(false);
        aiSwitchBox.setEnabled(false);
        forwardButton.setEnabled(false);


        for(int j = 7; j >= 0; j--){
            for(int i = 0; i < 8; i++){


                textView = findViewById(getBoardID(i, j));
                textView.setEnabled(false);
                textView.setTextColor(Color.argb(0, 255, 0, 0));


            }

        }


        save.setText("Save");
        cancel.setText("Cancel");



        //Layout of fields
        LinearLayout lay = new LinearLayout(this);
        lay.setOrientation(LinearLayout.VERTICAL);
        lay.addView(text);
        lay.addView(save);
        lay.addView(cancel);
        lay.setPaddingRelative(30, 10,30,10);


        builder.setView(lay);

        final AlertDialog dialog = builder.create();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    save(v);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                dialog.dismiss();;

            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();;

            }
        });

//        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        System.out.println(whichPlayerMove.getText());
        return true;

    }

    ///////////////////////////////////Good Version////////////////////////////////////////////////////////////
//    /**
//     * Checks to see if moves of different pieces puts the king into check
//     * @param kingPositionX represents the x-coordinate of the king position
//     * @param kingPositionY represents the y-coordinate of the king position
//     * @param color represents the color of the king piece
//     * @return returns the number of checks
//     */
//    public static boolean isCheck(int kingPositionX, int kingPositionY, String color) {
//        boolean result = false;
//        int numberOfChecks = 0;
//        boolean tryCatchIntiated = false;
//
//        //first if statement is from white turn if statement in main
//        //takes position of white king on white turn
//        //checks for isCheck of king position
//
//
//        if(color.equals("White")) {
//
//
//
//            for (int i = 0; i<board.length; i++){
//                for (int j = 0; j<board[i].length; j++){
//
//                    if(board[i][j] != null && (board[i][j]) instanceof Pawn && ((Pawn)board[i][j]).getColor() == "Black" ) {
//                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
//
//                            if(((Pawn)board[i][j]).isValidMoveForCheck(board, (Pawn)board[i][j], (King)board[kingPositionX][kingPositionY], i, j, kingPositionX, kingPositionY)) {
//                                numberOfChecks++;
//                            }
//
//                    }
//
//                    if(board[i][j] != null && (board[i][j]) instanceof Rook && ((Rook)board[i][j]).color == "Black" ) {
//                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
//                        if(((Rook)board[i][j]).isValidMoveForCheck(board, (Rook)board[i][j], i, j, kingPositionX, kingPositionY)) {
//
//                            numberOfChecks++;
//                        }
//
//
//                    }
//
//                    if(board[i][j] != null && (board[i][j]) instanceof Knight && ((Knight)board[i][j]).color == "Black" ) {
//                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
//                        if(((Knight)board[i][j]).isValidMoveForCheck(board, (Knight)board[i][j], i, j, kingPositionX, kingPositionY)) {
//                            numberOfChecks++;
//                        }
//
//                    }
//
//                    if(board[i][j] != null && (board[i][j]) instanceof Bishop && ((Bishop)board[i][j]).color == "Black" ) {
//                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
//                        if(((Bishop)board[i][j]).isValidMoveForCheck(board, (Bishop)board[i][j], i, j, kingPositionX, kingPositionY)) {
//                            numberOfChecks++;
//                        }
//
//                    }
//
//                    if(board[i][j] != null && (board[i][j]) instanceof Queen && ((Queen)board[i][j]).color == "Black" ) {
//                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
//                        if(((Queen)board[i][j]).isValidMoveForCheck(board, (Queen)board[i][j], i, j, kingPositionX, kingPositionY)) {
//                            numberOfChecks++;
//                        }
//
//                    }
//
//
//                    if(board[i][j] != null && (board[i][j]) instanceof King && ((King)board[i][j]).color == "Black" ) {
//                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
//                        if(((King)board[i][j]).isValidMoveForCheck(board, (King)board[i][j], i, j, kingPositionX, kingPositionY)) {
//                            numberOfChecks++;
//                        }
//
//                    }
//
//
//
//                }
//
//
//            }
//
//
//
//        }else {
//            for (int i = 0; i<board.length; i++){
//                for (int j = 0; j<board[i].length; j++){
//
//                    if(board[i][j] != null && (board[i][j]) instanceof Pawn && ((Pawn)board[i][j]).getColor() == "White" ) {
//                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
//                        if(((Pawn)board[i][j]).isValidMoveForCheck(board, (Pawn)board[i][j], (King)board[kingPositionX][kingPositionY], i, j, kingPositionX, kingPositionY)) {
//                            numberOfChecks++;
//                        }
//
//                    }
//
//                    if(board[i][j] != null && (board[i][j]) instanceof Rook && ((Rook)board[i][j]).color == "White" ) {
//                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
//                        if(((Rook)board[i][j]).isValidMoveForCheck(board, (Rook)board[i][j], i, j, kingPositionX, kingPositionY)) {
//                            numberOfChecks++;
//                        }
//
//                    }
//
//                    if(board[i][j] != null && (board[i][j]) instanceof Knight && ((Knight)board[i][j]).color == "White" ) {
//                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
//                        if(((Knight)board[i][j]).isValidMoveForCheck(board, (Knight)board[i][j], i, j, kingPositionX, kingPositionY)) {
//                            numberOfChecks++;
//                        }
//
//                    }
//
//                    if(board[i][j] != null && (board[i][j]) instanceof Bishop && ((Bishop)board[i][j]).color == "White" ) {
//                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
//                        if(((Bishop)board[i][j]).isValidMoveForCheck(board, (Bishop)board[i][j], i, j, kingPositionX, kingPositionY)) {
//                            numberOfChecks++;
//                        }
//
//                    }
//
//                    if(board[i][j] != null && (board[i][j]) instanceof Queen && ((Queen)board[i][j]).color == "White" ) {
//                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
//                        if(((Queen)board[i][j]).isValidMoveForCheck(board, (Queen)board[i][j], i, j, kingPositionX, kingPositionY)) {
//                            numberOfChecks++;
//                        }
//
//                    }
//
//
//                    if(board[i][j] != null && (board[i][j]) instanceof King && ((King)board[i][j]).color == "White" ) {
//                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
//                        if(((King)board[i][j]).isValidMoveForCheck(board, (King)board[i][j], i, j, kingPositionX, kingPositionY)) {
//                            numberOfChecks++;
//                        }
//
//                    }
//
//
//
//                }
//            }
//
//        }
//
//
//
//
//        if(numberOfChecks == 0) {
//            result = false;
//        }else {
//            System.out.println("Number of Checks: " + numberOfChecks);
//            result = true;
//        }
//
//
//
//
//        return result;
//    }

    /////////////////////////////////////End of Good Version/////////////////////////////////////////////////
    /////////////////////////////////////////Edited Version//////////////////////////////////////////////////////

    /**
     * Checks to see if moves of different pieces puts the king into check
     * @param kingPositionX represents the x-coordinate of the king position
     * @param kingPositionY represents the y-coordinate of the king position
     * @param color represents the color of the king piece
     * @return returns the number of checks
     */
    public  boolean isCheck(int kingPositionX, int kingPositionY, String color) {
        boolean result = false;
        int numberOfChecks = 0;
        boolean tryCatchIntiated = false;

        //first if statement is from white turn if statement in main
        //takes position of white king on white turn
        //checks for isCheck of king position


        if(color.equals("White")) {

//            isKingMissing("wk");

            for (int i = 0; i<board.length; i++){
                for (int j = 0; j<board[i].length; j++){

                    if(board[i][j] != null && (board[i][j]) instanceof Pawn && ((Pawn)board[i][j]).getColor() == "Black" ) {
                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
                        try{
                            if(((Pawn)board[i][j]).isValidMoveForCheck(board, (Pawn)board[i][j], (King)board[kingPositionX][kingPositionY], i, j, kingPositionX, kingPositionY)) {
                                numberOfChecks++;
                            }
                        }catch(ClassCastException e){
                            tryCatchIntiated = true;
                            break;
                        }


                    }

                    if(board[i][j] != null && (board[i][j]) instanceof Rook && ((Rook)board[i][j]).color == "Black" ) {
                        //System.out.print("Black Pawn at: " + i + "," + j + "->");

                        try{
                            if(((Rook)board[i][j]).isValidMoveForCheck(board, (Rook)board[i][j], i, j, kingPositionX, kingPositionY)) {

                                numberOfChecks++;
                            }
                        }catch(ClassCastException e){
                            tryCatchIntiated = true;
                            break;
                        }

                    }

                    if(board[i][j] != null && (board[i][j]) instanceof Knight && ((Knight)board[i][j]).color == "Black" ) {
                        //System.out.print("Black Pawn at: " + i + "," + j + "->");

                        try{
                            if(((Knight)board[i][j]).isValidMoveForCheck(board, (Knight)board[i][j], i, j, kingPositionX, kingPositionY)) {
                                numberOfChecks++;
                            }
                        }catch(ClassCastException e){
                            tryCatchIntiated = true;
                            break;
                        }

                    }

                    if(board[i][j] != null && (board[i][j]) instanceof Bishop && ((Bishop)board[i][j]).color == "Black" ) {
                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
                        try{
                            if(((Bishop)board[i][j]).isValidMoveForCheck(board, (Bishop)board[i][j], i, j, kingPositionX, kingPositionY)) {
                                numberOfChecks++;
                            }
                        }catch(ClassCastException e){
                            tryCatchIntiated = true;
                            break;
                        }

                    }

                    if(board[i][j] != null && (board[i][j]) instanceof Queen && ((Queen)board[i][j]).color == "Black" ) {
                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
                        try{
                            if(((Queen)board[i][j]).isValidMoveForCheck(board, (Queen)board[i][j], i, j, kingPositionX, kingPositionY)) {
                                numberOfChecks++;
                            }
                        }catch(ClassCastException e){
                            tryCatchIntiated = true;
                            break;
                        }

                    }


                    if(board[i][j] != null && (board[i][j]) instanceof King && ((King)board[i][j]).color == "Black" ) {
                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
//                        try{
                            if(((King)board[i][j]).isValidMoveForCheck(board, (King)board[i][j], i, j, kingPositionX, kingPositionY)) {
                                numberOfChecks++;
                            }
//                        }catch(ClassCastException e){
//                            tryCatchIntiated = true;
//                            break;
//                        }

                    }



                }
                if(tryCatchIntiated){
                    gameOver(null);
                    break;
                }

            }



        }else {
            for (int i = 0; i<board.length; i++){
                for (int j = 0; j<board[i].length; j++){

                    if(board[i][j] != null && (board[i][j]) instanceof Pawn && ((Pawn)board[i][j]).getColor() == "White" ) {
                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
                        try{
                            if(((Pawn)board[i][j]).isValidMoveForCheck(board, (Pawn)board[i][j], (King)board[kingPositionX][kingPositionY], i, j, kingPositionX, kingPositionY)) {
                                numberOfChecks++;
                            }
                        }catch(ClassCastException e){
                            tryCatchIntiated = true;
                            break;
                        }

                    }

                    if(board[i][j] != null && (board[i][j]) instanceof Rook && ((Rook)board[i][j]).color == "White" ) {
                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
                        try{
                            if(((Rook)board[i][j]).isValidMoveForCheck(board, (Rook)board[i][j], i, j, kingPositionX, kingPositionY)) {
                                numberOfChecks++;
                            }
                        }catch(ClassCastException e){
                            tryCatchIntiated = true;
                            break;
                        }

                    }

                    if(board[i][j] != null && (board[i][j]) instanceof Knight && ((Knight)board[i][j]).color == "White" ) {
                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
                        try{
                            if(((Knight)board[i][j]).isValidMoveForCheck(board, (Knight)board[i][j], i, j, kingPositionX, kingPositionY)) {
                                numberOfChecks++;
                            }
                        }catch(ClassCastException e){
                            tryCatchIntiated = true;
                            break;
                        }

                    }

                    if(board[i][j] != null && (board[i][j]) instanceof Bishop && ((Bishop)board[i][j]).color == "White" ) {
                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
                        try{
                            if(((Bishop)board[i][j]).isValidMoveForCheck(board, (Bishop)board[i][j], i, j, kingPositionX, kingPositionY)) {
                                numberOfChecks++;
                            }
                        }catch(ClassCastException e){
                            tryCatchIntiated = true;
                            break;
                        }


                    }

                    if(board[i][j] != null && (board[i][j]) instanceof Queen && ((Queen)board[i][j]).color == "White" ) {
                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
                        try{
                            if(((Queen)board[i][j]).isValidMoveForCheck(board, (Queen)board[i][j], i, j, kingPositionX, kingPositionY)) {
                                numberOfChecks++;
                            }
                        }catch(ClassCastException e){
                            tryCatchIntiated = true;
                            break;
                        }

                    }


                    if(board[i][j] != null && (board[i][j]) instanceof King && ((King)board[i][j]).color == "White" ) {
                        //System.out.print("Black Pawn at: " + i + "," + j + "->");
//                        try{
                            if(((King)board[i][j]).isValidMoveForCheck(board, (King)board[i][j], i, j, kingPositionX, kingPositionY)) {
                                numberOfChecks++;
                            }
//                        }catch(ClassCastException e){
//                            tryCatchIntiated = true;
//                            break;
//                        }

                    }



                }if(tryCatchIntiated){
                    gameOver(null);
                    break;
                }



            }

        }




        if(numberOfChecks == 0) {
            result = false;
        }else {
            System.out.println("Number of Checks: " + numberOfChecks);
            result = true;
        }




        return result;
    }

    ////////////////////////////////////End of Edited Version////////////////////////////////////////////////////////

    public void disableNullSquares(){
        TextView disableNullSquares;
        for(int j = 7; j >= 0; j--){
            for(int i = 0; i < 8; i++){
                if(board[i][j] == null){
                    disableNullSquares = findViewById(getBoardID(i, j));
                    disableNullSquares.setEnabled(false);
                    disableNullSquares.setTextColor(Color.argb(0, 255, 0, 0));
                }
            }
        }
    }

    public void enableNullSquares(){
        TextView enableNullSquares;
        for(int j = 7; j >= 0; j--){
            for(int i = 0; i < 8; i++){
                    enableNullSquares = findViewById(getBoardID(i, j));
                    enableNullSquares.setEnabled(true);
                    enableNullSquares.setTextColor(Color.argb(0, 255, 0, 0));
            }
        }
    }

    public int[] clickedPiece = new int[2];

    public void movePiece(View view){
        Drawable drawable;
        TextView textView;
        TextView textView1;
        TextView selectedPieceTextView;
        selectedPieceTextView = findViewById(R.id.selectedPieceTextView);
//        int[] moves = new int[2];
        int[] start = new int[2];
        int[] end = new int[2];

        if (clickedPiece[0] == 0){
            clickedPiece[0] = view.getId();


            //THis is first position x y
            start = clickedPosition(clickedPiece[0]);
//            selectedPieceTextView.getText();
///////////////////////////////////////////////////////////////////////////////////////////////////
            enableNullSquares();
 /////////////////////////////////////////////////////////////////////////////////////////////////
            if(board[start[0]][start[1]] != null){
                selectedPieceTextView.setText(board[start[0]][start[1]].name);
                selectedPieceTextView.setTextColor(getResources().getColor(R.color.greenPieceSelection2));
            }


        }else{
            clickedPiece[1] = view.getId();

//            Drawable drawable;
//            TextView textView;
//            TextView textView1;

            textView = findViewById(clickedPiece[0]);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

            textView1 = findViewById(clickedPiece[1]);

//            int[] start = new int[2];
//            int[] end = new int[2];

            start = clickedPosition(clickedPiece[0]);
            end = clickedPosition(clickedPiece[1]);


            //drawBoard();

            moveBoard(start[0], start[1], end[0], end[1]);

            drawBoard();

            drawAndroidBoard();

            clickedPiece[0]=0;
            clickedPiece[1]=0;


///////////////////////////////////////////////////////////////////////////////////////////////////
            disableNullSquares();
/////////////////////////////////////////////////////////////////////////////////////////////////

            selectedPieceTextView.setText("No Piece Selected");
            selectedPieceTextView.setTextColor(Color.GRAY);

        }
    }

    public boolean resign(View view){

        TextView textView;
        TextView whichPlayerMove = findViewById(R.id.playerTurn);
        TextView playerTurnTextBox = findViewById(R.id.playerTurn);
        Button resignButton = findViewById(R.id.resignButton);
        Button drawButton = findViewById(R.id.drawButton);
        Button undoButton = findViewById(R.id.undoButton);
        Switch aiSwitchBox = findViewById(R.id.aiSwitchBox);
        Button forwardButton = findViewById(R.id.forwardButton);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final Button save = new Button(this);
        final Button cancel = new Button(this);
        final TextView text = new TextView(this);

        if(whichPlayerMove.getText().equals("White Player Turn")){
            text.setText("Black Wins!\nGame Over!");
            text.setTextSize(30);
            text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            text.setTextColor(Color.RED);
            playerTurnTextBox.setText("Black Wins!");
            playerTurnTextBox.setTextColor(getResources().getColor(R.color.illegalMove));

        }else{
            text.setText("White Wins!\nGame Over!");
            text.setTextSize(30);
            text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            text.setTextColor(Color.RED);
            playerTurnTextBox.setText("White Wins!");
            playerTurnTextBox.setTextColor(getResources().getColor(R.color.illegalMove));
        }

        resignButton.setEnabled(false);
        drawButton.setEnabled(false);
        undoButton.setEnabled(false);
        aiSwitchBox.setEnabled(false);
        forwardButton.setEnabled(false);


        for(int j = 7; j >= 0; j--){
            for(int i = 0; i < 8; i++){


                textView = findViewById(getBoardID(i, j));
                textView.setEnabled(false);
                textView.setTextColor(Color.argb(0, 255, 0, 0));


            }

        }


        save.setText("Save");
        cancel.setText("Cancel");



        //Layout of fields
        LinearLayout lay = new LinearLayout(this);
        lay.setOrientation(LinearLayout.VERTICAL);
        lay.addView(text);
        lay.addView(save);
        lay.addView(cancel);
        lay.setPaddingRelative(30, 10,30,10);


        builder.setView(lay);

        final AlertDialog dialog = builder.create();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    save(v);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                dialog.dismiss();;

            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();;

            }
        });

//        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        System.out.println(whichPlayerMove.getText());
        return true;

    }

    public void drawButton(View view){

        TextView textView;
        TextView playerTurn = findViewById(R.id.playerTurn);
        Button resignButton = findViewById(R.id.resignButton);
        Button drawButton = findViewById(R.id.drawButton);
        Button undoButton = findViewById(R.id.undoButton);
        Switch aiSwitchBox = findViewById(R.id.aiSwitchBox);
        Button forwardButton = findViewById(R.id.forwardButton);

        for(int j = 7; j >= 0; j--){
            for(int i = 0; i < 8; i++){


                textView = findViewById(getBoardID(i, j));
                textView.setEnabled(false);
//                    textView.setTextColor(Color.argb(0, 255, 0, 0));
//                    textView.setTextColor(getResources().getColor(R.color.illegalMove));
                playerTurn.setText("Draw! Game Over!");
                playerTurn.setTextColor(getResources().getColor(R.color.illegalMove));

            }

        }
        resignButton.setEnabled(false);
        drawButton.setEnabled(false);
        undoButton.setEnabled(false);
        aiSwitchBox.setEnabled(false);
        forwardButton.setEnabled(false);



        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        final Button save = new Button(this);
        final Button cancel = new Button(this);
        final TextView text = new TextView(this);

        text.setText("Draw!\nGameOver!");
        text.setTextSize(30);
        text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        text.setTextColor(Color.RED);
        save.setText("Save");
        cancel.setText("Cancel");



        //Layout of fields
        LinearLayout lay = new LinearLayout(this);
        lay.setOrientation(LinearLayout.VERTICAL);
        lay.addView(text);
        lay.addView(save);
        lay.addView(cancel);
        lay.setPaddingRelative(30, 10,30,10);


        builder.setView(lay);

        final AlertDialog dialog = builder.create();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    save(v);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                dialog.dismiss();;

            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.dismiss();;

            }
        });

//        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

    }

/////////////////////////////////////////////////////////////////////////////////////////////////

    public void undo(View view){


        Pieces tempPiece = undoStoragePieces[0];
        Button undoButton = findViewById(R.id.undoButton);
        TextView playerTurn = findViewById(R.id.playerTurn);

        //deletes all pieces on both console board and android board
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = null;
                TextView textView = findViewById(getBoardID(i,j));
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }

        //copy of previous board
        board = undoBoard;

        System.out.println("STRINGFILEARRAY ELEMENTS: " + stringFileSystemArray + " size=" + stringFileSystemArray.size());
        stringFileSystemArray.remove(stringFileSystemArray.size()-1);
        //System.out.println("");

        //undo player turn
        if(playerTurn.getText().equals("Black Player Turn")){
            blackPlayer.setTurn(false);
            whitePlayer.setTurn(true);
            playerTurn.setText("White Player Turn");
        }else{
            blackPlayer.setTurn(true);
            whitePlayer.setTurn(false);
            playerTurn.setText("Black Player Turn");
        }

        drawBoard();
        System.out.println("UNDO BOARD PRINTED ----");
        drawAndroidBoard();
//////////////////////////////////////////////////////////////////////////////////
        enableNullSquares();
        disableNullSquares();
///////////////////////////////////////////////////////////////////////////////
        undoButton.setEnabled(false);

    }

//    public void setUndoStorage(Pieces tempPiece, int firstInputPosition, int secondInputPosition, int thirdInputPosition, int fourthInputPosition){
    public void setUndoStorage( int firstInputPosition, int secondInputPosition, int thirdInputPosition, int fourthInputPosition){

            Button undoButton = findViewById(R.id.undoButton);

        Integer a = null, b = null, c = null, d = null;
        //undoStoragePieces[0] = tempPiece;
//        undoStoragePosition[0] = "wR";
        undoStoragePosition[0] = null;
        undoStoragePosition[1] = a.toString(firstInputPosition);
        undoStoragePosition[2] = b.toString(secondInputPosition);
        undoStoragePosition[3] = c.toString(thirdInputPosition);
        undoStoragePosition[4] = d.toString(fourthInputPosition);
//        if(board[thirdInputPosition][fourthInputPosition] != null){
//            undoStorage[5] = "Unsure";
//        }


        undoButton.setEnabled(true);


    }

//Create directory and save file
    public void save(View view) throws IOException {

        final String[] nameOfFile = new String[1];

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Game Name: ");

//        final EditText input = new EditText(this);
//
//        input.setInputType(InputType.TYPE_CLASS_TEXT);
//        builder.setView(input);

        //Name
        final EditText name= new EditText(this);

        name.setInputType(InputType.TYPE_CLASS_TEXT);
        name.setHint("Game Name...");




        //Layout of fields
        LinearLayout lay = new LinearLayout(this);
        lay.setOrientation(LinearLayout.VERTICAL);
        lay.addView(name);
        builder.setView(lay);



        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
////////////////////////////////////////////////////////////////////////////////////////////////////
//                nameOfFile[0] = input.getText().toString();

                String nameWithOutSpaces;

                System.out.println("Creating directory...");
                File dir = new File("/data/data/com.example.android77/FileStorage");

                try{
                    if(dir.mkdir()) {
                        System.out.println("Directory created");
                    } else {
                        System.out.println("Directory is not created");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

                System.out.println("Directory Created...");

//        startActivity(new Intent(game.this, SaveGameInput.class));
                System.out.println("Saving data...");

//                File file = new File("/data/data/com.example.android77/FileStorage/" + nameOfFile[0] +".txt");
                if(!name.getText().toString().equals(null) && !name.getText().toString().equals("")){

//                    File file = new File("/data/data/com.example.android77/FileStorage/" +
//                            name.getText().toString() +".txt");
                    nameWithOutSpaces = name.getText().toString().trim().replaceAll("\\s", "_");
                    File file = new File("/data/data/com.example.android77/FileStorage/" +
                            nameWithOutSpaces +".txt");


                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    FileWriter fileWrite = null;
                    try {
                        fileWrite = new FileWriter(file);

                        fileWrite.write(nameWithOutSpaces + "\n");
//                        fileWrite.write(name.getText().toString() + "\n");
                        Date date = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                        String dateFormat = formatter.format(date); // MM/DD/YYYY
                        fileWrite.write(dateFormat + "\n");

                        //Writes String to file system text file
                        for (String array: stringFileSystemArray){

                            fileWrite.write(array);
                        }



                        fileWrite.flush();
                        fileWrite.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

                System.out.println("Saving Completed!");

////////////////////////////////////////////////////////////////////////////////////////////////////


            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();


 //////////////////////////Testing array////////////////////////////////////////////////////

        System.out.println("/////////////This is the String arraylist///////////\n");

        for (String array: stringFileSystemArray){

            System.out.println(array);


        }

 ////////////////////////////////////////////////////////////////////////////////



    }




    /**
     * This promotes the rook to another piece according to the user's input when rook reaches other end
     * @param color represents color input of the piece from the user
     * @param selection represents selection input from the user for what the rook piece will be promoted to
     * @return returns the new promoted piece
     */
    public static Pieces promote(String color, String selection) {


        if(color.equals("White")) {

            if (selection.equals("N")) {
                Knight wN = new Knight("White Knight", "wN", "White");

                return wN;
            }else if (selection.equals("B")) {
                Bishop wB = new Bishop("White Bishop", "wB", "White");

                return wB;
            }else if (selection.equals("R")) {
                Rook wR = new Rook("White Rook", "wR", "White", true);

                return wR;
            }else {
                Queen wQ = new Queen("White Queen", "wQ", "White");
                return wQ;
            }

        }else {

            if (selection.equals("N")) {
                Knight bN = new Knight("Black Knight", "bN", "Black");

                return bN;
            }else if (selection.equals("B")) {
                Bishop bB = new Bishop("Black Bishop", "bB", "Black");

                return bB;
            }else if (selection.equals("R")) {
                Rook bR = new Rook("Black Rook", "bR", "Black", true);

                return bR;
            }else {
                Queen bQ = new Queen("Black Queen", "bQ", "Black");
                return bQ;
            }

        }



    }


//////////////////////////////////////////////////////////////////////////

    public String promotionDialogBox() {


    final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message mesg) {
            throw new RuntimeException();
        }
    };

   String[] letter = new String[1];

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Promotion: Piece Selection!");
    builder.setMessage("Choose a piece for promotion!");

    final Button knight = new Button(this);
    final Button bishop = new Button(this);
    final Button rook = new Button(this);
    final Button queen = new Button(this);
    final Button cancel = new Button(this);

    knight.setText("Knight");
    bishop.setText("Bishop");
    rook.setText("Rook");
    queen.setText("Queen");
    cancel.setText("Cancel");



    //Layout of fields
    LinearLayout lay = new LinearLayout(this);
    lay.setOrientation(LinearLayout.VERTICAL);
    lay.addView(knight);
    lay.addView(bishop);
    lay.addView(rook);
    lay.addView(queen);
    lay.addView(cancel);
    lay.setPaddingRelative(30, 10,30,10);


    builder.setView(lay);

    final AlertDialog dialog = builder.create();

    knight.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            letter[0] = "N";
            handler.sendMessage(handler.obtainMessage());
            dialog.dismiss();;

        }
    });
        bishop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                letter[0] = "B";
                handler.sendMessage(handler.obtainMessage());
                dialog.dismiss();;

            }
        });
        rook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                letter[0] = "R";
                handler.sendMessage(handler.obtainMessage());
                dialog.dismiss();;

            }
        });
        queen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                letter[0] = "Q";
                handler.sendMessage(handler.obtainMessage());
                dialog.dismiss();;

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                letter[0] = "Q";
                handler.sendMessage(handler.obtainMessage());
                dialog.dismiss();;

            }
        });

//        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
    dialog.show();

    try { Looper.loop(); }
    catch(RuntimeException e2) {}

    return letter[0];
}

    /* ------------------------  ------------------------ */
    /* -------------------- AI START -------------------- */ // ------------------------------------------------------------------------------------------------------------------------
    /* ------------------------  ------------------------ */

    public static boolean AI_WHITE = false;
    public static boolean AI_BLACK = false;

    public static void AI_WHITE_ON() {
        AI_WHITE = true;
    }
    public static void AI_WHITE_OFF() {
        AI_WHITE = false;
    }
    public static void AI_BLACK_ON() {
        AI_BLACK = true;
    }
    public static void AI_BLACK_OFF() {
        AI_BLACK = false;
    }

    public static boolean pieceExists(String abr) {
        for(int X = 0; X < 8; X++) {
            for(int Y = 0; Y < 8; Y++) {
                if(board[X][Y] != null && board[X][Y].abbreviation.compareTo(abr) == 0) return true;
            }
        }
        return false;
    }
    public static boolean pExists(String team) {
        return pieceExists(team + "p");
    }
    public static boolean RExists(String team) {
        return pieceExists(team + "R");
    }
    public static boolean BExists(String team) {
        return pieceExists(team + "B");
    }
    public static boolean NExists(String team) {
        return pieceExists(team + "N");
    }
    public static boolean QExists(String team) {
        return pieceExists(team + "Q");
    }
    public static boolean KExists(String team) {
        return pieceExists(team + "K");
    }
    public static String AI_randomName(String team) {
        ArrayList<String> names = new ArrayList<String>();
        if(pExists(team)) names.add("p");
        if(RExists(team)) names.add("R");
        if(BExists(team)) names.add("B");
        if(NExists(team)) names.add("N");
        if(QExists(team)) names.add("Q");
        if(KExists(team)) names.add("K");
        return names.get((int) (Math.random() * names.size()));
    }
    public boolean AI_tryPiece(String team, String piece_name) {

        String search_piece = team + piece_name;

        for(int X = (int) (Math.random() * 8); X < 8; X++) {
            for(int Y = 0 ; Y < 8; Y++) {

                if(board[X][Y] == null) {
                    System.out.println("BOARD PIECE [" + X + "][" + Y + "] is null!");
                    continue;
                }
                if(board[X][Y].abbreviation.compareTo(search_piece) != 0) {
                    System.out.println("BOARD PIECE [" + X + "][" + Y + "] is " + board[X][Y].abbreviation + " and not " + search_piece + "!");
                    continue;
                }

                // System.out.println("moving X from [" + X + "][" + Y + "] to [" + X + "][" + new_Y + "]");
                if(board[X][Y].abbreviation.substring(1, 2).compareTo("p") == 0) {
                    int new_Y = -1;
                    int end_Y = 0;
                    if(team.compareTo("w") == 0) {
                        new_Y = Math.abs(new_Y);
                        end_Y = 7;
                    }
                    new_Y += Y;

                    String abr = "''";

                    if(new_Y < 0 || new_Y > 7) return false;
                    if(board[X][new_Y] != null) abr = board[X][new_Y].abbreviation;
                    boolean valid = ((Pawn) board[X][Y]).isValidMove(board, ((Pawn) board[X][Y]), ((Pieces) board[X][new_Y]), X, Y, X, new_Y);
                    // promotion, empassment
                    if(valid) {
                        if(new_Y == end_Y) {
                            String color = "White";
                            if(team.compareTo("b") == 0) color = "Black";
                            String name = color + " Queen";
                            String abbreviation = team + "Q";
                            board[X][new_Y] = new Queen(name, abbreviation, color);
                        }
                        System.out.println(("ADDING TO ARRAY: " + X+""+Y + X+""+new_Y + abr + X+""+new_Y + ""));
                        setFileSystemArray(X+""+Y, X+""+new_Y, abr, X+""+new_Y, "''");
                    }
                    return valid;
                } else if(board[X][Y].abbreviation.substring(1, 2).compareTo("R") == 0) {
                    System.out.println("found rook at " + "[" + X + "][" + Y + "]");
                    double random = Math.random();
                    int new_Y = Y, new_X = X;
                    int aboveY = 7 - Y, belowY = Y;
                    int leftX = X, rightX = 7 - X;
                    if(random < 0.5) {
                        if(random < 0.25) {
                            new_Y = (int) (Math.random() * aboveY);
                            if(new_Y == 0) new_Y++;
                        } else {
                            new_Y = (int) (Math.random() * belowY);
                            if(new_Y == 0) new_Y++;
                        }
                    } else {
                        if(random < 0.75) {
                            new_X = (int) (Math.random() * leftX);
                            if(new_X == 0) new_X++;
                        } else {
                            new_X = (int) (Math.random() * rightX);
                            if(new_X == 0) new_X++;
                        }
                    }
                    System.out.println("trying to move ROOK from [" + X + "][" + Y + "] to [" + new_X + "][" + new_Y + "]");
                    String abr = "''";
                    if(board[new_X][new_Y] != null) abr = board[new_X][new_Y].abbreviation;
                    boolean valid = ((Rook) board[X][Y]).isValidMove(board, ((Rook) board[X][Y]), X, Y, new_X, new_Y);
                    if(valid) setFileSystemArray(X+""+Y, new_X+""+new_Y, abr, new_X+""+new_Y, "''");
                    return valid;
                } else if(board[X][Y].abbreviation.substring(1, 2).compareTo("B") == 0) {
                    System.out.println("Bisop pawn at " + "[" + X + "][" + Y + "]");
                    double random = Math.random();
                    int new_Y = Y, new_X = X;
                    int aboveY = (int) ((7 - Y) * Math.random()), belowY = (int) (Y * Math.random());
                    int leftX = (int) (X * Math.random()), rightX = (int) ((7 - X) * Math.random());
                    if(random < 0.5) {
                        if(random < 0.25) {
                            if(aboveY > rightX) aboveY = rightX;
                            else rightX = aboveY;
                            new_X -= aboveY;
                            new_Y += aboveY;
                        } else {
                            if(aboveY > leftX) aboveY = leftX;
                            else leftX = aboveY;
                            new_X += aboveY;
                            new_Y += aboveY;
                        }
                    } else {
                        if(random < 0.75) {
                            if(belowY > leftX) belowY = leftX;
                            else leftX = belowY;
                            new_X -= belowY;
                            new_Y -= belowY;
                        } else {
                            if(belowY > rightX) belowY = rightX;
                            else rightX = belowY;
                            new_X += belowY;
                            new_Y -= belowY;
                        }
                    }

                    String abr = "''";
                    if(new_X < 0 || new_X > 7) return false;
                    if(new_Y < 0 || new_Y > 7) return false;

                    if(board[new_X][new_Y] != null) abr = board[new_X][new_Y].abbreviation;
                    System.out.println("trying to move BISHOP from [" + X + "][" + Y + "] to [" + new_X + "][" + new_Y + "]");
                    boolean valid = ((Bishop) board[X][Y]).isValidMove(board, ((Bishop) board[X][Y]), X, Y, new_X, new_Y);
                    System.out.println(valid + ", so add");
                    if(valid) {
                        System.out.println(("ADDING TO ARRAY: " + X+""+Y + new_X+""+new_Y + abr + new_X+""+new_Y + "''"));
                       // setFileSystemArray(X+""+Y, new_X+""+new_Y, abr, new_X+""+new_Y, "");
                    }
                    return valid;
                } else if(board[X][Y].abbreviation.substring(1, 2).compareTo("N") == 0) {
                    System.out.println("found knight at " + "[" + X + "][" + Y + "]");
                    double negative_Y = Math.random(), negative_X = Math.random(), random = Math.random();
                    int new_X = X, new_Y = Y;
                    int first = 1, second = 2;
                    if(negative_Y < 0.5) first *= -1;
                    if(negative_X < 0.5) second *= -1;
                    if(random < 0.5) {
                        new_X += first;
                        new_Y += second;
                    } else {
                        new_X += second;
                        new_Y += first;
                    }
                    if(new_X < 0 || new_X > 7) return false;
                    if(new_Y < 0 || new_Y > 7) return false;

                    String abr = "''";
                    if(board[new_X][new_Y] != null) abr = board[new_X][new_Y].abbreviation;
                    boolean valid = ((Knight) board[X][Y]).isValidMove(board, ((Knight) board[X][Y]), X, Y, new_X, new_Y);
                    if(valid) setFileSystemArray(X+""+Y, new_X+""+new_Y, abr, new_X+""+new_Y, "''");
                    return valid;
                } else if(board[X][Y].abbreviation.substring(1, 2).compareTo("K") == 0) {
                    System.out.println("found King at " + "[" + X + "][" + Y + "]");
                    double random = Math.random();
                    int new_Y = 1, new_X = 1;
                    if(random < 0.5) {
                        if(random < 0.25) {
                            if(random < (0.25/2.0)) {
                                new_X += X;
                                new_Y = 0;
                            } else {
                                new_Y += Y;
                                new_X = 0;
                            }
                        } else {
                            if(random < (0.25/2.0 + 0.25)) {
                                new_X -= X;
                                new_Y = 0;
                            }
                            else {
                                new_Y -= Y;
                                new_X = 0;
                            }
                        }
                    } else {
                        if(random < 0.75) {
                            if(random < (0.25/2.0 + 0.5)) {
                                new_X *= -1;
                            }
                        } else {
                            if(random < (0.25/2.0 + 0.75)) {
                                new_Y *= -1;
                                new_Y += Y;
                            } else {
                                new_X *= -1;
                                new_Y *= -1;
                                new_X += X;
                                new_Y += Y;
                            }
                        }
                    }
                    if(new_X < 0 || new_X > 7) return false;
                    if(new_Y < 0 || new_Y > 7) return false;

                    String abr = "''";
                    if(board[new_X][new_Y] != null) abr = board[new_X][new_Y].abbreviation;
                    boolean valid = ((King) board[X][Y]).isValidMove(board, ((King) board[X][Y]), X, Y, new_X, new_Y);
                    if(valid) setFileSystemArray(X+""+Y, new_X+""+new_Y, abr, new_X+""+new_Y, "''");
                    return valid;
                } else if(board[X][Y].abbreviation.substring(1, 2).compareTo("Q") == 0) {
                    System.out.println("found QUEEN at " + "[" + X + "][" + Y + "]");
                    int aboveY = (int) ((7 - Y) * Math.random()), belowY = (int) (Y * Math.random());
                    int leftX = (int) (X * Math.random()), rightX = (int) ((7 - X) * Math.random());
                    double random = Math.random();
                    int new_Y = 1, new_X = 1;
                    if(random < 0.5) {
                        if(random < 0.25) {
                            if(random < (0.25/2.0)) {
                                new_X *= rightX;
                                new_Y = 0;
                            } else {
                                new_Y *= aboveY;
                                new_X = 0;
                            }
                        } else {
                            if(random < (0.25/2.0 + 0.25)) {
                                new_X *= leftX * -1;
                                new_Y = 0;
                            }
                            else {
                                new_Y *= belowY * -1;
                                new_X = 0;
                            }
                        }
                    } else {
                        if(random < 0.75) {
                            if(random < (0.25/2.0 + 0.5)) {
                                if(aboveY > rightX) aboveY = rightX;
                                else rightX = aboveY;
                                new_X -= aboveY;
                                new_Y += aboveY;
                            } else {
                                if(aboveY > leftX) aboveY = leftX;
                                else leftX = aboveY;
                                new_X += aboveY;
                                new_Y += aboveY;
                            }
                        } else {
                            if(random < (0.25/2.0 + 0.75)) {
                                if(belowY > leftX) belowY = leftX;
                                else leftX = belowY;
                                new_X -= belowY;
                                new_Y -= belowY;
                            } else {
                                if(belowY > rightX) belowY = rightX;
                                else rightX = belowY;
                                new_X += belowY;
                                new_Y -= belowY;
                            }
                        }
                    }
                    if(new_X < 0 || new_X > 7) return false;
                    if(new_Y < 0 || new_Y > 7) return false;

                    String abr = "''";
                    if(board[new_X][new_Y] != null) abr = board[new_X][new_Y].abbreviation;
                    boolean valid = ((Queen) board[X][Y]).isValidMove(board, ((Queen) board[X][Y]), X, Y, new_X, new_Y);
                    if(valid) setFileSystemArray(X+""+Y, new_X+""+new_Y, abr, new_X+""+new_Y, "''");
                    return valid;
                }
            }
        }
        return false;
    }

    String findKing(String team) {
        String king = "w";
        if(team.compareTo("w") != 0) king = "b";
        king = king + "K";
//        String position = "";
     String position = "XX";

        for(int X = 0; X < 8; X++) {
            for(int Y = 0; Y < 8; Y++) {
                if(board[X][Y] != null && board[X][Y].abbreviation.compareTo(king) == 0) position = X + "" + Y;
            }
        }

        return position;
    }
    int findKX(String team) {
        return Integer.parseInt(findKing(team).substring(0,1));
    }
    int findKY(String team) {
        return Integer.parseInt(findKing(team).substring(1,2));
    }

    public void AI_execute(String team) {

        Button forward = findViewById(R.id.forwardButton);
        forward.setEnabled(false);

        /*
        String team = "";
        if(WHITE.playerTurn) {
            if(!AI_WHITE) return;
            WHITE.playerTurn = false;
            BLACK.playerTurn = true;
            team = team + "w";
        }
        if(BLACK.playerTurn) {
            if(!AI_BLACK) return;
            team = team + "b";
            WHITE.playerTurn = true;
            BLACK.playerTurn = false;
        }
        */

        String check = "w";
        int king_x = whiteKingPositionX, king_y = whiteKingPositionY;
        if(team.compareTo(check) == 0) {
            king_x = blackKingPositionX;
            king_y = blackKingPositionY;
            check = "b";
        }

        Button undo = findViewById(R.id.undoButton);
        undo.setEnabled(true);
        boolean success = false;
        while(!success) {
            success = AI_tryPiece(team, AI_randomName(team));
            if(!success) System.out.println("EXECUTE FAIL");
        }

//
        drawBoard();

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                TextView textView = findViewById(getBoardID(i,j));
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }

        TextView checkCheckMateTextView = findViewById(R.id.checkCheckMateTextView);
        checkCheckMateTextView.setText("");
        if(findKing(check).compareTo("XX") == 0) {
            gameOver(null);
        } else if(isCheck(findKX(check), findKY(check), check)) {
//            TextView checkCheckMateTextView = findViewById(R.id.checkCheckMateTextView);
            isInCheck = true;
            System.out.println("Check");
            checkCheckMateTextView.setText("Check");
        }

        drawAndroidBoard();
        forward.setEnabled(true);

        ///System.out.println("EXECUTE SUCCESS");
    }

    /* ------------------------  ------------------------ */
    /* --------------------- AI END --------------------- */ // ------------------------------------------------------------------------------------------------------------------------
    /* ------------------------  ------------------------ */

///////////////////////////////////////////////////////////////////////////
    public boolean aiOnOff = false;
    public void switchOnOff(View view){

Button forwardButton = findViewById(R.id.forwardButton);

        forwardButton.setEnabled(true);
        if(aiOnOff){
            aiOnOff = false;
            forwardButton.setEnabled(false);
        }else{
            aiOnOff = true;
            forwardButton.setEnabled(true);
        }




        /*
        if(aiOnOff){
            aiOnOff = false;
        }else{
            aiOnOff = true;
        }

        if(blackPlayer.playerTurn){
            forwardButton.setEnabled(true);

        }
        */
    }


    public void aiMoveForward(View view){
        TextView illegalMove  = findViewById(R.id.illegalMove);
        TextView playerTurn = findViewById(R.id.playerTurn);
        Button forwardButton = findViewById(R.id.forwardButton);

        undoBoard = makeCopyOfBoard();
        if(whitePlayer.playerTurn) {
            System.out.println("WHITE BUTTON PRESS");
            AI_execute("w");
            blackPlayer.setTurn(true);
            whitePlayer.setTurn(false);
            illegalMove.setVisibility(View.INVISIBLE);
            playerTurn.setText("Black Player Turn");
           // forwardButton.setEnabled(true);
        } else {
            System.out.println("BLACK BUTTON PRESS");
            AI_execute("b");
            blackPlayer.setTurn(false);
            whitePlayer.setTurn(true);
            illegalMove.setVisibility(View.INVISIBLE);
            playerTurn.setText("White Player Turn");
            //forwardButton.setEnabled(tr);
        }


        //System.out.println("Forward was pressed");

    }




    public void setFileSystemArray(String from, String to, String abbreviation, String deleted, String letter){

       // (X+""+Y, X+""+new_Y, abr, X+""+new_Y, "''");
        //format for storing string  [24,13:wp,13]
        String storedData = new String();



        storedData = "[" + from + "," + to + ":" + abbreviation + "," + deleted + ":" + letter +"]\n";
        stringFileSystemArray.add(storedData);
        System.out.println("ADDED " + storedData + " TO ARRAY");


    }


    public void moveBoard(int first, int second, int third, int fourth){
        boolean accessedEnPassantedIfStatement = false;
        boolean accessedPromotionIfStatment = false;
        boolean accessedCastlingIfStatment = false;
        TextView illegalMove = findViewById(R.id.illegalMove);
        TextView playerTurn = findViewById(R.id.playerTurn);
        TextView checkCheckMateTextView = findViewById(R.id.checkCheckMateTextView);
        Button forwardButton = findViewById(R.id.forwardButton);
        String promotionSelection = "";


        Pieces whitePiece = new Pieces();
        Pieces blackPiece = new Pieces();
        Pieces tempPiece = new Pieces();

        if(whitePlayer.playerTurn == true) {

////////////////////////////////////////////////////////////////////////////
            if (isCheck(whiteKingPositionX, whiteKingPositionY, "White")) {
                isInCheck = true;
                System.out.println("Check");
                checkCheckMateTextView.setText("Check");
//                }
            }else{
                checkCheckMateTextView.setText("");
            }

////////////////////////////////////////////////////////////////////////////

            int firstInputPosition;
            int secondInputPosition;
            int thirdInputPosition;
            int fourthInputPosition;


            firstInputPosition = first;
            secondInputPosition = second;
            thirdInputPosition = third;
            fourthInputPosition = fourth;




            whitePiece = board[firstInputPosition][secondInputPosition];
            tempPiece = board[thirdInputPosition][fourthInputPosition];

            undoBoard = makeCopyOfBoard();



            if (whitePiece != null && whitePiece.abbreviation.equals("wp") && ((Pawn) whitePiece).enPassant(/*((Pawn)whitePiece).getColor(),*/ secondInputPosition, board, firstInputPosition, secondInputPosition) || whitePiece != null && whitePiece.abbreviation.equals("wp")
                    && ((Pawn) whitePiece).isValidMove(board, (Pawn) whitePiece, tempPiece, firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition)
            ) {

                if(whitePiece != null && ((Pawn)whitePiece).getEnPassantIntiatedAndroidUse()){
                    TextView textView = findViewById(getBoardID(thirdInputPosition,fourthInputPosition-1));
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    ((Pawn)whitePiece).setEnPassantInitiatedAndroidUse(false);
                    accessedEnPassantedIfStatement = true;
                }

                //check to see if it can be promoted; if so promote
                if(((Pawn)whitePiece).isWhitePromotion(fourthInputPosition)) {

//                    startActivity(new Intent(MainActivity.this, Pop.class));

//                    String promotionSelection = promotionDialogBox();
                    promotionSelection = promotionDialogBox();

                    whitePiece = promote(((Pawn)whitePiece).color,promotionSelection);
                    //whitePiece = promote(((Pawn)whitePiece).color,"");
//                    whitePiece = promotionDialogBox(((Pawn)whitePiece).color);
                    board[thirdInputPosition][fourthInputPosition] = null;
                    board[thirdInputPosition][fourthInputPosition] = whitePiece;
                    board[firstInputPosition][secondInputPosition] = null;
                    accessedPromotionIfStatment = true;

                }


                //drawAndroidBoard();
//                setUndoStorage(whitePiece,firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);

                setUndoStorage(firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);


//////////////////////////////////////PASSING THE DATA TO SAVE////////////////////////////////////////////////////////////////////////////////////
                if(tempPiece != null){

                    if(accessedPromotionIfStatment){
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), promotionSelection);
                        accessedPromotionIfStatment = false;
                    }else{
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''");
                    }

                }else{
                    if (accessedEnPassantedIfStatement){
                        int subtracted = fourthInputPosition-1;
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + subtracted), "E");
                        accessedEnPassantedIfStatement = false;
                    } else if(accessedPromotionIfStatment){
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition), promotionSelection);
                        accessedPromotionIfStatment = false;
                    }else{
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition),"''");
                    }

                }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



                
                illegalMove.setVisibility(View.INVISIBLE);
                blackPlayer.setTurn(true);
                whitePlayer.setTurn(false);
                playerTurn.setText("Black Player Turn");




            } else if (whitePiece != null && whitePiece.abbreviation.equals("wR")
                    && ((Rook) whitePiece).isValidMove(board, (Rook) whitePiece, firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition)
            ) {

//                setUndoStorage(whitePiece,firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);
                setUndoStorage(firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);



  ///////////////////////////////////////////////////////////////PASSING THE DATA TO SAVE////////////////////////////////////////////////////////////////////////////////////
                if(tempPiece != null){
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''");
                }else{
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition),"''");

                }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



                illegalMove.setVisibility(View.INVISIBLE);
                blackPlayer.setTurn(true);
                whitePlayer.setTurn(false);
                playerTurn.setText("Black Player Turn");

            } else if (whitePiece != null && whitePiece.abbreviation.equals("wN")
                    && ((Knight) whitePiece).isValidMove(board, (Knight) whitePiece, firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition)
            ) {

//                setUndoStorage(whitePiece,firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);
                setUndoStorage(firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);



                ///////////////////////////////////////////////////////////////PASSING THE DATA TO SAVE////////////////////////////////////////////////////////////////////////////////////
                if(tempPiece != null){
                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''");
                }else{
                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition),"''");

                }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





                illegalMove.setVisibility(View.INVISIBLE);
                blackPlayer.setTurn(true);
                whitePlayer.setTurn(false);
                playerTurn.setText("Black Player Turn");

            } else if (whitePiece != null && whitePiece.abbreviation.equals("wB")
                    && ((Bishop) whitePiece).isValidMove(board, (Bishop) whitePiece, firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition)
            ) {

//                setUndoStorage(whitePiece,firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);
                setUndoStorage(firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);


                ///////////////////////////////////////////////////////////////PASSING THE DATA TO SAVE////////////////////////////////////////////////////////////////////////////////////
                if(tempPiece != null){
                    if(accessedCastlingIfStatment){
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition), "C");
                        accessedCastlingIfStatment = false;
                    }else{
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''");
                    }
//                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''");
                }else{
                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition),"''");

                }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




                illegalMove.setVisibility(View.INVISIBLE);
                blackPlayer.setTurn(true);
                whitePlayer.setTurn(false);
                playerTurn.setText("Black Player Turn");
            } else if (whitePiece != null && whitePiece.abbreviation.equals("wQ")
                    && ((Queen) whitePiece).isValidMove(board, (Queen) whitePiece, firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition)
            ) {
//                setUndoStorage(whitePiece,firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);
                setUndoStorage(firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);



                ///////////////////////////////////////////////////////////////PASSING THE DATA TO SAVE////////////////////////////////////////////////////////////////////////////////////
                if(tempPiece != null){
                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''");
                }else{
                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition),"''");

                }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




                illegalMove.setVisibility(View.INVISIBLE);
                blackPlayer.setTurn(true);
                whitePlayer.setTurn(false);
                playerTurn.setText("Black Player Turn");

            }else if(whitePiece != null && whitePiece.abbreviation.equals("wK")
                    && ((King)whitePiece).isValidMove(board, (King)whitePiece, firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition)
            ){

//                setUndoStorage(whitePiece,firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);
                setUndoStorage(firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);
                whiteKingPositionX = thirdInputPosition;
                whiteKingPositionY = fourthInputPosition;

                //System.out.println("White King.getPosition Position: " + ((King)whitePiece).getKingsX() + "," + ((King)whitePiece).getKingsY());
                whiteKingPositionX = ((King)whitePiece).getKingsX();
                whiteKingPositionY = ((King)whitePiece).getKingsY();

                if(whitePiece != null && ((King)whitePiece).castleRight){
                    TextView textView = findViewById(getBoardID(7,0/*thirdInputPosition,fourthInputPosition-1*/));
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    ((King)whitePiece).setCastleRight(false);
                    accessedCastlingIfStatment = true;
                }


                if(whitePiece != null && ((King)whitePiece).castleLeft){

                    TextView textView = findViewById(getBoardID(0,0/*thirdInputPosition,fourthInputPosition-1*/));
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    ((King)whitePiece).setCastleLeft(false);
                    accessedCastlingIfStatment = true;
                }



                ///////////////////////////////////////////////////////////////PASSING THE DATA TO SAVE////////////////////////////////////////////////////////////////////////////////////
                if(tempPiece != null){
                    if(accessedCastlingIfStatment){
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition), "C");
                        accessedCastlingIfStatment = false;
                    }else{
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''");
                    }
//                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''");
                }else{
                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition),"''");

                }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




                illegalMove.setVisibility(View.INVISIBLE);
                blackPlayer.setTurn(true);
                whitePlayer.setTurn(false);
                playerTurn.setText("Black Player Turn");

            } else {

                illegalMove.setVisibility(View.VISIBLE);
                System.out.println("Illegal move, try again");
            }

            /////////////////////isCheck//////////////////////////////////////////////
            if (isCheck(blackKingPositionX, blackKingPositionY, "Black")) {
                isInCheck = true;
                //System.out.println("Check");
//                if(isCheckMate(blackKingPositionX, blackKingPositionY, "Black") == 0) {
//                    //System.out.println("This is the amount of moves: " + isCheckMate(blackKingPositionX, blackKingPositionY, "Black"));
//                    System.out.println("Checkmate");
//                    System.out.println("White wins");
//                    break;
//                }else {
                System.out.println("Check");
                checkCheckMateTextView.setText("Check");

//                }
            }else{
                checkCheckMateTextView.setText("");
            }

            ///////////////////////////////////////////////////////////////////

            //////////////////////////////////////////////////////////////////////////////////////////////////////
            if (isCheck(blackKingPositionX, blackKingPositionY, "Black")) {
                isInCheck = true;

                System.out.println("Check");
                checkCheckMateTextView.setText("Check");
//                }
            }else{
                checkCheckMateTextView.setText("");
            }
            /////////////////////////////////////////////////////////////////////



        }else{



            /////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (isCheck(blackKingPositionX, blackKingPositionY, "Black")) {
                isInCheck = true;
                //System.out.println("Check");
//                if(isCheckMate(blackKingPositionX, blackKingPositionY, "Black") == 0) {
//                    //System.out.println("This is the amount of moves: " + isCheckMate(blackKingPositionX, blackKingPositionY, "Black"));
//                    System.out.println("Checkmate");
//                    System.out.println("White wins");
//                    break;
//                }else {
                System.out.println("Check");
                checkCheckMateTextView.setText("Check");

//                }
            }else{
                checkCheckMateTextView.setText("");
            }
            /////////////////////////////////////////////////////////////////////


            int firstInputPosition;
            int secondInputPosition;
            int thirdInputPosition;
            int fourthInputPosition;


            firstInputPosition = first;
            secondInputPosition = second;
            thirdInputPosition = third;
            fourthInputPosition = fourth;

            blackPiece = board[firstInputPosition][secondInputPosition];
            tempPiece = board[thirdInputPosition][fourthInputPosition];

            undoBoard = makeCopyOfBoard();



            if(blackPiece != null && blackPiece.abbreviation.equals("bp") && ((Pawn)blackPiece).enPassant(/*((Pawn)whitePiece).getColor(),*/ secondInputPosition, board, firstInputPosition, secondInputPosition)|| blackPiece != null && blackPiece.abbreviation.equals("bp")
                    && ((Pawn)blackPiece).isValidMove(board, (Pawn)blackPiece, tempPiece, firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition)
            ){

//                setUndoStorage(blackPiece,firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);
                setUndoStorage(firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);

                if(blackPiece != null && ((Pawn)blackPiece).getEnPassantIntiatedAndroidUse()){
                    TextView textView = findViewById(getBoardID(thirdInputPosition,fourthInputPosition+1));
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    ((Pawn)blackPiece).setEnPassantInitiatedAndroidUse(false);
                    accessedEnPassantedIfStatement = true;
                }

                //check to see if it can be promoted; if so promote
                if(((Pawn)blackPiece).isBlackPromotion(fourthInputPosition)) {

                   promotionSelection = promotionDialogBox();
//                    String promotionSelection = promotionDialogBox();

                    blackPiece = promote(((Pawn)blackPiece).color,promotionSelection);
                    board[thirdInputPosition][fourthInputPosition] = null;
                    board[thirdInputPosition][fourthInputPosition] = blackPiece;
                    board[firstInputPosition][secondInputPosition] = null;
                    accessedPromotionIfStatment = true;

                }


                //////////////////////////////////////PASSING THE DATA TO SAVE////////////////////////////////////////////////////////////////////////////////////
                if(tempPiece != null){

                    if(accessedPromotionIfStatment){
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), promotionSelection);
                        accessedPromotionIfStatment = false;
                    }else{
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''");
                    }

                }else{
                    if (accessedEnPassantedIfStatement){
                        int subtracted = fourthInputPosition+1;
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + subtracted), "E");
                        accessedEnPassantedIfStatement = false;
                    } else if(accessedPromotionIfStatment){
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition), promotionSelection);
                        accessedPromotionIfStatment = false;
                    }else{
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition),"''");
                    }

                }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


                illegalMove.setVisibility(View.INVISIBLE);
                blackPlayer.setTurn(false);
                whitePlayer.setTurn(true);
                playerTurn.setText("White Player Turn");
            }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            else if(blackPiece != null && blackPiece.abbreviation.equals("bR")
                    && ((Rook)blackPiece).isValidMove(board, (Rook)blackPiece, firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition)
            ){
//                setUndoStorage(blackPiece,firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);
                setUndoStorage(firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);


                ///////////////////////////////////////////////////////////////PASSING THE DATA TO SAVE////////////////////////////////////////////////////////////////////////////////////
                if(tempPiece != null){
                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''");
                }else{
                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition),"''");

                }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




                illegalMove.setVisibility(View.INVISIBLE);
                blackPlayer.setTurn(false);
                whitePlayer.setTurn(true);
                playerTurn.setText("White Player Turn");

            }else if(blackPiece != null && blackPiece.abbreviation.equals("bN")
                    && ((Knight)blackPiece).isValidMove(board, (Knight)blackPiece, firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition)
            ){
//                setUndoStorage(blackPiece,firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);
                setUndoStorage(firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);


                ///////////////////////////////////////////////////////////////PASSING THE DATA TO SAVE////////////////////////////////////////////////////////////////////////////////////
                if(tempPiece != null){
                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''");
                }else{
                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition),"''");

                }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




                illegalMove.setVisibility(View.INVISIBLE);
                blackPlayer.setTurn(false);
                whitePlayer.setTurn(true);
                playerTurn.setText("White Player Turn");

            }else if(blackPiece != null && blackPiece.abbreviation.equals("bB")
                    && ((Bishop)blackPiece).isValidMove(board, (Bishop)blackPiece, firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition)
            ){
//                setUndoStorage(blackPiece,firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);
                setUndoStorage(firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);


                ///////////////////////////////////////////////////////////////PASSING THE DATA TO SAVE////////////////////////////////////////////////////////////////////////////////////
                if(tempPiece != null){
                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''");
                }else{
                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition),"''");

                }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





                illegalMove.setVisibility(View.INVISIBLE);
                blackPlayer.setTurn(false);
                whitePlayer.setTurn(true);
                playerTurn.setText("White Player Turn");

            }else if(blackPiece != null && blackPiece.abbreviation.equals("bQ")
                    && ((Queen)blackPiece).isValidMove(board, (Queen)blackPiece, firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition)
            ){
//                setUndoStorage(blackPiece,firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);
                setUndoStorage(firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);


                ///////////////////////////////////////////////////////////////PASSING THE DATA TO SAVE////////////////////////////////////////////////////////////////////////////////////
                if(tempPiece != null){
                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''");
                }else{
                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition),"''");

                }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




                illegalMove.setVisibility(View.INVISIBLE);
                blackPlayer.setTurn(false);
                whitePlayer.setTurn(true);
                playerTurn.setText("White Player Turn");


            }else if(blackPiece != null && blackPiece.abbreviation.equals("bK")
                    && ((King)blackPiece).isValidMove(board, (King)blackPiece, firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition)
            ){

//                setUndoStorage(blackPiece,firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);
                setUndoStorage(firstInputPosition, secondInputPosition, thirdInputPosition, fourthInputPosition);

                blackKingPositionX = thirdInputPosition;
                blackKingPositionY = fourthInputPosition;


//					System.out.println("Black King.getPosition Position: " + ((King)blackPiece).getKingsX() + "," + ((King)blackPiece).getKingsY());
                blackKingPositionX = ((King)blackPiece).getKingsX();
                blackKingPositionY = ((King)blackPiece).getKingsY();

                if(blackPiece != null && ((King)blackPiece).castleRight){
                    TextView textView = findViewById(getBoardID(7,7/*thirdInputPosition,fourthInputPosition-1*/));
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    ((King)blackPiece).setCastleRight(false);
                    accessedCastlingIfStatment = true;
                }

                if(blackPiece != null && ((King)blackPiece).castleLeft){
                    TextView textView = findViewById(getBoardID(0,7/*thirdInputPosition,fourthInputPosition-1*/));
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    ((King)blackPiece).setCastleLeft(false);
                    accessedCastlingIfStatment = true;
                }





                ///////////////////////////////////////////////////////////////PASSING THE DATA TO SAVE////////////////////////////////////////////////////////////////////////////////////
                if(tempPiece != null){
                    if(accessedCastlingIfStatment){
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition), "C");
                        accessedCastlingIfStatment = false;
                    }else{
                        setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''");
                    }
//                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), tempPiece.abbreviation, String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''");
                }else{
                    setFileSystemArray(String.valueOf(firstInputPosition + "" + secondInputPosition), String.valueOf(thirdInputPosition + "" + fourthInputPosition), "''", String.valueOf(thirdInputPosition + "" + fourthInputPosition),"''");

                }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





                illegalMove.setVisibility(View.INVISIBLE);
                blackPlayer.setTurn(false);
                whitePlayer.setTurn(true);
                playerTurn.setText("White Player Turn");
            }else {
                illegalMove.setVisibility(View.VISIBLE);
                System.out.println("Illegal move, try again");

            }
/////////////////////////////////////////////////////////////

            /////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (isCheck(whiteKingPositionX, whiteKingPositionY, "White")) {
                isInCheck = true;

                //System.out.println("Check");
//                if(isCheckMate(whiteKingPositionX, whiteKingPositionY, "White") == 0) {
//                    //System.out.println("This is the amount of moves: " + isCheckMate(whiteKingPositionX, whiteKingPositionY, "White"));
//                    System.out.println("Checkmate");
//                    System.out.println("Black wins");
//                    break;
//                }else {
                System.out.println("Check");
                checkCheckMateTextView.setText("Check");
//                }
            }else{
                checkCheckMateTextView.setText("");
            }
            /////////////////////////////////////////////////////////////////////



        }
    }
}