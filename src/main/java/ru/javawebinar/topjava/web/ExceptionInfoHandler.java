package ru.javawebinar.topjava.web;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * User: gkislin
 * Date: 23.09.2014
 */
@ControllerAdvice(annotations = RestController.class)
public class ExceptionInfoHandler extends ResponseEntityExceptionHandler {
    LoggerWrapper LOG = LoggerWrapper.get(ExceptionInfoHandler.class);

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public ResponseEntity handleError(HttpServletRequest req, NotFoundException e) {
        //return LOG.getErrorInfo(req.getRequestURL(), e);
        return new ResponseEntity<>(LOG.getErrorInfo(req.getRequestURL(), e), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ResponseStatus(value = HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    @Order(Ordered.HIGHEST_PRECEDENCE + 1)
    public ResponseEntity conflict(HttpServletRequest req, DataIntegrityViolationException e) {
        //return LOG.getErrorInfo(req.getRequestURL(), e);
        return new ResponseEntity<>(LOG.getErrorInfo(req.getRequestURL(), e), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @Order(Ordered.LOWEST_PRECEDENCE)
    public ResponseEntity handleError(HttpServletRequest req, Exception e) {
        //return LOG.getErrorInfo(req.getRequestURL(), e);
        return new ResponseEntity<>(LOG.getErrorInfo(req.getRequestURL(), e), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
