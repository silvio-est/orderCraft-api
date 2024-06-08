package ordercraft.com.domain.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<String> handlerArgumentException(IllegalArgumentException e){
        log.error("Error:" + e.getMessage());
        return new ResponseEntity<>("Error in the request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlerRunTimeException(RuntimeException e){
        log.error("Error:" + e.getMessage());
        return new ResponseEntity<>("Error in the server", HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(OrderCraftUserNotFoundException.class)
    public ResponseEntity<String> handlerOrderCraftUserNotFoundException(OrderCraftUserNotFoundException e){
        log.error("Error:" + e.getMessage());
        return new ResponseEntity<>("User not found ", HttpStatus.NOT_FOUND);
    }





}

