package com.ruoyi.device.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.device.domain.IotDeviceConfig;
import com.ruoyi.device.domain.IotDeviceLog;
import com.ruoyi.device.domain.bo.IotDeviceLogBo;
import com.ruoyi.device.domain.vo.IotDeviceLogVo;
import com.ruoyi.device.mapper.IotDeviceConfigMapper;
import com.ruoyi.device.mapper.IotDeviceLogMapper;
import com.ruoyi.device.service.IIotDeviceLogService;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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

    private final IotDeviceConfigMapper deviceConfigMapper;

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
        lqw.eq(ObjectUtil.isNotEmpty(bo.getDeviceId()), IotDeviceLog::getDeviceId, bo.getDeviceId());
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

    @Override
    public Map<String, Integer> warnState() {
        Map<String, Integer> map = new HashMap<>(16);
        map.put("ExceedsTheThreshold", baseMapper.getExceedsTheThresholdCount());
        map.put("ThresholdNotExceeded", baseMapper.getThresholdNotExceededCount());
        return map;
    }

    @Override
    public Map<String, Integer> warnStateToday() {
        Map<String, Integer> map = new HashMap<>(16);
        List<IotDeviceLog> deviceLogs = new ArrayList<>();
        List<IotDeviceLog> iotDeviceLogs = baseMapper.selectList();
        List<IotDeviceConfig> iotDeviceConfigs = deviceConfigMapper.selectList();


        iotDeviceConfigs.forEach(deviceConfig -> {
            QueryWrapper<IotDeviceLog> deviceLogQueryWrapper = new QueryWrapper<>();
            deviceLogQueryWrapper.eq("device_name", deviceConfig.getDeviceName());
            deviceLogs.addAll(baseMapper.selectList(deviceLogQueryWrapper));
        });
        // iotDeviceConfigs.forEach(deviceConfig -> {
        //     iotDeviceLogs.forEach(deviceLog -> {
        //         if (deviceConfig.getDeviceName().equals(deviceLog.getDeviceName())) {
        //             String dateTime = DateUtils.dateTime(deviceLog.getCreateTime());
        //             if (dateTime.equals(String.valueOf(LocalDate.now()))) {
        //                 deviceLogs.add(deviceLog);
        //             }
        //         }
        //     });
        // });
        List<IotDeviceLog> collect = deviceLogs.stream()
            .filter(deviceLog -> deviceLog.getHasError() == 1)
            .collect(Collectors.toList());
        map.put("NumberOfAlarmsDate", collect.size());
        return map;
    }

    @Override
    public List<Integer> warnNumPerHour() {
        Map<String, Integer> initMap = initMap();
        List<String> stringList = new ArrayList<>();
        List<IotDeviceLog> iotDeviceLogs = baseMapper.selectList();
        iotDeviceLogs.forEach(deviceLog -> {
            String s = String.valueOf(deviceLog.getCreateTime());
            String substring = s.substring(11, 13);
            stringList.add(substring);
        });
        Map<Integer, Long> collect = stringList.stream()
            .map(Integer::parseInt)
            .collect(Collectors.groupingBy(k -> k, Collectors.counting()));
        Set<Integer> integers = collect.keySet();
        Set<String> strings = initMap.keySet();
        strings.forEach(k1 -> {
            integers.forEach(k2 -> {
                if (k1.equals(String.valueOf(k2))) {
                    initMap.put(k1, Math.toIntExact(collect.get(k2)));
                }
            });
        });
        List<Integer> integerList = new ArrayList<>();
        initMap.forEach((k, v) -> integerList.add(v));
        return integerList;
    }

    private Map<String, Integer> initMap() {
        Map<String, Integer> map = new LinkedHashMap<>(16);
        for (int i = 1;i <= 24; i++) {
            map.put(String.valueOf(i), 0);
        }
        return map;
    }

}
