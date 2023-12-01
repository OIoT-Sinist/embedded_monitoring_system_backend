package com.ruoyi.device.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.ruoyi.device.domain.bo.IotDeviceTransDataBo;
import com.ruoyi.device.domain.vo.IotDeviceTransDataVo;
import com.ruoyi.device.service.IIotDeviceTransDataService;
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
 * 物联网设备数据传输
 *
 * @author ruoyi
 * @date 2023-11-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/iot/deviceTransData")
public class IotDeviceTransDataController extends BaseController {

    private final IIotDeviceTransDataService iIotDeviceTransDataService;

    /**
     * 查询物联网设备数据传输列表
     */
    @SaCheckPermission("iot:deviceTransData:list")
    @GetMapping("/list")
    public TableDataInfo<IotDeviceTransDataVo> list(IotDeviceTransDataBo bo, PageQuery pageQuery) {
        return iIotDeviceTransDataService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出物联网设备数据传输列表
     */
    @SaCheckPermission("iot:deviceTransData:export")
    @Log(title = "物联网设备数据传输", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(IotDeviceTransDataBo bo, HttpServletResponse response) {
        List<IotDeviceTransDataVo> list = iIotDeviceTransDataService.queryList(bo);
        ExcelUtil.exportExcel(list, "物联网设备数据传输", IotDeviceTransDataVo.class, response);
    }

    /**
     * 获取物联网设备数据传输详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("iot:deviceTransData:query")
    @GetMapping("/{id}")
    public R<IotDeviceTransDataVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iIotDeviceTransDataService.queryById(id));
    }

    /**
     * 新增物联网设备数据传输
     */
    @SaCheckPermission("iot:deviceTransData:add")
    @Log(title = "物联网设备数据传输", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody IotDeviceTransDataBo bo) {
        return toAjax(iIotDeviceTransDataService.insertByBo(bo));
    }

    /**
     * 修改物联网设备数据传输
     */
    @SaCheckPermission("iot:deviceTransData:edit")
    @Log(title = "物联网设备数据传输", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody IotDeviceTransDataBo bo) {
        return toAjax(iIotDeviceTransDataService.updateByBo(bo));
    }

    /**
     * 删除物联网设备数据传输
     *
     * @param ids 主键串
     */
    @SaCheckPermission("iot:deviceTransData:remove")
    @Log(title = "物联网设备数据传输", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iIotDeviceTransDataService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
