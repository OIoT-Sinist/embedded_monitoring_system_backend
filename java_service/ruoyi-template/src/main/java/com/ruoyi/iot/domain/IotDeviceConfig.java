package com.ruoyi.iot.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备配置对象 iot_device_config
 *
 * @author ruoyi
 * @date 2023-11-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("iot_device_config")
public class IotDeviceConfig extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 位置纬度
     */
    private String locationLatitude;
    /**
     * 位置经度
     */
    private String locationLogitude;
    /**
     * co2范围
     */
    private String co2Range;
    /**
     * 亮度范围
     */
    private String luminanceRange;
    /**
     * 湿度范围
     */
    private String humidityRange;
    /**
     * 温度范围
     */
    private String tempratureRange;

}
