package ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository;

import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.OrderAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderAssignmentRepository extends JpaRepository<OrderAssignmentEntity, Long> {
}
