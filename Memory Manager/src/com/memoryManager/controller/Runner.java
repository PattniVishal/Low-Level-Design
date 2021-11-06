package com.memoryManager.controller;

import com.memoryManager.model.Memory;
import com.memoryManager.service.MemoryManager;

import java.util.Scanner;

public class Runner {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Max Capacity Of Memory : ");
        int maxCapacity = sc.nextInt();

        Memory memory = new Memory(maxCapacity);
        MemoryManager memoryManager = new MemoryManager(memory);

        String command = "";
        while (!command.equals("exit")) {
            command = "";
            System.out.println("\n enter command > ");
            command = sc.nextLine();

            String[] arg = command.split(" ");

            try {
                switch (arg[0]) {
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
            catch(Exception e){
                System.out.println("ERROR -> " + e.getMessage());
            }
        }
    }
}
