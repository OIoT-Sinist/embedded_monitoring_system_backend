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
import com.ruoyi.iot.domain.bo.IotUserBo;
import com.ruoyi.iot.domain.vo.IotUserVo;
import com.ruoyi.iot.domain.IotUser;
import com.ruoyi.iot.mapper.IotUserMapper;
import com.ruoyi.iot.service.IIotUserService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 用户Service业务层处理
 *
 * @author ruoyi
 * @date 2023-11-26
 */
@RequiredArgsConstructor
@Service
public class IotUserServiceImpl implements IIotUserService {

    private final IotUserMapper baseMapper;

    /**
     * 查询用户
     */
    @Override
    public IotUserVo queryById(Long userId){
        return baseMapper.selectVoById(userId);
    }

    /**
     * 查询用户列表
     */
    @Override
    public TableDataInfo<IotUserVo> queryPageList(IotUserBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<IotUser> lqw = buildQueryWrapper(bo);
        Page<IotUserVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询用户列表
     */
    @Override
    public List<IotUserVo> queryList(IotUserBo bo) {
        LambdaQueryWrapper<IotUser> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<IotUser> buildQueryWrapper(IotUserBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<IotUser> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getUsername()), IotUser::getUsername, bo.getUsername());
        lqw.eq(StringUtils.isNotBlank(bo.getPassword()), IotUser::getPassword, bo.getPassword());
        lqw.eq(bo.getType() != null, IotUser::getType, bo.getType());
        lqw.eq(StringUtils.isNotBlank(bo.getPhone()), IotUser::getPhone, bo.getPhone());
        lqw.eq(StringUtils.isNotBlank(bo.getEmail()), IotUser::getEmail, bo.getEmail());
        lqw.eq(bo.getGround() != null, IotUser::getGround, bo.getGround());
        return lqw;
    }

    /**
     * 新增用户
     */
    @Override
    public Boolean insertByBo(IotUserBo bo) {
        IotUser add = BeanUtil.toBean(bo, IotUser.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setUserId(add.getUserId());
        }
        return flag;
    }

    /**
     * 修改用户
     */
    @Override
    public Boolean updateByBo(IotUserBo bo) {
        IotUser update = BeanUtil.toBean(bo, IotUser.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(IotUser entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除用户
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
