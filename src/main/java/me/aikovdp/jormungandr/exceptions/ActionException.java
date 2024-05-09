package me.aikovdp.jormungandr.exceptions;

public class ActionException extends RuntimeException {
    public ActionException(Throwable cause) {
        super(cause);
    }

    public ActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActionException(String message) {
        super(message);
    }

    public ActionException() {
    }
}
