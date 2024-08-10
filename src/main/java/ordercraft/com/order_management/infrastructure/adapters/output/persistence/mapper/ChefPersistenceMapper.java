package ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper;

import ordercraft.com.order_management.domain.model.Chef;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.ChefEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface ChefPersistenceMapper {
    Chef toChef(ChefEntity entity);
    ChefEntity toChefEntity(Chef model);
}
