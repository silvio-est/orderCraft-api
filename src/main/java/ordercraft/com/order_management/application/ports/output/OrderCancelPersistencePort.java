package ordercraft.com.order_management.application.ports.output;

import ordercraft.com.order_management.domain.model.OrderCancel;

public interface OrderCancelPersistencePort {
    void save(OrderCancel orderCancel);
}
