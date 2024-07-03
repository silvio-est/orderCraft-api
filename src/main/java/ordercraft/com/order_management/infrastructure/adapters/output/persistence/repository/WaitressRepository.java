package ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository;

import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.WaitressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WaitressRepository extends JpaRepository<WaitressEntity, Long> {
    Optional<WaitressEntity> findByUsername(String username);
}
