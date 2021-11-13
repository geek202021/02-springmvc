package com.jun.exception;

/**
 * @author HuangJun7
 * @date 2021-11-13 12:27
 */
public class MyUserException extends Exception{
    public MyUserException() {
        super();
    }

    public MyUserException(String message) {
        super(message);
    }
}
