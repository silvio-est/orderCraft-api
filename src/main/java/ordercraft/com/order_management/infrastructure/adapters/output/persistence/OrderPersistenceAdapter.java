package ordercraft.com.order_management.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import ordercraft.com.order_management.application.ports.output.OrderPersistencePort;
import ordercraft.com.order_management.domain.model.Order;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper.OrderPersistenceMapper;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository.OrderRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderPersistenceAdapter implements OrderPersistencePort {

    private final OrderRepository repository;
    private final OrderPersistenceMapper mapper;

    @Override
    public Order save(Order order) {

        return mapper.toOrder(
                repository.save(mapper.toOrderEntity(order))
        );
    }
}
