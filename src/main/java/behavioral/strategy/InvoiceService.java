package behavioral.strategy;


public class InvoiceService {

    public double calculateTotal(Invoice invoice) {
        var customerType = invoice.customer().customerType();
        var discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customerType);
        var subTotal = invoice.calculateSubTotal();
        return discountStrategy.applyDiscount(subTotal);
    }

}
