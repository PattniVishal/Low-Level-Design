package com.lld.controller;

import com.lld.model.ComputerPlayer;
import com.lld.model.HumanPlayer;
import com.lld.model.Player;
import com.lld.model.TicTacToeBoard;
import com.lld.service.ClassicWinningStrategy;
import com.lld.service.IWinningStrategy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {
    private TicTacToeBoard board;
    private Deque<Player> players;  // Queue of Players
    private IWinningStrategy strategy;
    private boolean isGameOver = false;

    Scanner sc;

    public TicTacToeGame() {
        players = new LinkedList<>();
        strategy = new ClassicWinningStrategy();
        sc = new Scanner(System.in);
    }

    public void setupGame() {
        System.out.println("Enter Size of Board : ");
        int size = sc.nextInt();
        board = new TicTacToeBoard(size);   // initialize Board

        System.out.println("Enter Number of Players : ");
        int numberOfPlayers = sc.nextInt();

        for (int idx = 0; idx < numberOfPlayers; idx++) {
            System.out.println("0:Human / 1:Computer => ");
            int playerType = sc.nextInt();
            System.out.println("Name of Player " + (idx + 1) + " : ");
            String playerName = sc.nextLine();
            System.out.println("Symbol of Player " + (idx + 1) + " : ");
            char symbol = sc.next().charAt(0);

            // add Players
            switch (playerType) {
                case 0:
                    players.add(new HumanPlayer(playerName, symbol));
                    break;
                case 1:
                    players.add(new ComputerPlayer(playerName, symbol));
                    break;
            }
        }

        startGame();
    }

    private void startGame() {
        while (!isGameOver) {
            Player currentPlayer = players.remove();
            board.printBoard(board);
            System.out.println("====>" + currentPlayer.getUserName() + "'s turn");
            currentPlayer.makeMove(board);

            if (strategy.hasWon(currentPlayer, board)) {
                board.printBoard(board);
                isGameOver = true;
                printWinner(currentPlayer);
            }

            players.add(currentPlayer);
        }
    }

    private void printWinner(Player currentPlayer) {
        System.out.println("Player " + currentPlayer.getUserName() + " with Symbol '" + currentPlayer.getSymbol() + "' won the Game !!");
    }
}
