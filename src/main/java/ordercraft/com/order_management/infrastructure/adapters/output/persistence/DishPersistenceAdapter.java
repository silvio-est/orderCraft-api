package ordercraft.com.order_management.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import ordercraft.com.order_management.application.ports.output.DishPersistencePort;
import ordercraft.com.order_management.domain.model.Dish;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper.DishPersistenceMapper;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository.DishRepository;
import org.springframework.stereotype.Component;

import java.util.List;
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

    @Override
    public void addDish(Dish dish) {
        repository.save(mapper.toDishEntity(dish));
    }

    @Override
    public Optional<Dish> findDishById(Long dishId) {
        return repository.findDishEntitiesByDishId(dishId).map(mapper::toDish);
    }

    @Override
    public Dish save(Dish dish) {
        return mapper.toDish(repository.save(mapper.toDishEntity(dish)));
    }

    @Override
    public void deleteDish(Long dishId) {
        repository.deleteById(dishId);
    }

    @Override
    public List<Dish> getDishesAvailable() {
        return mapper.toDishList(repository.findDishEntitiesByAvailableIsTrue());
    }

    @Override
    public List<Dish> getAllDishes() {
        return mapper.toDishList(repository.findAll());
    }

}
