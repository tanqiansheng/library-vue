package com.ruoyi.admin.mapper;

import com.ruoyi.admin.domain.BorrowRecordAll;
import com.ruoyi.admin.domain.NameValue;
import com.ruoyi.admin.domain.StBorrowrecord;

import java.util.List;

/**
 * 借书记录Mapper接口
 * 
 * @author tqs
 * @date 2022-05-11
 */
public interface StBorrowrecordMapper 
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
     * 删除借书记录
     * 
     * @param borrowrecordId 借书记录主键
     * @return 结果
     */
    public int deleteStBorrowrecordByBorrowrecordId(Long borrowrecordId);

    /**
     * 批量删除借书记录
     * 
     * @param borrowrecordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStBorrowrecordByBorrowrecordIds(Long[] borrowrecordIds);

    int handleReturnBook(Long[] borrowrecordId);

    int selectStBorrowrecordByUserid(String userid);

    List<NameValue> borrowrecordOf30Day();

    List<NameValue> borrowrecordBycataloguePercentage();

    List<NameValue> borrowrecordByDeptPercentage();

    List<BorrowRecordAll> getBorrowrecordAll();

    List<String> getDeptCount();

    List catalogueNamelist();

    List<NameValue> borrowrecordBycatalogueRaddar();
}
