package ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper;

import ordercraft.com.order_management.domain.model.OrderCancel;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.OrderCancelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderCancelPersistenceMapper {

    OrderCancel toOrderCancel(OrderCancelEntity entity);
    OrderCancelEntity tOrderCancelEntity(OrderCancel model);
}
