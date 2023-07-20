package com.ruoyi.admin.service;

import com.ruoyi.admin.domain.StCatalogue;

import java.util.List;

/**
 * 图书种类Service接口
 * 
 * @author tqs
 * @date 2022-05-11
 */
public interface IStCatalogueService 
{
    /**
     * 查询图书种类
     * 
     * @param catalogueId 图书种类主键
     * @return 图书种类
     */
    public StCatalogue selectStCatalogueByCatalogueId(Long catalogueId);

    /**
     * 查询图书种类列表
     * 
     * @param stCatalogue 图书种类
     * @return 图书种类集合
     */
    public List<StCatalogue> selectStCatalogueList(StCatalogue stCatalogue);

    /**
     * 新增图书种类
     * 
     * @param stCatalogue 图书种类
     * @return 结果
     */
    public int insertStCatalogue(StCatalogue stCatalogue);

    /**
     * 修改图书种类
     * 
     * @param stCatalogue 图书种类
     * @return 结果
     */
    public int updateStCatalogue(StCatalogue stCatalogue);

    /**
     * 批量删除图书种类
     * 
     * @param catalogueIds 需要删除的图书种类主键集合
     * @return 结果
     */
    public int deleteStCatalogueByCatalogueIds(Long[] catalogueIds);

    /**
     * 删除图书种类信息
     * 
     * @param catalogueId 图书种类主键
     * @return 结果
     */
    public int deleteStCatalogueByCatalogueId(Long catalogueId);

    public List<StCatalogue>  listCatalogueAll();
}
