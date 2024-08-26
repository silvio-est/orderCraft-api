package ordercraft.com.order_management.application.ports.output;

import ordercraft.com.order_management.domain.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishPersistencePort {
    Optional<Dish> findByName(String name);
    void addDish(Dish dish);
    Optional<Dish> findDishById(Long dishId);
    Dish save(Dish dish);
    void deleteDish(Long dishId);
    List<Dish> getDishesAvailable();
    List<Dish> getAllDishes();
}
