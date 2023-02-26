package com.ruoyi.admin.controller;

import com.ruoyi.admin.domain.StBook;
import com.ruoyi.admin.service.IStBookService;
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
 * 新书购入Controller
 * 
 * @author tqs
 * @date 2022-05-11
 */
@RestController
@RequestMapping("/admin/book")
public class StBookController extends BaseController
{
    @Autowired
    private IStBookService stBookService;

    /**
     * 查询新书购入列表
     */
    @PreAuthorize("@ss.hasPermi('admin:book:list')")
    @GetMapping("/list")
    public TableDataInfo list(StBook stBook)
    {
        startPage();
        List<StBook> list = stBookService.selectStBookList(stBook);
        return getDataTable(list);
    }

    /**
     * 导出新书购入列表
     */
    @PreAuthorize("@ss.hasPermi('admin:book:export')")
    @Log(title = "新书购入", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StBook stBook)
    {
        List<StBook> list = stBookService.selectStBookList(stBook);
        ExcelUtil<StBook> util = new ExcelUtil<StBook>(StBook.class);
        util.exportExcel(response, list, "新书购入数据");
    }

    /**
     * 获取新书购入详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:book:query')")
    @GetMapping(value = "/{bookId}")
    public AjaxResult getInfo(@PathVariable("bookId") Long bookId)
    {
        return AjaxResult.success(stBookService.selectStBookByBookId(bookId));
    }

    /**
     * 新增新书购入
     */
    @PreAuthorize("@ss.hasPermi('admin:book:add')")
    @Log(title = "新书购入", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StBook stBook)
    {
        return toAjax(stBookService.insertStBook(stBook));
    }

    /**
     * 修改新书购入
     */
    @PreAuthorize("@ss.hasPermi('admin:book:edit')")
    @Log(title = "新书购入", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StBook stBook)
    {
        return toAjax(stBookService.updateStBook(stBook));
    }

    /**
     * 删除新书购入
     */
    @PreAuthorize("@ss.hasPermi('admin:book:remove')")
    @Log(title = "新书购入", businessType = BusinessType.DELETE)
	@DeleteMapping("/{bookIds}")
    public AjaxResult remove(@PathVariable Long[] bookIds)
    {
        return toAjax(stBookService.deleteStBookByBookIds(bookIds));
    }
    /**
     * 查询图书通过borrowrecorduuid
     */
	@RequestMapping("selectBooksByCategoryuuid")
    public AjaxResult selectBooksByCategoryuuid(@RequestBody StBook stBook)
    {
        return AjaxResult.success("操作成功",stBookService.selectBooksByCategoryuuid(stBook.getCategoryuuid()));
    }
    /**
     * 查询图书通过borrowrecorduuid
     */
	@RequestMapping("getPanelGroupData")
    public AjaxResult getPanelGroupData()
    {
        return AjaxResult.success("操作成功",stBookService.getPanelGroupData());
    }
}
