package discrimy.algorithms.datastruct;

public class DequeEmptyException extends RuntimeException {
    public DequeEmptyException() {
    }

    public DequeEmptyException(String message) {
        super(message);
    }

    public DequeEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public DequeEmptyException(Throwable cause) {
        super(cause);
    }

    public DequeEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
