package ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository;

import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.CustomerOrderEntity;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.OrderAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<CustomerOrderEntity, Long> {
    Optional<CustomerOrderEntity> findFirstByTableIdOrderByOrderIdDesc(Integer tableId);
}
