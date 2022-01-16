package service.commands.user;

import service.commands.CommandRegistry;
import service.commands.ICommand;

import java.util.List;

public class RegisterUserCommand implements ICommand {
    @Override
    public boolean matches(List<String> commands) {
        return (commands.size() >= 4) && (commands.get(0).equalsIgnoreCase(CommandRegistry.REGISTER_USER.name()));
    }

    @Override
    public void execute(List<String> commands) {

    }
}
