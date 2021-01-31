package com.less.core.mvcconfigurer;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


public class HttpInterceptor extends HandlerInterceptorAdapter {

    private static final List<String> resourceApis = new ArrayList<>(10);

    static {
        resourceApis.add("/api/log");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String url = request.getRequestURL().toString();


        if (!isContains(url)) {
            return true;
        }
        /* todo */

        return true;
    }

    private boolean isContains(String url) {
        boolean isContains = false;

        for (String api : HttpInterceptor.resourceApis) {
            if (url.contains(api)) {
                isContains = true;
                break;
            }
        }
        return isContains;
    }
}
