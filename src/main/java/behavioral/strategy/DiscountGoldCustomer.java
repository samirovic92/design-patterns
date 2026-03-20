package behavioral.strategy;

public class DiscountGoldCustomer implements   DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return  total * 0.5;
    }
}
