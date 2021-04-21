package com.huatu.flowable.service.impl;

import com.huatu.flowable.bean.Employee;
import com.huatu.flowable.dao.EmployeeMapper;
import com.huatu.flowable.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Cai.ChangJun
 * @since 2020-12-12
 */
@CacheConfig(cacheNames = {"emp","temp"})  //抽取缓存公共配置
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * cacheable
     *      cacheNames/value:指定缓存的名字
     *          CacheManager管理多个Cache组件，对缓存的真正crud操作在Cache组件中，每一个缓存组件有自己唯一一个名字
     *      key：缓存数据时使用的key,默认使用方法参数的值可以使用spEl表达式 #root.args[0] #id #p0 #a0
     *      keyGenerator : key的生成器
     *      keyManager: 指定缓存管理器，cacheResolver
     *      condition:指定符合条件的情况下才缓存；
     *      unless:否定缓存；当unless指定的条件为true，方法返回值就不会被缓存，可以获取到结果在判断
     *      sync:是否异步模式，默认false
     * 默认生效org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration
     * 给容器中注册了一个CacheManager: ConcurrentMapCacheManager
     * 可以获取和创建ConcurrentMapCache类型的缓存组件
     *
     * 运行流程
     * 1.方法运行前，先查询Cache，按照cacheNames指定名字获取，第一次获取缓存会自动创建出来
     * 2.在cache中查找缓存的内容，使用一个key，默认时方法的参数，key时按照某种策略生成的；默认使用keyGenerator生成的
     * 默认使用SimpleKeyGenerator
     * 3.没有查到缓存就调用目标方法；
     * 4.将目标方法返回的结果放进缓存中
     * @Date 2020/12/12 16:42
     */
    @Override
    @Cacheable(/*cacheNames = {"emp","temp"},*/key = "#id")
    public Employee getById(Serializable id) {
        System.out.println("查询："+id);
        return super.getById(id);
    }

    /**
     * @CachePut :即调用方法，也更新缓存数据
     * 修改了数据库的某个数据，同时更新缓存
     * 调用时机：
     * 1.先调用目标方法
     * 2.将目标方法的结果缓存
     * @author Cai.ChangJun
     * @Date 2020/12/13 23:21
     */
    @Override
    @CachePut(/*value = {"emp","temp"},*/key = "#result.id")
    public Employee updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * 缓存清除
     * allEntries = true 删除这个元素的所有缓存
     * beforeInvocation = false; 缓存清除是否在方法之前执行 默认在方法执行之后执行，这样可以保证如果出错缓存不会清除
     * @author Cai.ChangJun
     * @Date 2020/12/13 23:37
     */
    @Override
    @CacheEvict(/*value = {"emp","temp"},*/key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("删除元素："+id);
//        employeeMapper.deleteEmpById(id);
    }

    /**
     * 定义复杂规则，@CachePut有这个注解方法一定会被执行
     * @author Cai.ChangJun
     * @Date 2020/12/13 23:56
     */
    @Override
    @Caching(
            cacheable = {
                 @Cacheable(/*value = {"emp","temp"},*/key = "#lastName")
            },
            put = {
                @CachePut(/*value = {"emp","temp"},*/key = "#result.id"),
                @CachePut(/*value = {"emp","temp"},*/key = "#result.lastName")
            },
            evict = {
                    @CacheEvict(/*value = {"emp","temp"},*/key = "#lastName")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        return employeeMapper.getEmpBylastName(lastName);
    }
}
