package com.ruoyi.device.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.device.domain.IotDeviceTransData;
import com.ruoyi.device.domain.bo.IotDeviceTransDataBo;
import com.ruoyi.device.domain.vo.IotDeviceTransDataVo;
import com.ruoyi.device.mapper.IotDeviceTransDataMapper;
import com.ruoyi.device.service.IIotDeviceTransDataService;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 物联网设备数据传输Service业务层处理
 *
 * @author ruoyi
 * @date 2023-11-26
 */
@RequiredArgsConstructor
@Service
public class IotDeviceTransDataServiceImpl implements IIotDeviceTransDataService {

    private final IotDeviceTransDataMapper baseMapper;

    /**
     * 查询物联网设备数据传输
     */
    @Override
    public IotDeviceTransDataVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询物联网设备数据传输列表
     */
    @Override
    public TableDataInfo<IotDeviceTransDataVo> queryPageList(IotDeviceTransDataBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<IotDeviceTransData> lqw = buildQueryWrapper(bo);
        Page<IotDeviceTransDataVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询物联网设备数据传输列表
     */
    @Override
    public List<IotDeviceTransDataVo> queryList(IotDeviceTransDataBo bo) {
        LambdaQueryWrapper<IotDeviceTransData> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<IotDeviceTransData> buildQueryWrapper(IotDeviceTransDataBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<IotDeviceTransData> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getCo2()), IotDeviceTransData::getCo2, bo.getCo2());
        lqw.eq(StringUtils.isNotBlank(bo.getLuminance()), IotDeviceTransData::getLuminance, bo.getLuminance());
        lqw.eq(StringUtils.isNotBlank(bo.getHumidity()), IotDeviceTransData::getHumidity, bo.getHumidity());
        lqw.eq(StringUtils.isNotBlank(bo.getTemprature()), IotDeviceTransData::getTemprature, bo.getTemprature());
        lqw.eq(StringUtils.isNotBlank(bo.getCustomData()), IotDeviceTransData::getCustomData, bo.getCustomData());
        return lqw;
    }

    /**
     * 新增物联网设备数据传输
     */
    @Override
    public Boolean insertByBo(IotDeviceTransDataBo bo) {
        IotDeviceTransData add = BeanUtil.toBean(bo, IotDeviceTransData.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改物联网设备数据传输
     */
    @Override
    public Boolean updateByBo(IotDeviceTransDataBo bo) {
        IotDeviceTransData update = BeanUtil.toBean(bo, IotDeviceTransData.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(IotDeviceTransData entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除物联网设备数据传输
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
