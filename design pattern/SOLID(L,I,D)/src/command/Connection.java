package command;

public class Connection {
    private Command command;

    public Connection(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeAction(){
        command.execute();
    }
}
