package ordercraft.com.order_management.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ordercraft.com.order_management.application.ports.output.OrderAssignmentPersistencePort;
import ordercraft.com.order_management.domain.exception.OrderNotFoundException;
import ordercraft.com.order_management.domain.model.OrderAssignment;
import ordercraft.com.order_management.domain.model.Waitress;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.OrderAssignmentEntity;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper.OrderAssignmentMapper;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository.OrderAssignmentRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderAssignmentPersistenceAdapter implements OrderAssignmentPersistencePort {

    private final OrderAssignmentRepository repository;
    private final OrderAssignmentMapper mapper;

    @Override
    public OrderAssignment save(OrderAssignment orderAssignment) {
        return mapper.toOrderAssignment(
                repository.save(mapper.tOrderAssignmentEntity(orderAssignment))
        );
    }

    @Override
    public void updateChefUserByOrderId(Integer orderId, Integer chefId) {

        OrderAssignmentEntity orderAssignmentEntity = repository.findByOrderId(orderId)
                .orElseThrow(()-> new OrderNotFoundException("Order not found in the database"));

        orderAssignmentEntity.setChefId(chefId);
        repository.save(orderAssignmentEntity);

    }
}
