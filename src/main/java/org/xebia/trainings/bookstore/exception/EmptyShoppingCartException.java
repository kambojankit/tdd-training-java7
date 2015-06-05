package org.xebia.trainings.bookstore.exception;

/**
 * Created by ankit on 05/06/15.
 */
public class EmptyShoppingCartException extends RuntimeException {

    public EmptyShoppingCartException(String message){
        super(message);
    }
}
