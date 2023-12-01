package com.ruoyi.device.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.ruoyi.device.domain.bo.IotDeviceLogBo;
import com.ruoyi.device.domain.vo.IotDeviceLogVo;
import com.ruoyi.device.service.IIotDeviceLogService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.List;

/**
 * 设备日志
 *
 * @author ruoyi
 * @date 2023-11-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/iot/deviceLog")
public class IotDeviceLogController extends BaseController {

    private final IIotDeviceLogService iIotDeviceLogService;

    /**
     * 查询设备日志列表
     */
    @SaCheckPermission("iot:deviceLog:list")
    @GetMapping("/list")
    public TableDataInfo<IotDeviceLogVo> list(IotDeviceLogBo bo, PageQuery pageQuery) {
        return iIotDeviceLogService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出设备日志列表
     */
    @SaCheckPermission("iot:deviceLog:export")
    @Log(title = "设备日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(IotDeviceLogBo bo, HttpServletResponse response) {
        List<IotDeviceLogVo> list = iIotDeviceLogService.queryList(bo);
        ExcelUtil.exportExcel(list, "设备日志", IotDeviceLogVo.class, response);
    }

    /**
     * 获取设备日志详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("iot:deviceLog:query")
    @GetMapping("/{id}")
    public R<IotDeviceLogVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iIotDeviceLogService.queryById(id));
    }

    /**
     * 新增设备日志
     */
    @SaCheckPermission("iot:deviceLog:add")
    @Log(title = "设备日志", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody IotDeviceLogBo bo) {
        return toAjax(iIotDeviceLogService.insertByBo(bo));
    }

    /**
     * 修改设备日志
     */
    @SaCheckPermission("iot:deviceLog:edit")
    @Log(title = "设备日志", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody IotDeviceLogBo bo) {
        return toAjax(iIotDeviceLogService.updateByBo(bo));
    }

    /**
     * 删除设备日志
     *
     * @param ids 主键串
     */
    @SaCheckPermission("iot:deviceLog:remove")
    @Log(title = "设备日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iIotDeviceLogService.deleteWithValidByIds(Arrays.asList(ids), true));
    }

    /**
     * 警告个数
     * @return
     */
    @GetMapping("/warnState")
    public R warnState() {
        return R.ok(iIotDeviceLogService.warnState());
    }

    /**
     * 当天设备警告数
     *
     * @return
     */
    @GetMapping("/warnStateToday")
    public R warnStateToday() {
        return R.ok(iIotDeviceLogService.warnStateToday());
    }

    /**
     * 获取每小时报警数量
     *
     * @return
     */
    @GetMapping("/warnNumPerHour")
    public R warnNumPerHour() {
        return R.ok(iIotDeviceLogService.warnNumPerHour());
    }
}
