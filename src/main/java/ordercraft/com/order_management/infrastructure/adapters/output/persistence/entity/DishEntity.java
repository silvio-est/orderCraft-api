package ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "dish", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = "dish_id")
})
public class DishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Integer dishId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "available")
    private Boolean available;
}
