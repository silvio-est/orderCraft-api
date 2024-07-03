package ordercraft.com.order_management.infrastructure.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import ordercraft.com.order_management.application.ports.input.OrderManagementServicePort;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.mapper.OrderManagementControllerMapper;
import ordercraft.com.order_management.infrastructure.adapters.input.rest.model.OrderRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderManagementController {

    private final OrderManagementServicePort servicePort;
    private final OrderManagementControllerMapper mapper;

    @MessageMapping("/sendOrder")
    @SendTo("/topic/orders")
    ResponseEntity<HttpStatus> receiveOrder(@RequestBody OrderRequest orderRequest){

        servicePort.saveOrder(mapper.toOrder(orderRequest));
        return ResponseEntity.ok().build();
    }



}

