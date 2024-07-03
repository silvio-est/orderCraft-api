package ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper;

import ordercraft.com.order_management.domain.model.OrderDish;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.OrderDishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderDishPersistenceMapper {

    OrderDish toOrderDish(OrderDishEntity entity);
    OrderDishEntity toOrderDishEntity(OrderDish model);
}
