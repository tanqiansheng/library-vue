package com.ruoyi.admin.service.impl;

import com.ruoyi.admin.domain.PanelGroupData;
import com.ruoyi.admin.domain.StBook;
import com.ruoyi.admin.mapper.StBookMapper;
import com.ruoyi.admin.service.IStBookService;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 新书购入Service业务层处理
 * 
 * @author tqs
 * @date 2022-05-11
 */
@Service
public class StBookServiceImpl implements IStBookService 
{
    @Autowired
    private StBookMapper stBookMapper;

    /**
     * 查询新书购入
     * 
     * @param bookId 新书购入主键
     * @return 新书购入
     */
    @Override
    public StBook selectStBookByBookId(Long bookId)
    {
        return stBookMapper.selectStBookByBookId(bookId);
    }

    /**
     * 查询新书购入列表
     * 
     * @param stBook 新书购入
     * @return 新书购入
     */
    @Override
    public List<StBook> selectStBookList(StBook stBook)
    {
        return stBookMapper.selectStBookList(stBook);
    }

    /**
     * 新增新书购入
     * 
     * @param stBook 新书购入
     * @return 结果
     */
    @Override
    public int insertStBook(StBook stBook)
    {
        stBook.setBookuuid(StringUtils.uuid());
        stBook.setCreateTime(DateUtils.getNowDate());
        return stBookMapper.insertStBook(stBook);
    }

    /**
     * 修改新书购入
     * 
     * @param stBook 新书购入
     * @return 结果
     */
    @Override
    public int updateStBook(StBook stBook)
    {
        stBook.setUpdateTime(DateUtils.getNowDate());
        return stBookMapper.updateStBook(stBook);
    }

    /**
     * 批量删除新书购入
     * 
     * @param bookIds 需要删除的新书购入主键
     * @return 结果
     */
    @Override
    public int deleteStBookByBookIds(Long[] bookIds)
    {
        return stBookMapper.deleteStBookByBookIds(bookIds);
    }

    /**
     * 删除新书购入信息
     * 
     * @param bookId 新书购入主键
     * @return 结果
     */
    @Override
    public int deleteStBookByBookId(Long bookId)
    {
        return stBookMapper.deleteStBookByBookId(bookId);
    }

    @Override
    public List<StBook> selectBooksByCategoryuuid(String categoryuuid) {
        return  stBookMapper.selectBooksByCategoryuuid(categoryuuid);
    }

    @Override
    public List<PanelGroupData> getPanelGroupData() {
        return stBookMapper.getPanelGroupData();
    }
}
