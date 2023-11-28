import request from '@/utils/request'

// 查询物联网设备数据传输列表
export function listDeviceTransData(query) {
  return request({
    url: '/iot/deviceTransData/list',
    method: 'get',
    params: query
  })
}

// 查询物联网设备数据传输详细
export function getDeviceTransData(id) {
  return request({
    url: '/iot/deviceTransData/' + id,
    method: 'get'
  })
}

// 新增物联网设备数据传输
export function addDeviceTransData(data) {
  return request({
    url: '/iot/deviceTransData',
    method: 'post',
    data: data
  })
}

// 修改物联网设备数据传输
export function updateDeviceTransData(data) {
  return request({
    url: '/iot/deviceTransData',
    method: 'put',
    data: data
  })
}

// 删除物联网设备数据传输
export function delDeviceTransData(id) {
  return request({
    url: '/iot/deviceTransData/' + id,
    method: 'delete'
  })
}
