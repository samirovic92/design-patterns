package behavioral.strategy;

import java.util.List;

public class Invoice {
    private Customer customer;
    private List<InvoiceItem> items;

    public Invoice(Customer customer, List<InvoiceItem> items) {
        this.customer = customer;
        this.items = items;
    }

    public Customer customer() {
        return customer;
    }

    public double calculateSubTotal() {
        return  items.stream().map(item -> item.quantity() * item.unitPrice())
                .reduce(0d, Double::sum);
    }

}
