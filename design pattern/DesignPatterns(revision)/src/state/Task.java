package state;

public class Task {
    private String content;
    private TaskState state;// pending,complte,late

    public Task(String content, TaskState state) {
        this.content = content;
        this.state = state;
    }

    public Task(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }
}
