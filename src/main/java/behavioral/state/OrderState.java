package behavioral.state;

public interface OrderState {

    default void Ship(){
        throw new IllegalStateException("Cannot ship order");
    }

    default void deliver(){
        throw  new IllegalStateException("Cannot deliver order");
    }

    default void cancel(){
        throw new IllegalStateException("Cannot cancel order");
    }
}
