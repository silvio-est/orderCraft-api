package ordercraft.com.order_management.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import ordercraft.com.order_management.application.ports.output.OrderAssignmentPersistencePort;
import ordercraft.com.order_management.domain.model.OrderAssignment;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper.OrderAssignmentMapper;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository.OrderAssignmentRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderAssignmentPersistenceAdapter implements OrderAssignmentPersistencePort {

    private final OrderAssignmentRepository repository;
    private final OrderAssignmentMapper mapper;

    @Override
    public OrderAssignment save(OrderAssignment orderAssignment) {
        return mapper.toOrderAssignment(
                repository.save(mapper.tOrderAssignmentEntity(orderAssignment))
        );
    }
}
