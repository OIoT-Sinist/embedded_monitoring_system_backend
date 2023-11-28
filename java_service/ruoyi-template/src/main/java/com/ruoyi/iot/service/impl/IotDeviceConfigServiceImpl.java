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
import com.ruoyi.iot.domain.bo.IotDeviceConfigBo;
import com.ruoyi.iot.domain.vo.IotDeviceConfigVo;
import com.ruoyi.iot.domain.IotDeviceConfig;
import com.ruoyi.iot.mapper.IotDeviceConfigMapper;
import com.ruoyi.iot.service.IIotDeviceConfigService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

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
        return lqw;
    }

    /**
     * 新增设备配置
     */
    @Override
    public Boolean insertByBo(IotDeviceConfigBo bo) {
        IotDeviceConfig add = BeanUtil.toBean(bo, IotDeviceConfig.class);
        validEntityBeforeSave(add);
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
}
