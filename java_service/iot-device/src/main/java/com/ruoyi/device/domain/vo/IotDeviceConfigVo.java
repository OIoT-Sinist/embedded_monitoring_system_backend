package com.ruoyi.device.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 设备配置视图对象 iot_device_config
 *
 * @author ruoyi
 * @date 2023-11-26
 */
@Data
@ExcelIgnoreUnannotated
public class IotDeviceConfigVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 设备名
     */
    @ExcelProperty(value = "设备名")
    private String deviceName;
    /**
     * 位置纬度
     */
    @ExcelProperty(value = "位置纬度")
    private String locationLatitude;

    /**
     * 位置经度
     */
    @ExcelProperty(value = "位置经度")
    private String locationLogitude;

    /**
     * co2范围
     */
    @ExcelProperty(value = "co2范围")
    private String co2Range;

    /**
     * 亮度范围
     */
    @ExcelProperty(value = "亮度范围")
    private String luminanceRange;

    /**
     * 湿度范围
     */
    @ExcelProperty(value = "湿度范围")
    private String humidityRange;

    /**
     * 温度范围
     */
    @ExcelProperty(value = "温度范围")
    private String tempratureRange;

    /**
     * 报警阈值
     */
    @ExcelProperty(value = "报警阈值")
    private String alarmThreshold;
}
