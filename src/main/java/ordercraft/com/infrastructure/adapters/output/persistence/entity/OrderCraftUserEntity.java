package ordercraft.com.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import ordercraft.com.domain.model.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_craft_user", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_name")
})

public class OrderCraftUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;


}
