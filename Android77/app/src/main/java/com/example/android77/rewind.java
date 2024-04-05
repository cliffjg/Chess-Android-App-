package com.example.android77;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class rewind extends AppCompatActivity {

    public static MainActivity.saved_game rewind = null;
    TextView message;
    TextView title;
    private static Pieces[][] board = new Pieces[8][8];
    public static boolean deleted_turn = false, deleted_turn2 = false;
    public static int D_X = 0, D2_X = 0;
    public static int D_Y = 0, D2_Y = 0;

    public int R_getBoardID(int i, int j) {
        int squareID = 0;

        if (i == 0 && j == 7) {
            return R.id.square07;
        } else if (i == 1 && j == 7) {
            return R.id.square17;
        } else if (i == 2 && j == 7) {
            return R.id.square27;
        } else if (i == 3 && j == 7) {
            return R.id.square37;
        } else if (i == 4 && j == 7) {
            return R.id.square47;
        } else if (i == 5 && j == 7) {
            return R.id.square57;
        } else if (i == 6 && j == 7) {
            return R.id.square67;
        } else if (i == 7 && j == 7) {
            return R.id.square77;
        } else if (i == 0 && j == 6) {
            return R.id.square06;
        } else if (i == 1 && j == 6) {
            return R.id.square16;
        } else if (i == 2 && j == 6) {
            return R.id.square26;
        } else if (i == 3 && j == 6) {
            return R.id.square36;
        } else if (i == 4 && j == 6) {
            return R.id.square46;
        } else if (i == 5 && j == 6) {
            return R.id.square56;
        } else if (i == 6 && j == 6) {
            return R.id.square66;
        } else if (i == 7 && j == 6) {
            return R.id.square76;
        } else if (i == 0 && j == 5) {
            return R.id.square05;
        } else if (i == 1 && j == 5) {
            return R.id.square15;
        } else if (i == 2 && j == 5) {
            return R.id.square25;
        } else if (i == 3 && j == 5) {
            return R.id.square35;
        } else if (i == 4 && j == 5) {
            return R.id.square45;
        } else if (i == 5 && j == 5) {
            return R.id.square55;
        } else if (i == 6 && j == 5) {
            return R.id.square65;
        } else if (i == 7 && j == 5) {
            return R.id.square75;
        } else if (i == 0 && j == 4) {
            return R.id.square04;
        } else if (i == 1 && j == 4) {
            return R.id.square14;
        } else if (i == 2 && j == 4) {
            return R.id.square24;
        } else if (i == 3 && j == 4) {
            return R.id.square34;
        } else if (i == 4 && j == 4) {
            return R.id.square44;
        } else if (i == 5 && j == 4) {
            return R.id.square54;
        } else if (i == 6 && j == 4) {
            return R.id.square64;
        } else if (i == 7 && j == 4) {
            return R.id.square74;
        } else if (i == 0 && j == 3) {
            return R.id.square03;
        } else if (i == 1 && j == 3) {
            return R.id.square13;
        } else if (i == 2 && j == 3) {
            return R.id.square23;
        } else if (i == 3 && j == 3) {
            return R.id.square33;
        } else if (i == 4 && j == 3) {
            return R.id.square43;
        } else if (i == 5 && j == 3) {
            return R.id.square53;
        } else if (i == 6 && j == 3) {
            return R.id.square63;
        } else if (i == 7 && j == 3) {
            return R.id.square73;
        } else if (i == 0 && j == 2) {
            return R.id.square02;
        } else if (i == 1 && j == 2) {
            return R.id.square12;
        } else if (i == 2 && j == 2) {
            return R.id.square22;
        } else if (i == 3 && j == 2) {
            return R.id.square32;
        } else if (i == 4 && j == 2) {
            return R.id.square42;
        } else if (i == 5 && j == 2) {
            return R.id.square52;
        } else if (i == 6 && j == 2) {
            return R.id.square62;
        } else if (i == 7 && j == 2) {
            return R.id.square72;
        } else if (i == 0 && j == 1) {
            return R.id.square01;
        } else if (i == 1 && j == 1) {
            return R.id.square11;
        } else if (i == 2 && j == 1) {
            return R.id.square21;
        } else if (i == 3 && j == 1) {
            return R.id.square31;
        } else if (i == 4 && j == 1) {
            return R.id.square41;
        } else if (i == 5 && j == 1) {
            return R.id.square51;
        } else if (i == 6 && j == 1) {
            return R.id.square61;
        } else if (i == 7 && j == 1) {
            return R.id.square71;
        } else if (i == 0 && j == 0) {
            return R.id.square00;
        } else if (i == 1 && j == 0) {
            return R.id.square10;
        } else if (i == 2 && j == 0) {
            return R.id.square20;
        } else if (i == 3 && j == 0) {
            return R.id.square30;
        } else if (i == 4 && j == 0) {
            return R.id.square40;
        } else if (i == 5 && j == 0) {
            return R.id.square50;
        } else if (i == 6 && j == 0) {
            return R.id.square60;
        } else if (i == 7 && j == 0) {
            return R.id.square70;
        }

        return squareID;


    }

    public int R_getDrawable(int i, int j) {
        int rDrawable = 0;

        if (board[i][j] != null && board[i][j].name.equals("Black Pawn")) {
            rDrawable = R.drawable.blackpawn;
        } else if (board[i][j] != null && board[i][j].name.equals("Black Rook")) {
            rDrawable = R.drawable.blackrook;
        } else if (board[i][j] != null && board[i][j].name.equals("Black Knight")) {
            rDrawable = R.drawable.blackknight;
        } else if (board[i][j] != null && board[i][j].name.equals("Black Bishop")) {
            rDrawable = R.drawable.blackbishop;
        } else if (board[i][j] != null && board[i][j].name.equals("Black Queen")) {
            rDrawable = R.drawable.blackqueen;
        } else if (board[i][j] != null && board[i][j].name.equals("Black King")) {
            rDrawable = R.drawable.blackking;
        } else if (board[i][j] != null && board[i][j].name.equals("White Pawn")) {
            rDrawable = R.drawable.whitepawn;
        } else if (board[i][j] != null && board[i][j].name.equals("White Rook")) {
            rDrawable = R.drawable.whiterook;
        } else if (board[i][j] != null && board[i][j].name.equals("White Knight")) {
            rDrawable = R.drawable.whiteknight;
        } else if (board[i][j] != null && board[i][j].name.equals("White Bishop")) {
            rDrawable = R.drawable.whitebishop;
        } else if (board[i][j] != null && board[i][j].name.equals("White Queen")) {
            rDrawable = R.drawable.whitequeen;
        } else if (board[i][j] != null && board[i][j].name.equals("White King")) {
            rDrawable = R.drawable.whiteking;
        } else {
            //System.out.println("The position is null");
            rDrawable = 0;
        }


        return rDrawable;
    }

    public void R_drawAndroidBoard() {

        TextView textView;
        Drawable drawable;

        int left = 20;
        int top = 0;
        int right = 70;
        int bottom = 80;


        for (int j = 7; j >= 0; j--) {
            for (int i = 0; i < 8; i++) {

                if (R_getDrawable(i, j) != 0) {
                    textView = findViewById(R_getBoardID(i, j));
                    drawable = ResourcesCompat.getDrawable(getResources(), R_getDrawable(i, j), null);
                    drawable.setBounds(left, top, right, bottom);
                    textView.setCompoundDrawables(drawable, null, null, null);

                }

            }

        }
    }



    public void deletePiece(int x, int y) {
        TextView textView = findViewById(R_getBoardID(x,y));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        System.out.println("[" + x + " " + y + "]" + " WAS DELETED");
    }

    public void setBoard() {

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
        board[4][0] = new King("White King", "wK", "White", true,0,0);
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
        board[4][7] = new King("Black King", "bK", "Black",true,0,0);
        board[5][7] = new Bishop("Black Bishop", "bB", "Black");
        board[6][7] = new Knight("Black Knight", "bN", "Black");
        board[7][7] = new Rook("Black Rook", "bR", "Black",true);

    }

    public Pieces getPiece(String abr) {
        if(abr.compareTo("wp") == 0) return new Pawn("White Pawn", "wp", "White", true, false, false);
        if(abr.compareTo("wR") == 0) return new Rook("White Rook", "wR", "White", true);
        if(abr.compareTo("wN") == 0) return new Knight("White Knight", "wN", "White");
        if(abr.compareTo("wB") == 0) return new Bishop("White Bishop", "wB", "White");
        if(abr.compareTo("wQ") == 0) return new Queen("White Queen", "wQ", "White");
        if(abr.compareTo("wK") == 0) return new King("White King", "wK", "White", true,0,0);

        if(abr.compareTo("bp") == 0) return new Pawn("Black Pawn", "bp","Black", true, false, false);
        if(abr.compareTo("bR") == 0) return new Rook("Black Rook", "bR", "Black", true);
        if(abr.compareTo("bN") == 0) return new Knight("Black Knight", "bN", "Black");
        if(abr.compareTo("bB") == 0) return new Bishop("Black Bishop", "bB", "Black");
        if(abr.compareTo("bQ") == 0) return new Queen("Black Queen", "bQ", "Black");
        if(abr.compareTo("bK") == 0) return new King("Black King", "bK", "Black",true,0,0);

        return null;
    }

    public String moveNext() {

        boolean promoted = false;
        if(rewind.end) return "END OF GAME";
        String piecePromoted = "";
        String move_number = "Move " + (rewind.move_index + 1);

        System.out.println("start");
        Pieces deleted = getPiece(rewind.getDeleted());
        System.out.println("got piece");
        if(deleted != null) System.out.println(deleted.name);
        else System.out.println("deleted piece is null");
        int deleted_X = rewind.getDeletedX();
        int deleted_Y = rewind.getDeletedY();
        int start_X = rewind.getStartX();
        int start_Y = rewind.getStartY();
        int final_X = rewind.getFinalX();
        int final_Y = rewind.getFinalY();
        String promotion = rewind.getPromotion();
        System.out.println("THIS IS THE PROMOTION: " + promotion);
        System.out.println("got positions");

        if(!(deleted_X + deleted_Y == 16)) {
            board[deleted_X][deleted_Y] = null;
            deleted_turn = true;
            D_X = deleted_X;
            D_Y = deleted_Y;
        }
        System.out.println("deleted delete piece");
        ///////////////////////////////replace piece with promotion/////////////////
        if(promotion.equals("Q") && board[start_X][start_Y].color.equals("White")){
            board[final_X][final_Y] = new Queen("White Queen", "wQ", "White");
            piecePromoted = "Queen";
            promoted = true;
        }else if(promotion.equals("N")  && board[start_X][start_Y].color.equals("White")){
            board[final_X][final_Y] = new Knight("White Knight", "wN", "White");
            piecePromoted = "Knight";
            promoted = true;
        }else if(promotion.equals("B")  && board[start_X][start_Y].color.equals("White")){
            board[final_X][final_Y] = new Bishop("White Bishop", "wB", "White");
            piecePromoted = "Bishop";
            promoted = true;
        }else if(promotion.equals("R")  && board[start_X][start_Y].color.equals("White")){
            board[final_X][final_Y] = new Rook("White Rook", "wR", "White", false);
            piecePromoted = "Rook";
            promoted = true;
        }else if(promotion.equals("Q") && board[start_X][start_Y].color.equals("Black")){
            board[final_X][final_Y] = new Queen("Black Queen", "bQ", "Black");
            piecePromoted = "Queen";
            promoted = true;
        }else if(promotion.equals("N")  && board[start_X][start_Y].color.equals("Black")){
            board[final_X][final_Y] = new Knight("Black Knight", "bN", "Black");
            piecePromoted = "Knight";
            promoted = true;
        }else if(promotion.equals("B")  && board[start_X][start_Y].color.equals("Black")){
            board[final_X][final_Y] = new Bishop("Black Bishop", "bB", "Black");
            piecePromoted = "Bishop";
            promoted = true;
        }else if(promotion.equals("R")  && board[start_X][start_Y].color.equals("Black")){
            board[final_X][final_Y] = new Rook("Black Rook", "bR", "Black", false);
            piecePromoted = "Rook";
            promoted = true;
        }else if(promotion.equals("C")){
            if(final_X == 0 && final_Y == 0){
                board[0][0] = null;
                board[2][0] = new King("White King", "wK", "White", false,2,0);
                board[3][0] = new Rook("White Rook", "wR", "White", false);
            }else if(final_X == 7 && final_Y == 0){
                board[7][0] = null;
                board[6][0] = new King("White King", "wK", "White", false,6,0);
                board[5][0] = new Rook("White Rook", "wR", "White", false);
            }else if(final_X == 0 && final_Y == 7){
                board[0][7] = null;
                board[2][7] = new King("Black King", "bK", "Black", false,2,7);
                board[3][7] = new Rook("Black Rook", "bR", "Black", false);
            }else if(final_X == 7 && final_Y == 7){
                board[7][7] = null;
                board[6][7] = new King("Black King", "bK", "Black", false,6,7);
                board[5][7] = new Rook("Black Rook", "bR", "Black", false);
            }

        }else{
            board[final_X][final_Y] = board[start_X][start_Y];
        }
        /////////////////////////////////end promotion////////////////////////////
//        board[final_X][final_Y] = board[start_X][start_Y];
        System.out.println("moved piece");
        board[start_X][start_Y] = null;
        deleted_turn2 = true;
        D2_X = start_X;
        D2_Y = start_Y;
        System.out.println("deleted initial");

        rewind.incrementMove();
        String message;
        if(promoted && deleted == null){
            message = move_number + ": " + "Pawn promoted to " + piecePromoted + "!";
            promoted = false;
            return message;
        }else if (deleted == null) {
            return move_number;
        }
        System.out.println("not null");

        System.out.println("move incremented");

        if(promoted && deleted != null){
            message = move_number + ": " + "Pawn promoted to " + piecePromoted + ". " + deleted.name + " was taken!";

        }else{
            message = move_number + ": " + deleted.name + " was taken!";
        }
        return message;
    }
    public String moveBack() {
        boolean castling = false;
        boolean enPassant = false;

        if(rewind.move_index == 0) return "START OF GAME";

        rewind.decrementMove();

        String move_number = "Move " + (rewind.move_index + 1);

        System.out.println("");
        Pieces deleted = getPiece(rewind.getDeleted());
        int deleted_X = rewind.getDeletedX();
        int deleted_Y = rewind.getDeletedY();
        int start_X = rewind.getStartX();
        int start_Y = rewind.getStartY();
        int final_X = rewind.getFinalX();
        int final_Y = rewind.getFinalY();
        String promotion = rewind.getPromotion();
        System.out.println("");

        System.out.println("");
        //////////////////////////Deleted promotion undo////////////////////////////////////////////
        if(promotion.equals("Q") || promotion.equals("N") || promotion.equals("B") || promotion.equals("R")){
            if(board[final_X][final_Y].color.equals("White")){
                board[start_X][start_Y] = new Pawn("White Pawn", "wp","White", false, false, false);
            } else{
                board[start_X][start_Y] = new Pawn("Black Pawn", "bp","Black", false, false, false);
            }
        }else if(promotion.equals("E")){
            System.out.println("IT IS IN E");
            System.out.println("THE COLOR: " + board[final_X][final_Y].color);
            if(board[final_X][final_Y].color.equals("White")){
                board[final_X][final_Y-1] = new Pawn("Black Pawn", "bp","Black", false, false, false);
                board[start_X][start_Y] = board[final_X][final_Y];
                board[final_X][final_Y] = null;
                enPassant = true;
            }else {
                board[final_X][final_Y+1] = new Pawn("White Pawn", "wp","White", false, false, false);
                board[start_X][start_Y] = board[final_X][final_Y];
                board[final_X][final_Y] = null;
                enPassant = true;
            }
        }
        else if(promotion.equals("C")){
            if(start_X == 4 && start_Y == 0 && final_X == 0 && final_Y == 0){
                board[2][0] = null;
                board[3][0] = null;
                board[4][0] = new King("White King", "wK", "White", true,4,0);
                board[0][0] = new Rook("White Rook", "wR", "White", true);
                deletePiece(2,0);
                deletePiece(3,0);
                R_drawAndroidBoard();
                castling = true;
            }else if(start_X == 4 && start_Y == 7 && final_X == 0 && final_Y == 7){
                board[2][7] = null;
                board[3][7] = null;
                board[4][7] = new King("Black King", "bK", "Black", true,4,7);
                board[0][7] = new Rook("Black Rook", "bR", "Black", true);
                deletePiece(2,7);
                deletePiece(3,7);
                R_drawAndroidBoard();
                castling = true;
            }else if(start_X == 4 && start_Y == 0 && final_X == 7 && final_Y == 0){
                board[6][0] = null;
                board[5][0] = null;
                board[4][0] = new King("White King", "wK", "White", true,4,0);
                board[7][0] = new Rook("White Rook", "wR", "White", true);
                deletePiece(6,0);
                deletePiece(5,0);
                R_drawAndroidBoard();
                castling = true;
            }else if(start_X == 4 && start_Y == 7 && final_X == 7 && final_Y == 7){
                board[6][7] = null;
                board[5][7] = null;
                board[4][7] = new King("Black King", "bK", "Black", true,4,7);
                board[7][7] = new Rook("Black Rook", "bR", "Black", true);
                deletePiece(6,7);
                deletePiece(5,7);
                R_drawAndroidBoard();
                castling = true;
            }
        }
        else{
            board[start_X][start_Y] = board[final_X][final_Y];
            board[final_X][final_Y] = null;
        }
/////////////////////////////Deleted promotion undo end//////////////////////////////////////
//        board[start_X][start_Y] = board[final_X][final_Y];
        System.out.println("");

        deleted_turn = true;
        D_X = final_X;
        D_Y = final_Y;
        System.out.println("");
        if(!(deleted_X + deleted_Y == 16) && !castling && !enPassant ) board[deleted_X][deleted_Y] = deleted;
//        if(!(deleted_X + deleted_Y == 16) && !castling) board[deleted_X][deleted_Y] = deleted;
        System.out.println("");

        if(rewind.move_index == 0) return "START OF GAME";
        if(deleted == null) return move_number;

        return move_number + ": " + deleted.name + " was returned!";
    }


    public void drawBoard() {
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewind);



        //Disables the chess board
        TextView textView;
        for(int j = 7; j >= 0; j--){
            for(int i = 0; i < 8; i++){
                textView = findViewById(R_getBoardID(i, j));
                textView.setEnabled(false);
                textView.setTextColor(Color.argb(0, 255, 0, 0));
            }
        }

        message = (TextView) findViewById(R.id.rewind_message);
        message.setText("");
        Intent activity_rewind = getIntent();
        rewind = (MainActivity.saved_game) activity_rewind.getSerializableExtra("pass");
        title = (TextView) findViewById(R.id.rewind_title);
        title.setText("Replaying '" + rewind.getName() + "' on " + rewind.getDate());

        setBoard();
        R_drawAndroidBoard();
        drawBoard();


        Button forward = (Button) findViewById(R.id.FORWARD_BUTTON);
        Button back = (Button) findViewById(R.id.BACKWARDS_BUTTON);

        if(rewind.getMoves().size() == 0) {
            back.setEnabled(false);
            forward.setEnabled(false);
            message.setText("START OF GAME: NO MOVES SAVED!");
        }else{
            back.setEnabled(false);
            message.setText("START OF GAME");
        }

//        Button back = (Button) findViewById(R.id.BACKWARDS_BUTTON);
//        back.setEnabled(false);
//        message.setText("START OF GAME");
    }

    public void REPLAY_HOME_BUTTON(View v) {
        while(rewind.move_index != 0) moveBack();
        rewind.resetMove();
        message.setText("");
        this.finish();
    }
    public void BACKWARDS_BUTTON(View v) {
        Button forward = (Button) findViewById(R.id.FORWARD_BUTTON);
        forward.setEnabled(true);
        deleted_turn = false;
        message.setText(moveBack());
        if(deleted_turn) {
            deletePiece(D_X, D_Y);
            D_X = 0;
            D_Y = 0;
            deleted_turn = false;
        }
        R_drawAndroidBoard();
        drawBoard();
        if(rewind.move_index == 0) {
            Button back = (Button) findViewById(R.id.BACKWARDS_BUTTON);
            back.setEnabled(false);
        }
    }
    public void FORWARD_BUTTON(View v) {
        if(rewind.end) {
            Button forward = (Button) findViewById(R.id.FORWARD_BUTTON);
            forward.setEnabled(false);
        }
        Button back = (Button) findViewById(R.id.BACKWARDS_BUTTON);
        back.setEnabled(true);
        deleted_turn = false;
        deleted_turn2 = false;
        message.setText(moveNext());
        if(deleted_turn) {
            deletePiece(D_X, D_Y);
            D_X = 0;
            D_Y = 0;
            deleted_turn = false;
        }
        if(deleted_turn2) {
            deletePiece(D2_X, D2_Y);
            D2_X = 0;
            D2_Y = 0;
            deleted_turn2 = false;
        }
        R_drawAndroidBoard();
        drawBoard();
    }
}