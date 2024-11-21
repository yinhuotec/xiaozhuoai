package com.yinhuotec.xiaozhuoai.service;

import com.yinhuotec.xiaozhuoai.common.R;

/**
 * @author xpf
 * @version 1.0
 * @description 认证中心
 * @since 2024-11-18 17:25:55
 */
public interface IAuthService {
    /**
      登录
      @description
     * */
    R<String> login();

    /**
     * 注销
     * */

    /**
     * 发送验证码
     * @description 腾讯短信接口
     * */
    R<String> sendCode(String phoneNumber);
}
