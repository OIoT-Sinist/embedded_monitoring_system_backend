package com.ruoyi.iot.controller;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import lombok.RequiredArgsConstructor;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.iot.domain.vo.IotUserVo;
import com.ruoyi.iot.domain.bo.IotUserBo;
import com.ruoyi.iot.service.IIotUserService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户
 *
 * @author ruoyi
 * @date 2023-11-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/iot/user")
public class IotUserController extends BaseController {

    private final IIotUserService iIotUserService;

    /**
     * 查询用户列表
     */
    @SaCheckPermission("iot:user:list")
    @GetMapping("/list")
    public TableDataInfo<IotUserVo> list(IotUserBo bo, PageQuery pageQuery) {
        return iIotUserService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出用户列表
     */
    @SaCheckPermission("iot:user:export")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(IotUserBo bo, HttpServletResponse response) {
        List<IotUserVo> list = iIotUserService.queryList(bo);
        ExcelUtil.exportExcel(list, "用户", IotUserVo.class, response);
    }

    /**
     * 获取用户详细信息
     *
     * @param userId 主键
     */
    @SaCheckPermission("iot:user:query")
    @GetMapping("/{userId}")
    public R<IotUserVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long userId) {
        return R.ok(iIotUserService.queryById(userId));
    }

    /**
     * 新增用户
     */
    @SaCheckPermission("iot:user:add")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody IotUserBo bo) {
        return toAjax(iIotUserService.insertByBo(bo));
    }

    /**
     * 修改用户
     */
    @SaCheckPermission("iot:user:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody IotUserBo bo) {
        return toAjax(iIotUserService.updateByBo(bo));
    }

    /**
     * 删除用户
     *
     * @param userIds 主键串
     */
    @SaCheckPermission("iot:user:remove")
    @Log(title = "用户", businessType = BusinessType.DELETE)
    @DeleteMapping("/{userIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] userIds) {
        return toAjax(iIotUserService.deleteWithValidByIds(Arrays.asList(userIds), true));
    }
}
