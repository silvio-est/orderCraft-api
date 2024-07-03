package ordercraft.com.order_management.application.ports.input;

import ordercraft.com.order_management.domain.model.Order;

public interface OrderManagementServicePort {
    void saveOrder(Order order);

}
