package service;

import model.ATM;
import model.Account;
import model.Card;

public class ATMService {

    private ATM atm;
    private BankService bankService;

    public ATMService(
            ATM atm,
            BankService bankService) {

        this.atm = atm;
        this.bankService = bankService;
    }

    public boolean authenticate(
            Card card,
            int pin) {

        return bankService.authenticate(card, pin);
    }

    public boolean withdraw(
            Card card,
            double amount) {

        Account account = card.getAccount();

        if (amount <= 0) {
            System.out.println("Invalid amount");
            return false;
        }

        if (amount > account.getBalance()) {
            System.out.println(
                    "Insufficient account balance"
            );
            return false;
        }

        if (amount > atm.getCashAvailable()) {
            System.out.println(
                    "ATM does not have enough cash"
            );
            return false;
        }

        boolean success =
                bankService.withdraw(account, amount);

        if (!success) {
            return false;
        }

        atm.dispenseCash(amount);

        System.out.println(
                "Please collect your cash"
        );

        return true;
    }

    public void deposit(
            Card card,
            double amount) {

        bankService.deposit(
                card.getAccount(),
                amount
        );

        System.out.println(
                "Amount deposited successfully"
        );
    }

    public double checkBalance(Card card) {

        return bankService.checkBalance(
                card.getAccount()
        );
    }
}