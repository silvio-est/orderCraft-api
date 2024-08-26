package ordercraft.com.order_management.infrastructure.adapters.input.rest.mapper;

import ordercraft.com.order_management.domain.model.Dish;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.model.DishRequest;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.model.DishResponse;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.model.EditDishRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DishManagementControllerMapper {

    Dish toDishResponse(DishRequest request);
    Dish toDishResponse(EditDishRequest request);
    List<DishResponse> toDishResponseList(List<Dish> models);
    DishResponse toDishResponse(Dish models);
}
