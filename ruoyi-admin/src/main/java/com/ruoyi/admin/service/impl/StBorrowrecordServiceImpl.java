package com.ruoyi.admin.service.impl;

import com.ruoyi.admin.domain.BorrowRecordAll;
import com.ruoyi.admin.domain.NameValue;
import com.ruoyi.admin.domain.StBorrowrecord;
import com.ruoyi.admin.mapper.StBookMapper;
import com.ruoyi.admin.mapper.StBorrowrecordMapper;
import com.ruoyi.admin.service.IStBorrowrecordService;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 借书记录Service业务层处理
 * 
 * @author tqs
 * @date 2022-05-11
 */
@Service
public class StBorrowrecordServiceImpl implements IStBorrowrecordService 
{
    @Autowired
    private StBorrowrecordMapper stBorrowrecordMapper;
    @Autowired
    private StBookMapper stBookMapper;

    /**
     * 查询借书记录
     * 
     * @param borrowrecordId 借书记录主键
     * @return 借书记录
     */
    @Override
    public StBorrowrecord selectStBorrowrecordByBorrowrecordId(Long borrowrecordId)
    {
        return stBorrowrecordMapper.selectStBorrowrecordByBorrowrecordId(borrowrecordId);
    }

    /**
     * 查询借书记录列表
     * 
     * @param stBorrowrecord 借书记录
     * @return 借书记录
     */
    @Override
    public List<StBorrowrecord> selectStBorrowrecordList(StBorrowrecord stBorrowrecord)
    {
        return stBorrowrecordMapper.selectStBorrowrecordList(stBorrowrecord);
    }

    /**
     * 新增借书记录
     * 
     * @param stBorrowrecord 借书记录
     * @return 结果
     */
    @Override
    public int insertStBorrowrecord(StBorrowrecord stBorrowrecord)
    {
            if (stBorrowrecord.getBorrowtime()==null){
                stBorrowrecord.setBorrowtime(DateUtils.getNowDate());
            }
            stBorrowrecord.setBorrowrecorduuid(StringUtils.uuid());
            stBorrowrecord.setCreateTime(DateUtils.getNowDate());
            return stBorrowrecordMapper.insertStBorrowrecord(stBorrowrecord);

    }

    /**
     * 修改借书记录
     * 
     * @param stBorrowrecord 借书记录
     * @return 结果
     */
    @Override
    public int updateStBorrowrecord(StBorrowrecord stBorrowrecord)
    {
        stBorrowrecord.setUpdateTime(DateUtils.getNowDate());
        return stBorrowrecordMapper.updateStBorrowrecord(stBorrowrecord);
    }

    /**
     * 批量删除借书记录
     * 
     * @param borrowrecordIds 需要删除的借书记录主键
     * @return 结果
     */
    @Override
    public int deleteStBorrowrecordByBorrowrecordIds(Long[] borrowrecordIds)
    {
        return stBorrowrecordMapper.deleteStBorrowrecordByBorrowrecordIds(borrowrecordIds);
    }

    /**
     * 删除借书记录信息
     * 
     * @param borrowrecordId 借书记录主键
     * @return 结果
     */
    @Override
    public int deleteStBorrowrecordByBorrowrecordId(Long borrowrecordId)
    {
        return stBorrowrecordMapper.deleteStBorrowrecordByBorrowrecordId(borrowrecordId);
    }

    @Override
    public int handleReturnBook(Long[] borrowrecordId) {
        return  stBorrowrecordMapper.handleReturnBook(borrowrecordId);
    }

    @Override
    public int selectStBorrowrecordByUserid(String userid) {
       return stBorrowrecordMapper.selectStBorrowrecordByUserid(userid);
    }

    @Override
    public HashMap<String,List<String>> borrowrecordOf30Day() {
        List<NameValue> nameValues = stBorrowrecordMapper.borrowrecordOf30Day();
        HashMap<String, NameValue> stringNameValueHashMap = new HashMap<>();
        for (NameValue nameValue : nameValues) {
            stringNameValueHashMap.put(nameValue.getName(),nameValue);
        }
        List<String> dateList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            dateList.add(DateUtils.getPastDate(i));
        }
        //返回的数据
        List<String> dataList = new ArrayList<>();

        for (String date : dateList) {
            if (stringNameValueHashMap.containsKey(date)){
                dataList.add(stringNameValueHashMap.get(date).getValue());
            }
            else{
                NameValue nameValue = new NameValue(date, "0");
                dataList.add(nameValue.getValue());
            }
        }
        HashMap<String, List<String>> res = new HashMap<>();
        res.put("date",dateList);
        res.put("data",dataList);
        return res;
    }

    @Override
    public List<NameValue> borrowrecordBycataloguePercentage() {
        return stBorrowrecordMapper.borrowrecordBycataloguePercentage();
    }

    @Override
    public List<BorrowRecordAll> getBorrowrecordAll() {
        return stBorrowrecordMapper.getBorrowrecordAll();
    }

    @Override
    public HashMap<String, Set<String>>  borrowrecordByDeptPercentage() {

        List<NameValue> borrowrecordAll = stBorrowrecordMapper.borrowrecordByDeptPercentage();
        HashMap<String, Set<String>> res = new HashMap<>();
        Set<String> name = new LinkedHashSet<>();
        Set<String> value = new LinkedHashSet<>();
        for (NameValue nameValue : borrowrecordAll) {
            name.add(nameValue.getName());
            value.add(nameValue.getValue());
        }
        res.put("name",name);
        res.put("value",value);
        return res;
    }

    @Override
    public HashMap<String, Collection<String>> borrowrecordBycatalogueRaddar() {
        List<NameValue> borrowrecordAll = stBorrowrecordMapper.borrowrecordBycataloguePercentage();
        HashMap<String, Collection<String>> res = new HashMap<>();
        Set<String> name = new LinkedHashSet<>();
        List<String> value = new ArrayList<>();
        for (NameValue nameValue : borrowrecordAll) {
            name.add(nameValue.getName());
            value.add(nameValue.getValue());
        }
        res.put("name",name);
        res.put("value",value);
        return res;
    }

    @Override
    public int handleBrrowBook(Long[] bookIds) {
        String usernumber = SecurityUtils.getLoginUser().getUser().getUsernumber();
        for (Long bookId : bookIds) {
            StBorrowrecord stBorrowrecord = new StBorrowrecord();
            stBorrowrecord.setUserid(usernumber);
            stBorrowrecord.setBookuuid(stBookMapper.selectStBookByBookId(bookId).getBookuuid());
            insertStBorrowrecord(stBorrowrecord);
        }
        return bookIds.length;
    }

/*
    @Override
    public HashSet borrowrecordByDeptPercentage() {

        List<BorrowRecordAll> borrowrecordAll = stBorrowrecordMapper.getBorrowrecordAll();
        List<String> dpetList = stBorrowrecordMapper.getDeptCount();
        List<String> catalogueNamelist = stBorrowrecordMapper.catalogueNamelist();
        int[] ints = new int[dpetList.size()];
        HashMap<String, List<BorrowRecordAll>> deptMap = new HashMap<>();
        for (BorrowRecordAll borrowRecordAll : borrowrecordAll) {
            if (deptMap.containsKey(borrowRecordAll.getDeptId())){
                deptMap.get(borrowRecordAll.getDeptId()).add(borrowRecordAll);
            }else{
                List<BorrowRecordAll> borrowRecordAlls = new ArrayList<>();
                borrowRecordAlls.add(borrowRecordAll);
                deptMap.put(borrowRecordAll.getDeptId(),borrowRecordAlls);
            }
        }
        int size = dpetList.size();
        for (int i = 0; i < catalogueNamelist.size(); i++) {
            int[] lsit1 = new int[dpetList];
        }
        deptMap.forEach((key,value)->{
            for (BorrowRecordAll borrowRecordAll : value) {
                int i=0;
                for (String catalogueName : catalogueNamelist) {
                    if (catalogueName==borrowRecordAll.getCataloguename()){

                    }
                }
            }
        });

        return null;
    }
*/

}
