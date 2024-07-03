package ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_order", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = "order_id")
})
public class CustomerOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "table_id", nullable = false)
    private Integer tableId;


}
