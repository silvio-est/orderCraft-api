package ordercraft.com.order_management.infrastructure.adapters.input.rest.mapper;

import ordercraft.com.order_management.domain.model.Order;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.model.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface OrderManagementControllerMapper {
    Order toOrder(OrderRequest request);
    OrderRequest toOrderRequest(Order model);
}
