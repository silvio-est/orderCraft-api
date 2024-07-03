package ordercraft.com.order_management.infrastructure.adapters.input.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishRequest{
    private String name;
    private Integer amount;
}
