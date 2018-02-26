package com.personal.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器
 */
@Configuration
@WebFilter(filterName = "apiFilter",urlPatterns = "api/*")
public class ApiFilter implements Filter {
    private final static Logger _Log = LoggerFactory.getLogger(ApiFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        _Log.info("filter is initiated");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //请求的url方式
        String method = request.getMethod();
        returnJson(response);
        _Log.info("filter is doing");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        _Log.info("filter is destroyed");
    }
    public void returnJson(HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        //解决跨域问题
        response.addHeader("Access-Control-Allow-Origin", "*");
        /*response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "0");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control,user_token, Expires, Content-Type, X-E4M-With");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("XDomainRequestAllowed","1");
        response.getWriter().append(message);*/
    }
}
