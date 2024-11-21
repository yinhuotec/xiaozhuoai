package com.yinhuotec.xiaozhuoai.dto.req;

import lombok.Data;
import java.util.List;

/**
 * @author xpf
 * @version 1.0
 * @description
 * @since 2024-10-17 15:47:10
 */
@Data
public class JsonDataReq {
    private String model;
    private List<MessageReq> messageReqs;
}


