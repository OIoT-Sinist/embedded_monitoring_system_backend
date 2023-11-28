package com.ruoyi.iot.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备日志业务对象 iot_device_log
 *
 * @author ruoyi
 * @date 2023-11-26
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class IotDeviceLogBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 设备名
     */
    @NotBlank(message = "设备名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String deviceName;

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
     * 位置纬度
     */
    @NotBlank(message = "位置纬度不能为空", groups = { AddGroup.class, EditGroup.class })
    private String locationLatitude;

    /**
     * 位置经度
     */
    @NotBlank(message = "位置经度不能为空", groups = { AddGroup.class, EditGroup.class })
    private String locationLogitude;

    /**
     * 是否超出阈值
     */
    @NotNull(message = "是否超出阈值不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer hasError;

    /**
     * 自定义数据
     */
    @NotBlank(message = "自定义数据不能为空", groups = { AddGroup.class, EditGroup.class })
    private String customData;


}
