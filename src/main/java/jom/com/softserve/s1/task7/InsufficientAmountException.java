package jom.com.softserve.s1.task7;

public class InsufficientAmountException extends Exception {
    private double amount;

    public InsufficientAmountException(double needs) {
        amount=needs;
    }

    @Override
    public String getMessage() {
        return "Sorry, but you are short $" + amount;
    }

    public double getAmount() {
        return amount;
    }
}
