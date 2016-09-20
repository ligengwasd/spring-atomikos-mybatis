package com.oneapm.atomikos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oneapm.atomikos.a.domain.TblA;
import com.oneapm.atomikos.a.mapper.TblAMapper;
import com.oneapm.atomikos.b.domain.TblB;
import com.oneapm.atomikos.b.mapper.TblBMapper;

@Service(value = "outterService")
public class OutterService {
    
    @Autowired
    private InnerService innerService;
    
    @Autowired
    private TblAMapper   tblAMapper;
    
    @Autowired
    private TblBMapper   tblBMapper;
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void insertTwoTables(int id) {
        //
        TblA ra = new TblA();
        ra.setA1(11);
        ra.setA2("aa");
        tblAMapper.insertSelective(ra);
        if (id ==1){
            throw new RuntimeException("111111111111");
        }
        //
        TblB rb = new TblB();
        rb.setB1(2);
        rb.setB2("b");
        tblBMapper.insertSelective(rb);
    }
    
    // -----------------------------------------------------------------------------------------
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void case_01() {
        //
        TblA ra = new TblA();
        ra.setA1(11);
        ra.setA2("aa");
        tblAMapper.insertSelective(ra);
        //
        try {
            innerService.case_01();
        } catch (Exception ignore) {
            // skip
        }
        //
        TblA ra2 = new TblA();
        ra2.setA1(111);
        ra2.setA2("aaa");
        tblAMapper.insertSelective(ra2);
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void case_02() {
        //
        TblA ra = new TblA();
        ra.setA1(11);
        ra.setA2("aa");
        tblAMapper.insertSelective(ra);
        //
        try {
            innerService.case_02();
        } catch (Exception ignore) {
            // skip
        }
        //
        TblA ra2 = new TblA();
        ra2.setA1(111);
        ra2.setA2("aaa");
        tblAMapper.insertSelective(ra2);
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void case_03() {
        //
        TblA ra = new TblA();
        ra.setA1(11);
        ra.setA2("aa");
        tblAMapper.insertSelective(ra);
        //
        try {
            TblB rb = new TblB();
            rb.setB1(2);
            rb.setB2("b");
            tblBMapper.insertSelective(rb);
        } catch (Exception ignore) {
            // skip
        }
        //
        TblA ra2 = new TblA();
        ra2.setA1(111);
        ra2.setA2("aaa");
        tblAMapper.insertSelective(ra2);
    }
    
}
