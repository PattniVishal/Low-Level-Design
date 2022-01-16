import service.commands.CommandExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Main Init ..");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CommandExecutor commandExecutor = new CommandExecutor();

        while(true){
            System.out.print("\n> ");
            List<String> input = Arrays.asList(br.readLine().split(" "));
            try {
                commandExecutor.execute(input);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
