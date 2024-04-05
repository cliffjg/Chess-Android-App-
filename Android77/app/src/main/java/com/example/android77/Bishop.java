package com.example.android77;



public class Bishop extends Pieces{

    /**
     * Creates superclass with name abbreviation and color of the piece
     * @param name Accepts bishop name and sets it to bishop piece
     * @param abbreviation Accepts abbreviation for bishop and sets it to bishop piece
     * @param color Accepts color for bishop and sets it to bishop piece
     */
    public Bishop(String name, String abbreviation, String color) {
        super(name, abbreviation, color);

    }

    /**
     *
     * @return returns the color and sets it to bishop piece
     */
    public String getColor() {
        return color;
    }

    /**
     * Checks to see if the move is valid depending on if path is free
     * @param board Used for coordinate input on chess board
     * @param bishop Creates bishop object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result which is new move if the move is valid
     */
    public boolean isValidMove(Pieces[][] board, Bishop bishop, int firstX, int firstY, int nextX, int nextY) {
        boolean result = false;


        //move up right
        if (firstX < nextX && firstY < nextY) {

            result = checkPathRightDiagonolUp(board, bishop, firstX, firstY, nextX, nextY);
//			System.out.println("IN HERE");
//			result = isFriendlySpace (board, bishop, nextX, nextY);

            //move up left
        } else if (firstX > nextX && firstY < nextY) {


            result = checkPathLeftDiagonolUp(board, bishop, firstX, firstY, nextX, nextY);
            //result = isFriendlySpace (board, bishop, nextX, nextY);

            //move down right
        }else
        if (firstX < nextX && firstY > nextY){

            result = checkPathRightDiagonolDown(board, bishop, firstX, firstY, nextX, nextY);
            //result = isFriendlySpace (board, bishop, nextX, nextY);

            //move down left
        }else
        if (firstX > nextX && firstY > nextY) {

            result = checkPathLeftDiagonolDown(board, bishop, firstX, firstY, nextX, nextY);
            //result = isFriendlySpace (board, bishop, nextX, nextY);

        }
        else if (nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
            result = false;
        }

        if(result == true) {

            board[nextX][nextY] = bishop;
            board[firstX][firstY]	= null;
        }

        return result;


    }


    /**
     * checks to see if the move is valid
     * @param board Used for coordinate input on chess board
     * @param bishop Creates bishop object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result which is new move if the move is valid
     */
    public boolean isValidMoveForCheck(Pieces[][] board, Bishop bishop, int firstX, int firstY, int nextX, int nextY) {
        boolean result = false;


        //move up right
        if (firstX < nextX && firstY < nextY) {

            result = checkPathRightDiagonolUp(board, bishop, firstX, firstY, nextX, nextY);
//			System.out.println("IN HERE");
//			result = isFriendlySpace (board, bishop, nextX, nextY);

            //move up left
        }else if (firstX > nextX && firstY < nextY) {


            result = checkPathLeftDiagonolUp(board, bishop, firstX, firstY, nextX, nextY);
            //result = isFriendlySpace (board, bishop, nextX, nextY);

            //move down right
        } else if (firstX < nextX && firstY > nextY){

            result = checkPathRightDiagonolDown(board, bishop, firstX, firstY, nextX, nextY);
            //result = isFriendlySpace (board, bishop, nextX, nextY);

            //move down left
        } else if (firstX > nextX && firstY > nextY) {

            result = checkPathLeftDiagonolDown(board, bishop, firstX, firstY, nextX, nextY);
            //result = isFriendlySpace (board, bishop, nextX, nextY);

        }else if (nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
            result = false;
        }else {
            result = false;
        }



        return result;


    }


    /**
     * checks to see if a piece inputted by the user is occupied by a friendly piece
     * @param board Used for coordinate input on chess board
     * @param bishop bishop Creates bishop object
     * @param x represents x-coordinate of friendly space
     * @param y represents y-coordinate of friendly space
     * @return results true or false dependent if piece coordinates color is equal to piece color
     */
    public boolean isFriendlySpace(Pieces[][] board, Bishop bishop, int x, int y) {
        boolean results = false;


        if(board[x][y] == null) {
            //System.out.println("true");
            results = true;
        }else if(!(board[x][y].color.equals(bishop.color))) {
            //System.out.println("true");

            results = true;
        }else if(board[x][y].color.equals(bishop.color)) {
            //System.out.println("true");

            results = false;
        }


        return results;
    }


    /**
     * @param board Used for coordinate input on chess board
     * @param bishop Creates bishop object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result if path right diagonal up is clear of any piece
     */
    public boolean checkPathRightDiagonolUp(Pieces[][] board, Bishop bishop,int firstX, int firstY, int nextX, int nextY) {
        boolean results = false;

        int count = 0;



        //right diagonal up
        int y = firstY+1;
        //System.out.print(firstX+1);
        for (int x = firstX+1; x <= nextX; x++) {

            //System.out.print("Testing this "+x + "," + y);

            if (x < 0 || x > 7 || y < 0 || y > 7) {
                results = false;
                break;
            }else
            if((x == nextX && y == nextY) && board[x][y] != null && !(board[nextX][nextY].color.equals(bishop.color)) ) {
                //System.out.print(x + "," + y);
                //System.out.print(": true \n");
                results = true;

            }else if(board[x][y] != null ) {

                //System.out.print(x + "," + y);
                //System.out.print(": false \n");
                results = false;
                break;

            }else if(board[x][y] == null && x == nextX && y == nextY ) {
                //System.out.print(x + "," + y);
                //System.out.print(": true \n");
                results = true;

            }




            y++;

        }

        return results;
    }


    /**
     * @param board Used for coordinate input on chess board
     * @param bishop Creates bishop object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result if path left diagonal up is clear of any piece
     */
    public boolean checkPathLeftDiagonolUp(Pieces[][] board, Bishop bishop, int firstX, int firstY, int nextX, int nextY) {
        boolean results = false;
        int count = 0;


        //left diagonal up
        int y = firstY+1;
        for (int x = firstX-1; x >= nextX; x--) {


            if (x < 0 || x > 7 || y < 0 || y > 7) {
                results = false;
                break;
            }else
            if((x == nextX && y == nextY) && board[x][y] != null && !(board[nextX][nextY].color.equals(bishop.color)) ) {
//	        		System.out.print(x + "," + y);
//					System.out.print(": true \n");
                results = true;

            }else if(board[x][y] != null) {
//	            	System.out.print(x + "," + y);
//	            	System.out.print(": false \n");
                results = false;
                break;

            }else if(board[x][y] == null && x == nextX && y == nextY ) {
//	            	System.out.print(x + "," + y);
//	            	System.out.print(": true \n");
                results = true;

            }

            y++;
        }

        return results;
    }

    /**
     * @param board Used for coordinate input on chess board
     * @param bishop Creates bishop object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result if path left diagonal up is clear of any piece
     */
    public boolean checkPathLeftDiagonolDown(Pieces[][] board, Bishop bishop, int firstX, int firstY, int nextX, int nextY) {
        boolean results = false;

        int count = 0;

        //left diagonal up
        int y = firstY-1;
        for (int x = firstX-1; x >= nextX; x--) {


            if (x < 0 || x > 7 || y < 0 || y > 7) {
                results = false;
                break;
            }else
            if((x == nextX && y == nextY) && board[x][y] != null && !(board[nextX][nextY].color.equals(bishop.color)) ) {
//		        		System.out.print(x + "," + y);
//						System.out.print(": true \n");
                results = true;

            }else if(board[x][y] != null) {
//		            	System.out.print(x + "," + y);
//		            	System.out.print(": false \n");
                results = false;
                break;

            }else if(board[x][y] == null && x == nextX && y == nextY ) {
//		            	System.out.print(x + "," + y);
//		            	System.out.print(": true \n");
                results = true;

            }


            y--;
        }


        return results;
    }

    /**
     * @param board Used for coordinate input on chess board
     * @param bishop Creates bishop object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result if path right diagonal down is clear of any piece
     */
    public boolean checkPathRightDiagonolDown(Pieces[][] board, Bishop bishop, int firstX, int firstY, int nextX, int nextY) {
        boolean results = false;

        int count = 0;

        //left diagonal up
        int y = firstY-1;
        for (int x = firstX+1; x <= nextX; x++) {


            if (x < 0 || x > 7 || y < 0 || y > 7) {
                results = false;
                break;
            }else
            if((x == nextX && y == nextY) && board[x][y] != null && !(board[nextX][nextY].color.equals(bishop.color)) ) {
//	        		System.out.print(x + "," + y);
//					System.out.print(": true \n");
                results = true;

            }else if(board[x][y] != null) {
//	            	System.out.print(x + "," + y);
//	            	System.out.print(": false \n");
                results = false;
                break;

            }else if(board[x][y] == null && x == nextX && y == nextY ) {
//	            	System.out.print(x + "," + y);
//	            	System.out.print(": true \n");
                results = true;

            }

            //System.out.println(x + "," + y);
            y--;
        }

        return results;
    }





}


