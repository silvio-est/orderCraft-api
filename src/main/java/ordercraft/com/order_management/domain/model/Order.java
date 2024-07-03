package ordercraft.com.order_management.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private Integer tableId;
    private String username;
    private List<Dish> dishes;
}
