package ordercraft.com.order_management.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import ordercraft.com.order_management.application.ports.output.DishPersistencePort;
import ordercraft.com.order_management.domain.model.Dish;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper.DishPersistenceMapper;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository.DishRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@RequiredArgsConstructor
@Component

public class DishPersistenceAdapter implements DishPersistencePort {

    private final DishRepository repository;
    private final DishPersistenceMapper mapper;

    @Override
    public Optional<Dish> findByName(String name) {
        return repository.findDishEntitiesByName(name)
                .map(mapper::toDish);
    }
}
