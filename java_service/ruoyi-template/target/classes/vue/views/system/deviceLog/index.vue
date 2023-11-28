<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="设备名" prop="deviceName">
        <el-input
          v-model="queryParams.deviceName"
          placeholder="请输入设备名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="co2" prop="co2">
        <el-input
          v-model="queryParams.co2"
          placeholder="请输入co2"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="亮度" prop="luminance">
        <el-input
          v-model="queryParams.luminance"
          placeholder="请输入亮度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="湿度" prop="humidity">
        <el-input
          v-model="queryParams.humidity"
          placeholder="请输入湿度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="温度" prop="temprature">
        <el-input
          v-model="queryParams.temprature"
          placeholder="请输入温度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
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
      <el-form-item label="是否超出阈值" prop="hasError">
        <el-input
          v-model="queryParams.hasError"
          placeholder="请输入是否超出阈值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="自定义数据" prop="customData">
        <el-input
          v-model="queryParams.customData"
          placeholder="请输入自定义数据"
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
          v-hasPermi="['system:deviceLog:add']"
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
          v-hasPermi="['system:deviceLog:edit']"
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
          v-hasPermi="['system:deviceLog:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:deviceLog:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="deviceLogList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" v-if="true"/>
      <el-table-column label="设备名" align="center" prop="deviceName" />
      <el-table-column label="co2" align="center" prop="co2" />
      <el-table-column label="亮度" align="center" prop="luminance" />
      <el-table-column label="湿度" align="center" prop="humidity" />
      <el-table-column label="温度" align="center" prop="temprature" />
      <el-table-column label="位置纬度" align="center" prop="locationLatitude" />
      <el-table-column label="位置经度" align="center" prop="locationLogitude" />
      <el-table-column label="是否超出阈值" align="center" prop="hasError" />
      <el-table-column label="自定义数据" align="center" prop="customData" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:deviceLog:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:deviceLog:remove']"
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

    <!-- 添加或修改设备日志对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="设备名" prop="deviceName">
          <el-input v-model="form.deviceName" placeholder="请输入设备名" />
        </el-form-item>
        <el-form-item label="co2" prop="co2">
          <el-input v-model="form.co2" placeholder="请输入co2" />
        </el-form-item>
        <el-form-item label="亮度" prop="luminance">
          <el-input v-model="form.luminance" placeholder="请输入亮度" />
        </el-form-item>
        <el-form-item label="湿度" prop="humidity">
          <el-input v-model="form.humidity" placeholder="请输入湿度" />
        </el-form-item>
        <el-form-item label="温度" prop="temprature">
          <el-input v-model="form.temprature" placeholder="请输入温度" />
        </el-form-item>
        <el-form-item label="位置纬度" prop="locationLatitude">
          <el-input v-model="form.locationLatitude" placeholder="请输入位置纬度" />
        </el-form-item>
        <el-form-item label="位置经度" prop="locationLogitude">
          <el-input v-model="form.locationLogitude" placeholder="请输入位置经度" />
        </el-form-item>
        <el-form-item label="是否超出阈值" prop="hasError">
          <el-input v-model="form.hasError" placeholder="请输入是否超出阈值" />
        </el-form-item>
        <el-form-item label="自定义数据" prop="customData">
          <el-input v-model="form.customData" placeholder="请输入自定义数据" />
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
import { listDeviceLog, getDeviceLog, delDeviceLog, addDeviceLog, updateDeviceLog } from "@/api/iot/deviceLog";

export default {
  name: "DeviceLog",
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
      // 设备日志表格数据
      deviceLogList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        deviceName: undefined,
        co2: undefined,
        luminance: undefined,
        humidity: undefined,
        temprature: undefined,
        locationLatitude: undefined,
        locationLogitude: undefined,
        hasError: undefined,
        customData: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [
          { required: true, message: "id不能为空", trigger: "blur" }
        ],
        deviceName: [
          { required: true, message: "设备名不能为空", trigger: "blur" }
        ],
        co2: [
          { required: true, message: "co2不能为空", trigger: "blur" }
        ],
        luminance: [
          { required: true, message: "亮度不能为空", trigger: "blur" }
        ],
        humidity: [
          { required: true, message: "湿度不能为空", trigger: "blur" }
        ],
        temprature: [
          { required: true, message: "温度不能为空", trigger: "blur" }
        ],
        locationLatitude: [
          { required: true, message: "位置纬度不能为空", trigger: "blur" }
        ],
        locationLogitude: [
          { required: true, message: "位置经度不能为空", trigger: "blur" }
        ],
        hasError: [
          { required: true, message: "是否超出阈值不能为空", trigger: "blur" }
        ],
        customData: [
          { required: true, message: "自定义数据不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询设备日志列表 */
    getList() {
      this.loading = true;
      listDeviceLog(this.queryParams).then(response => {
        this.deviceLogList = response.rows;
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
        deviceName: undefined,
        co2: undefined,
        luminance: undefined,
        humidity: undefined,
        temprature: undefined,
        locationLatitude: undefined,
        locationLogitude: undefined,
        hasError: undefined,
        customData: undefined,
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
      this.title = "添加设备日志";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.loading = true;
      this.reset();
      const id = row.id || this.ids
      getDeviceLog(id).then(response => {
        this.loading = false;
        this.form = response.data;
        this.open = true;
        this.title = "修改设备日志";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.buttonLoading = true;
          if (this.form.id != null) {
            updateDeviceLog(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          } else {
            addDeviceLog(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除设备日志编号为"' + ids + '"的数据项？').then(() => {
        this.loading = true;
        return delDeviceLog(ids);
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
      this.download('system/deviceLog/export', {
        ...this.queryParams
      }, `deviceLog_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
