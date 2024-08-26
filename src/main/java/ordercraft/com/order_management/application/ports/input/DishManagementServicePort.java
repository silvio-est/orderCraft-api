package ordercraft.com.order_management.application.ports.input;

import ordercraft.com.order_management.domain.model.Dish;

import java.util.List;

public interface DishManagementServicePort {
    void addDish(Dish dish);
    void editDish(Long dishId, Dish dish);
    void deleteDish(Long dishId);
    List<Dish> getDishesAvailable();
    List<Dish> getAllDishes();
    Dish getDishByID(Long dishId);
}