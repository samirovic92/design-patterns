package behavioral.state;

public class OrderShippedState implements  OrderState {
    private final Order order;

    public OrderShippedState(Order order) {
        this.order = order;
        this.order.updateStatus(OrderStatus.SHIPPED);
    }

    @Override
    public void deliver() {
        this.order.updateState(new OrderDeliveredState(this.order));
    }
}
