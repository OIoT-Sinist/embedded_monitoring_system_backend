package com.ruoyi.device.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.helper.LoginHelper;
import com.ruoyi.device.domain.IotDeviceConfig;
import com.ruoyi.device.domain.IotDeviceLog;
import com.ruoyi.device.domain.bo.IotDeviceConfigBo;
import com.ruoyi.device.domain.vo.IotDeviceConfigVo;
import com.ruoyi.device.mapper.IotDeviceConfigMapper;
import com.ruoyi.device.mapper.IotDeviceLogMapper;
import com.ruoyi.device.service.IIotDeviceConfigService;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 设备配置Service业务层处理
 *
 * @author ruoyi
 * @date 2023-11-26
 */
@RequiredArgsConstructor
@Service
public class IotDeviceConfigServiceImpl implements IIotDeviceConfigService {

    private final IotDeviceConfigMapper baseMapper;

    /**
     * 查询设备配置
     */
    @Override
    public IotDeviceConfigVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询设备配置列表
     */
    @Override
    public TableDataInfo<IotDeviceConfigVo> queryPageList(IotDeviceConfigBo bo, PageQuery pageQuery) {
        LoginUser loginUser = LoginHelper.getLoginUser();
        System.out.println("loginUser.getUsername() = " + loginUser.getUsername());
        LambdaQueryWrapper<IotDeviceConfig> lqw = buildQueryWrapper(bo);
        Page<IotDeviceConfigVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询设备配置列表
     */
    @Override
    public List<IotDeviceConfigVo> queryList(IotDeviceConfigBo bo) {
        LambdaQueryWrapper<IotDeviceConfig> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<IotDeviceConfig> buildQueryWrapper(IotDeviceConfigBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<IotDeviceConfig> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getLocationLatitude()), IotDeviceConfig::getLocationLatitude, bo.getLocationLatitude());
        lqw.eq(StringUtils.isNotBlank(bo.getLocationLogitude()), IotDeviceConfig::getLocationLogitude, bo.getLocationLogitude());
        lqw.eq(StringUtils.isNotBlank(bo.getCo2Range()), IotDeviceConfig::getCo2Range, bo.getCo2Range());
        lqw.eq(StringUtils.isNotBlank(bo.getLuminanceRange()), IotDeviceConfig::getLuminanceRange, bo.getLuminanceRange());
        lqw.eq(StringUtils.isNotBlank(bo.getHumidityRange()), IotDeviceConfig::getHumidityRange, bo.getHumidityRange());
        lqw.eq(StringUtils.isNotBlank(bo.getTempratureRange()), IotDeviceConfig::getTempratureRange, bo.getTempratureRange());
        lqw.eq(StringUtils.isNotBlank(bo.getAlarmThreshold()), IotDeviceConfig::getAlarmThreshold, bo.getAlarmThreshold());
        lqw.eq(StringUtils.isNotBlank(bo.getDeviceName()), IotDeviceConfig::getDeviceName, bo.getDeviceName());
        return lqw;
    }

    /**
     * 新增设备配置
     */
    @Override
    public Boolean insertByBo(IotDeviceConfigBo bo) {
        IotDeviceConfig add = BeanUtil.toBean(bo, IotDeviceConfig.class);
        validEntityBeforeSave(add);
        // QueryWrapper<IotDeviceConfig> deviceConfigQueryWrapper = new QueryWrapper<>();
        // deviceConfigQueryWrapper.eq("device_name", add.getDeviceName());
        // IotDeviceConfig iotDeviceConfig = baseMapper.selectOne(deviceConfigQueryWrapper);
        // if (ObjectUtil.isNull(iotDeviceConfig)) {
        //
        // }
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改设备配置
     */
    @Override
    public Boolean updateByBo(IotDeviceConfigBo bo) {
        IotDeviceConfig update = BeanUtil.toBean(bo, IotDeviceConfig.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(IotDeviceConfig entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除设备配置
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }

    @Override
    public List<String> deviceNameList() {
        List<String> deviceNameList = new ArrayList<>();
        List<IotDeviceConfig> iotDeviceConfigs = baseMapper.selectList();
        iotDeviceConfigs.forEach(iotDeviceConfig -> {
                deviceNameList.add(iotDeviceConfig.getDeviceName());
            });
        return deviceNameList;
    }
}
