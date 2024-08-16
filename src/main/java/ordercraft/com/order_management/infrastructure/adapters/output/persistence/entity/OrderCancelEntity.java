package ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_cancel", schema = "public")
public class OrderCancelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderCancelId;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "message")
    private String message;
}
