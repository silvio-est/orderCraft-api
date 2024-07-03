package ordercraft.com.auth.application.ports.output;

import ordercraft.com.auth.domain.model.OrderCraftUser;
import java.util.Optional;

public interface AuthPersistencePort {
    OrderCraftUser save(OrderCraftUser orderCraftUser);
    Optional<OrderCraftUser> findByUsername(String username);
    Optional<OrderCraftUser> findById(Long idUser);
    void deleteUserByID(Long idUser);
}
