package ordercraft.com.order_management.domain.exception;

public class ChefNotFoundException extends RuntimeException{

    public ChefNotFoundException(String message) {
        super(message);
    }
}
