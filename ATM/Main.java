import java.util.Scanner;

import enums.AccountType;
import model.ATM;
import model.Account;
import model.Card;
import model.User;
import service.ATMService;
import service.BankService;
import service.BankServiceImpl;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User
        User user = new User(
                "U001",
                "Anjali"
        );

        // Account
        Account account = new Account(
                "ACC001",
                10000,
                AccountType.SAVINGS
        );

        // Card
        Card card = new Card(
                "1234567890",
                1234,
                account
        );

        // ATM
        ATM atm = new ATM(
                "ATM001",
                50000
        );

        // Dependency
        BankService bankService =
                new BankServiceImpl();

        ATMService atmService =
                new ATMService(
                        atm,
                        bankService
                );

        System.out.println(
                "===== WELCOME " +
                user.getName() +
                " ====="
        );

        System.out.print("Enter PIN: ");

        int pin = sc.nextInt();

        if (!atmService.authenticate(card, pin)) {

            System.out.println("Invalid PIN");

            sc.close();
            return;
        }

        System.out.println(
                "\nLogin successful!"
        );

        boolean running = true;

        while (running) {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");

            System.out.print(
                    "Enter your choice: "
            );

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println(
                            "Balance: ₹" +
                            atmService.checkBalance(card)
                    );

                    break;

                case 2:

                    System.out.print(
                            "Enter amount: "
                    );

                    double withdrawAmount =
                            sc.nextDouble();

                    atmService.withdraw(
                            card,
                            withdrawAmount
                    );

                    break;

                case 3:

                    System.out.print(
                            "Enter amount: "
                    );

                    double depositAmount =
                            sc.nextDouble();

                    atmService.deposit(
                            card,
                            depositAmount
                    );

                    break;

                case 4:

                    System.out.print(
                            "Enter old PIN: "
                    );

                    int oldPin =
                            sc.nextInt();

                    System.out.print(
                            "Enter new PIN: "
                    );

                    int newPin =
                            sc.nextInt();

                    try {

                        card.changePin(
                                oldPin,
                                newPin
                        );

                        System.out.println(
                                "PIN changed successfully"
                        );

                    } catch (
                            IllegalArgumentException e) {

                        System.out.println(
                                e.getMessage()
                        );
                    }

                    break;

                case 5:

                    running = false;

                    System.out.println(
                            "Thank you!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice"
                    );
            }
        }
    }
}