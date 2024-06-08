package ordercraft.com.domain.exception;


import lombok.Getter;


@Getter

public class OrderCraftUserNotFoundException extends RuntimeException{
    public OrderCraftUserNotFoundException() {
    }

    public OrderCraftUserNotFoundException(String message) {
        super(message);
    }

    public OrderCraftUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderCraftUserNotFoundException(Throwable cause) {
        super(cause);
    }

    public OrderCraftUserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
