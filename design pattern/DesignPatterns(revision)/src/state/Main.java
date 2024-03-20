package state;

public class Main {
    public static void main(String[] args) {
        //task,taskservice
        //task,tsakstate,taskservice

        TaskState state=new CompleteTaskState();
        Task task=new Task("hello all",state);
        TaskService taskService=new TaskService();
        taskService.modify(task);
    }
}
