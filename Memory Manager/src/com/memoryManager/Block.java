package com.memoryManager;

import java.util.Objects;

public class Block {
    private String variableName;
    private int memoryOccupied;

    public Block(String variableName) {
        this.variableName = variableName;
    }

    public Block(String variableName, int memoryOccupied) {
        this.variableName = variableName;
        this.memoryOccupied = memoryOccupied;
    }

    public String getVariableName() {
        return variableName;
    }

    public int getMemoryOccupied() {
        return memoryOccupied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Objects.equals(variableName, block.variableName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variableName);
    }
}
