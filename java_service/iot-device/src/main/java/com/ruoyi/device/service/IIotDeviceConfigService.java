package com.ruoyi.device.service;

import com.ruoyi.device.domain.bo.IotDeviceConfigBo;
import com.ruoyi.device.domain.vo.IotDeviceConfigVo;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 设备配置Service接口
 *
 * @author ruoyi
 * @date 2023-11-26
 */
public interface IIotDeviceConfigService {

    /**
     * 查询设备配置
     */
    IotDeviceConfigVo queryById(Long id);

    /**
     * 查询设备配置列表
     */
    TableDataInfo<IotDeviceConfigVo> queryPageList(IotDeviceConfigBo bo, PageQuery pageQuery);

    /**
     * 查询设备配置列表
     */
    List<IotDeviceConfigVo> queryList(IotDeviceConfigBo bo);

    /**
     * 新增设备配置
     */
    Boolean insertByBo(IotDeviceConfigBo bo);

    /**
     * 修改设备配置
     */
    Boolean updateByBo(IotDeviceConfigBo bo);

    /**
     * 校验并批量删除设备配置信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

    /**
     * 设备名列表
     *
     * @return
     */
    List<String> deviceNameList();

}
