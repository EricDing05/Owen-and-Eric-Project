package model.scraper.Exceptions;

public class NoMoreProductsException extends RuntimeException {

    public NoMoreProductsException(String message) {
        super(message);
    }
}
