package com.lld.model;

public abstract class Player {
    private String userName;
    private char symbol;
    private boolean hasWon;

    public Player(String userName, char symbol) {
        this.userName = userName;
        this.symbol = symbol;
    }

    public String getUserName() {
        return userName;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public abstract void makeMove(TicTacToeBoard board);
}
