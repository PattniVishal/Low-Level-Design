package service.commands;

import java.util.List;

public interface ICommand {
    boolean matches(List<String> commands);

    void execute(List<String> commands);
}
