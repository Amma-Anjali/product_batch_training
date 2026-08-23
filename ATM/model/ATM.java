package model;

public class ATM {

    private String atmId;
    private double cashAvailable;

    public ATM(String atmId, double cashAvailable) {
        this.atmId = atmId;
        this.cashAvailable = cashAvailable;
    }

    public String getAtmId() {
        return atmId;
    }

    public double getCashAvailable() {
        return cashAvailable;
    }

    public boolean dispenseCash(double amount) {

        if (amount <= 0) {
            return false;
        }

        if (amount > cashAvailable) {
            return false;
        }

        cashAvailable -= amount;

        return true;
    }

    public void addCash(double amount) {

        if (amount > 0) {
            cashAvailable += amount;
        }
    }
}