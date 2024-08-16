package ordercraft.com.order_management.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import ordercraft.com.order_management.application.ports.output.OrderCancelPersistencePort;
import ordercraft.com.order_management.domain.model.OrderCancel;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper.OrderCancelPersistenceMapper;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository.OrderCancelRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCancelPersistenceAdapter implements OrderCancelPersistencePort {

    private final OrderCancelRepository repository;
    private final OrderCancelPersistenceMapper mapper;


    @Override
    public void save(OrderCancel orderCancel) {
        repository.save(mapper.tOrderCancelEntity(orderCancel));
    }
}
