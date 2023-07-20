package com.ruoyi.admin.mapper;

import com.ruoyi.admin.domain.StCatalogue;

import java.util.List;

/**
 * 图书种类Mapper接口
 * 
 * @author tqs
 * @date 2022-05-11
 */
public interface StCatalogueMapper 
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
     * 删除图书种类
     * 
     * @param catalogueId 图书种类主键
     * @return 结果
     */
    public int deleteStCatalogueByCatalogueId(Long catalogueId);

    /**
     * 批量删除图书种类
     * 
     * @param catalogueIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStCatalogueByCatalogueIds(Long[] catalogueIds);

    List<StCatalogue> listCatalogueAll();
}
