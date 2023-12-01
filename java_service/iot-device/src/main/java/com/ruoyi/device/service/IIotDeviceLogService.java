package com.ruoyi.device.service;

import com.ruoyi.device.domain.bo.IotDeviceLogBo;
import com.ruoyi.device.domain.vo.IotDeviceLogVo;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;


import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 设备日志Service接口
 *
 * @author ruoyi
 * @date 2023-11-26
 */
public interface IIotDeviceLogService {

    /**
     * 查询设备日志
     */
    IotDeviceLogVo queryById(Long id);

    /**
     * 查询设备日志列表
     */
    TableDataInfo<IotDeviceLogVo> queryPageList(IotDeviceLogBo bo, PageQuery pageQuery);

    /**
     * 查询设备日志列表
     */
    List<IotDeviceLogVo> queryList(IotDeviceLogBo bo);

    /**
     * 新增设备日志
     */
    Boolean insertByBo(IotDeviceLogBo bo);

    /**
     * 修改设备日志
     */
    Boolean updateByBo(IotDeviceLogBo bo);

    /**
     * 校验并批量删除设备日志信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

    /**
     * 设备警告状态占比
     *
     * @return
     */
    Map<String, Integer> warnState();

    /**
     * 当天设备警告数
     *
     * @return
     */
    Map<String, Integer> warnStateToday();

    /**
     * 每小时报警数量
     *
     * @return
     */
    List<Integer> warnNumPerHour();
}
