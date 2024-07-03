package ordercraft.com.auth.infrastructure.adapters.input.res;

import lombok.RequiredArgsConstructor;
import ordercraft.com.auth.application.ports.input.AuthServicePort;
import ordercraft.com.auth.infrastructure.adapters.input.res.mapper.AuthControllerMapper;
import ordercraft.com.auth.infrastructure.adapters.input.res.model.LoginRequest;
import ordercraft.com.auth.infrastructure.adapters.input.res.model.RegisterRequest;
import ordercraft.com.auth.infrastructure.adapters.input.res.model.UpdateRequest;
import ordercraft.com.auth.infrastructure.adapters.input.res.model.AuthResponse;
import ordercraft.com.auth.infrastructure.adapters.input.res.model.UserResponse;
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
    ResponseEntity<HttpStatus> updateUser(@PathVariable Long idUser, @RequestBody UpdateRequest updateRequest) {
        authService.updateUser(authMapper.toOrderCraftUser(updateRequest), idUser);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }

    @DeleteMapping("/delete/{idUser}")
    ResponseEntity<HttpStatus> deleteUser(@PathVariable Long idUser)  {
        authService.deleteUser(idUser);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/user/{idUser}")
    ResponseEntity<UserResponse> getUser(@PathVariable Long idUser){
        return ResponseEntity.ok(authMapper.toUserResponse(authService.getUserById(idUser)));
    }

}
