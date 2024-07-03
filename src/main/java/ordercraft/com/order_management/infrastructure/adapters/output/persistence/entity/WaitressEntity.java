package ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "waitress")
public class WaitressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "waitress_id")
    private Integer waitressId;

    @Column(name = "username", nullable = false)
    private String username;
}
