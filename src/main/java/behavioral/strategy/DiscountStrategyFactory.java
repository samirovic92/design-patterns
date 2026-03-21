package behavioral.strategy;

public class DiscountStrategyFactory {

    public static DiscountStrategy getDiscountStrategy(CustomerType customerType) {
        return switch (customerType) {
            case NEW -> new DiscountNewCustomer();
            case SILVER -> new DiscountSilverCustomer();
            case GOLD -> new DiscountGoldCustomer();
        };
    }

}
