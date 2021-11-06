package com.memoryManager.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    private List<Process> processList;
    private int maxCapacity;

    public Memory(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.processList = new ArrayList<>();
    }

    public List<Process> getProcessList() {
        return processList;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
