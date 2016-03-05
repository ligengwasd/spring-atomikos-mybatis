package com.oneapm.atomikos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oneapm.atomikos.a.domain.TblA;
import com.oneapm.atomikos.a.mapper.TblAMapper;
import com.oneapm.atomikos.b.domain.TblB;
import com.oneapm.atomikos.b.mapper.TblBMapper;

@Service(value = "innerService")
public class InnerService {
    
    @Autowired
    private TblAMapper tblAMapper;
    
    @Autowired
    private TblBMapper tblBMapper;
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void insertOneTableA() {
        TblA ra = new TblA();
        ra.setA1(4);
        ra.setA2("d");
        tblAMapper.insertSelective(ra);
    }
    
    public void insertTwoTblsWithoutAnnotation() {
        //
        TblA ra = new TblA();
        ra.setA1(11);
        ra.setA2("aa");
        tblAMapper.insertSelective(ra);
        //
        TblB rb = new TblB();
        rb.setB1(2);
        rb.setB2("b");
        tblBMapper.insertSelective(rb);
    }
    
}
