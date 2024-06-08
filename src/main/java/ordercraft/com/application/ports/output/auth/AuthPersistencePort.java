package ordercraft.com.application.ports.output.auth;

import ordercraft.com.domain.model.OrderCraftUser;
import java.util.Optional;

public interface AuthPersistencePort {
    OrderCraftUser save(OrderCraftUser orderCraftUser);
    Optional<OrderCraftUser> findByUsername(String username);
    Optional<OrderCraftUser> findById(Long idUser);
    void deleteUserByID(Long idUser);
}
