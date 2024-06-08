package ordercraft.com.infrastructure.adapters.input.res;

import lombok.RequiredArgsConstructor;
import ordercraft.com.application.ports.input.auth.AuthServicePort;
import ordercraft.com.domain.exception.OrderCraftUserNotFoundException;
import ordercraft.com.infrastructure.adapters.input.res.mapper.auth.AuthControllerMapper;
import ordercraft.com.infrastructure.adapters.input.res.model.request.auth.LoginRequest;
import ordercraft.com.infrastructure.adapters.input.res.model.request.auth.RegisterRequest;
import ordercraft.com.infrastructure.adapters.input.res.model.request.auth.UpdateRequest;
import ordercraft.com.infrastructure.adapters.input.res.model.response.AuthResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthRestController {

    private final AuthServicePort authService;
    private final AuthControllerMapper authMapper;

    @PostMapping("/register")
    ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authMapper.toAuthResponse(
                authService.register(
                        authMapper.toOrderCraftUser(registerRequest))));
    }

    @PostMapping("/login")
    ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authMapper.toAuthResponse(
                authService.login(
                        authMapper.toOrderCraftUser(loginRequest))));

    }

    @PutMapping("/update/{idUser}")
    ResponseEntity<HttpStatus> updateUser(@PathVariable Long idUser, @RequestBody UpdateRequest updateRequest) throws OrderCraftUserNotFoundException {
        authService.updateUser(authMapper.toOrderCraftUser(updateRequest), idUser);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }
    @DeleteMapping("/delete/{idUser}")
    ResponseEntity<HttpStatus> deleteUser(@PathVariable Long idUser)  {
        authService.deleteUser(idUser);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
