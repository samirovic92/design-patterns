package behavioral.strategy;

public class InvoiceService {

    public double calculateTotal(Invoice invoice) {
        var discountStrategy =  switch (invoice.customer().customerType()) {
            case NEW -> new DiscountNewCustomer();
            case SILVER -> new DiscountSilverCustomer();
            case  GOLD -> new DiscountGoldCustomer();
        };
        var subTotal = invoice.calculateSubTotal();
        return discountStrategy.applyDiscount(subTotal);
    }

}
