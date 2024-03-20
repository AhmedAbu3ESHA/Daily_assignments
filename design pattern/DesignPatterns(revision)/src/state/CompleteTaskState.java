package state;

public class CompleteTaskState implements TaskState{
    @Override
    public void modify(Task task) {
        System.out.println("modifying complete "+task);
    }

    @Override
    public void delete(Task task) {
        System.out.println("deleting complete "+task);
    }
}
