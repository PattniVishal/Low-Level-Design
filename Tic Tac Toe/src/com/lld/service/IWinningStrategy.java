package com.lld.service;

import com.lld.model.Player;
import com.lld.model.TicTacToeBoard;

public interface IWinningStrategy {
    public boolean hasWon(Player player, TicTacToeBoard board);
}
