package structural.adapter;

public class OldPaymentSystem {

    public void makePayment(String cardNumber, double amount) {
        System.out.println("Paying " + amount + " using card " + cardNumber);
    }
}
