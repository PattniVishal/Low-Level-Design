package service.commands;

public enum CommandRegistry {
    REGISTER_USER("register"),
    ADD_EXPENSE("expense");

    private String command;

    CommandRegistry(String command) {
        this.command = command;
    }
}
