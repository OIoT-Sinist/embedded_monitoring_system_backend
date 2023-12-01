package com.ruoyi.device.mapper;


import com.ruoyi.device.domain.IotDeviceLog;
import com.ruoyi.device.domain.vo.IotDeviceLogVo;
import com.ruoyi.common.core.mapper.BaseMapperPlus;

/**
 * 设备日志Mapper接口
 *
 * @author ruoyi
 * @date 2023-11-26
 */
public interface IotDeviceLogMapper extends BaseMapperPlus<IotDeviceLogMapper, IotDeviceLog, IotDeviceLogVo> {

    /**
     * 获取超出阈值数量
     *
     * @return
     */
    int getExceedsTheThresholdCount();

    /**
     * 获取未超出阈值数量
     *
     * @return
     */
    int getThresholdNotExceededCount();
}
