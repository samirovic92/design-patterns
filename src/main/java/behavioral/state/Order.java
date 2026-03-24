package behavioral.state;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Order {
    private UUID id;
    private OrderStatus status;
    private OrderState state;

    public Order(UUID id) {
        this.id = id;
        this.state = new OrderCreateState(this);
    }

    public void ship() {
        state.Ship();
    }

    public void deliver() {
        state.deliver();
    }

    public void cancel() {
        state.cancel();
    }

    public void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
    }

    public  void updateState(OrderState newState) {
        this.state =  newState;
    }

}
