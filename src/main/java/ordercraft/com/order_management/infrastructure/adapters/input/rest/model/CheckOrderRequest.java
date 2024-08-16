package ordercraft.com.order_management.infrastructure.adapters.input.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CheckOrderRequest {

    private Integer orderId;
    private String chefUsername;
}
