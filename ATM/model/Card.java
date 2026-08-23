package model;

public class Card {

    private String cardNumber;
    private int pin;
    private Account account;

    public Card(
            String cardNumber,
            int pin,
            Account account) {

        this.cardNumber = cardNumber;
        this.pin = pin;
        this.account = account;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Account getAccount() {
        return account;
    }

    public boolean validatePin(int enteredPin) {

        return this.pin == enteredPin;
    }

    public void changePin(int oldPin, int newPin) {

        if (!validatePin(oldPin)) {
            throw new IllegalArgumentException(
                    "Incorrect old PIN"
            );
        }

        if (newPin < 1000 || newPin > 9999) {
            throw new IllegalArgumentException(
                    "PIN must contain 4 digits"
            );
        }

        this.pin = newPin;
    }
}