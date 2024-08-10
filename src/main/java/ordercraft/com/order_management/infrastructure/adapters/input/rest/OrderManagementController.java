package ordercraft.com.order_management.infrastructure.adapters.input.rest;

import lombok.RequiredArgsConstructor;

import ordercraft.com.order_management.application.ports.input.OrderManagementServicePort;
import ordercraft.com.order_management.domain.model.Order;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.mapper.OrderManagementControllerMapper;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.model.CheckOrderRequest;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.model.OrderRequest;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.model.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderManagementController {

    private final OrderManagementServicePort servicePort;
    private final OrderManagementControllerMapper mapper;

    @MessageMapping("/orderManagement/{roomId}")
    @SendTo("/topic/{roomId}")
    OrderResponse receiveOrder(OrderRequest orderRequest){

        Order order = servicePort.saveOrder(mapper.toOrder(orderRequest));

        return new OrderResponse(order.getOrderId(), orderRequest.getUsername(),
                orderRequest.getTableId(), orderRequest.getDishes());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/checkOrder")
    ResponseEntity<HttpStatus> checkOrder(@RequestBody CheckOrderRequest checkOrderRequest){

        servicePort.orderComplete(checkOrderRequest);

        return ResponseEntity.status(HttpStatus.OK).build();

    }







}

