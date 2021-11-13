package com.jun.exception;

/**
 * @author HuangJun7
 * @date 2021-11-13 12:27
 */
public class NameException extends MyUserException{
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
