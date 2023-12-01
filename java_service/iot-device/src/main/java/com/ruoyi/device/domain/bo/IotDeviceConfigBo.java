package com.ruoyi.device.domain.bo;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.*;

/**
 * 设备配置业务对象 iot_device_config
 *
 * @author ruoyi
 * @date 2023-11-26
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class IotDeviceConfigBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 设备名
     */
    @NotNull(message = "设备名不能为空", groups = { EditGroup.class })
    private String deviceName;
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
     * co2范围
     */
    @NotBlank(message = "co2范围不能为空", groups = { AddGroup.class, EditGroup.class })
    private String co2Range;

    /**
     * 亮度范围
     */
    @NotBlank(message = "亮度范围不能为空", groups = { AddGroup.class, EditGroup.class })
    private String luminanceRange;

    /**
     * 湿度范围
     */
    @NotBlank(message = "湿度范围不能为空", groups = { AddGroup.class, EditGroup.class })
    private String humidityRange;

    /**
     * 温度范围
     */
    @NotBlank(message = "温度范围不能为空", groups = { AddGroup.class, EditGroup.class })
    private String tempratureRange;

    /**
     * 报警阈值
     */
    @NotBlank(message = "报警阈值不能为空", groups = { AddGroup.class, EditGroup.class })
    private String alarmThreshold;

}
