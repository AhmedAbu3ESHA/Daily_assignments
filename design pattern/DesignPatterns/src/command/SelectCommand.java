package command;

public class SelectCommand implements Command{
    @Override
    public void execute() {
        System.out.println("executing select command");
    }
}
