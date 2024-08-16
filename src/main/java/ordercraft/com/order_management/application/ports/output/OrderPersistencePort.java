package ordercraft.com.order_management.application.ports.output;

import ordercraft.com.order_management.domain.model.Order;

import java.util.Optional;

public interface OrderPersistencePort {
    Order save(Order order);
    Optional<Order> searchLastOrder(Long tableId);
    Optional<Order> findOrderById(Long orderId);
}
