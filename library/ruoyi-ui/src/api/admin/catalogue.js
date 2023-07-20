import request from '@/utils/request'

// 查询图书种类列表
export function listCatalogue(query) {
  return request({
    url: '/admin/catalogue/list',
    method: 'get',
    params: query
  })
}

// 查询图书种类详细
export function getCatalogue(catalogueId) {
  return request({
    url: '/admin/catalogue/' + catalogueId,
    method: 'get'
  })
}

// 新增图书种类
export function addCatalogue(data) {
  return request({
    url: '/admin/catalogue',
    method: 'post',
    data: data
  })
}

// 修改图书种类
export function updateCatalogue(data) {
  return request({
    url: '/admin/catalogue',
    method: 'put',
    data: data
  })
}

// 删除图书种类
export function delCatalogue(catalogueId) {
  return request({
    url: '/admin/catalogue/' + catalogueId,
    method: 'delete'
  })
}
// 查询所有种类
export function listCatalogueAll() {
  return request({
    url: '/admin/catalogue/listCatalogueAll',
    method: 'get'
  })
}
