import request from '@/utils/request'

// 查询借书记录列表
export function listBorrowrecord(query) {
  return request({
    url: '/admin/borrowrecord/list',
    method: 'get',
    params: query
  })
}

// 查询借书记录详细
export function getBorrowrecord(borrowrecordId) {
  return request({
    url: '/admin/borrowrecord/' + borrowrecordId,
    method: 'get'
  })
}

// 新增借书记录
export function addBorrowrecord(data) {
  return request({
    url: '/admin/borrowrecord',
    method: 'post',
    data: data
  })
}

// 修改借书记录
export function updateBorrowrecord(data) {
  return request({
    url: '/admin/borrowrecord',
    method: 'put',
    data: data
  })
}

// 删除借书记录
export function delBorrowrecord(borrowrecordId) {
  return request({
    url: '/admin/borrowrecord/' + borrowrecordId,
    method: 'delete'
  })
}
// 还书
export function handleReturnBook(borrowrecordId) {
  return request({
    url: '/admin/borrowrecord/handleReturnBook/' + borrowrecordId,
  })
}
// 30天记录
export function borrowrecordOf30Day() {
  return request({
    url: '/admin/borrowrecord/borrowrecordOf30Day',
  })
}
// 种类记录
export function borrowrecordBycataloguePercentage() {
  return request({
    url: '/admin/borrowrecord/borrowrecordBycataloguePercentage',
  })
}
// dept
export function borrowrecordByDeptPercentage() {
  return request({
    url: '/admin/borrowrecord/borrowrecordByDeptPercentage',
  })
}
export function borrowrecordBycatalogueRaddar() {
  return request({
    url: '/admin/borrowrecord/borrowrecordBycatalogueRaddar',
  })
}
export function handleBrrowBook(bookIds) {
  return request({
    url: '/admin/borrowrecord/handleBrrowBook/'+bookIds,
  })
}
