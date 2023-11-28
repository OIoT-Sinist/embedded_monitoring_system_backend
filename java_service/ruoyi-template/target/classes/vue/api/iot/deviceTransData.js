import request from '@/utils/request'

// 查询物联网设备数据传输列表
export function listDeviceTransData(query) {
  return request({
    url: '/system/deviceTransData/list',
    method: 'get',
    params: query
  })
}

// 查询物联网设备数据传输详细
export function getDeviceTransData(id) {
  return request({
    url: '/system/deviceTransData/' + id,
    method: 'get'
  })
}

// 新增物联网设备数据传输
export function addDeviceTransData(data) {
  return request({
    url: '/system/deviceTransData',
    method: 'post',
    data: data
  })
}

// 修改物联网设备数据传输
export function updateDeviceTransData(data) {
  return request({
    url: '/system/deviceTransData',
    method: 'put',
    data: data
  })
}

// 删除物联网设备数据传输
export function delDeviceTransData(id) {
  return request({
    url: '/system/deviceTransData/' + id,
    method: 'delete'
  })
}
