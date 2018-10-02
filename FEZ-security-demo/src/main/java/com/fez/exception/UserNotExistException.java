package com.fez.exception;

/**
 * Created by H.J
 * 2018/10/2
 */
public class UserNotExistException extends RuntimeException{

    static final long serialVersionUID = -7034897190745766933L;

    private String id;

    public UserNotExistException(String id){
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
