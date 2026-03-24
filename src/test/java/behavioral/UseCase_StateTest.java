package behavioral;

import behavioral.state.Order;
import behavioral.state.OrderStatus;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UseCase_StateTest {

    @Test
    public void create_order_with_CREATED_status() {
        // Given
        var orderId = UUID.randomUUID();
        // When
        var order = new Order(orderId);

        // Then
        assertEquals(orderId, order.getId());
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }

    @Test
    public void ship_order_with_SHIPPED_status() {
        // Given
        var orderId = UUID.randomUUID();
        var order = new Order(orderId);

        // When
        order.ship();

        // Then
        assertEquals(OrderStatus.SHIPPED, order.getStatus());
    }

    @Test
    public void deliver_order_with_DELIVERED_status() {
        // Given
        var orderId = UUID.randomUUID();
        var order = new Order(orderId);
        order.ship();

        // When
        order.deliver();

        // Then
        assertEquals(OrderStatus.DELIVERED, order.getStatus());
    }

    @Test
    public void cannot_deliver_Order_if_is_created() {
        // Given
        var orderId = UUID.randomUUID();
        var order = new Order(orderId);

        // When + Then
        var message = assertThrows(IllegalStateException.class, order::deliver)
                .getMessage();
        assertEquals("Cannot deliver order", message);
    }

    @Test
    public void cancel_order_with_CANCELLED() {
        // Given
        var orderId = UUID.randomUUID();
        var order = new Order(orderId);
        order.ship();
        order.deliver();

        // When
        order.cancel();

        // Then
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }

    @Test
    public void cannot_cancel_Order_if_is_created() {
        // Given
        var orderId = UUID.randomUUID();
        var order = new Order(orderId);

        // When + Then
        var message = assertThrows(IllegalStateException.class, order::cancel)
                .getMessage();
        assertEquals("Cannot cancel order", message);
    }

    @Test
    public void cannot_cancel_Order_if_is_shipped() {
        // Given
        var orderId = UUID.randomUUID();
        var order = new Order(orderId);
        order.ship();

        // When + Then
        var message = assertThrows(IllegalStateException.class, order::cancel)
                .getMessage();
        assertEquals("Cannot cancel order", message);
    }

}
