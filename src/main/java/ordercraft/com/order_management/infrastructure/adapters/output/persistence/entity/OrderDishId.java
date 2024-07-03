package ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class OrderDishId implements Serializable {
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "dish_id")
    private Integer dishId;
}
