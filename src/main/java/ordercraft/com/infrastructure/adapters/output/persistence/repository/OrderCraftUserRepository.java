package ordercraft.com.infrastructure.adapters.output.persistence.repository;

import ordercraft.com.infrastructure.adapters.output.persistence.entity.OrderCraftUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderCraftUserRepository extends JpaRepository<OrderCraftUserEntity, Long> {
    Optional<OrderCraftUserEntity> findByUsername(String username);

}
