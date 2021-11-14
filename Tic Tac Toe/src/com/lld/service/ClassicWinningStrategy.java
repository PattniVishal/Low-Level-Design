package com.lld.service;

import com.lld.model.Player;
import com.lld.model.TicTacToeBoard;

public class ClassicWinningStrategy implements IWinningStrategy {
    @Override
    public boolean hasWon(Player player, TicTacToeBoard board) {
        char symbol = player.getSymbol();
        char[][] b = board.getBoard();
        int row = board.getBoard().length;
        int col = board.getBoard()[0].length;
        boolean hasWon = false;

        // check row-wise
        for (int i = 0; i < row; i++) {
            hasWon = true;
            for (int j = 0; j < col; j++) {
                if (b[i][j] != symbol) {
                    hasWon = false;
                    break;
                }
            }
            if (hasWon) {
                return true;
            }
        }

        // check column-wise
        for (int i = 0; i < row; i++) {
            hasWon = true;
            for (int j = 0; j < col; j++) {
                if (b[j][i] != symbol) {
                    hasWon = false;
                    break;
                }
            }
            if (hasWon) {
                return true;
            }
        }

        // check left-diagonal
        hasWon = true;
        for (int i = 0; i < row; i++) {
            if (b[i][i] != symbol) {
                hasWon = false;
                break;
            }
        }
        if (hasWon) {
            return true;
        }

        // check right-diagonal
        hasWon = true;
        for (int i = 0; i < row; i++) {
            if (b[i][row-i-1] != symbol) {
                hasWon = false;
                break;
            }
        }
        if (hasWon) {
            return true;
        }

        return false;
    }
}
