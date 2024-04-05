package com.example.android77;


public class Pieces {

    /**
     * name represents name of the chess piece
     * abbreviation represents abbreviated name of chess piece
     * color represents the color of the chess piece
     */
    String name;
    String abbreviation;
    String color;
    String fromXY;
    String toXY;
    String consumesPiece;
    String deletedXY;


    public Pieces() {


    }

    /**
     *
     * @param name name represents name of the chess piece
     * @param abbreviation abbreviation represents abbreviated name of chess piece
     * @param color represents the color of the chess piece
     */
    public Pieces(String name, String abbreviation, String color) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.color = color;

    }

    public void setFromXY(String fromXY){
        this.fromXY = fromXY;
    }

    public String getFromXY(){
        return fromXY;
    }


}

