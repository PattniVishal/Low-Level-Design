package com.lld.model;

import java.util.UUID;

public class Player {
    private String id;
    private String name;
    private int position;
    private boolean hasWon;

    public Player(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.position = 0;
        this.hasWon = false;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isHasWon() {
        return hasWon;
    }
}
