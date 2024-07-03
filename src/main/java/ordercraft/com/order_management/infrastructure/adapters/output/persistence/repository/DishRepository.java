package ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository;

import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DishRepository extends JpaRepository<DishEntity, Long> {
    Optional<DishEntity> findDishEntitiesByName(String name);
}
