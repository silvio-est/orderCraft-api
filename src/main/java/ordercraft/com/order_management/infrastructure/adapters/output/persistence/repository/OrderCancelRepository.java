package ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository;

import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.OrderCancelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCancelRepository  extends JpaRepository<OrderCancelEntity, Integer> {

}
