package state;

public class PendingTaskState implements TaskState{
    @Override
    public void modify(Task task) {
        System.out.println("modifying pending task "+task);
    }

    @Override
    public void delete(Task task) {
        System.out.println("deleting pending task "+task);
    }
}
