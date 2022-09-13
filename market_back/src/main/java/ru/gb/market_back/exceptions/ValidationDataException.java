package ru.gb.market_back.exceptions;
import java.util.List;



public class ValidationDataException extends RuntimeException {

    private List<String> messages;

    public List<String> getMessages() {
        return messages;
    }

    public ValidationDataException(String message) {
        this(List.of(message));
    }

    public ValidationDataException(List<String> messages) {

        this.messages = messages;
    }
}






