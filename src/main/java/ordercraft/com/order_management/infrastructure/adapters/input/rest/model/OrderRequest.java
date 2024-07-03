package ordercraft.com.order_management.infrastructure.adapters.input.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private String username;
    private Integer tableId;
    private List<DishRequest> dishes;
}


