package com.example.android77;


public class Pawn extends Pieces{

    boolean firstMove;
    boolean potentialEnPassant;
    boolean enPassantAvailable;
    boolean enPassantInitiated = false;


    /**
     *
     * @param name Accepts pawn name and sets it to pawn piece
     * @param abbreviation Accepts abbreviation for pawn and sets it to pawn piece
     * @param color Accepts color for pawn and sets it to pawn piece
     * @param firstMove represents the first move the pawn makes
     * @param potentialEnPassant shows the potential enpassant moves
     * @param enPassantAvailable checks to see of enpassant is possible
     */
    public Pawn(String name, String abbreviation, String color, boolean firstMove, boolean potentialEnPassant,boolean enPassantAvailable) {
        //public Pawn(String name, String abbreviation, String color, boolean firstMove) {

        super(name, abbreviation, color);
        this.firstMove = firstMove;
        this.potentialEnPassant = potentialEnPassant;
        this.enPassantAvailable = enPassantAvailable;

    }

    /**
     *
     * @return returns the color and sets it to pawn piece
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @param setFirstMove sets the first move of the pawn
     */
    public void setPawnsFirstMove(boolean setFirstMove) {
        this.firstMove = setFirstMove;
    }

    /**
     *
     * @return gets and accepts the first move of the pawn
     */
    public boolean getPawnFirstMove() {
        return firstMove;
    }

    /**
     *
     * @param setPotentialEnPassant sets the potential enpassant
     */
    public void setPotentialEnPassant(boolean setPotentialEnPassant) {
        this.potentialEnPassant = setPotentialEnPassant;

    }

    /**
     *
     * @param setEnPassantAvailable sets the enpassant available
     */
    public void setEnPassantAvailable(boolean setEnPassantAvailable) {
        this.enPassantAvailable = setEnPassantAvailable;
    }

    /**
     *
     * @return returns value of potential enpassant
     */
    public boolean getPotentialEnPassant() {
        return potentialEnPassant;

    }

    /**
     *
     * @return returns value of enpassant available
     */
    public boolean getEnPassantAvailable() {
        return enPassantAvailable;
    }

    /**
     * checks to see if move is valid and if pawn can move 2 spaces
     * @param board Used for coordinate input on chess board
     * @param pawn creates pawn object
     * @param tempPiece holds a temp position
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result which is new move if the move is valid
     */
    public boolean isValidMove(Pieces[][] board, Pawn pawn, Pieces tempPiece, int firstX, int firstY, int nextX, int nextY) {
        boolean result = false;

        if(pawn.color.equals("White")) {
            //can move forward if there is no piece in front of it
            if((firstX == nextX && firstY == nextY-2) && tempPiece == null && board[firstX][firstY+1] == null && pawn.firstMove) {
                result = isFriendlySpace(board,pawn, nextX, nextY);

                //can move forward if there is no piece in front of it
            }else if((firstX == nextX && firstY == nextY-1) && tempPiece == null){
                result = isFriendlySpace(board,pawn, nextX, nextY);

                //can move right if there is a black piece
            }else if((firstX == nextX-1 && firstY == nextY-1) && tempPiece != null && tempPiece.color.equals("Black")) {
                result = isFriendlySpace(board,pawn, nextX, nextY);

                //can move left if there is a black piece
            }else if((firstX == nextX+1 && firstY == nextY-1) && tempPiece != null && tempPiece.color.equals("Black")) {
                result = isFriendlySpace(board,pawn, nextX, nextY);


            }else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
                result = false;
            }else {
                result = false;
            }
        }else {
            if((firstX == nextX && firstY == nextY+2) && tempPiece == null && board[firstX][firstY-1] == null && pawn.firstMove) {
                //if((firstPostionX == nextPostionX && 6 == nextPostionY+2) && tempPiece == null) {

                result = true;

                //can move forward if there is no piece in front of it
            }else if((firstX == nextX && firstY == nextY+1) && tempPiece == null){
                result = true;

                //can move left if there is a white piece
            }else if((firstX == nextX+1 && firstY == nextY+1) && tempPiece != null && tempPiece.color.equals("White")) {
                result = true;

                //can move right if there is a white piece
            }else if((firstX == nextX-1 && firstY == nextY+1) && tempPiece != null && tempPiece.color.equals("White")) {
                result = true;
            }else {
                result = false;
            }
        }




        if(result == true) {



            board[nextX][nextY] = pawn;
            board[firstX][firstY]	= null;

            //once pawn moves for the first time it is set to false
            // so it can't jump two spaces
            pawn.setPawnsFirstMove(false);
            ((Pawn)board[nextX][nextY]).setPawnsFirstMove(false);

            if(pawn.potentialEnPassant(pawn.color,nextY, board,nextX, nextY)) {
                pawn.setPotentialEnPassant(true);
                ((Pawn)board[nextX][nextY]).setPotentialEnPassant(true);
            }
        }

        return result;
    }

    /**
     * checks to see if the move is valid
     * @param board Used for coordinate input on chess board
     * @param pawn Creates pawn object
     * @param tempPiece holds temp position for king
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result which is new move if the move is valid
     */
    public boolean isValidMoveForCheck(Pieces[][] board, Pawn pawn, King tempPiece, int firstX, int firstY, int nextX, int nextY) {
        boolean result = false;

        if(pawn.color.equals("White")) {
            //can move forward if there is no piece in front of it
            if((firstX == nextX && firstY == nextY-2) && tempPiece == null && board[firstX][firstY+1] == null && pawn.firstMove) {
                result = isFriendlySpace(board,pawn, nextX, nextY);

                //can move forward if there is no piece in front of it
            }else if((firstX == nextX && firstY == nextY-1) && tempPiece == null){
                result = isFriendlySpace(board,pawn, nextX, nextY);

                //can move right if there is a black piece
            }else if((firstX == nextX-1 && firstY == nextY-1) && tempPiece != null && tempPiece.color.equals("Black")) {
                result = isFriendlySpace(board,pawn, nextX, nextY);

                //can move left if there is a black piece
            }else if((firstX == nextX+1 && firstY == nextY-1) && tempPiece != null && tempPiece.color.equals("Black")) {
                result = isFriendlySpace(board,pawn, nextX, nextY);


            }else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
                result = false;
            }else {
                result = false;
            }
        }else {
            if((firstX == nextX && firstY == nextY+2) && tempPiece == null && board[firstX][firstY-1] == null && pawn.firstMove) {
                //if((firstPostionX == nextPostionX && 6 == nextPostionY+2) && tempPiece == null) {

                result = true;

                //can move forward if there is no piece in front of it
            }else if((firstX == nextX && firstY == nextY+1) && tempPiece == null){
                result = true;

                //can move left if there is a white piece
            }else if((firstX == nextX+1 && firstY == nextY+1) && tempPiece != null && tempPiece.color.equals("White")) {
                //System.out.print("VALID MOVE PAWN CHECK -> ");
                result = true;

                //can move right if there is a white piece
            }else if((firstX == nextX-1 && firstY == nextY+1) && tempPiece != null && tempPiece.color.equals("White")) {
                //System.out.print("VALID MOVE PAWN CHECK -> ");
                result = true;
            }else {
                //System.out.print("(NOT) VALID MOVE PAWN CHECK -> ");
                result = false;
            }
        }


        return result;
    }


    /**
     * checks to see if a piece inputted by the user is occupied by a friendly piece
     * @param board Used for coordinate input on chess board
     * @param pawn bishop Creates pawn object
     * @param x represents x-coordinate of friendly space
     * @param y represents y-coordinate of friendly space
     * @return results true or false dependent if piece coordinates color is equal to piece color
     */
    public boolean isFriendlySpace(Pieces[][] board, Pawn pawn, int x, int y) {
        boolean results = false;


        if(board[x][y] == null) {
            results = true;

        }else if(!(board[x][y].color.equals(pawn.color))) {
            results = true;

        }else if(board[x][y].color.equals(pawn.color)) {
            results = false;

        }

        return results;
    }




    /**
     * checks to see if white pawn has reached the other side
     * @param nextPostionY represents the y-coordinate of new position
     * @return results dependent if piece reaches other side
     */
    public boolean isWhitePromotion(int nextPostionY) {

        if(nextPostionY == 7) {
            //System.out.println("Can be promoted");
            return true;
        }
        return false;
    }

    /**
     * checks to see if black pawn has reached the other side
     * @param nextPostionY represents the y-coordinate of new position
     * @return results dependent if piece reaches other side
     */
    public boolean isBlackPromotion(int nextPostionY) {

        if(nextPostionY == 0) {
            return true;
        }
        return false;
    }

    /**
     * shows the potential enpassant moves
     * @param color represents the color of the pawn piece
     * @param enPassantPositionY represents the y-coordinate of the piece at enpassant
     * @param board represent the board array
     * @param x represents the x-coordinate
     * @param y represents the y-coordinate
     * @return results returns if potential enpassant is valid
     */
    public boolean potentialEnPassant(String color, int enPassantPositionY, Pieces[][] board,int x, int y/*, boolean firstMove*/) {

        boolean result = false;


        if (color.equals("White")) {
            if((enPassantPositionY == 4 && x!=0 &&board[x-1][y+2] != null && (board[x-1][y+2]).name.equals("Black Pawn"))
                    && (enPassantPositionY == 4 && x!=7 && board[x+1][y+2] != null && (board[x+1][y+2]).name.equals("Black Pawn"))/*(x == x-1 && y == y+2) */ /*&& firstMove && (firstPostionX == nextPostionX-1 && firstPostionY == nextPostionY+2*/) {
                //System.out.println("Potential enPassant 2");
                ((Pawn)board[x][y]).setPotentialEnPassant(true);
                ((Pawn)board[x-1][y+2]).setPotentialEnPassant(true);
                ((Pawn)board[x+1][y+2]).setPotentialEnPassant(true);
                //setPotentialEnPassant(boolean setPotentialEnPassant);
                result = true;
            }else if(enPassantPositionY == 4 && x!=0 && board[x-1][y+2] != null && (board[x-1][y+2]).name.equals("Black Pawn")/*(x == x-1 && y == y+2) */ /*&& firstMove && (firstPostionX == nextPostionX-1 && firstPostionY == nextPostionY+2*/) {
                //System.out.println("Potential enPassant");
                ((Pawn)board[x-1][y+2]).setPotentialEnPassant(true);
                result = true;
            }else if(enPassantPositionY == 4 && x!=7 && board[x+1][y+2] != null && (board[x+1][y+2]).name.equals("Black Pawn")/*(x == x-1 && y == y+2) */ /*&& firstMove && (firstPostionX == nextPostionX-1 && firstPostionY == nextPostionY+2*/) {
                //System.out.println("Potential enPassant");
                ((Pawn)board[x+1][y+2]).setPotentialEnPassant(true);
                result = true;
            }else {
                result = false;
            }

        } else if (color.equals("Black")) {

            if((enPassantPositionY == 3 && x!=0 &&board[x-1][y-2] != null && (board[x-1][y-2]).name.equals("White Pawn"))
                    && (enPassantPositionY == 3 && x!=7 && board[x+1][y-2] != null && (board[x+1][y-2]).name.equals("White Pawn"))/*(x == x-1 && y == y+2) */ /*&& firstMove && (firstPostionX == nextPostionX-1 && firstPostionY == nextPostionY+2*/) {
                //System.out.println("Potential enPassant 2");
                ((Pawn)board[x][y]).setPotentialEnPassant(true);
                ((Pawn)board[x-1][y-2]).setPotentialEnPassant(true);
                ((Pawn)board[x+1][y-2]).setPotentialEnPassant(true);
                //setPotentialEnPassant(boolean setPotentialEnPassant);
                result = true;
            }else if(enPassantPositionY == 3 && x!=0 && board[x-1][y-2] != null && (board[x-1][y-2]).name.equals("White Pawn")/*(x == x-1 && y == y+2) */ /*&& firstMove && (firstPostionX == nextPostionX-1 && firstPostionY == nextPostionY+2*/) {
                //System.out.println("Potential enPassant");
                ((Pawn)board[x-1][y-2]).setPotentialEnPassant(true);
                result = true;
            }else if(enPassantPositionY == 3 && x!=7 && board[x+1][y-2] != null && (board[x+1][y-2]).name.equals("White Pawn")/*(x == x-1 && y == y+2) */ /*&& firstMove && (firstPostionX == nextPostionX-1 && firstPostionY == nextPostionY+2*/) {
                //System.out.println("Potential enPassant");
                ((Pawn)board[x+1][y-2]).setPotentialEnPassant(true);
                result = true;
            }else {
                result = false;
            }


        }



        return result;

    }




    /**
     *
     * @param enPassantPositionY represents the y-coordinate of the piece at enpassant
     * @param board represent the board array
     * @param x represents the x-coordinate
     * @param y represents the y-coordinate
     * @return returns if enpassant is executed
     */
    public boolean enPassant(int enPassantPositionY, Pieces[][] board,int x, int y) {
        boolean result = false;

        //if (color.equals("White")) {
        //if(((Pawn)board[x][y]) != null && ((Pawn)board[x][y]).color.equals("White")) {

        if(((Pawn)board[x][y]).color.equals("White")) {
            if(enPassantPositionY == 4 && x!=0 && board[x-1][y] != null && (board[x-1][y]).name.equals("Black Pawn") && ((Pawn)board[x][y]).getPotentialEnPassant() &&((Pawn)board[x-1][y]).getPotentialEnPassant()/*(x == x-1 && y == y+2) */ /*&& firstMove && (firstPostionX == nextPostionX-1 && firstPostionY == nextPostionY+2*/) {
                //System.out.println("enPassant executed!");
                ((Pawn)board[x][y]).setPotentialEnPassant(false);
                board[x-1][y+1] = (Pawn)board[x][y];
                board[x][y] = null;
                board[x-1][y] = null;
                result = true;
                enPassantInitiated = true;

            }else if(enPassantPositionY == 4 && x!=7 && board[x+1][y] != null && (board[x+1][y]).name.equals("Black Pawn") && ((Pawn)board[x][y]).getPotentialEnPassant() &&((Pawn)board[x+1][y]).getPotentialEnPassant()/*(x == x-1 && y == y+2) */ /*&& firstMove && (firstPostionX == nextPostionX-1 && firstPostionY == nextPostionY+2*/) {
                //(board[x+1][y]).setEnPassantAvailable(true);
                ((Pawn)board[x][y]).setPotentialEnPassant(false);
                board[x+1][y+1] = (Pawn)board[x][y];
                board[x][y] = null;
                board[x+1][y] = null;
                //System.out.println("enPassant executed!");
                result = true;
                enPassantInitiated = true;
            }else {
                result = false;
            }
        }else {
            if(enPassantPositionY == 3 && x!=0 && board[x-1][y] != null && (board[x-1][y]).name.equals("White Pawn") && ((Pawn)board[x][y]).getPotentialEnPassant() &&((Pawn)board[x-1][y]).getPotentialEnPassant()/*(x == x-1 && y == y+2) */ /*&& firstMove && (firstPostionX == nextPostionX-1 && firstPostionY == nextPostionY+2*/) {
                //System.out.println("enPassant executed!");
                ((Pawn)board[x][y]).setPotentialEnPassant(false);
                board[x-1][y-1] = (Pawn)board[x][y];
                board[x][y] = null;
                board[x-1][y] = null;
                result = true;
                enPassantInitiated = true;

            }else if(enPassantPositionY == 3 && x!=7 && board[x+1][y] != null && (board[x+1][y]).name.equals("White Pawn") && ((Pawn)board[x][y]).getPotentialEnPassant() &&((Pawn)board[x+1][y]).getPotentialEnPassant()/*(x == x-1 && y == y+2) */ /*&& firstMove && (firstPostionX == nextPostionX-1 && firstPostionY == nextPostionY+2*/) {
                //(board[x+1][y]).setEnPassantAvailable(true);
                ((Pawn)board[x][y]).setPotentialEnPassant(false);
                board[x+1][y-1] = (Pawn)board[x][y];
                board[x][y] = null;
                board[x+1][y] = null;

                //System.out.println("enPassant executed!");
                result = true;
                enPassantInitiated = true;
            }else {
                result = false;
            }
        }



        return result;
    }

public void setEnPassantInitiatedAndroidUse(boolean enPassantInitiated ){
        this.enPassantInitiated = enPassantInitiated;
}
public boolean getEnPassantIntiatedAndroidUse(){
        return enPassantInitiated;
}


}

