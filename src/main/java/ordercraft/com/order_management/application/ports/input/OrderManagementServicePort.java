package ordercraft.com.order_management.application.ports.input;

import ordercraft.com.order_management.domain.model.Order;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.model.CheckOrderRequest;

public interface OrderManagementServicePort {
    Order saveOrder(Order order);
    void orderComplete(CheckOrderRequest checkOrderRequest);

}
