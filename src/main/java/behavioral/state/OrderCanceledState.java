package behavioral.state;

public class OrderCanceledState implements  OrderState {
    private final Order order;

    public OrderCanceledState(Order order) {
        this.order = order;
        this.order.updateStatus(OrderStatus.CANCELLED);
    }
}
