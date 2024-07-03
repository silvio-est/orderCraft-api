package ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper;

import ordercraft.com.order_management.domain.model.Order;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.CustomerOrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface OrderPersistenceMapper {

    @Mapping(target = "orderId", source = "model.orderId")
    @Mapping(target = "tableId", source = "model.tableId")
    CustomerOrderEntity toOrderEntity(Order model);
    Order toOrder(CustomerOrderEntity entity);
}
