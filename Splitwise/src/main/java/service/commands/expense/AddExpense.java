package service.commands.expense;

import service.commands.CommandRegistry;
import service.commands.ICommand;

import java.util.List;

public class AddExpense implements ICommand {
    @Override
    public boolean matches(List<String> commands) {
        return (commands.size() >= 6) && (commands.get(0).equalsIgnoreCase(CommandRegistry.ADD_EXPENSE.name()));
    }

    @Override
    public void execute(List<String> commands) {

    }
}
