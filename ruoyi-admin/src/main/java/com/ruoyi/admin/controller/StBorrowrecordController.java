package com.ruoyi.admin.controller;

import com.ruoyi.admin.domain.StBorrowrecord;
import com.ruoyi.admin.service.IStBorrowrecordService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 借书记录Controller
 *
 * @author tqs
 * @date 2022-05-11
 */
@RestController
@RequestMapping("/admin/borrowrecord")
public class StBorrowrecordController extends BaseController {
    @Autowired
    private IStBorrowrecordService stBorrowrecordService;

    /**
     * 查询借书记录列表
     */
    @PreAuthorize("@ss.hasPermi('admin:borrowrecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(StBorrowrecord stBorrowrecord) {
        startPage();
        List<StBorrowrecord> list = stBorrowrecordService.selectStBorrowrecordList(stBorrowrecord);
        return getDataTable(list);
    }

    /**
     * 导出借书记录列表
     */
    @PreAuthorize("@ss.hasPermi('admin:borrowrecord:export')")
    @Log(title = "借书记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StBorrowrecord stBorrowrecord) {
        List<StBorrowrecord> list = stBorrowrecordService.selectStBorrowrecordList(stBorrowrecord);
        ExcelUtil<StBorrowrecord> util = new ExcelUtil<StBorrowrecord>(StBorrowrecord.class);
        util.exportExcel(response, list, "借书记录数据");
    }

    /**
     * 获取借书记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:borrowrecord:query')")
    @GetMapping(value = "/{borrowrecordId}")
    public AjaxResult getInfo(@PathVariable("borrowrecordId") Long borrowrecordId) {
        return AjaxResult.success(stBorrowrecordService.selectStBorrowrecordByBorrowrecordId(borrowrecordId));
    }

    /**
     * 新增借书记录
     */
    @PreAuthorize("@ss.hasPermi('admin:borrowrecord:add')")
    @Log(title = "借书记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StBorrowrecord stBorrowrecord) {
        int count = stBorrowrecordService.selectStBorrowrecordByUserid(stBorrowrecord.getUserid());
        if (count > 10) {
            return AjaxResult.error("已经借书" + count + "本，大于最大限制10本，不能借书了");
        } else {
            return toAjax(stBorrowrecordService.insertStBorrowrecord(stBorrowrecord));
        }

    }

    /**
     * 修改借书记录
     */
    @PreAuthorize("@ss.hasPermi('admin:borrowrecord:edit')")
    @Log(title = "借书记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StBorrowrecord stBorrowrecord) {
        return toAjax(stBorrowrecordService.updateStBorrowrecord(stBorrowrecord));
    }

    /**
     * 删除借书记录
     */
    @PreAuthorize("@ss.hasPermi('admin:borrowrecord:remove')")
    @Log(title = "借书记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{borrowrecordIds}")
    public AjaxResult remove(@PathVariable Long[] borrowrecordIds) {
        return toAjax(stBorrowrecordService.deleteStBorrowrecordByBorrowrecordIds(borrowrecordIds));
    }

    /**
     * 还书
     */
    @RequestMapping("handleReturnBook/{borrowrecordId}")
    public AjaxResult handleReturnBook(@PathVariable Long[] borrowrecordId) {
        return toAjax(stBorrowrecordService.handleReturnBook(borrowrecordId));
    }

    /**
     * 获取最近1一个月数据
     */
    @RequestMapping("borrowrecordOf30Day")
    public AjaxResult borrowrecordOf30Day() {
        return AjaxResult.success("操作成功", stBorrowrecordService.borrowrecordOf30Day());
    }

    /**
     * 图书分类
     */
    @RequestMapping("borrowrecordBycataloguePercentage")
    public AjaxResult borrowrecordBycataloguePercentage() {
        return AjaxResult.success("操作成功", stBorrowrecordService.borrowrecordBycataloguePercentage());
    }

    /**
     * 班级占比
     */
    @RequestMapping("borrowrecordByDeptPercentage")
    public AjaxResult borrowrecordByDeptPercentage() {
        return AjaxResult.success("操作成功", stBorrowrecordService.borrowrecordByDeptPercentage());
    }

    /**
     * 班级占比
     */
    @RequestMapping("borrowrecordBycatalogueRaddar")
    public AjaxResult borrowrecordBycatalogueRaddar() {
        return AjaxResult.success("操作成功", stBorrowrecordService.borrowrecordBycatalogueRaddar());
    }

    /**
     * 借书
     */
    @RequestMapping("handleBrrowBook/{bookIds}")
    public AjaxResult handleBrrowBook(@PathVariable Long[] bookIds) {
        List<SysRole> roles = SecurityUtils.getLoginUser().getUser().getRoles();

         if (roles.get(0).getRoleId()==3){
            return AjaxResult.success("操作成功", stBorrowrecordService.handleBrrowBook(bookIds));
        }
        else{
            return AjaxResult.error("非学生不能借书！");
        }
    }
}
