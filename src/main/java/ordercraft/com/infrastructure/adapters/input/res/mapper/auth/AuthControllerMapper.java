package ordercraft.com.infrastructure.adapters.input.res.mapper.auth;

import ordercraft.com.domain.model.OrderCraftUser;
import ordercraft.com.infrastructure.adapters.input.res.model.request.auth.LoginRequest;
import ordercraft.com.infrastructure.adapters.input.res.model.request.auth.RegisterRequest;
import ordercraft.com.infrastructure.adapters.input.res.model.request.auth.UpdateRequest;
import ordercraft.com.infrastructure.adapters.input.res.model.response.AuthResponse;
import ordercraft.com.infrastructure.adapters.input.res.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface AuthControllerMapper {
    OrderCraftUser toOrderCraftUser(RegisterRequest registerRequest);
    OrderCraftUser toOrderCraftUser(LoginRequest loginRequest);
    OrderCraftUser toOrderCraftUser(UpdateRequest updateRequest);
    AuthResponse toAuthResponse(OrderCraftUser orderCraftUser);
    UserResponse toUserResponse(OrderCraftUser orderCraftUser);
}
