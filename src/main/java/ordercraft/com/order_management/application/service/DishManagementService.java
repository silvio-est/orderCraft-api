package ordercraft.com.order_management.application.service;

import lombok.RequiredArgsConstructor;
import ordercraft.com.order_management.application.ports.input.DishManagementServicePort;
import ordercraft.com.order_management.application.ports.output.DishPersistencePort;
import ordercraft.com.order_management.domain.exception.DishNotFoundException;
import ordercraft.com.order_management.domain.model.Dish;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.model.DishRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishManagementService implements DishManagementServicePort {

    private final DishPersistencePort dishPersistencePort;

    @Override
    public void addDish(Dish dish) {
        dishPersistencePort.addDish(dish);
    }

    @Override
    public void editDish(Long dishId, Dish dish) {

        dishPersistencePort.findDishById(dishId)
                .map(updateDish ->{
                    updateDish.setName(dish.getName());
                    updateDish.setPrice(dish.getPrice());
                    updateDish.setAvailable(dish.getAvailable());

                    return dishPersistencePort.save(updateDish);
                }).orElseThrow(() -> new DishNotFoundException("Dish not found in the database: " + dishId));

    }

    @Override
    public void deleteDish(Long dishId) {
        dishPersistencePort.deleteDish(dishId);
    }

    @Override
    public List<Dish> getDishesAvailable() {
        return dishPersistencePort.getDishesAvailable();
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishPersistencePort.getAllDishes();
    }

    @Override
    public Dish getDishByID(Long dishId) {
        return dishPersistencePort.findDishById(dishId)
                .orElseThrow(()-> new DishNotFoundException("Dish not found in the database: " + dishId));
    }
}
