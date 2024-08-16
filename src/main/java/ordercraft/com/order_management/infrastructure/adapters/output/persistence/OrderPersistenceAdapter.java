package ordercraft.com.order_management.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import ordercraft.com.order_management.application.ports.output.OrderPersistencePort;
import ordercraft.com.order_management.domain.model.Order;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper.OrderPersistenceMapper;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    @Override
    public Optional<Order> searchLastOrder(Long tableId) {

        return repository.findFirstByTableIdOrderByOrderIdDesc(tableId.intValue())
                .map(mapper::toOrder);

    }

    @Override
    public Optional<Order> findOrderById(Long orderId) {
        return repository.findById(orderId)
                .map(mapper::toOrder);
    }
}
