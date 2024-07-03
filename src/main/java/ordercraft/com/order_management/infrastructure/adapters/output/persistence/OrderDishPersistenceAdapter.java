package ordercraft.com.order_management.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import ordercraft.com.order_management.application.ports.output.OrderDishPersistencePort;
import ordercraft.com.order_management.domain.model.OrderDish;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper.OrderDishPersistenceMapper;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository.OrderDishRepository;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class OrderDishPersistenceAdapter implements OrderDishPersistencePort {

    private final OrderDishRepository repository;
    private final OrderDishPersistenceMapper mapper;


    @Override
    public OrderDish save(OrderDish orderDish) {
        return mapper.toOrderDish(
                repository.save(mapper.toOrderDishEntity(orderDish))
        );
    }
}
