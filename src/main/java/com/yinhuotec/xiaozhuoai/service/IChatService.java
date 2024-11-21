package com.yinhuotec.xiaozhuoai.service;

import com.yinhuotec.xiaozhuoai.common.R;

import java.io.IOException;

/**
 * @author xpf
 * @version 1.0
 * @description
 * @since 2024-10-17 15:08:37
 */
public interface IChatService {
    R<String> chat(String text) throws IOException;
}
