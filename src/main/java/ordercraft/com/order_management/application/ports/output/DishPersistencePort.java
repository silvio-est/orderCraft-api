package ordercraft.com.order_management.application.ports.output;

import ordercraft.com.order_management.domain.model.Dish;

import java.util.Optional;

public interface DishPersistencePort {
    Optional<Dish> findByName(String name);
}
