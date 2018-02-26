package com.personal.login.service.imp;

import com.personal.login.common.CMS_Result;
import com.personal.login.dao.LoginDao;
import com.personal.login.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class LoginServiceImp implements LoginService {
    @Resource
    private LoginDao loginDao;

    /**
     * 判断账号和密码是否正确
     * @param map
     * @return
     */
    @Override
    public CMS_Result login(Map<String, Object> map) {
        CMS_Result result = checkLoginParams(map);
        if (!"true".equals(result.getSuccess())) {
            return result;
        }
        if (loginDao.verifyAccountPwd(map) == null || "".equals(loginDao.verifyAccountPwd(map))) {
            return new CMS_Result("5003","账号密码不正确");
        } else {
            String user_name = loginDao.verifyAccountPwd(map);
            Map<String,Object> data = new HashMap<>();
            data.put("user_name", user_name);
            return CMS_Result.bulid("true",data);
        }
    }

    /**
     * 增加账号
     * @param map
     * @return
     */
    @Override
    public CMS_Result addAccount(Map<String, Object> map) {
        CMS_Result result = checkRegisterParams(map);
        if (!"true".equals(result.getSuccess())) {
            return result;
        }
        map.put("user_id", UUID.randomUUID().toString());
        if (loginDao.addAccount(map) != 1) {
            return CMS_Result.bulid("5005","注册失败");
        }
        return CMS_Result.ok();
    }

    /**
     * 验证登录时的参数
     * @param map
     * @return
     */
    private CMS_Result checkLoginParams(Map<String, Object> map) {
        if (!map.containsKey("user_account") || StringUtils.isBlank(map.get("user_account").toString())) {
            return CMS_Result.bulid("5001", "user_account不可以为空");
        }
        if (!map.containsKey("user_pwd") || StringUtils.isBlank(map.get("user_pwd").toString())) {
            return CMS_Result.bulid("5002", "user_pwd不可以为空");
        }
        return CMS_Result.ok();
    }

    /**
     * 验证注册时的参数
     * @param map
     * @return
     */
    private CMS_Result checkRegisterParams(Map<String, Object> map) {
        if (!map.containsKey("user_account") || StringUtils.isBlank(map.get("user_account").toString())) {
            return CMS_Result.bulid("5001", "user_account不可以为空");
        }
        if (loginDao.findAccount(map.get("user_account").toString()) == 1) {
            return CMS_Result.bulid("5006", "user_account已存在");
        }
        if (!map.containsKey("user_name") || StringUtils.isBlank(map.get("user_name").toString())) {
            return CMS_Result.bulid("5004", "user_name不可以为空");
        }
        if (!map.containsKey("user_pwd") || StringUtils.isBlank(map.get("user_pwd").toString())) {
            return CMS_Result.bulid("5002", "user_pwd不可以为空");
        }
        return CMS_Result.ok();
    }
}
