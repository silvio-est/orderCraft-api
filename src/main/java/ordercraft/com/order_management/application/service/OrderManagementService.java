package ordercraft.com.order_management.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ordercraft.com.order_management.application.ports.input.OrderManagementServicePort;
import ordercraft.com.order_management.application.ports.output.*;
import ordercraft.com.order_management.domain.exception.ChefNotFoundException;
import ordercraft.com.order_management.domain.exception.DishNotFoundException;
import ordercraft.com.order_management.domain.exception.OrderNotFoundException;
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
    private final ChefPersistencePort chefPersistencePort;
    private final OrderCancelPersistencePort orderCancelPersistencePort;


    @Override
    public void orderComplete(Order order) {

//        Find chef in the database

        Chef findChef = chefPersistencePort.findByUsername(order.getChefUsername())
                .orElseThrow(()-> new ChefNotFoundException("Chef not found in the database " + order.getChefUsername()));

//        Set chef in the orderAssignmentPersistence table

        orderAssignmentPersistencePort.updateChefUserByOrderId(order.getOrderId(), findChef.getChefId());

        Order findOrder = orderPersistencePort.findOrderById(order.getOrderId().longValue())
                .orElseThrow(()-> new OrderNotFoundException("Order not found in the database "
                        + order.getOrderId()));

        findOrder.setState(String.valueOf(State.COMPLETE));

        orderPersistencePort.save(findOrder);



    }

    @Override
    public void cancelOrder(Long tableId,  OrderCancel orderCancel) {

//        Search the last order

        Order order = orderPersistencePort.searchLastOrder(tableId)
                .orElseThrow(()-> new OrderNotFoundException("Order not found in the database with id  " + tableId));

        order.setState(String.valueOf(State.CANCEL));

        orderPersistencePort.save(order);

        orderCancelPersistencePort.save(
                OrderCancel.builder()
                        .orderId(order.getOrderId())
                        .message(orderCancel.getMessage())
                        .build()
        );

    }

    @Override
    @Transactional
    public Order saveOrder(Order order) {

//         Save the order in the database and get the saved instance

        Order saveOrder = orderPersistencePort.save(
                Order.builder()
                        .tableId(order.getTableId())
                        .state(order.getState())
                        .build()
        );


//         For each dish in the order, find the corresponding dish in the database and save the relationship

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

//         Find the waitress in the database

        Waitress findWaitress =  waitressPersistencePort.findByUsername(order.getWaitressUsername())
                .orElseThrow(() -> new WaitressNotFoundException("Waitress not found in the database" + order.getChefUsername()));



//         Save order assignment of the order in the database

        orderAssignmentPersistencePort.save(
                OrderAssignment.builder()
                        .orderId(saveOrder.getOrderId())
                        .waitressId(findWaitress.getWaitressId())
                        .build()
        );

        return saveOrder;

    }
}
