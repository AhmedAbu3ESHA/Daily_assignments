package state;

public interface TaskState {
    void modify(Task task);
    void delete(Task task);
}
