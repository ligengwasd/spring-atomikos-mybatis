package com.oneapm.atomikos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oneapm.atomikos.service.InnerService;
import com.oneapm.atomikos.service.OutterService;

/**
 * @author xushjie
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/beans.xml" })
public class ServiceIT {
    
    @Autowired
    private OutterService outterService;
    
    @Autowired
    private InnerService  innerService;
    
    @Test
    public void test_01() {
        outterService.insertTwoTables();
    }
    
}
