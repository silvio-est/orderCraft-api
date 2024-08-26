package ordercraft.com.order_management.infrastructure.adapters.input.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishRequest{
    private String name;
    private Double price;
    private Integer amount;
    private Boolean available;
}
