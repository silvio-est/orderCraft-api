package ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper;

import ordercraft.com.order_management.domain.model.OrderAssignment;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.OrderAssignmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface OrderAssignmentMapper {
    OrderAssignment toOrderAssignment(OrderAssignmentEntity entity);
    OrderAssignmentEntity tOrderAssignmentEntity(OrderAssignment model);
}
