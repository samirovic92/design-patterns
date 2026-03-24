package behavioral.state;

public class OrderDeliveredState implements  OrderState {

    private final Order order;

    public OrderDeliveredState(Order order) {
        this.order = order;
        this.order.updateStatus(OrderStatus.DELIVERED);
    }

    @Override
    public void cancel() {
        this.order.updateState(new OrderCanceledState(this.order));
    }
}
