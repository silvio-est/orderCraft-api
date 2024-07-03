package ordercraft.com.auth.application.ports.input;

import ordercraft.com.auth.domain.model.OrderCraftUser;

public interface AuthServicePort {
    OrderCraftUser login(OrderCraftUser orderCraftUser);
    OrderCraftUser register(OrderCraftUser orderCraftUser);
    void updateUser(OrderCraftUser orderCraftUser, Long idUser);
    void deleteUser(Long idUser);
    OrderCraftUser getUserById(Long idUser);
}
