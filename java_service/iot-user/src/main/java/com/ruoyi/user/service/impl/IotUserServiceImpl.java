package com.ruoyi.user.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.SysUserRole;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.mapper.SysUserRoleMapper;
import com.ruoyi.user.domain.IotUser;
import com.ruoyi.user.domain.bo.IotUserBo;
import com.ruoyi.user.domain.vo.IotUserVo;
import com.ruoyi.user.mapper.IotUserMapper;
import com.ruoyi.user.service.IIotUserService;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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
    private final SysUserMapper sysUserMapper;
    private final SysUserRoleMapper sysUserRoleMapper;

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
        result.getRecords()
            .forEach(userVo -> {
                QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
                sysUserQueryWrapper.eq("user_name", userVo.getUsername());
                if (ObjectUtil.isNull(sysUserMapper.selectOne(sysUserQueryWrapper))) {
                    // 用户处理
                    SysUser sysUser = new SysUser();
                    sysUser.setUserName(userVo.getUsername());
                    sysUser.setPassword(BCrypt.hashpw(userVo.getPassword()));
                    sysUser.setUserType("sys_user");
                    sysUser.setPhonenumber(userVo.getPhone());
                    sysUser.setEmail(userVo.getEmail());
                    sysUser.setNickName(userVo.getUsername());
                    sysUserMapper.insert(sysUser);

                    // 角色处理
                    SysUser user = sysUserMapper.selectByCreateTime();
                    SysUserRole sysUserRole = new SysUserRole();
                    sysUserRole.setUserId(user.getUserId());
                    sysUserRole.setRoleId(2L);
                    sysUserRoleMapper.insert(sysUserRole);
                }
        });

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
        // 新增到系统用户中
        SysUser sysUser = new SysUser();
        sysUser.setUserType("sys_user");
        sysUser.setUserName(add.getUsername());
        sysUser.setNickName(add.getUsername());
        sysUser.setPhonenumber(add.getPhone());
        sysUser.setEmail(add.getEmail());
        sysUser.setPassword(add.getPassword());
        sysUserMapper.insert(sysUser);
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
