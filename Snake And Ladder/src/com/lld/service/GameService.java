package com.lld.service;

import com.lld.model.Board;
import com.lld.model.Ladder;
import com.lld.model.Player;
import com.lld.model.Snake;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameService {

    private Board board;
    private DiceService dice;
    private Queue<Player> players;
    private boolean isGameOver;

    public GameService() {
        this.board = new Board();
        this.dice = new DiceService();
        this.players = new LinkedList<>();
        this.isGameOver = false;
    }

    public void setBoard(List<Snake> snakes, List<Ladder> ladders) {
        this.board.setLadders(ladders);
        this.board.setSnakes(snakes);
    }

    public void setPlayers(Queue<Player> players) {
        this.players.addAll(players);
    }

    public void initGame(){
        while( !isGameOver ){
            Player currentPlayer = players.poll();
            int val = dice.roll();

            movePlayer(currentPlayer, val);

            if( hasPlayerWon(currentPlayer) ){
                isGameOver = true;
            }
            else{
                players.add(currentPlayer);
            }
        }
    }

    public void movePlayer(Player player, int val){
        int currPosition = player.getPosition();
        int newPosition = currPosition + val;

        if( newPosition > board.getSize() ){
            // cannot move right now
        }
        else{
            newPosition = checkSnakeAndLadder(newPosition);
            player.setPosition(newPosition);
        }
    }

    public int checkSnakeAndLadder(int newPosition){
        for(Snake snake : board.getSnakes()){
            if(snake.getStart() == newPosition){
                newPosition = snake.getEnd();
                return newPosition;
            }
        }

        for(Ladder ladder : board.getLadders()){
            if(ladder.getStart() == newPosition){
                newPosition = ladder.getEnd();
                return newPosition;
            }
        }

        return newPosition;
    }

    public boolean hasPlayerWon(Player player){
        if(player.getPosition() == board.getSize()){
            player.setHasWon(true);
        }
        return player.isHasWon();
    }
}
