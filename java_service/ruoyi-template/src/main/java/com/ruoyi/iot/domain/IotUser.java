package com.ruoyi.iot.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 iot_user
 *
 * @author ruoyi
 * @date 2023-11-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("iot_user")
public class IotUser extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "user_id")
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户类型
     */
    private Long type;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 可见范围
     */
    private Integer ground;

}
