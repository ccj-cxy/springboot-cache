package com.snk.cache;

import com.snk.cache.bean.Employee;
import com.snk.cache.dao.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringbootCacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    //操作字符串
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    //操作k-v都是对象
    RedisTemplate redisTemplate;
    @Test
    void contextLoads() {

    }

    @Test
    void selectByid(){
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
    }
    /**
     * string list set hash ZSet有序集合
     * stringRedisTemplate.opsForValue() 操作字符串
     * stringRedisTemplate.opsForList() 操作列表
     * stringRedisTemplate.opsForSet() 操作集合
     * stringRedisTemplate.opsForHash() 操作hash
     * stringRedisTemplate.opsForZSet() 操作有序集合
     */
    @Test
    void redisTest(){
//        stringRedisTemplate.opsForValue().append("message","hello");
        String message = stringRedisTemplate.opsForValue().get("message");
        System.out.println(message);
    }

    @Test
    void redisObjectTest(){
        Employee empById = employeeMapper.getEmpById(1);
        redisTemplate.opsForValue().set("emp-01",empById);
        //将数据已json格式保存
        //1.自己将对象转为json
        //2.redisTemplate默认的序列化规则
    }
}
