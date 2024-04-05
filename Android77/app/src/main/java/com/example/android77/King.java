package com.example.android77;



public class King extends Pieces {

    /**
     * First move of king can only move if true
     * kingsX represents x-coordinate of piece
     * kingY represents y-coordinate of piece
     */
    boolean firstMove;
    int kingsX;
    int kingsY;
    boolean castleRight = false;
    boolean castleLeft = false;

    /**
     * Creates superclass with name abbreviation and color and first move of the piece
     * @param name Accepts queen name and sets it to king piece
     * @param abbreviation Accepts abbreviation for king and sets it to king piece
     * @param color Accepts color for king and sets it to king piece
     * @param firstMove represents the first move of the king
     * @param x represents x-coordinate of position
     * @param y represents y-coordinate of position
     */
    public King(String name, String abbreviation, String color, boolean firstMove, int x, int y) {
        super(name, abbreviation, color);
        this.firstMove = firstMove;
        this.kingsX = x;
        this.kingsY = y;

    }

    /**
     * Sets the position of the king
     * @param x represents x-coordinate of position
     * @param y represents y-coordinate of position
     */
    public void setPosition(int x, int y){
        this.kingsX = x;
        this.kingsY = y;
    }

    /**
     *
     * @return returns the value of king's x-coordinate
     */
    public int getKingsX(){
        return kingsX;
    }

    /**
     *
     * @return returns the value of king's y-coordinate
     */
    public int getKingsY(){
        return kingsY;
    }



    /**
     * Checks to see if the move is valid depending on if path is free
     * @param board Used for coordinate input on chess board
     * @param king Creates king object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result which is new move if the move is valid
     */
    public boolean isValidMove(Pieces[][] board, King king, int firstX, int firstY, int nextX, int nextY) {
        boolean result = false;



//        System.out.println("KING FIRST MOVE: " + king.firstMove);
//        System.out.println("THIS IS THE Rook First Move: " + ((Rook)board[nextX][nextY]).firstMove);

        if(isCastling(board, firstX,firstY, nextX, nextY) && king.firstMove && ((Rook)board[nextX][nextY]) != null && ((Rook)board[nextX][nextY]).firstMove) {
            board[nextX][nextY] =  null;
//           System.out.println("WHAT IS GOING ON?");
            return true;
        }else

            //UP
            if(firstX == nextX && firstY + 1 == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);

                //Right Top
            }else if(firstX + 1 == nextX && firstY + 1 == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);

                //Right
            }else if(firstX + 1 == nextX && firstY == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);

                //Right Bottom
            }else if(firstX + 1 == nextX && firstY - 1 == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);

                //Bottom
            }else if(firstX == nextX && firstY - 1 == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);

                //Left Bottom
            }else if(firstX - 1 == nextX && firstY -1 == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);

                //Left
            }else if(firstX - 1 == nextX && firstY == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);


                //Left Top
            }else if(firstX - 1 == nextX && firstY + 1 == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);

            }
//		else if(canCastle(board, color, firstX, firstY, nextX, nextY)) {
//			result = isFriendlySpace(board,king, nextX, nextY);
//		}
            else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
                result = false;
            }


        if(result == true) {
            king.firstMove = false;
            board[nextX][nextY] = king;
            board[firstX][firstY]	= null;
            king.setPosition(nextX, nextY);

        }

        return result;



    }

    /**
     * checks to see if the move is valid
     * @param board Used for coordinate input on chess board
     * @param king Creates king object
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return returns result which is new move if the move is valid
     */
    public boolean isValidMoveForCheck(Pieces[][] board, King king, int firstX, int firstY, int nextX, int nextY) {
        boolean result = false;



        if(isCastling(board, firstX,firstY, nextX, nextY) && king.firstMove && ((Rook)board[nextX][nextY]) != null && ((Rook)board[nextX][nextY]).firstMove) {
            board[nextX][nextY] =  null;
            return true;
        }else

            //UP
            if(firstX == nextX && firstY + 1 == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);

                //Right Top
            }else if(firstX + 1 == nextX && firstY + 1 == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);

                //Right
            }else if(firstX + 1 == nextX && firstY == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);

                //Right Bottom
            }else if(firstX + 1 == nextX && firstY - 1 == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);

                //Bottom
            }else if(firstX == nextX && firstY - 1 == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);

                //Left Bottom
            }else if(firstX - 1 == nextX && firstY -1 == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);

                //Left
            }else if(firstX - 1 == nextX && firstY == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);


                //Left Top
            }else if(firstX - 1 == nextX && firstY + 1 == nextY ) {
                result = isFriendlySpace(board,king, nextX, nextY);

            }
//		else if(canCastle(board, color, firstX, firstY, nextX, nextY)) {
//			result = isFriendlySpace(board,king, nextX, nextY);
//		}
            else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
                result = false;
            }




        return result;



    }

    /**
     * checks to see if a piece inputted by the user is occupied by a friendly piece
     * @param board Used for coordinate input on chess board
     * @param king bishop Creates king object
     * @param x represents x-coordinate of friendly space
     * @param y represents y-coordinate of friendly space
     * @return  results if spaces are friendly or not
     */
    public boolean isFriendlySpace(Pieces[][] board, King king, int x, int y) {
        boolean results = false;


        if(board[x][y] == null) {
            results = true;

        }else if(!(board[x][y].color.equals(king.color))) {
            results = true;

        }else if(board[x][y].color.equals(king.color)) {
            results = false;

        }

        return results;
    }

    /**
     * This performs the castling move
     * @param board Used for coordinate input on chess board
     * @param firstX represents x-coordinate of original position
     * @param firstY represents y-coordinate of original position
     * @param nextX represents x-coordinate of new position
     * @param nextY represents y-coordinate of new position
     * @return results if castling move is valid
     */
    public boolean isCastling(Pieces[][] board, int firstX, int firstY, int nextX, int nextY) {
        boolean partialResult = false;
        boolean results = false;

        //checks to see if path is right
        //Move Right
        if(firstX < nextX && firstY == nextY ) {
            partialResult = checkPathRight(board, firstY, firstX, nextX );

            //Move Left
        }else if(firstX > nextX && firstY == nextY ) {
            //System.out.println("Left");
            partialResult = checkPathLeft(board, firstY, firstX, nextX );
        }


        if((firstX == 4 && firstY == 0 && nextX == 7 && nextY == 0) && partialResult) {
            ((King)board[4][0]).setPosition(6, 0);
            board[6][0] =  ((King)board[4][0]);
            board[4][0] =  null;


            board[5][0] =  ((Rook)board[7][0]);
            //board[7][0] =  null;
            castleRight = true;
            results = true;

        }else if((firstX == 4 && firstY == 0 && nextX == 0 && nextY == 0) && partialResult) {
            ((King)board[4][0]).setPosition(2, 0);
            board[2][0] =  ((King)board[4][0]);
            board[4][0] =  null;

            board[3][0] =  ((Rook)board[0][0]);
//            board[0][0] =  null;
            castleLeft = true;
            results = true;

        }else if((firstX == 4 && firstY == 7 && nextX == 7 && nextY == 7) && partialResult) {
            ((King)board[4][7]).setPosition(6, 7);
            board[6][7] =  ((King)board[4][7]);
            board[4][7] =  null;

            board[5][7] =  ((Rook)board[7][7]);
            //board[7][7] =  null;
            castleRight = true;
            results = true;

        }else if((firstX == 4 && firstY == 7 && nextX == 0 && nextY == 7) && partialResult ){
            ((King)board[4][7]).setPosition(2, 7);
            board[2][7] =  ((King)board[4][7]);
            board[4][7] =  null;

            board[3][7] =  ((Rook)board[0][7]);
//			board[0][7] =  null;

            castleLeft = true;
            results = true;

        }

        return results;
    }

    /**
     * Checks to see if king's path right is available
     * @param board Used for coordinate input on chess board
     * @param y represents the y-coordinate of the original position
     * @param start represent x-coordinte of orignial position
     * @param end represents x-coordinate of new position
     * @return returns result is path right is clear
     */
    public boolean checkPathRight(Pieces[][] board,int y, int start, int end ) {
        boolean results = false;
        for(int i = start+1; i < end ; i++) {
            if(board[i][y] == null) {
                //System.out.println("true");
                results = true;
            }
//			else if(board[end][y] != null && board[start][y].color != board[end][y].color) {
//				System.out.println("true");
//				results = true;
//				break;
//			}
            else {
                //System.out.println("false");
                results = false;
                break;
            }
        }

        return results;
    }

    /**
     * Checks to see if king's path right is available
     * @param board Used for coordinate input on chess board
     * @param y represents the y-coordinate of the original position
     * @param start represent x-coordinte of orignial position
     * @param end represents x-coordinate of new position
     * @return returns result is path left is clear
     */
    public boolean checkPathLeft(Pieces[][] board,int y, int start, int end ) {
        boolean results = false;
        for(int i = start-1; i > end ; i--) {
            if(board[i][y] == null) {
                //System.out.println("true");
                results = true;
            }
//			else if(board[end][y] != null && board[start][y].color != board[end][y].color) {
//				System.out.println("true");
//				results = true;
//				break;
//			}
            else {
                //System.out.println("false");
                results = false;
                break;
            }
        }

        return results;
    }


    public void  setCastleRight (boolean castleLeft){
        this.castleLeft = castleLeft;
    }

    public void setCastleLeft(boolean castleRight){
        this.castleRight = castleRight;
    }

    public boolean getCastleLeft(){
        return castleLeft;
    }
    public boolean getCastleRight(){
        return castleRight;
    }



}




