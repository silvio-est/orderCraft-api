package ordercraft.com.auth.domain.exception;


import lombok.Getter;


@Getter

public class OrderCraftUserNotFoundException extends RuntimeException{

    public OrderCraftUserNotFoundException(String message) {
        super(message);
    }
}
