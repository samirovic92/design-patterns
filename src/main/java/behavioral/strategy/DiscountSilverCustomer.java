package behavioral.strategy;

public class DiscountSilverCustomer implements  DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.9;
    }
}
