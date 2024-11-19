package com.yinhuotec.xiaoyinai.dto.req;

import lombok.Data;

/**
 * @author xpf
 * @version 1.0
 * @description 信息实体
 * @since 2024-10-17 16:08:49
 */
@Data
public class MessageReq {
    private String role;
    private String content;
}
