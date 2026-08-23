import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);

    static Admin admin = new Admin(1, "Admin", 1, "Admin", "Admin@123");

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== TODO LIST APPLICATION =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Exit");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    adminLogin();
                    break;

                case 2:
                    System.out.println("Thank You...");
                    break;

                default:
                    System.out.println("Invalid Choice");

            }

        } while(choice != 2);

    }

    // ---------------- Admin Login ----------------

    public static void adminLogin() {

        System.out.print("Username : ");
        String username = sc.next();

        System.out.print("Password : ");
        String password = sc.next();

        if(username.equals("Admin") && password.equals("Admin@123")) {

            System.out.println("Login Successful");

            adminMenu();

        }
        else {

            System.out.println("Invalid Username or Password");

        }

    }

    // ---------------- Admin Menu ----------------

    public static void adminMenu() {

        int option;

        do {

            System.out.println("\n------ ADMIN MENU ------");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. View Customers");
            System.out.println("5. Exit");

            System.out.print("Enter Option : ");
            option = sc.nextInt();

            switch(option) {

                case 1:
                    addCustomer();
                    break;

                case 2:
                    updateCustomer();
                    break;

                case 3:
                    deleteCustomer();
                    break;

                case 4:
                    admin.viewCustomers();
                    break;

                case 5:
                    System.out.println("Logged Out");
                    break;

                default:
                    System.out.println("Invalid Option");
            }

        } while(option != 5);

    }

    // ---------------- Add Customer ----------------

    public static void addCustomer() {

        System.out.print("Customer ID : ");
        int cid = sc.nextInt();

        System.out.print("Customer Name : ");
        String cname = sc.next();

        System.out.print("User ID : ");
        int uid = sc.nextInt();

        System.out.print("Username : ");
        String username = sc.next();

        System.out.print("Password : ");
        String password = sc.next();

        Customer c = new Customer(cid, cname, uid, username, password);

        admin.addCustomer(c);

        customerMenu(c);

    }

    // ---------------- Update Customer ----------------

    public static void updateCustomer() {

        System.out.print("Enter Customer ID : ");
        int cid = sc.nextInt();

        System.out.print("Enter New Name : ");
        String name = sc.next();

        admin.updateCustomer(cid, name);

    }

    // ---------------- Delete Customer ----------------

    public static void deleteCustomer() {

        System.out.print("Enter Customer ID : ");
        int cid = sc.nextInt();

        admin.removeCustomer(cid);

    }

    // ---------------- Customer Menu ----------------

    public static void customerMenu(Customer customer) {

        int choice;

        do {

            System.out.println("\n------ CUSTOMER MENU ------");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.print("Task ID : ");
                    int id = sc.nextInt();

                    System.out.print("Title : ");
                    String title = sc.next();

                    System.out.print("Description : ");
                    String desc = sc.next();

                    System.out.print("Due Date : ");
                    String date = sc.next();

                    System.out.print("Status : ");
                    String status = sc.next();

                    Task t = new Task(id, title, desc, date, status);

                    customer.addTask(t);

                    break;

                case 2:

                    System.out.print("Enter Task ID : ");
                    customer.updateTask(sc.nextInt());

                    break;

                case 3:

                    System.out.print("Enter Task ID : ");
                    customer.deleteTask(sc.nextInt());

                    break;

                case 4:

                    customer.viewTask();

                    break;

                case 5:

                    System.out.println("Exit Customer Menu");

                    break;

                default:

                    System.out.println("Invalid Choice");

            }

        } while(choice != 5);

    }

}