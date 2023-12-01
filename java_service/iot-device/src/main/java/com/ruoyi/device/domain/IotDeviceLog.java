package com.ruoyi.device.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 设备日志对象 iot_device_log
 *
 * @author ruoyi
 * @date 2023-11-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("iot_device_log")
public class IotDeviceLog extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    private Long deviceId;
    /**
     * 设备名
     */
    private String deviceName;
    /**
     * co2
     */
    private String co2;
    /**
     * 亮度
     */
    private String luminance;
    /**
     * 湿度
     */
    private String humidity;
    /**
     * 温度
     */
    private String temprature;
    /**
     * 位置纬度
     */
    private String locationLatitude;
    /**
     * 位置经度
     */
    private String locationLogitude;
    /**
     * 是否超出阈值
     */
    private Integer hasError;
    /**
     * 自定义数据
     */
    private String customData;
}
