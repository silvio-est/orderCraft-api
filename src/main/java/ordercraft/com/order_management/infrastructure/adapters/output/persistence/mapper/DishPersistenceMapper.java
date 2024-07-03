package ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper;

import ordercraft.com.order_management.domain.model.Dish;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface DishPersistenceMapper {

    DishEntity toDishEntity(Dish model);
    Dish toDish(DishEntity entity);
}
