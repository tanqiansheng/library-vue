package com.ruoyi.admin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图书种类对象 st_catalogue
 * 
 * @author tqs
 * @date 2022-05-11
 */
public class StCatalogue extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 种类id */
    private Long catalogueId;

    /** 种类流水id */
    @Excel(name = "种类流水id")
    private String catalogueuuid;

    /** 种类名称 */
    @Excel(name = "种类名称")
    private String cataloguename;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setCatalogueId(Long catalogueId) 
    {
        this.catalogueId = catalogueId;
    }

    public Long getCatalogueId() 
    {
        return catalogueId;
    }
    public void setCatalogueuuid(String catalogueuuid) 
    {
        this.catalogueuuid = catalogueuuid;
    }

    public String getCatalogueuuid() 
    {
        return catalogueuuid;
    }
    public void setCataloguename(String cataloguename) 
    {
        this.cataloguename = cataloguename;
    }

    public String getCataloguename() 
    {
        return cataloguename;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("catalogueId", getCatalogueId())
            .append("catalogueuuid", getCatalogueuuid())
            .append("cataloguename", getCataloguename())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
