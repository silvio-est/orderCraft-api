package ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_assignment", schema = "public")
public class OrderAssignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderAssignmentId;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "waitress_id")
    private Integer waitressId;

    @Column(name = "chef_id")
    private Integer chefId;
}
