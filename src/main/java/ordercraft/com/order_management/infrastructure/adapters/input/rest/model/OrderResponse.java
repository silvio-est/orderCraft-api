package ordercraft.com.order_management.infrastructure.adapters.input.rest.model;

import java.util.List;

public record OrderResponse(Integer orderId, String username, Integer tableId, List<DishRequest> dishes) {
}
