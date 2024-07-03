package ordercraft.com.order_management.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    private Integer dishId;
    private String name;
    private Integer amount;
}
