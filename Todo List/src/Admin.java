import java.util.ArrayList;

public class Admin extends User {

    private int adminId;
    private String adminName;

    // Aggregation
    private ArrayList<Customer> customerList = new ArrayList<>();

    public Admin() {

    }

    public Admin(int adminId, String adminName,
            int userId,
            String username,
            String password) {

        super(userId, username, password);

        this.adminId = adminId;
        this.adminName = adminName;
    }

    // Add Customer
    public void addCustomer(Customer c) {

        customerList.add(c);

        System.out.println("Customer Added Successfully");

    }

    // Update Customer
    public void updateCustomer(int cid, String newName) {

        for (Customer c : customerList) {

            if (c.getCid() == cid) {

                c.setCname(newName);

                System.out.println("Customer Updated Successfully");

                return;
            }

        }

        System.out.println("Customer Not Found");

    }

    // Remove Customer
    public void removeCustomer(int cid) {

        for (int i = 0; i < customerList.size(); i++) {

            if (customerList.get(i).getCid() == cid) {

                customerList.remove(i);

                System.out.println("Customer Removed Successfully");

                return;
            }

        }

        System.out.println("Customer Not Found");

    }

    // View Customers
    public void viewCustomers() {

        if (customerList.isEmpty()) {

            System.out.println("No Customers Available");

            return;

        }

        for (Customer c : customerList) {

            System.out.println("------------------------");
            System.out.println("Customer ID : " + c.getCid());
            System.out.println("Customer Name : " + c.getCname());
            System.out.println("Username : " + c.getUsername());

        }

    }

    // Getters & Setters

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

}