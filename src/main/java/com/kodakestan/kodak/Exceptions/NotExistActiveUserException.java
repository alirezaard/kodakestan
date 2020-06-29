package com.kodakestan.kodak.Exceptions;

import com.kodakestan.kodak.Exceptions.handler.HandledException;

import static com.kodakestan.kodak.Exceptions.handler.ExceptionType.THERE_IS_NO_ACTIVE_USER_ERROR;

@HandledException(type = THERE_IS_NO_ACTIVE_USER_ERROR)
public class NotExistActiveUserException extends ServiceException {
}
