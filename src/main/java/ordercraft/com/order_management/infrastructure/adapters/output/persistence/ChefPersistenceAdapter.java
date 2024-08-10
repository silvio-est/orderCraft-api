package ordercraft.com.order_management.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import ordercraft.com.order_management.application.ports.output.ChefPersistencePort;
import ordercraft.com.order_management.domain.model.Chef;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper.ChefPersistenceMapper;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository.ChefRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@RequiredArgsConstructor
@Component

public class ChefPersistenceAdapter implements ChefPersistencePort {

    private final ChefRepository repository;
    private final ChefPersistenceMapper mapper;

    @Override
    public Optional<Chef> findByUsername(String username) {
        return repository.findChefEntitiesByUsername(username)
                .map(mapper::toChef);

    }
}
