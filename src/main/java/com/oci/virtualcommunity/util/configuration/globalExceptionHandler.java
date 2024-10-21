package com.oci.virtualcommunity.util.configuration;

import com.oci.virtualcommunity.util.restful.ResponseResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class globalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseResult<Object> exceptionHandler(MethodArgumentNotValidException e){

        return new ResponseResult<>(503,"error",null);
    }

}
