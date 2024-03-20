package state;

public class TaskService {

    public void modify(Task task){
        task.getState().modify(task);
//        if (task.getType().equals("pending"))
//            System.out.println("modifying pending task "+task);
//        else if (task.getType().equals("complete"))
//            System.out.println("modifying complete "+task);

    }

    public void delete(Task task){
        task.getState().delete(task);
//        if (task.getType().equals("pending"))
//            System.out.println("deleting pending task "+task);
//        else if (task.getType().equals("complete"))
//            System.out.println("deleting complete "+task);
    }
}
