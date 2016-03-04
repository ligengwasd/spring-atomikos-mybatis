package com.oneapm.atomikos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneapm.atomikos.a.mapper.TblAMapper;
import com.oneapm.atomikos.b.mapper.TblBMapper;

@Service(value = "innerService")
public class InnerService {
    
    @Autowired
    private TblAMapper tblAMapper;
    
    @Autowired
    private TblBMapper tblBMapper;
    
}
