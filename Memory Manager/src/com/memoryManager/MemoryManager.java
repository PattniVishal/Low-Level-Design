package com.memoryManager;

public class MemoryManager {
    private Memory memory;
    private int memoryUsed;

    public MemoryManager(Memory memory) {
        this.memory = memory;
        this.memoryUsed = 0;
    }

    public void allocate(String processName, String variableName, int memoryRequested) {
        for (Process process : this.memory.getProcessList()) {
            if (process.getProcessName().equals(processName)) {
                process.getMemoryBlockList().add(new Block(variableName, memoryRequested));
                return;
            }
        }

        this.memory.getProcessList().add(new Process(processName));
    }

    public void free(String processName, String variableName) {
        for (Process process : this.memory.getProcessList()) {
            if (process.getProcessName().equals(processName)) {
                process.getMemoryBlockList().remove(new Block(variableName));
                return;
            }
        }
    }

    public void kill(String processName) {
        this.memory.getProcessList().remove(new Process(processName));
    }

    public void inspect(String processName) {
        for(Process process : this.memory.getProcessList()){
            System.out.println("Process Name : " + process.getProcessName());
            process.getMemoryBlockList().stream().forEach(b -> {
                System.out.print("Variable " + b.getVariableName() + " Occupied " + b.getMemoryOccupied());
            });
        }
    }

    public void status() {

    }
}
