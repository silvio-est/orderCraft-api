package ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "chef", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = "chef_id")
})
public class ChefEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chef_id")
    private Integer chefId;

    @Column(name = "username", nullable = false)
    private String username;
}
