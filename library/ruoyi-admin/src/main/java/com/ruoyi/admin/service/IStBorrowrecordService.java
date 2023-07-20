package com.ruoyi.admin.service;

import com.ruoyi.admin.domain.BorrowRecordAll;
import com.ruoyi.admin.domain.NameValue;
import com.ruoyi.admin.domain.StBorrowrecord;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 借书记录Service接口
 * 
 * @author tqs
 * @date 2022-05-11
 */
public interface IStBorrowrecordService 
{
    /**
     * 查询借书记录
     * 
     * @param borrowrecordId 借书记录主键
     * @return 借书记录
     */
    public StBorrowrecord selectStBorrowrecordByBorrowrecordId(Long borrowrecordId);

    /**
     * 查询借书记录列表
     * 
     * @param stBorrowrecord 借书记录
     * @return 借书记录集合
     */
    public List<StBorrowrecord> selectStBorrowrecordList(StBorrowrecord stBorrowrecord);

    /**
     * 新增借书记录
     * 
     * @param stBorrowrecord 借书记录
     * @return 结果
     */
    public int insertStBorrowrecord(StBorrowrecord stBorrowrecord);

    /**
     * 修改借书记录
     * 
     * @param stBorrowrecord 借书记录
     * @return 结果
     */
    public int updateStBorrowrecord(StBorrowrecord stBorrowrecord);

    /**
     * 批量删除借书记录
     * 
     * @param borrowrecordIds 需要删除的借书记录主键集合
     * @return 结果
     */
    public int deleteStBorrowrecordByBorrowrecordIds(Long[] borrowrecordIds);

    /**
     * 删除借书记录信息
     * 
     * @param borrowrecordId 借书记录主键
     * @return 结果
     */
    public int deleteStBorrowrecordByBorrowrecordId(Long borrowrecordId);

    int handleReturnBook(Long[] borrowrecordId);

    int selectStBorrowrecordByUserid(String userid);

    HashMap<String,List<String>> borrowrecordOf30Day();

    List<NameValue> borrowrecordBycataloguePercentage();

    List<BorrowRecordAll> getBorrowrecordAll();

    HashMap<String, Set<String>>  borrowrecordByDeptPercentage();

    HashMap<String, Collection<String>> borrowrecordBycatalogueRaddar();

    int handleBrrowBook(Long[] bookIds);
}
