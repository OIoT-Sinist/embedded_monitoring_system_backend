package com.ruoyi.iot.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;

import java.io.Serializable;

/**
 * 设备日志视图对象 iot_device_log
 *
 * @author ruoyi
 * @date 2023-11-26
 */
@Data
@ExcelIgnoreUnannotated
public class IotDeviceLogVo implements Serializable {

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
     * co2
     */
    @ExcelProperty(value = "co2")
    private String co2;

    /**
     * 亮度
     */
    @ExcelProperty(value = "亮度")
    private String luminance;

    /**
     * 湿度
     */
    @ExcelProperty(value = "湿度")
    private String humidity;

    /**
     * 温度
     */
    @ExcelProperty(value = "温度")
    private String temprature;

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
     * 是否超出阈值
     */
    @ExcelProperty(value = "是否超出阈值")
    private Integer hasError;

    /**
     * 自定义数据
     */
    @ExcelProperty(value = "自定义数据")
    private String customData;


}
