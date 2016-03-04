package com.oneapm.atomikos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oneapm.atomikos.a.domain.TblA;
import com.oneapm.atomikos.a.mapper.TblAMapper;
import com.oneapm.atomikos.b.domain.TblB;
import com.oneapm.atomikos.b.mapper.TblBMapper;
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
    
    @Autowired
    private TblAMapper    tblAMapper;
    
    @Autowired
    private TblBMapper    tblBMapper;
    
    /**
     * 正确回滚 <br>
     * 参考1.log和2.log <br>
     */
    @Test
    public void test_01() {
        outterService.insertTwoTables();
    }
    
    /**
     * 无关于事务，肯定插入失败
     */
    @Test
    public void test_02() {
        TblA ra = new TblA();
        ra.setA1(1);
        ra.setA2("a");
        tblAMapper.insertSelective(ra);
    }
    
    /**
     * 成功插入，也就是说MyBatis事务成功执行了commit
     */
    @Test
    public void test_03() {
        TblB rb = new TblB();
        rb.setB1(3);
        rb.setB2("c");
        tblBMapper.insertSelective(rb);
    }
    
    /**
     * 正确插入，即atomikos的jta事务正确执行了commit <br>
     * 具体日志可以参考3.log <br>
     */
    @Test
    public void test_04() {
        innerService.insertOneTableA();
    }
    
}
