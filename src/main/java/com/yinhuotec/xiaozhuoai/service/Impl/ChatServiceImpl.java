package com.yinhuotec.xiaozhuoai.service.Impl;

import com.yinhuotec.xiaozhuoai.common.R;
import com.yinhuotec.xiaozhuoai.dto.req.JsonData;
import com.yinhuotec.xiaozhuoai.dto.req.Message;
import com.yinhuotec.xiaozhuoai.service.IChatService;
import org.json.JSONObject;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xpf
 * @version 1.0
 * @description
 * @since 2024-10-17 15:09:03
 */
@Service
public class ChatServiceImpl implements IChatService {
    private final String ZHIPU_URL = "https://open.bigmodel.cn/api/paas/v4/chat/completions";
    private final String API_KEY = "c63812e429e83a29ef878af43102dac1.szEedCIIVibESEOb";
    @Override
    public R<String> chat(String text) throws IOException {
        //将JsonData、Message对象转换成
        Message messageReq = new Message();
        messageReq.setRole("user");
        messageReq.setContent(text);
        List<Message> messageReqs = new ArrayList<>();
        messageReqs.add(messageReq);
        JsonData jsonData = new JsonData();
        //jsonData设置参数
        jsonData.setModel("glm-4-flash");
        jsonData.setMessages(messageReqs);
//        jsonData.setStream("True");

        JSONObject jsonObject = new JSONObject(jsonData);
        String jsonString = jsonObject.toString();
        //设置请求URL
        URL url = new URL(ZHIPU_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //设置请求方法
        connection.setRequestMethod("POST");
        //设置请求头
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer"+" "+API_KEY);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }

        // 允许输出和输入流
        connection.setDoOutput(true);
        connection.setDoInput(true);

        // 发送 JSON 数据
        try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
            byte[] input = jsonString.getBytes(StandardCharsets.UTF_8);
            outputStream.write(input, 0, input.length);
        }
        String rr;
        // 获取响应
        int responseCode = connection.getResponseCode();
        System.out.println("响应状态码：" + responseCode);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine())!= null) {
                response.append(inputLine);
            }
            System.out.println("响应: " + response.toString());
            rr = response.toString();
        }
        connection.disconnect();

        return R.success(rr);
    }
}
