package com.example.android77;



public class Knight extends Pieces {

    /**
     * Creates superclass with name abbreviation and color of the piece
     * @param name Accepts knight name and sets it to knight piece
     * @param abbreviation Accepts abbreviation for knight and sets it to knight piece
     * @param color Accepts color for knight and sets it to knight piece
     */
    public Knight(String name, String abbreviation, String color) {

        super(name, abbreviation, color);

    }

    /**
     *
     * @return returns the color and sets it to knight piece
     */
    public String getColor() {
        return color;
    }

    /**
     * Checks to see if the move is valid depending on if path is free
     * @param board Used for coordinate input on chess board
     * @param knight Creates knight object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result which is new move if the move is valid
     */
    public boolean isValidMove(Pieces[][] board, Knight knight, int firstX, int firstY, int nextX, int nextY) {
        boolean result = false;


        //Two up one left
        if(firstX - 1  == nextX && firstY + 2 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);


            //Two down one left
        }else if(firstX - 1  == nextX && firstY - 2 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);


            //Two up one right
        }else if(firstX + 1 == nextX && firstY + 2 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);


            //Two down one right
        }else if(firstX + 1   == nextX && firstY - 2 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);


            //Two left one up
        }else if(firstX - 2  == nextX && firstY + 1 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);


            //Two left one down
        }else if(firstX - 2  == nextX && firstY - 1 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);


            //Two right one up
        }else if(firstX + 2  == nextX && firstY + 1 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);



            //Two right one down
        }else if(firstX + 2  == nextX && firstY - 1 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);


            //bounds
        }else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
            result = false;

        }

        if(result == true) {

            board[nextX][nextY] = knight;
            board[firstX][firstY]	= null;
        }

        return result;
    }

    /**
     * checks to see if the move is valid
     * @param board Used for coordinate input on chess board
     * @param knight Creates knight object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result which is new move if the move is valid
     */
    public boolean isValidMoveForCheck(Pieces[][] board, Knight knight, int firstX, int firstY, int nextX, int nextY) {
        boolean result = false;


        //Two up one left
        if(firstX - 1  == nextX && firstY + 2 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);


            //Two down one left
        }else if(firstX - 1  == nextX && firstY - 2 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);


            //Two up one right
        }else if(firstX + 1 == nextX && firstY + 2 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);


            //Two down one right
        }else if(firstX + 1   == nextX && firstY - 2 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);


            //Two left one up
        }else if(firstX - 2  == nextX && firstY + 1 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);


            //Two left one down
        }else if(firstX - 2  == nextX && firstY - 1 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);


            //Two right one up
        }else if(firstX + 2  == nextX && firstY + 1 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);



            //Two right one down
        }else if(firstX + 2  == nextX && firstY - 1 == nextY ) {
            result = isFriendlySpace(board,knight, nextX, nextY);


            //bounds
        }else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
            result = false;

        }



        return result;
    }




    /**
     * checks to see if a piece inputted by the user is occupied by a friendly piece
     * @param board Used for coordinate input on chess board
     * @param knight bishop Creates knight object
     * @param x represents x-coordinate of friendly space
     * @param y represents y-coordinate of friendly space
     * @return results true or false dependent if piece coordinates color is equal to piece color
     */
    public boolean isFriendlySpace(Pieces[][] board, Knight knight, int x, int y) {
        boolean results = false;


        if(board[x][y] == null) {
            results = true;

        }else if(!(board[x][y].color.equals(knight.color))) {
            results = true;

        }else if(board[x][y].color.equals(knight.color)) {
            results = false;

        }

        return results;
    }





}

