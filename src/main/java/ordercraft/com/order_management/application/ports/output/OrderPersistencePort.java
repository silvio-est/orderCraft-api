package ordercraft.com.order_management.application.ports.output;

import ordercraft.com.order_management.domain.model.Order;

public interface OrderPersistencePort {
    Order save(Order order);

}
