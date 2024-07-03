package ordercraft.com.auth.infrastructure.adapters.input.res.mapper;

import ordercraft.com.auth.domain.model.OrderCraftUser;
import ordercraft.com.auth.infrastructure.adapters.input.res.model.LoginRequest;
import ordercraft.com.auth.infrastructure.adapters.input.res.model.RegisterRequest;
import ordercraft.com.auth.infrastructure.adapters.input.res.model.UpdateRequest;
import ordercraft.com.auth.infrastructure.adapters.input.res.model.AuthResponse;
import ordercraft.com.auth.infrastructure.adapters.input.res.model.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface AuthControllerMapper {
    OrderCraftUser toOrderCraftUser(RegisterRequest request);
    OrderCraftUser toOrderCraftUser(LoginRequest request);
    OrderCraftUser toOrderCraftUser(UpdateRequest request);
    AuthResponse toAuthResponse(OrderCraftUser model);
    UserResponse toUserResponse(OrderCraftUser model);
}
