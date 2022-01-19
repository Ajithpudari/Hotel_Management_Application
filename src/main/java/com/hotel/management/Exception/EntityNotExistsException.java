package com.hotel.management.Exception;


public class EntityNotExistsException extends RuntimeException {


    private static final long serialVersionID = 1l;
    private String errorCode;
    private String errorMessage;


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public static long getSerialVersionID() {
        return serialVersionID;
    }


    public EntityNotExistsException(String errorCode, String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
    public EntityNotExistsException(){

    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
