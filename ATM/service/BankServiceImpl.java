package service;

import model.Account;
import model.Card;

public class BankServiceImpl implements BankService {

    @Override
    public boolean authenticate(Card card, int pin) {

        return card != null && card.validatePin(pin);
    }

    @Override
    public boolean withdraw(Account account, double amount) {

        return account.withdraw(amount);
    }

    @Override
    public void deposit(Account account, double amount) {

        account.deposit(amount);
    }

    @Override
    public double checkBalance(Account account) {

        return account.getBalance();
    }
}