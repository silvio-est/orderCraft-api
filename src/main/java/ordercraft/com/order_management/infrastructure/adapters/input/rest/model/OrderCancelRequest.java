package ordercraft.com.order_management.infrastructure.adapters.input.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderCancelRequest {

    private String message;
}
