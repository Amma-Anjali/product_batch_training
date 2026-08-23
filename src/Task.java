public class Task {

    private int taskId;
    private String title;
    private String description;
    private String dueDate;
    private String status;

    public Task() {

    }

    public Task(int taskId, String title, String description,
                String dueDate, String status) {

        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public void create() {
        System.out.println("Task Created");
    }

    public void update() {
        System.out.println("Task Updated");
    }

    public void delete() {
        System.out.println("Task Deleted");
    }

    public void scheduleTime() {
        System.out.println("Task Scheduled");
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}