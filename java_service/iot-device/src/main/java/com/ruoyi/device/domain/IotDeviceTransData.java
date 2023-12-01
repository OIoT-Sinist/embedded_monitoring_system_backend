package com.ruoyi.device.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 物联网设备数据传输对象 iot_device_trans_data
 *
 * @author ruoyi
 * @date 2023-11-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("iot_device_trans_data")
public class IotDeviceTransData extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;
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
     * 自定义数据
     */
    private String customData;

}
