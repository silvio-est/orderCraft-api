package ordercraft.com.infrastructure.adapters.output.persistence.mapper;

import ordercraft.com.domain.model.OrderCraftUser;
import ordercraft.com.infrastructure.adapters.output.persistence.entity.OrderCraftUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface OrderCraftUserPersistenceMapper {

    OrderCraftUserEntity toOrderCraftUserEntity(OrderCraftUser model);
    OrderCraftUser toOrderCraftUser(OrderCraftUserEntity entity);
}
