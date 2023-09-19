package com.example.weather_back.infrastructure;

import com.example.weather_back.infrastructure.error.ApiError;
import com.example.weather_back.infrastructure.exception.BusinessException;
import com.example.weather_back.infrastructure.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiError> handleDataNotFoundException(DataNotFoundException exception) {
        ApiError apiError = new ApiError();
        apiError.setMessage(exception.getMessage());
        apiError.setErrorCode(exception.getErrorCode());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleBusinessException(BusinessException exception) {
        ApiError apiError = new ApiError();
        apiError.setMessage(exception.getMessage());
        apiError.setErrorCode(exception.getErrorCode());
        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
    }


//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ApiError apiError = new ApiError();
//        apiError.setMessage("Invalid request body content.");
//        apiError.setErrorCode(exception.getMessage());
//        return handleExceptionInternal(exception, apiError, headers, HttpStatus.BAD_REQUEST, request);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ApiError apiError = new ApiError();
//        apiError.setMessage("Invalid parameter type.");
//        apiError.setErrorCode(exception.getMessage());
//        return handleExceptionInternal(exception, apiError, headers, HttpStatus.BAD_REQUEST, request);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException exception, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
//        ApiError apiError = new ApiError();
//        apiError.setMessage("Invalid request body content.");
//        final List<String> errors = new ArrayList<>();
//        for (final FieldError error : exception.getBindingResult().getFieldErrors()) {
//            // default lahendus
//            // errors.add(error.getField() + ": " + error.getDefaultMessage());
//            errors.add(error.getDefaultMessage());
//        }
//        for (final ObjectError error : exception.getBindingResult().getGlobalErrors()) {
//            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
//        }
//        apiError.setErrorCode(errors.toString());
//        return handleExceptionInternal(exception, apiError, headers, HttpStatus.BAD_REQUEST, request);
//    }

}
