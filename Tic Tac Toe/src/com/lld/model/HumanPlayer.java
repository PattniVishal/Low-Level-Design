package com.lld.model;

import java.util.Scanner;

public class HumanPlayer extends Player{
    Scanner sc;

    public HumanPlayer(String userName, char symbol) {
        super(userName, symbol);
        sc = new Scanner(System.in);
    }

    @Override
    public void makeMove(TicTacToeBoard board) {
        System.out.println("Enter coordinates to make move (row<space>col) : ");
        String move = sc.nextLine();
        int row = Integer.parseInt(move.split(" ")[0]);
        int col = Integer.parseInt(move.split(" ")[1]);

        board.getBoard()[row][col] = getSymbol();
    }
}
