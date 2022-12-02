package com.miracle.worm_cat.common.exception;

import com.miracle.worm_cat.common.constant.BaseConstant;
import com.miracle.worm_cat.common.response.RespResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * author: Miracle-
 * time: 2022/7/28 23:13
 * 全局异常处理类
 */
@Slf4j
@RestControllerAdvice //声明为全局的 Control 异常处理
public class GlobalExceptHandler {

    @ExceptionHandler(value = MiracleException.class)
    public RespResult<?> miracleExceptionHandler(MiracleException exception) {
        log.error("Happen MiracleException Exception: " + exception.getMessage());
        return RespResult.failure(exception.getErrCode(), exception.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public RespResult<?> methodArgumentNotValidHandler(MethodArgumentNotValidException exception) {
        Map<String, String> errMap = new HashMap<>();
        BindingResult bindingResult = exception.getBindingResult();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }

        log.error("Happen MethodArgumentNotValidException Exception: " + errMap);
        return RespResult.failure(BaseConstant.PARAM_VALIDATE_FAIL, errMap);
    }

    @ExceptionHandler(value = BindException.class)
    public RespResult<?> bindExceptionHandler(BindException exception) {
        Map<String, String> errMap = new HashMap<>();
        BindingResult bindingResult = exception.getBindingResult();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }

        log.error("Happen BindException Exception: " + errMap);
        return RespResult.failure(BaseConstant.BIND_EXCEPTION, errMap);
    }

    @ExceptionHandler(value = Exception.class)
    public RespResult<?> defaultExceptionHandler(Exception exception) {
        log.error("Happen Default Exception: " + exception.getMessage());
        return RespResult.failure(BaseConstant.RESPONSE_CODE_FAILURE, exception.getMessage());
    }
}
