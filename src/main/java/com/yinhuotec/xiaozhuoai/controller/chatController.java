package com.yinhuotec.xiaozhuoai.controller;

import com.yinhuotec.xiaozhuoai.common.R;
import com.yinhuotec.xiaozhuoai.service.IChatService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author xpf
 * @version 1.0
 * @description
 * @since 2024-10-16 12:56:42
 */
@RestController
@RequestMapping("/api/chat")
@CrossOrigin
public class chatController {
  @Resource
  private IChatService zhipuService;
  @RequestMapping()
  public R<String> autoAnswer(@RequestBody String text) throws IOException {
       System.out.println(text);
       return zhipuService.chat(text);
  }
}
