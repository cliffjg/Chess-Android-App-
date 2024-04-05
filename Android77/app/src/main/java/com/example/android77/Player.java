package com.example.android77;


public class Player {
    String name;
    boolean playerTurn;
    boolean draw;

    /**
     * creates attributes of player
     * @param name represents the name of the chess piece
     * @param playerTurn represents the turn of user
     * @param draw represents if the game is a draw
     */
    public Player(String name, boolean playerTurn, boolean draw) {
        this.name = name;
        this.playerTurn = playerTurn;
        this.draw = draw;
    }

    /**
     * sets the player's turn
     * @param setPlayerTurn sets the player turn if boolean value is true
     */
    public void setTurn(boolean setPlayerTurn) {
        this.playerTurn = setPlayerTurn;
    }

    /**
     * sets if the game is a draw
     * @param setDraw sets the game as draw if boolean value is true
     */
    public void setDraw(boolean setDraw) {
        this.draw = setDraw;
    }

}

