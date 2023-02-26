package com.ruoyi.admin.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 借书记录对象 st_borrowrecord
 * 
 * @author tqs
 * @date 2022-05-11
 */
public class StBorrowrecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 借阅id */
    private Long borrowrecordId;

    /** 借阅流水id */
    @Excel(name = "借阅流水id")
    private String borrowrecorduuid;

    /** 图书 */
    @Excel(name = "图书")
    private String bookuuid;

    /** 读者 */
    @Excel(name = "读者")
    private String userid;

    /** 借阅日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "借阅日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date borrowtime;

    /** 归还日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "归还日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date returndtime;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setBorrowrecordId(Long borrowrecordId) 
    {
        this.borrowrecordId = borrowrecordId;
    }

    public Long getBorrowrecordId() 
    {
        return borrowrecordId;
    }
    public void setBorrowrecorduuid(String borrowrecorduuid) 
    {
        this.borrowrecorduuid = borrowrecorduuid;
    }

    public String getBorrowrecorduuid() 
    {
        return borrowrecorduuid;
    }
    public void setBookuuid(String bookuuid) 
    {
        this.bookuuid = bookuuid;
    }

    public String getBookuuid() 
    {
        return bookuuid;
    }
    public void setUserid(String userid) 
    {
        this.userid = userid;
    }

    public String getUserid() 
    {
        return userid;
    }
    public void setBorrowtime(Date borrowtime) 
    {
        this.borrowtime = borrowtime;
    }

    public Date getBorrowtime() 
    {
        return borrowtime;
    }
    public void setReturndtime(Date returndtime) 
    {
        this.returndtime = returndtime;
    }

    public Date getReturndtime() 
    {
        return returndtime;
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
            .append("borrowrecordId", getBorrowrecordId())
            .append("borrowrecorduuid", getBorrowrecorduuid())
            .append("bookuuid", getBookuuid())
            .append("userid", getUserid())
            .append("borrowtime", getBorrowtime())
            .append("returndtime", getReturndtime())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
