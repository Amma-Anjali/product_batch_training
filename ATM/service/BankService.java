package service;

import model.Account;
import model.Card;

public interface BankService {

    boolean authenticate(Card card, int pin);

    boolean withdraw(Account account, double amount);

    void deposit(Account account, double amount);

    double checkBalance(Account account);
}