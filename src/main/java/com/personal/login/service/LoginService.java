package com.personal.login.service;

import com.personal.login.common.CMS_Result;

import javax.xml.transform.Result;
import java.util.Map;

public interface LoginService {
    /**
     * 判断账号和密码是否正确
     * @param map
     * @return
     */
    CMS_Result login(Map<String, Object> map);

    /**
     * 增加账号
     * @param map
     * @return
     */
    CMS_Result addAccount(Map<String, Object> map);
}
