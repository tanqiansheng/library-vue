package com.ruoyi.admin.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 新书购入对象 st_book
 * 
 * @author tqs
 * @date 2022-05-11
 */
public class StBook extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 种类id */
    private Long bookId;

    /** 图书流水id */
    @Excel(name = "图书流水id")
    private String bookuuid;

    /** 种类 */
    @Excel(name = "种类")
    private String categoryuuid;

    /** 书名 */
    @Excel(name = "书名")
    private String bookname;

    /** 作者 */
    @Excel(name = "作者")
    private String author;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 购买日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购买日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date buydate;

    /** 图片 */
    @Excel(name = "图片")
    private String img;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setBookId(Long bookId) 
    {
        this.bookId = bookId;
    }

    public Long getBookId() 
    {
        return bookId;
    }
    public void setBookuuid(String bookuuid) 
    {
        this.bookuuid = bookuuid;
    }

    public String getBookuuid() 
    {
        return bookuuid;
    }
    public void setCategoryuuid(String categoryuuid) 
    {
        this.categoryuuid = categoryuuid;
    }

    public String getCategoryuuid() 
    {
        return categoryuuid;
    }
    public void setBookname(String bookname) 
    {
        this.bookname = bookname;
    }

    public String getBookname() 
    {
        return bookname;
    }
    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setBuydate(Date buydate) 
    {
        this.buydate = buydate;
    }

    public Date getBuydate() 
    {
        return buydate;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
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
            .append("bookId", getBookId())
            .append("bookuuid", getBookuuid())
            .append("categoryuuid", getCategoryuuid())
            .append("bookname", getBookname())
            .append("author", getAuthor())
            .append("price", getPrice())
            .append("buydate", getBuydate())
            .append("img", getImg())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
