package exception;

import enums.EnumException;

public class AppException extends RuntimeException {


    public  AppException(EnumException ex){
        super(ex.getMessage());
    }



}
