package com.personal.login.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LoginDao {
    /**
     * 判断账号和密码是否正确
     * @param map
     * @return
     */
    String verifyAccountPwd (Map<String,Object> map);

    /**
     * 新增账号
     * @param map
     * @return
     */
    Integer addAccount(Map<String,Object> map);

    /**
     * 判断注册账号是否已存在
     * @param user_account
     * @return
     */
    Integer findAccount(String user_account);

}
