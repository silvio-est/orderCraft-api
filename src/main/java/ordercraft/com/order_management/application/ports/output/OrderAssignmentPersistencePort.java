package ordercraft.com.order_management.application.ports.output;

import ordercraft.com.order_management.domain.model.OrderAssignment;

public interface OrderAssignmentPersistencePort {
    OrderAssignment save(OrderAssignment orderAssignment);
    void updateChefUserByOrderId(Integer orderId, Integer chefId);
}
