package com.yinhuotec.xiaozhuoai.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
/**
 * @author xpf
 * @version 1.0
 * @description 用户实体
 * @since 2024-11-18 17:11:09
 */
@Data
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = -87189031778658376L;
    /**
     * 主键
     * */
    @TableId(value = "id")
    @TableField("id")
    private Integer id;
    /**
     * 手机号
     * */
    @TableField("phone_number")
    private String phoneNumber;
    /**
     * 平台分配账号
     * */
    @TableField("code")
    private String code;
    /**
     * 用户名称
     * */
    @TableField("nickname")
    private String nickname;
    /**
     * 用户状态,0:正常，1:禁用
     * */
    @TableField("status")
    private Integer status;
}
