package ordercraft.com.order_management.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ordercraft.com.order_management.application.ports.input.OrderManagementServicePort;
import ordercraft.com.order_management.application.ports.output.*;
import ordercraft.com.order_management.domain.exception.DishNotFoundException;
import ordercraft.com.order_management.domain.exception.WaitressNotFoundException;
import ordercraft.com.order_management.domain.model.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderManagementService implements OrderManagementServicePort {

    private final OrderPersistencePort orderPersistencePort;
    private final DishPersistencePort dishPersistencePort;
    private final OrderDishPersistencePort orderDishPersistencePort;
    private final WaitressPersistencePort waitressPersistencePort;
    private final OrderAssignmentPersistencePort orderAssignmentPersistencePort;


    @Override
    public void saveOrder(Order order) {

        //  Save the order in the database and get the saved instance

        Order saveOrder = orderPersistencePort.save(
                Order.builder()
                        .tableId(order.getTableId())
                        .build()
        );


        // For each dish in the order, find the corresponding dish in the database and save the relationship

        order.getDishes().forEach(dish -> {
            Dish dishFind = dishPersistencePort.findByName(dish.getName())
                    .orElseThrow(() -> new DishNotFoundException("Dish not found in the database" + dish.getName()));

            // Save the relationship between the order and the dish
            orderDishPersistencePort.save(
                    OrderDish.builder()
                            .orderId(saveOrder.getOrderId())
                            .dishId(dishFind.getDishId())
                            .amount(dish.getAmount())
                            .build()
            );
        });

        // Find the waitress in the database

        Waitress findWaitress =  waitressPersistencePort.findByUsername(order.getUsername())
                .orElseThrow(() -> new WaitressNotFoundException("Waitress not found in the database" + order.getUsername()));



        // Save order assignment of the order in the database

        orderAssignmentPersistencePort.save(
                OrderAssignment.builder()
                        .orderID(saveOrder.getOrderId())
                        .waitressId(findWaitress.getWaitressId())
                        .build()
        );





    }
}
