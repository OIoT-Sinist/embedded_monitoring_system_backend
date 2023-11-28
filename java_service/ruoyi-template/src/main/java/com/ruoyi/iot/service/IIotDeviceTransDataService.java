package com.ruoyi.iot.service;

import com.ruoyi.iot.domain.IotDeviceTransData;
import com.ruoyi.iot.domain.vo.IotDeviceTransDataVo;
import com.ruoyi.iot.domain.bo.IotDeviceTransDataBo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 物联网设备数据传输Service接口
 *
 * @author ruoyi
 * @date 2023-11-26
 */
public interface IIotDeviceTransDataService {

    /**
     * 查询物联网设备数据传输
     */
    IotDeviceTransDataVo queryById(Long id);

    /**
     * 查询物联网设备数据传输列表
     */
    TableDataInfo<IotDeviceTransDataVo> queryPageList(IotDeviceTransDataBo bo, PageQuery pageQuery);

    /**
     * 查询物联网设备数据传输列表
     */
    List<IotDeviceTransDataVo> queryList(IotDeviceTransDataBo bo);

    /**
     * 新增物联网设备数据传输
     */
    Boolean insertByBo(IotDeviceTransDataBo bo);

    /**
     * 修改物联网设备数据传输
     */
    Boolean updateByBo(IotDeviceTransDataBo bo);

    /**
     * 校验并批量删除物联网设备数据传输信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
