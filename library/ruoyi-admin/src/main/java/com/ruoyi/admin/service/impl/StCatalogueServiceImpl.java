package com.ruoyi.admin.service.impl;

import com.ruoyi.admin.domain.StCatalogue;
import com.ruoyi.admin.mapper.StCatalogueMapper;
import com.ruoyi.admin.service.IStCatalogueService;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 图书种类Service业务层处理
 * 
 * @author tqs
 * @date 2022-05-11
 */
@Service
public class StCatalogueServiceImpl implements IStCatalogueService 
{
    @Autowired
    private StCatalogueMapper stCatalogueMapper;

    /**
     * 查询图书种类
     * 
     * @param catalogueId 图书种类主键
     * @return 图书种类
     */
    @Override
    public StCatalogue selectStCatalogueByCatalogueId(Long catalogueId)
    {
        return stCatalogueMapper.selectStCatalogueByCatalogueId(catalogueId);
    }

    /**
     * 查询图书种类列表
     * 
     * @param stCatalogue 图书种类
     * @return 图书种类
     */
    @Override
    public List<StCatalogue> selectStCatalogueList(StCatalogue stCatalogue)
    {
        return stCatalogueMapper.selectStCatalogueList(stCatalogue);
    }

    /**
     * 新增图书种类
     * 
     * @param stCatalogue 图书种类
     * @return 结果
     */
    @Override
    public int insertStCatalogue(StCatalogue stCatalogue)
    {
        stCatalogue.setCreateTime(DateUtils.getNowDate());
        stCatalogue.setCatalogueuuid(StringUtils.uuid());
        return stCatalogueMapper.insertStCatalogue(stCatalogue);
    }

    /**
     * 修改图书种类
     * 
     * @param stCatalogue 图书种类
     * @return 结果
     */
    @Override
    public int updateStCatalogue(StCatalogue stCatalogue)
    {
        stCatalogue.setUpdateTime(DateUtils.getNowDate());
        return stCatalogueMapper.updateStCatalogue(stCatalogue);
    }

    /**
     * 批量删除图书种类
     * 
     * @param catalogueIds 需要删除的图书种类主键
     * @return 结果
     */
    @Override
    public int deleteStCatalogueByCatalogueIds(Long[] catalogueIds)
    {
        return stCatalogueMapper.deleteStCatalogueByCatalogueIds(catalogueIds);
    }

    /**
     * 删除图书种类信息
     * 
     * @param catalogueId 图书种类主键
     * @return 结果
     */
    @Override
    public int deleteStCatalogueByCatalogueId(Long catalogueId)
    {
        return stCatalogueMapper.deleteStCatalogueByCatalogueId(catalogueId);
    }

    @Override
    public List<StCatalogue> listCatalogueAll() {
        return stCatalogueMapper.listCatalogueAll();
    }
}
