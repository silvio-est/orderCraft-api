package ordercraft.com.order_management.domain.exception;

public class WaitressNotFoundException extends RuntimeException{

    public WaitressNotFoundException(String message) {
        super(message);
    }
}
