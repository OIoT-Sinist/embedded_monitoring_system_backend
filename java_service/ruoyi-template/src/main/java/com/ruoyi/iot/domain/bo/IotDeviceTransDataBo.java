package com.ruoyi.iot.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物联网设备数据传输业务对象 iot_device_trans_data
 *
 * @author ruoyi
 * @date 2023-11-26
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class IotDeviceTransDataBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * co2
     */
    @NotBlank(message = "co2不能为空", groups = { AddGroup.class, EditGroup.class })
    private String co2;

    /**
     * 亮度
     */
    @NotBlank(message = "亮度不能为空", groups = { AddGroup.class, EditGroup.class })
    private String luminance;

    /**
     * 湿度
     */
    @NotBlank(message = "湿度不能为空", groups = { AddGroup.class, EditGroup.class })
    private String humidity;

    /**
     * 温度
     */
    @NotBlank(message = "温度不能为空", groups = { AddGroup.class, EditGroup.class })
    private String temprature;

    /**
     * 自定义数据
     */
    @NotBlank(message = "自定义数据不能为空", groups = { AddGroup.class, EditGroup.class })
    private String customData;


}
