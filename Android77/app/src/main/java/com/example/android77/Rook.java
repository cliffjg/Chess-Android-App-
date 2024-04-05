package com.example.android77;


public class Rook extends Pieces {

    /**
     * First move of rook can only move if true
     */
    boolean firstMove;

    /**
     * Creates superclass with name abbreviation and color and first move of the piece
     * @param name Accepts rook name and sets it to rook piece
     * @param abbreviation Accepts abbreviation for rook and sets it to rook piece
     * @param color Accepts color for rook and sets it to rook piece
     * @param firstMove Accepts first move for rook and is valid if true
     */
    public Rook(String name, String abbreviation, String color, boolean firstMove) {
        super(name, abbreviation, color);
        this.firstMove = firstMove;

    }

    /**
     * Checks to see if the move is valid depending on if path is free
     * @param board Used for coordinate input on chess board
     * @param rook Creates rook object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result which is new move if the move is valid
     */
    public boolean isValidMove(Pieces[][] board, Rook rook, int firstX, int firstY, int nextX, int nextY) {
        boolean result = false;

        //Move Up
        if(firstX == nextX && firstY < nextY ) {
            result = checkPathUp(board, firstX, firstY, nextY );

            //Move Down
        }else if(firstX == nextX && firstY > nextY ) {
            result = checkPathDown(board, firstX, firstY, nextY );


            //Move Right
        }else if(firstX < nextX && firstY == nextY ) {
            result = checkPathRight(board, firstY, firstX, nextX );

            //Move Left
        }else if(firstX > nextX && firstY == nextY ) {
            //System.out.println("Left");
            result = checkPathLeft(board, firstY, firstX, nextX );
        }else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
            result = false;
        }

        if(result == true) {
            rook.firstMove = false;
            board[nextX][nextY] = rook;
            board[firstX][firstY]	= null;
        }

        return result;
    }

    /**
     * checks to see if the move is valid
     * @param board Used for coordinate input on chess board
     * @param rook Creates rook object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result which is new move if the move is valid
     */
    public boolean isValidMoveForCheck(Pieces[][] board, Rook rook, int firstX, int firstY, int nextX, int nextY) {
        boolean result = false;

        //Move Up
        if(firstX == nextX && firstY < nextY ) {
            result = checkPathUp(board, firstX, firstY, nextY );

            //Move Down
        }else if(firstX == nextX && firstY > nextY ) {
            result = checkPathDown(board, firstX, firstY, nextY );


            //Move Right
        }else if(firstX < nextX && firstY == nextY ) {
            result = checkPathRight(board, firstY, firstX, nextX );
//            System.out.println("THIS IS THE RESULT FOR PATH RIGHT: " + result );

            //Move Left
        }else if(firstX > nextX && firstY == nextY ) {
            //System.out.println("Left");
            result = checkPathLeft(board, firstY, firstX, nextX );
        }else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
            result = false;
        }



        return result;
    }


    /**
     * checks to see if path up is available
     * @param board Used for coordinate input on chess board
     * @param x represents the x-coordinate of the original position
     * @param start represent y-coordinte of orignial position
     * @param end represents y-coordinate of new position
     * @return returns result is path up is clear
     */
    public boolean checkPathUp(Pieces[][] board, int x, int start, int end ) {
        boolean results = false;
//        System.out.println("x: " + x + "\nstart: " + start + "\nend: "+ end);
////////////////////////////////////////////////////////////////////////////////////////
        for(int i = start+1; i <= end ; i++) {
//            System.out.println("i: " + i);
            if(board[x][i] == null) {
                results = true;

            }else if(board[x][i] != null) {

                if(i == end && board[x][start].color != board[x][end].color) {
                    results = true;
                    break;

                }else{
                    results = false;
                    break;

                }


            }

        }

//////////////////////////////////////////////////////////////////////////////////////////


        return results;
    }

    /**
     * checks to see if path down is available
     * @param board Used for coordinate input on chess board
     * @param x represents the x-coordinate of the original position
     * @param start represent y-coordinte of orignial position
     * @param end represents y-coordinate of new position
     * @return returns result is path down is clear
     */
    public boolean checkPathDown(Pieces[][] board, int x, int start, int end ) {
        boolean results = false;

        for(int i = start-1; i >= end ; i--) {

            if(board[x][i] == null) {
                results = true;

            }else if(board[x][i] != null) {

                if(i == end && board[x][start].color != board[x][end].color) {
                    results = true;
                    break;

                }else{
                    results = false;
                    break;

                }


            }
        }

        return results;
    }

    //checkPathRight(board, firstY, firstX, nextX );
    /**
     * checks to see if path right is available
     * @param board Used for coordinate input on chess board
     * @param y represents the y-coordinate of the original position
     * @param start represent x-coordinte of orignial position
     * @param end represents x-coordinate of new position
     * @return returns result is path right is clear
     */
    public boolean checkPathRight(Pieces[][] board,int y, int start, int end ) {
        boolean results = false;
        for(int i = start+1; i <= end ; i++) {
            if(board[i][y] == null) {
                //System.out.println("true");
                results = true;
            }else if(board[i][y] != null ) {
                if(i == end && board[start][y].color != board[end][y].color){
                    results = true;
                    break;
                }else{
                    results = false;
                    break;
                }

            }
        }

        return results;
    }


    /**
     * checks to see if path left is available
     * @param board Used for coordinate input on chess board
     * @param y represents the y-coordinate of the original position
     * @param start represent x-coordinte of orignial position
     * @param end represents x-coordinate of new position
     * @return returns result is path left is clear
     */
    public boolean checkPathLeft(Pieces[][] board,int y, int start, int end ) {
        boolean results = false;
        for(int i = start-1; i >= end ; i--) {
            if(board[i][y] == null) {
                //System.out.println("true");
                results = true;
            }else if(board[i][y] != null ) {
                if(i == end && board[start][y].color != board[end][y].color){
                    results = true;
                    break;
                }else{
                    results = false;
                    break;
                }

            }
        }

        return results;
    }




}



