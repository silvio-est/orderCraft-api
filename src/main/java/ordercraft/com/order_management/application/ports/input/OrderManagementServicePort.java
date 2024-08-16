package ordercraft.com.order_management.application.ports.input;

import ordercraft.com.order_management.domain.model.Order;
import ordercraft.com.order_management.domain.model.OrderCancel;

public interface OrderManagementServicePort {
    Order saveOrder(Order order);
    void orderComplete(Order order);
    void cancelOrder(Long tableId, OrderCancel orderCancel);
}
