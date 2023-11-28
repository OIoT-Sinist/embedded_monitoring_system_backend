package com.ruoyi.iot.service;

import com.ruoyi.iot.domain.IotUser;
import com.ruoyi.iot.domain.vo.IotUserVo;
import com.ruoyi.iot.domain.bo.IotUserBo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 用户Service接口
 *
 * @author ruoyi
 * @date 2023-11-26
 */
public interface IIotUserService {

    /**
     * 查询用户
     */
    IotUserVo queryById(Long userId);

    /**
     * 查询用户列表
     */
    TableDataInfo<IotUserVo> queryPageList(IotUserBo bo, PageQuery pageQuery);

    /**
     * 查询用户列表
     */
    List<IotUserVo> queryList(IotUserBo bo);

    /**
     * 新增用户
     */
    Boolean insertByBo(IotUserBo bo);

    /**
     * 修改用户
     */
    Boolean updateByBo(IotUserBo bo);

    /**
     * 校验并批量删除用户信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
