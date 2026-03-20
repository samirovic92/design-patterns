package behavioral.strategy;

public class DiscountNewCustomer implements  DiscountStrategy {

    @Override
    public double applyDiscount(double total) {
        return total;
    }
}
