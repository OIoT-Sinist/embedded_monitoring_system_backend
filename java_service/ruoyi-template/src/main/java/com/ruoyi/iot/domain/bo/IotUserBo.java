package com.ruoyi.iot.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户业务对象 iot_user
 *
 * @author ruoyi
 * @date 2023-11-26
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class IotUserBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long userId;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String password;

    /**
     * 用户类型
     */
    @NotNull(message = "用户类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long type;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String phone;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空", groups = { AddGroup.class, EditGroup.class })
    private String email;

    /**
     * 可见范围
     */
    @NotNull(message = "可见范围不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer ground;


}
