package com.personal.login.controller;

import com.personal.login.ApiFilter;
import com.personal.login.common.CMS_Result;
import com.personal.login.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class LoginController {
    private final static Logger _Log = LoggerFactory.getLogger(ApiFilter.class);
    @Resource
    private LoginService loginService;
    /**
     * 登录
     * @param map
     * @return
     */
    @PostMapping(value="api/login_in")
    public CMS_Result login(@RequestParam Map<String, Object> map){
        _Log.info("is logining..........");
        return loginService.login(map);
    }
    @PostMapping(value="api/register")
    public CMS_Result addAccount(@RequestParam Map<String, Object> map){
        _Log.info("is registering.........");
        return loginService.addAccount(map);
    }
}

