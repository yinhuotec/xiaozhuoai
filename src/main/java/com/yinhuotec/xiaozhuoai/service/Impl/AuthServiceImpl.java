package com.yinhuotec.xiaozhuoai.service.Impl;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20210111.models.PullSmsSendStatusRequest;
import com.tencentcloudapi.sms.v20210111.models.PullSmsSendStatusResponse;
import com.yinhuotec.xiaozhuoai.common.R;
import com.yinhuotec.xiaozhuoai.service.IAuthService;

import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
// 导入对应SMS模块的client
import com.tencentcloudapi.sms.v20210111.SmsClient;

// 导入要请求接口对应的request response类
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
/**
 * @author xpf
 * @version 1.0
 * @description 认证中心实现类
 * @since 2024-11-18 17:28:21
 */
public class AuthServiceImpl implements IAuthService {

    @Override
    public R<String> login() {
        return null;
    }

    @Override
    public R<String> sendCode(String phoneNumber) {
        try {
            System.out.println(111);
            System.out.println(222);
             Credential cred = new Credential("SecretId", "SecretKey");


            HttpProfile httpProfile = new HttpProfile();

            httpProfile.setReqMethod("GET"); // get请求(默认为post请求)
            httpProfile.setConnTimeout(30); // 请求连接超时时间，单位为秒(默认60秒)
            httpProfile.setWriteTimeout(30);  // 设置写入超时时间，单位为秒(默认0秒)
            httpProfile.setReadTimeout(30);  // 设置读取超时时间，单位为秒(默认0秒)

            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            /* 非必要步骤:
             * 实例化一个客户端配置对象，可以指定超时时间等配置 */
            ClientProfile clientProfile = new ClientProfile();
            /* SDK默认用TC3-HMAC-SHA256进行签名
             * 非必要请不要修改这个字段 */
            clientProfile.setSignMethod("HmacSHA256");
            clientProfile.setHttpProfile(httpProfile);

            /* 实例化要请求产品(以sms为例)的client对象
             * 第二个参数是地域信息，可以直接填写字符串ap-guangzhou，支持的地域列表参考 https://cloud.tencent.com/document/api/382/52071#.E5.9C.B0.E5.9F.9F.E5.88.97.E8.A1.A8 */
            SmsClient client = new SmsClient(cred, "ap-guangzhou", clientProfile);

            PullSmsSendStatusRequest req = new PullSmsSendStatusRequest();

            String sdkAppId = "1400009099";
            req.setSmsSdkAppId(sdkAppId);

            // 设置拉取最大条数，最多100条
            Long limit = 5L;
            req.setLimit(limit);

            /* 通过 client 对象调用 PullSmsSendStatus 方法发起请求。注意请求方法名与请求对象是对应的
             * 返回的 res 是一个 PullSmsSendStatusResponse 类的实例，与请求对象对应 */
            PullSmsSendStatusResponse res = client.PullSmsSendStatus(req);

            // 输出json格式的字符串回包
            System.out.println(PullSmsSendStatusResponse.toJsonString(res));

        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }



        return null;
    }
}
