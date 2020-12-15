package com.snk.cache;

import com.snk.cache.bean.Employee;
import com.snk.cache.dao.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootCacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;
    @Test
    void contextLoads() {

    }

    @Test
    void selectByid(){
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
    }

}
