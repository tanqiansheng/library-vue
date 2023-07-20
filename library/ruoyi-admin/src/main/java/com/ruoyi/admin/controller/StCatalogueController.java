package com.ruoyi.admin.controller;

import com.ruoyi.admin.domain.StCatalogue;
import com.ruoyi.admin.service.IStCatalogueService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 图书种类Controller
 * 
 * @author tqs
 * @date 2022-05-11
 */
@RestController
@RequestMapping("/admin/catalogue")
public class StCatalogueController extends BaseController
{
    @Autowired
    private IStCatalogueService stCatalogueService;

    /**
     * 查询图书种类列表
     */
    @PreAuthorize("@ss.hasPermi('admin:catalogue:list')")
    @GetMapping("/list")
    public TableDataInfo list(StCatalogue stCatalogue)
    {
        startPage();
        List<StCatalogue> list = stCatalogueService.selectStCatalogueList(stCatalogue);
        return getDataTable(list);
    }

    /**
     * 导出图书种类列表
     */
    @PreAuthorize("@ss.hasPermi('admin:catalogue:export')")
    @Log(title = "图书种类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StCatalogue stCatalogue)
    {
        List<StCatalogue> list = stCatalogueService.selectStCatalogueList(stCatalogue);
        ExcelUtil<StCatalogue> util = new ExcelUtil<StCatalogue>(StCatalogue.class);
        util.exportExcel(response, list, "图书种类数据");
    }

    /**
     * 获取图书种类详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:catalogue:query')")
    @GetMapping(value = "/{catalogueId}")
    public AjaxResult getInfo(@PathVariable("catalogueId") Long catalogueId)
    {
        return AjaxResult.success(stCatalogueService.selectStCatalogueByCatalogueId(catalogueId));
    }

    /**
     * 新增图书种类
     */
    @PreAuthorize("@ss.hasPermi('admin:catalogue:add')")
    @Log(title = "图书种类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StCatalogue stCatalogue)
    {
        return toAjax(stCatalogueService.insertStCatalogue(stCatalogue));
    }

    /**
     * 修改图书种类
     */
    @PreAuthorize("@ss.hasPermi('admin:catalogue:edit')")
    @Log(title = "图书种类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StCatalogue stCatalogue)
    {
        return toAjax(stCatalogueService.updateStCatalogue(stCatalogue));
    }

    /**
     * 删除图书种类
     */
    @PreAuthorize("@ss.hasPermi('admin:catalogue:remove')")
    @Log(title = "图书种类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{catalogueIds}")
    public AjaxResult remove(@PathVariable Long[] catalogueIds)
    {
        return toAjax(stCatalogueService.deleteStCatalogueByCatalogueIds(catalogueIds));
    }
    /**
     * 删除图书种类
     */
	@RequestMapping("/listCatalogueAll")
    public AjaxResult listCatalogueAll()
    {
        return AjaxResult.success("操作成功",stCatalogueService.listCatalogueAll());
    }
}
