package behavioral.state;

public class OrderCreateState implements OrderState {

    private final Order order;

    public OrderCreateState(Order order) {
        this.order = order;
        this.order.updateStatus(OrderStatus.CREATED);
    }

    @Override
    public void Ship() {
        this.order.updateState(new OrderShippedState(this.order));
    }
}
