package com.less.controller;

import com.less.model.annotations.exception.SelfException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(SelfException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "exception");
        map.put("message", e.getMessage());
        /* 使用DefaultErrorAttributes处理 */
        request.setAttribute("errorMsg", map);
        return "forward:/error";
    }
}
