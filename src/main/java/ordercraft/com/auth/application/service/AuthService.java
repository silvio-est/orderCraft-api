package ordercraft.com.auth.application.service;

import lombok.RequiredArgsConstructor;
import ordercraft.com.auth.application.ports.input.AuthServicePort;
import ordercraft.com.auth.application.ports.output.AuthPersistencePort;
import ordercraft.com.auth.domain.exception.OrderCraftUserNotFoundException;
import ordercraft.com.auth.domain.model.OrderCraftUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AuthService implements AuthServicePort {

    private final AuthPersistencePort authPersistencePort;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OrderCraftUser login(OrderCraftUser orderCraftUser) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                orderCraftUser.getUsername(), orderCraftUser.getPassword()));

        OrderCraftUser orderCraftUserLogin = authPersistencePort.findByUsername(
                orderCraftUser.getUsername()).orElseThrow(() -> new OrderCraftUserNotFoundException
                ("User not found in the database:" + orderCraftUser.getUsername()));

        String token = jwtService.getToken(orderCraftUserLogin);

        return OrderCraftUser.builder()
                .username(orderCraftUserLogin.getUsername())
                .password(orderCraftUserLogin.getPassword())
                .role(orderCraftUserLogin.getRole())
                .token(token)
                .build();



    }

    @Override
    public OrderCraftUser register(OrderCraftUser orderCraftUser) {

       OrderCraftUser orderCraftUserRegister = OrderCraftUser.builder()
               .username(orderCraftUser.getUsername())
               .password(passwordEncoder.encode(orderCraftUser.getPassword()))
               .role(orderCraftUser.getRole())
               .build();

       authPersistencePort.save(orderCraftUserRegister);

        return OrderCraftUser.builder()
                .role(orderCraftUserRegister.getRole())
                .token(jwtService.getToken(orderCraftUserRegister))
                .build();
    }

    @Override
    public void updateUser(OrderCraftUser orderCraftUser, Long idUser){
        authPersistencePort.findById(idUser)
                .map(saveUser -> {
                    saveUser.setUsername(orderCraftUser.getUsername());
                    saveUser.setPassword(passwordEncoder.encode(orderCraftUser.getPassword()));
                    saveUser.setRole(orderCraftUser.getRole());

                    return authPersistencePort.save(saveUser);
                }).orElseThrow(() -> new OrderCraftUserNotFoundException
                        ("User not found in the database:" + orderCraftUser.getUsername()));

    }

    @Override
    public void deleteUser(Long idUser) {
        if (authPersistencePort.findById(idUser).isEmpty()){
            throw new OrderCraftUserNotFoundException("User not found in the database");
        }

        authPersistencePort.deleteUserByID(idUser);
    }

    @Override
    public OrderCraftUser getUserById(Long idUser) {
        return authPersistencePort
                .findById(idUser).orElseThrow(() -> new OrderCraftUserNotFoundException
                        ("User not found in the database:"));
    }
}
