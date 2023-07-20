package com.ruoyi.admin.service;

import com.ruoyi.admin.domain.PanelGroupData;
import com.ruoyi.admin.domain.StBook;

import java.util.List;

/**
 * 新书购入Service接口
 * 
 * @author tqs
 * @date 2022-05-11
 */
public interface IStBookService 
{
    /**
     * 查询新书购入
     * 
     * @param bookId 新书购入主键
     * @return 新书购入
     */
    public StBook selectStBookByBookId(Long bookId);

    /**
     * 查询新书购入列表
     * 
     * @param stBook 新书购入
     * @return 新书购入集合
     */
    public List<StBook> selectStBookList(StBook stBook);

    /**
     * 新增新书购入
     * 
     * @param stBook 新书购入
     * @return 结果
     */
    public int insertStBook(StBook stBook);

    /**
     * 修改新书购入
     * 
     * @param stBook 新书购入
     * @return 结果
     */
    public int updateStBook(StBook stBook);

    /**
     * 批量删除新书购入
     * 
     * @param bookIds 需要删除的新书购入主键集合
     * @return 结果
     */
    public int deleteStBookByBookIds(Long[] bookIds);

    /**
     * 删除新书购入信息
     * 
     * @param bookId 新书购入主键
     * @return 结果
     */
    public int deleteStBookByBookId(Long bookId);

    List<StBook> selectBooksByCategoryuuid(String borrowrecorduuid);

    List<PanelGroupData> getPanelGroupData();
}
