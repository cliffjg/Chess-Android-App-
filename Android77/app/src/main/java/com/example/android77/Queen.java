package com.example.android77;


public class Queen extends Pieces {

    /**
     * Creates superclass with name abbreviation and color of the piece
     * @param name Accepts queen name and sets it to queen piece
     * @param abbreviation Accepts abbreviation for queen and sets it to queen piece
     * @param color Accepts color for queen and sets it to queen piece
     */
    public Queen(String name, String abbreviation, String color) {

        super(name, abbreviation, color);

    }

    /**
     *
     * @return returns the color and sets it to queen piece
     */
    public String getColor() {
        return color;
    }

    /**
     * Checks to see if the move is valid depending on if path is free
     * @param board Used for coordinate input on chess board
     * @param queen Creates queen object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result which is new move if the move is valid
     */
    public boolean isValidMove(Pieces[][] board, Queen queen, int firstX, int firstY, int nextX, int nextY) {
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

            //move up right
        }else if (firstX < nextX && firstY < nextY) {

            result = checkPathRightDiagonolUp(board, queen, firstX, firstY, nextX, nextY);


            //move up left
        } else if (firstX > nextX && firstY < nextY) {


            result = checkPathLeftDiagonolUp(board, queen, firstX, firstY, nextX, nextY);
            //result = isFriendlySpace (board, bishop, nextX, nextY);

            //move down right
        }else
        if (firstX < nextX && firstY > nextY){

            result = checkPathRightDiagonolDown(board, queen, firstX, firstY, nextX, nextY);
            //result = isFriendlySpace (board, bishop, nextX, nextY);

            //move down left
        }else
        if (firstX > nextX && firstY > nextY) {

            result = checkPathLeftDiagonolDown(board, queen, firstX, firstY, nextX, nextY);
            //result = isFriendlySpace (board, bishop, nextX, nextY);

        }else if (nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
            result = false;

        }else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
            result = false;
        }

        if(result == true) {
            //rook.firstMove = false;
            board[nextX][nextY] = queen;
            board[firstX][firstY]	= null;
        }

        return result;
    }

    /**
     * checks to see if the move is valid
     * @param board Used for coordinate input on chess board
     * @param queen Creates queen object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result which is new move if the move is valid
     */
    public boolean isValidMoveForCheck(Pieces[][] board, Queen queen, int firstX, int firstY, int nextX, int nextY) {
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

            //move up right
        }else if (firstX < nextX && firstY < nextY) {

            result = checkPathRightDiagonolUp(board, queen, firstX, firstY, nextX, nextY);


            //move up left
        } else if (firstX > nextX && firstY < nextY) {


            result = checkPathLeftDiagonolUp(board, queen, firstX, firstY, nextX, nextY);
            //result = isFriendlySpace (board, bishop, nextX, nextY);

            //move down right
        }else
        if (firstX < nextX && firstY > nextY){

            result = checkPathRightDiagonolDown(board, queen, firstX, firstY, nextX, nextY);
            //result = isFriendlySpace (board, bishop, nextX, nextY);

            //move down left
        }else
        if (firstX > nextX && firstY > nextY) {

            result = checkPathLeftDiagonolDown(board, queen, firstX, firstY, nextX, nextY);
            //result = isFriendlySpace (board, bishop, nextX, nextY);

        }else if (nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
            result = false;

        }else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
            result = false;
        }



        return result;
    }

    /**
     * Checks to see if path up is available
     * @param board Used for coordinate input on chess board
     * @param x represents the x-coordinate of the original position
     * @param start represent y-coordinte of orignial position
     * @param end represents y-coordinate of new position
     * @return returns result is path up is clear
     */
    public boolean checkPathUp(Pieces[][] board, int x, int start, int end ) {
        boolean results = false;

        for(int i = start+1; i <= end ; i++) {
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

    /**
     * Checks to see if path down is available
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

    /**
     * @param board Used for coordinate input on chess board
     * @param queen Creates queen object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result if path right diagonal up is clear of any piece
     */
    public boolean checkPathRightDiagonolUp(Pieces[][] board, Queen queen,int firstX, int firstY, int nextX, int nextY) {
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
            if((x == nextX && y == nextY) && board[x][y] != null && !(board[nextX][nextY].color.equals(queen.color)) ) {
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
     * @param queen Creates queen object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result if path left diagonal up is clear of any piece
     */
    public boolean checkPathLeftDiagonolUp(Pieces[][] board, Queen queen, int firstX, int firstY, int nextX, int nextY) {
        boolean results = false;
        int count = 0;


        //left diagonal up
        int y = firstY+1;
        for (int x = firstX-1; x >= nextX; x--) {


            if (x < 0 || x > 7 || y < 0 || y > 7) {
                results = false;
                break;
            }else
            if((x == nextX && y == nextY) && board[x][y] != null && !(board[nextX][nextY].color.equals(queen.color)) ) {
//        		System.out.print(x + "," + y);
//				System.out.print(": true \n");
                results = true;

            }else if(board[x][y] != null) {
//            	System.out.print(x + "," + y);
//            	System.out.print(": false \n");
                results = false;
                break;

            }else if(board[x][y] == null && x == nextX && y == nextY ) {
//            	System.out.print(x + "," + y);
//            	System.out.print(": true \n");
                results = true;

            }

            y++;
        }

        return results;
    }

    /**
     * @param board Used for coordinate input on chess board
     * @param queen Creates queen object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result if path left diagonal down is clear of any piece
     */
    public boolean checkPathLeftDiagonolDown(Pieces[][] board, Queen queen, int firstX, int firstY, int nextX, int nextY) {
        boolean results = false;

        int count = 0;

        //left diagonal up
        int y = firstY-1;
        for (int x = firstX-1; x >= nextX; x--) {


            if (x < 0 || x > 7 || y < 0 || y > 7) {
                results = false;
                break;
            }else
            if((x == nextX && y == nextY) && board[x][y] != null && !(board[nextX][nextY].color.equals(queen.color)) ) {
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


            y--;
        }


        return results;
    }

    /**
     * @param board Used for coordinate input on chess board
     * @param queen Creates queen object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result if path right diagonal down is clear of any piece
     */
    public boolean checkPathRightDiagonolDown(Pieces[][] board, Queen queen, int firstX, int firstY, int nextX, int nextY) {
        boolean results = false;

        int count = 0;

        //left diagonal up
        int y = firstY-1;
        for (int x = firstX+1; x <= nextX; x++) {


            if (x < 0 || x > 7 || y < 0 || y > 7) {
                results = false;
                break;
            }else
            if((x == nextX && y == nextY) && board[x][y] != null && !(board[nextX][nextY].color.equals(queen.color)) ) {
//        		System.out.print(x + "," + y);
//				System.out.print(": true \n");
                results = true;

            }else if(board[x][y] != null) {
//            	System.out.print(x + "," + y);
//            	System.out.print(": false \n");
                results = false;
                break;

            }else if(board[x][y] == null && x == nextX && y == nextY ) {
//            	System.out.print(x + "," + y);
//            	System.out.print(": true \n");
                results = true;

            }

            //System.out.println(x + "," + y);
            y--;
        }

        return results;
    }


}
