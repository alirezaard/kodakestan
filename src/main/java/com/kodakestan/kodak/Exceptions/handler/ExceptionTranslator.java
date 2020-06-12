package com.kodakestan.kodak.Exceptions.handler;

import com.kodakestan.kodak.configuration.utils.MessageUtils;
import com.kodakestan.kodak.configuration.utils.RestResponse;
import com.kodakestan.kodak.services.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kodakestan.kodak.Exceptions.handler.ExceptionType.*;


/**
 * Controller advice to translate the server side exceptions to client-friendly json structures.
 */
@ControllerAdvice
@Slf4j
public class ExceptionTranslator {

    @Autowired
    private MessageService messageService;

    @ExceptionHandler(ConcurrencyFailureException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ExceptionDTO processConcurencyError(ConcurrencyFailureException ex) {
        return new ExceptionDTO(messageService.getMessage("internalException." + ERR_CONCURRENCY_FAILURE.getCode()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionDTO processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        return processFieldErrors(fieldErrors);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ExceptionDTO processAccessDeniedException(AccessDeniedException e) {
        return new ExceptionDTO(messageService.getMessage("internalException." + ERR_ACCESS_DENIED.getCode()), e.getMessage());
    }

    private ExceptionDTO processFieldErrors(List<FieldError> fieldErrors) {
        return new ExceptionDTO(messageService.getMessage("internalException." + ERR_VALIDATION.getCode()));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ExceptionDTO processMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        return new ExceptionDTO(messageService.getMessage("internalException." + ERR_METHOD_NOT_SUPPORTED.getCode(), exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestResponse> processRuntimeException(Exception ex) throws Exception {
        if (ex.getClass().isAnnotationPresent(HandledException.class)) {
            HandledException annotation = ex.getClass().getAnnotation(HandledException.class);
            String des = annotation.description();
            String[] params = annotation.params();
            int system_error_code = annotation.type().getCode();
            logger.debug("Service Exception --> code: {}, description: {}", system_error_code, des);
            String tempMsg = messageService.getMessage("serviceException." + system_error_code);
            Map<String, Object> paramsMap = new HashMap<>();
            for (String param : params) {
                Object value;
                try {
                    value = ex.getClass().getMethod("get" + StringUtils.capitalize(param)).invoke(ex);
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    value = null;
                }
                paramsMap.put(param, value);
            }
            String message = MessageUtils.putParams(tempMsg, paramsMap);
            return new ResponseEntity<>(RestResponse.error(system_error_code, message), HttpStatus.OK);
        }
        if (ex instanceof MissingServletRequestPartException || ex instanceof MissingServletRequestParameterException)
            return new ResponseEntity<>(RestResponse.error(ERR_BAD_REQUEST.getCode(),
                    messageService.getMessage("serviceException." + ERR_BAD_REQUEST.getCode())), HttpStatus.OK);
        logger.error("Un handled Error:", ex);
        return new ResponseEntity<>(RestResponse.error(UNHANDLED_EXCEPTION.getCode(),
                messageService.getMessage("internalException." + UNHANDLED_EXCEPTION.getCode())), HttpStatus.OK);
    }
}