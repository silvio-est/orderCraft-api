package ordercraft.com.order_management.application.ports.output;

import ordercraft.com.order_management.domain.model.Chef;

import java.util.Optional;

public interface ChefPersistencePort {
    Optional<Chef> findByUsername(String username);
}
