import java.util.ArrayList;

public class Customer extends User {

    private int cid;
    private String cname;

    private ArrayList<Task> taskList = new ArrayList<>();

    public Customer() {

    }

    public Customer(int cid, String cname,
                    int userId,
                    String username,
                    String password) {

        super(userId, username, password);

        this.cid = cid;
        this.cname = cname;
    }

    public void addTask(Task t) {
        taskList.add(t);
        System.out.println("Task Added Successfully");
    }

    public void updateTask(int id) {

        for(Task t : taskList) {

            if(t.getTaskId()==id) {

                t.setStatus("Completed");

                System.out.println("Task Updated");

                return;
            }
        }

        System.out.println("Task Not Found");
    }

    public void deleteTask(int id) {

        for(Task t : taskList) {

            if(t.getTaskId()==id) {

                taskList.remove(t);

                System.out.println("Task Deleted");

                return;
            }
        }

    }

    public void viewTask() {

        if(taskList.isEmpty()) {

            System.out.println("No Tasks");

            return;
        }

        for(Task t : taskList) {

            System.out.println("Task ID : "+t.getTaskId());
            System.out.println("Title : "+t.getTitle());
            System.out.println("Description : "+t.getDescription());
            System.out.println("Due Date : "+t.getDueDate());
            System.out.println("Status : "+t.getStatus());

            System.out.println("----------------------");
        }

    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

}