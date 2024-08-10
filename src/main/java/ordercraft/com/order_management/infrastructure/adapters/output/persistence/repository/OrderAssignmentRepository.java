package ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository;

import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.OrderAssignmentEntity;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.WaitressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderAssignmentRepository extends JpaRepository<OrderAssignmentEntity, Long> {
    Optional<OrderAssignmentEntity> findByOrderId(Integer orderId);
}
