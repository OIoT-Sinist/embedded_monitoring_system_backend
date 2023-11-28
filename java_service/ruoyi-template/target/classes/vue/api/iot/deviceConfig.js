import request from '@/utils/request'

// 查询设备配置列表
export function listDeviceConfig(query) {
  return request({
    url: '/system/deviceConfig/list',
    method: 'get',
    params: query
  })
}

// 查询设备配置详细
export function getDeviceConfig(id) {
  return request({
    url: '/system/deviceConfig/' + id,
    method: 'get'
  })
}

// 新增设备配置
export function addDeviceConfig(data) {
  return request({
    url: '/system/deviceConfig',
    method: 'post',
    data: data
  })
}

// 修改设备配置
export function updateDeviceConfig(data) {
  return request({
    url: '/system/deviceConfig',
    method: 'put',
    data: data
  })
}

// 删除设备配置
export function delDeviceConfig(id) {
  return request({
    url: '/system/deviceConfig/' + id,
    method: 'delete'
  })
}
