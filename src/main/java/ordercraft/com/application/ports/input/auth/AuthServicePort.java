package ordercraft.com.application.ports.input.auth;

import ordercraft.com.domain.model.OrderCraftUser;

public interface AuthServicePort {
    public OrderCraftUser login(OrderCraftUser orderCraftUser);
    public OrderCraftUser register(OrderCraftUser orderCraftUser);
    public void updateUser(OrderCraftUser orderCraftUser, Long idUser);
    public void deleteUser(Long idUser);
    public OrderCraftUser getUserById(Long idUser);
}
