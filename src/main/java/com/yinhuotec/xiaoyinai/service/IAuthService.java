package com.yinhuotec.xiaoyinai.service;

import com.yinhuotec.xiaoyinai.common.R;

/**
 * @author xpf
 * @version 1.0
 * @description 认证中心
 * @since 2024-11-18 17:25:55
 */
public interface IAuthService {
    /**
      登录
      @description 手机验证码登录
     * */
    R<String> login();



    /**
     * 注销
     * */
}
