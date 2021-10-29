package com.memoryManager;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Process {
    private String processName;
    private List<Block> memoryBlockList;

    public Process(String processName) {
        this.processName = processName;
        this.memoryBlockList = new LinkedList<>();
    }

    public String getProcessName() {
        return processName;
    }

    public List<Block> getMemoryBlockList() {
        return memoryBlockList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Process process = (Process) o;
        return Objects.equals(processName, process.processName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processName);
    }
}
