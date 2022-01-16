package service.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    List<ICommand> commandList;

    public CommandExecutor() {
        this.commandList = new ArrayList<>();
    }

    public void execute(List<String> input){
        ICommand command = getCommand(input);
        if(command != null)
            command.execute(input);
    }

    private ICommand getCommand(List<String> input){
        for (ICommand command: commandList){
            if(command.matches(input))
                return command;
        }
        return null;
    }
}
