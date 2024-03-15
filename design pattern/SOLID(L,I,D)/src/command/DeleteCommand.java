package command;

public class DeleteCommand implements Command{
    @Override
    public void execute() {
        System.out.println("executing delete command");
    }
}
