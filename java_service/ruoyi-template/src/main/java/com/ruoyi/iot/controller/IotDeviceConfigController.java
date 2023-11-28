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
import com.ruoyi.iot.domain.vo.IotDeviceConfigVo;
import com.ruoyi.iot.domain.bo.IotDeviceConfigBo;
import com.ruoyi.iot.service.IIotDeviceConfigService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备配置
 *
 * @author ruoyi
 * @date 2023-11-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/iot/deviceConfig")
public class IotDeviceConfigController extends BaseController {

    private final IIotDeviceConfigService iIotDeviceConfigService;

    /**
     * 查询设备配置列表
     */
    @SaCheckPermission("iot:deviceConfig:list")
    @GetMapping("/list")
    public TableDataInfo<IotDeviceConfigVo> list(IotDeviceConfigBo bo, PageQuery pageQuery) {
        return iIotDeviceConfigService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出设备配置列表
     */
    @SaCheckPermission("iot:deviceConfig:export")
    @Log(title = "设备配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(IotDeviceConfigBo bo, HttpServletResponse response) {
        List<IotDeviceConfigVo> list = iIotDeviceConfigService.queryList(bo);
        ExcelUtil.exportExcel(list, "设备配置", IotDeviceConfigVo.class, response);
    }

    /**
     * 获取设备配置详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("iot:deviceConfig:query")
    @GetMapping("/{id}")
    public R<IotDeviceConfigVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iIotDeviceConfigService.queryById(id));
    }

    /**
     * 新增设备配置
     */
    @SaCheckPermission("iot:deviceConfig:add")
    @Log(title = "设备配置", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody IotDeviceConfigBo bo) {
        return toAjax(iIotDeviceConfigService.insertByBo(bo));
    }

    /**
     * 修改设备配置
     */
    @SaCheckPermission("iot:deviceConfig:edit")
    @Log(title = "设备配置", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody IotDeviceConfigBo bo) {
        return toAjax(iIotDeviceConfigService.updateByBo(bo));
    }

    /**
     * 删除设备配置
     *
     * @param ids 主键串
     */
    @SaCheckPermission("iot:deviceConfig:remove")
    @Log(title = "设备配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iIotDeviceConfigService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
