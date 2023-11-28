<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="位置纬度" prop="locationLatitude">
        <el-input
          v-model="queryParams.locationLatitude"
          placeholder="请输入位置纬度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="位置经度" prop="locationLogitude">
        <el-input
          v-model="queryParams.locationLogitude"
          placeholder="请输入位置经度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="co2范围" prop="co2Range">
        <el-input
          v-model="queryParams.co2Range"
          placeholder="请输入co2范围"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="亮度范围" prop="luminanceRange">
        <el-input
          v-model="queryParams.luminanceRange"
          placeholder="请输入亮度范围"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="湿度范围" prop="humidityRange">
        <el-input
          v-model="queryParams.humidityRange"
          placeholder="请输入湿度范围"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="温度范围" prop="tempratureRange">
        <el-input
          v-model="queryParams.tempratureRange"
          placeholder="请输入温度范围"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:deviceConfig:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:deviceConfig:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:deviceConfig:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:deviceConfig:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="deviceConfigList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" v-if="true"/>
      <el-table-column label="位置纬度" align="center" prop="locationLatitude" />
      <el-table-column label="位置经度" align="center" prop="locationLogitude" />
      <el-table-column label="co2范围" align="center" prop="co2Range" />
      <el-table-column label="亮度范围" align="center" prop="luminanceRange" />
      <el-table-column label="湿度范围" align="center" prop="humidityRange" />
      <el-table-column label="温度范围" align="center" prop="tempratureRange" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:deviceConfig:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:deviceConfig:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改设备配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="位置纬度" prop="locationLatitude">
          <el-input v-model="form.locationLatitude" placeholder="请输入位置纬度" />
        </el-form-item>
        <el-form-item label="位置经度" prop="locationLogitude">
          <el-input v-model="form.locationLogitude" placeholder="请输入位置经度" />
        </el-form-item>
        <el-form-item label="co2范围" prop="co2Range">
          <el-input v-model="form.co2Range" placeholder="请输入co2范围" />
        </el-form-item>
        <el-form-item label="亮度范围" prop="luminanceRange">
          <el-input v-model="form.luminanceRange" placeholder="请输入亮度范围" />
        </el-form-item>
        <el-form-item label="湿度范围" prop="humidityRange">
          <el-input v-model="form.humidityRange" placeholder="请输入湿度范围" />
        </el-form-item>
        <el-form-item label="温度范围" prop="tempratureRange">
          <el-input v-model="form.tempratureRange" placeholder="请输入温度范围" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDeviceConfig, getDeviceConfig, delDeviceConfig, addDeviceConfig, updateDeviceConfig } from "@/api/iot/deviceConfig";

export default {
  name: "DeviceConfig",
  data() {
    return {
      // 按钮loading
      buttonLoading: false,
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 设备配置表格数据
      deviceConfigList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        locationLatitude: undefined,
        locationLogitude: undefined,
        co2Range: undefined,
        luminanceRange: undefined,
        humidityRange: undefined,
        tempratureRange: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [
          { required: true, message: "id不能为空", trigger: "blur" }
        ],
        locationLatitude: [
          { required: true, message: "位置纬度不能为空", trigger: "blur" }
        ],
        locationLogitude: [
          { required: true, message: "位置经度不能为空", trigger: "blur" }
        ],
        co2Range: [
          { required: true, message: "co2范围不能为空", trigger: "blur" }
        ],
        luminanceRange: [
          { required: true, message: "亮度范围不能为空", trigger: "blur" }
        ],
        humidityRange: [
          { required: true, message: "湿度范围不能为空", trigger: "blur" }
        ],
        tempratureRange: [
          { required: true, message: "温度范围不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询设备配置列表 */
    getList() {
      this.loading = true;
      listDeviceConfig(this.queryParams).then(response => {
        this.deviceConfigList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: undefined,
        locationLatitude: undefined,
        locationLogitude: undefined,
        co2Range: undefined,
        luminanceRange: undefined,
        humidityRange: undefined,
        tempratureRange: undefined,
        createBy: undefined,
        createTime: undefined,
        updateBy: undefined,
        updateTime: undefined
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加设备配置";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.loading = true;
      this.reset();
      const id = row.id || this.ids
      getDeviceConfig(id).then(response => {
        this.loading = false;
        this.form = response.data;
        this.open = true;
        this.title = "修改设备配置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.buttonLoading = true;
          if (this.form.id != null) {
            updateDeviceConfig(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          } else {
            addDeviceConfig(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除设备配置编号为"' + ids + '"的数据项？').then(() => {
        this.loading = true;
        return delDeviceConfig(ids);
      }).then(() => {
        this.loading = false;
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      }).finally(() => {
        this.loading = false;
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/deviceConfig/export', {
        ...this.queryParams
      }, `deviceConfig_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
