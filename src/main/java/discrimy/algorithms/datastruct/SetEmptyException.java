package discrimy.algorithms.datastruct;

public class SetEmptyException extends RuntimeException {
    public SetEmptyException() {
    }

    public SetEmptyException(String message) {
        super(message);
    }

    public SetEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public SetEmptyException(Throwable cause) {
        super(cause);
    }

    public SetEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
