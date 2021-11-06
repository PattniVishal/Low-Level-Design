package com.memoryManager.service;

import com.memoryManager.exception.InvalidMemoryAllocationArguments;
import com.memoryManager.exception.NoSuchMemoryBlock;
import com.memoryManager.exception.NoSuchProcess;
import com.memoryManager.model.Block;
import com.memoryManager.model.Memory;
import com.memoryManager.model.Process;

import java.util.List;

public class MemoryManager {
    private Memory memory;
    private int memoryUsed;
    private double maxMemoryAllowedAtOnce;

    public MemoryManager(Memory memory) {
        this.memory = memory;
        this.memoryUsed = 0;
        this.maxMemoryAllowedAtOnce = this.memory.getMaxCapacity() * 0.25;
    }

    // allocate memory
    public void allocate(String processName, String variableName, int memoryRequested) throws InvalidMemoryAllocationArguments {
        if (isVariablePresentInProcess(processName, variableName) ||
                !isRequestedMemoryLessThanAllowed(memoryRequested)) {
            throw new InvalidMemoryAllocationArguments("Please check arguments");
        }

        Block newBlock = new Block(variableName, memoryRequested);
        List<Process> processList = this.memory.getProcessList();

        for (Process process : processList) {
            if (process.getProcessName().equals(processName)) {
                process.getMemoryBlockList().add(newBlock);
                this.memoryUsed += memoryRequested;
                printSuccess();
                return;
            }
        }
        Process newProcess = new Process(processName);
        processList.add(newProcess);
        processList.get(processList.indexOf(newProcess)).getMemoryBlockList().add(newBlock);
        this.memoryUsed += memoryRequested;
        printSuccess();
    }

    // free any memory block within any process
    public void free(String processName, String variableName) throws NoSuchProcess, NoSuchMemoryBlock {
        List<Process> processList = this.memory.getProcessList();

        if (!processList.contains(new Process(processName))) {
            throw new NoSuchProcess("Process with name " + processName + " does not exist");
        }

        for (Process process : processList) {
            if (process.getProcessName().equals(processName)) {
                if (!process.getMemoryBlockList().contains(new Block(variableName))) {
                    throw new NoSuchMemoryBlock("Memory Block with variable name " + variableName + " does not exist");
                }
                process.getMemoryBlockList().stream().forEach(b -> {
                    if (b.getVariableName().equals(variableName)) {
                        this.memoryUsed -= b.getMemoryOccupied();
                    }
                });
                Block blockToRemove = new Block(variableName);
                process.getMemoryBlockList().remove(blockToRemove);
                printSuccess();
                return;
            }
        }
    }

    // kill existing process and variables of that process
    public void kill(String processName) throws NoSuchProcess {
        Process processToRemove = new Process(processName);
        List<Process> processList = this.memory.getProcessList();

        if (!processList.contains(processToRemove)) {
            throw new NoSuchProcess("Process with name " + processName + " does not exist");
        }

        for (Process process : processList) {
            if (process.getProcessName().equals(processName)) {
                process.getMemoryBlockList().stream().forEach(b -> {
                    memoryUsed -= b.getMemoryOccupied();
                });
                processList.remove(processToRemove);
                printSuccess();
                return;
            }
        }
    }

    // check current status of process (and its variables)
    public void inspect(String processName) throws NoSuchProcess {
        List<Process> processList = this.memory.getProcessList();

        if (!processList.contains(new Process(processName))) {
            throw new NoSuchProcess("Process with name " + processName + " does not exist");
        }

        for (Process process : processList) {
            if (process.getProcessName().equals(processName)) {
                System.out.println("Process Name : " + process.getProcessName());
                process.getMemoryBlockList().stream().forEach(b -> {
                    System.out.print("Variable " + b.getVariableName() + " Occupied " + b.getMemoryOccupied() + "\n");
                });
                return;
            }
        }
    }

    // show complete view of memory
    public void status() {
        List<Process> processList = this.memory.getProcessList();

        processList.stream().forEach(process -> {
            System.out.println("Process Name : " + process.getProcessName());
            process.getMemoryBlockList().stream().forEach(b -> {
                System.out.print("Variable " + b.getVariableName() + " Occupied " + b.getMemoryOccupied() + "\n");
            });
        });
    }

    // allocation of memory for an existing variable within a process not allowed
    private boolean isVariablePresentInProcess(String processName, String variableName) {
        List<Process> processList = this.memory.getProcessList();
        for (Process process : processList) {
            if (process.getProcessName().equals(processName)) {
                int index = process.getMemoryBlockList().indexOf(new Block(variableName));
                if (index < 0)
                    return false;
                else
                    return true;
            }
        }
        return false;
    }

    // process may not request more than a 25% of the total memory
    private boolean isRequestedMemoryLessThanAllowed(int memoryRequested) {
        return (memoryRequested < this.maxMemoryAllowedAtOnce);
    }

    public void printSuccess() {
        System.out.println("SUCCESS : " + this.memoryUsed + " / " + (this.memory.getMaxCapacity() - this.memoryUsed));
    }
}
