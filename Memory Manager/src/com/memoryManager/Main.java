package com.memoryManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        System.out.println("Max Capacity Of Memory : ");
        int maxCapacity = sc.nextInt();

        Memory memory = new Memory(maxCapacity);
        MemoryManager memoryManager = new MemoryManager(memory);

        String commandString = "";
        while(!commandString.equals("exit")){
            commandString = "";
            System.out.println("memManager > ");
            commandString = sc.nextLine();

            String[] arg = commandString.split(" ");

            switch (arg[0]){
                case "allocate":
                    memoryManager.allocate(arg[1], arg[2], Integer.parseInt(arg[3]));
                    break;
                case "free":
                    memoryManager.free(arg[1], arg[2]);
                    break;
                case "kill":
                    memoryManager.kill(arg[1]);
                    break;
                case "inspect":
                    memoryManager.inspect(arg[1]);
                    break;
                case "status":
                    memoryManager.status();
                    break;
            }
        }
    }
}
