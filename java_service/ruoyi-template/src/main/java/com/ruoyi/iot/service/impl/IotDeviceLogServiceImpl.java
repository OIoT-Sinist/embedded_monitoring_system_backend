package com.ruoyi.iot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ruoyi.iot.domain.bo.IotDeviceLogBo;
import com.ruoyi.iot.domain.vo.IotDeviceLogVo;
import com.ruoyi.iot.domain.IotDeviceLog;
import com.ruoyi.iot.mapper.IotDeviceLogMapper;
import com.ruoyi.iot.service.IIotDeviceLogService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 设备日志Service业务层处理
 *
 * @author ruoyi
 * @date 2023-11-26
 */
@RequiredArgsConstructor
@Service
public class IotDeviceLogServiceImpl implements IIotDeviceLogService {

    private final IotDeviceLogMapper baseMapper;

    /**
     * 查询设备日志
     */
    @Override
    public IotDeviceLogVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询设备日志列表
     */
    @Override
    public TableDataInfo<IotDeviceLogVo> queryPageList(IotDeviceLogBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<IotDeviceLog> lqw = buildQueryWrapper(bo);
        Page<IotDeviceLogVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询设备日志列表
     */
    @Override
    public List<IotDeviceLogVo> queryList(IotDeviceLogBo bo) {
        LambdaQueryWrapper<IotDeviceLog> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<IotDeviceLog> buildQueryWrapper(IotDeviceLogBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<IotDeviceLog> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getDeviceName()), IotDeviceLog::getDeviceName, bo.getDeviceName());
        lqw.eq(StringUtils.isNotBlank(bo.getCo2()), IotDeviceLog::getCo2, bo.getCo2());
        lqw.eq(StringUtils.isNotBlank(bo.getLuminance()), IotDeviceLog::getLuminance, bo.getLuminance());
        lqw.eq(StringUtils.isNotBlank(bo.getHumidity()), IotDeviceLog::getHumidity, bo.getHumidity());
        lqw.eq(StringUtils.isNotBlank(bo.getTemprature()), IotDeviceLog::getTemprature, bo.getTemprature());
        lqw.eq(StringUtils.isNotBlank(bo.getLocationLatitude()), IotDeviceLog::getLocationLatitude, bo.getLocationLatitude());
        lqw.eq(StringUtils.isNotBlank(bo.getLocationLogitude()), IotDeviceLog::getLocationLogitude, bo.getLocationLogitude());
        lqw.eq(bo.getHasError() != null, IotDeviceLog::getHasError, bo.getHasError());
        lqw.eq(StringUtils.isNotBlank(bo.getCustomData()), IotDeviceLog::getCustomData, bo.getCustomData());
        return lqw;
    }

    /**
     * 新增设备日志
     */
    @Override
    public Boolean insertByBo(IotDeviceLogBo bo) {
        IotDeviceLog add = BeanUtil.toBean(bo, IotDeviceLog.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改设备日志
     */
    @Override
    public Boolean updateByBo(IotDeviceLogBo bo) {
        IotDeviceLog update = BeanUtil.toBean(bo, IotDeviceLog.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(IotDeviceLog entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除设备日志
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
