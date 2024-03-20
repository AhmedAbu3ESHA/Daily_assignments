package command;

public class Main {
    public static void main(String[] args) {
        Connection connection=new Connection(new SelectCommand());
        connection.executeAction();
        connection.setCommand(new DeleteCommand());
        connection.executeAction();
    }
}
