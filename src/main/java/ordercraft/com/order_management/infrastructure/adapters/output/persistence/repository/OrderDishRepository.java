package ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository;

import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.OrderDishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDishRepository extends JpaRepository<OrderDishEntity, Long> {
}
