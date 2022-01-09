package com.lld.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int DEFAULT_BOARD_SIZE = 100;

    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(int size) {
        this.size = size;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
    }

    public Board(){
        this(Board.DEFAULT_BOARD_SIZE);
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public int getSize() {
        return size;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }
}
