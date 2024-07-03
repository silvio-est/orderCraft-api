package ordercraft.com.order_management.application.ports.output;

import ordercraft.com.order_management.domain.model.Waitress;

import java.util.Optional;

public interface WaitressPersistencePort {
    Optional<Waitress> findByUsername(String username);
}
