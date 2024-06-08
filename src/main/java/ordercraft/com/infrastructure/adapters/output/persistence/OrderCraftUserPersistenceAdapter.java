package ordercraft.com.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import ordercraft.com.application.ports.output.auth.AuthPersistencePort;
import ordercraft.com.domain.model.OrderCraftUser;
import ordercraft.com.infrastructure.adapters.output.persistence.mapper.OrderCraftUserPersistenceMapper;
import ordercraft.com.infrastructure.adapters.output.persistence.repository.OrderCraftUserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@RequiredArgsConstructor
@Component
public class OrderCraftUserPersistenceAdapter implements AuthPersistencePort {

    private final OrderCraftUserRepository repository;
    private final OrderCraftUserPersistenceMapper mapper;

    @Override
    public OrderCraftUser save(OrderCraftUser orderCraftUser) {
        return mapper.toOrderCraftUser(repository.save(
                mapper.toOrderCraftUserEntity(orderCraftUser)
        ));
    }

    @Override
    public Optional<OrderCraftUser> findByUsername(String username) {
        return repository.findByUsername(username)
                .map(mapper::toOrderCraftUser);
    }

    @Override
    public Optional<OrderCraftUser> findById(Long idUser) {
        return repository.findById(idUser)
                .map(mapper::toOrderCraftUser);
    }

    @Override
    public void deleteUserByID(Long idUser) {
        repository.deleteById(idUser);
    }


}
