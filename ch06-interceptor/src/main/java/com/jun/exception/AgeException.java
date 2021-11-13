package com.jun.exception;

/**
 * @author HuangJun7
 * @date 2021-11-13 12:28
 */
public class AgeException extends MyUserException{
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
