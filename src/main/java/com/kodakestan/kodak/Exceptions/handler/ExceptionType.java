package com.kodakestan.kodak.Exceptions.handler;

public enum ExceptionType {
    //internal Exception
    UNHANDLED_EXCEPTION(101),
    ERR_CONCURRENCY_FAILURE(102),
    ERR_ACCESS_DENIED(103),
    ERR_VALIDATION(104),
    ERR_METHOD_NOT_SUPPORTED(105),
    ERR_INTERNAL_SERVER_ERROR(106),

    //service Exception
    ERR_BAD_REQUEST(201),

    THERE_IS_NO_ACTIVE_USER_ERROR(202);


    private int code;

    ExceptionType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
