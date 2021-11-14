package com.lld.model;

import java.util.Arrays;

public class TicTacToeBoard {
    private int size;
    private char[][] board;

    public TicTacToeBoard(int size) {
        this.size = size;
        board = new char[size][size];
        for(char[] c: board){
            Arrays.fill(c, '-');
        }
    }

    public int getSize() {
        return size;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void printBoard(TicTacToeBoard board) {
        char[][] b = board.getBoard();
        int n = board.getSize();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("| " + b[i][j] + " |");
            }
            System.out.println();
        }
    }
}
