package ordercraft.com.order_management.application.ports.output;

import ordercraft.com.order_management.domain.model.OrderDish;


public interface OrderDishPersistencePort {
    OrderDish save(OrderDish orderDish);
}
