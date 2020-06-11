package com.kodakestan.kodak.Exceptions.handler;
/**
 * Copyright (c) 2019 , thnx  Project . All Rights Reserved
 * Created by Mostafa.Farhadi on 9/3/2019.
 */

import java.io.Serializable;

public class ExceptionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String message;
    private final String description;

    public ExceptionDTO(String message) {
        this(message, null);
    }

    public ExceptionDTO(String message, String description) {
        this.message = message;
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
