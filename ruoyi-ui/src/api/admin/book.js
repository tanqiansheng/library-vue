import request from '@/utils/request'

// 查询新书购入列表
export function listBook(query) {
  return request({
    url: '/admin/book/list',
    method: 'get',
    params: query
  })
}

// 查询新书购入详细
export function getBook(bookId) {
  return request({
    url: '/admin/book/' + bookId,
    method: 'get'
  })
}

// 新增新书购入
export function addBook(data) {
  return request({
    url: '/admin/book',
    method: 'post',
    data: data
  })
}

// 修改新书购入
export function updateBook(data) {
  return request({
    url: '/admin/book',
    method: 'put',
    data: data
  })
}

// 删除新书购入
export function delBook(bookId) {
  return request({
    url: '/admin/book/' + bookId,
    method: 'delete'
  })
}
// 查询图书通过种类id
export function selectBooksByCategoryuuid(categoryuuid) {
  return request({
    url: '/admin/book/selectBooksByCategoryuuid',
    method: 'post',
    data: {categoryuuid:categoryuuid}
  })
}
// 查询图书通过种类id
export function getPanelGroupData(categoryuuid) {
  return request({
    url: '/admin/book/getPanelGroupData',
  })
}
