package ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper;

import ordercraft.com.order_management.domain.model.Waitress;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.entity.WaitressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface WaitressPersistenceMapper {
    Waitress toWaitress(WaitressEntity entity);
    WaitressEntity toWaitressEntity(Waitress model);
}
