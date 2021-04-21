package com.huatu.flowable.service.impl;

import com.huatu.flowable.bean.Department;
import com.huatu.flowable.dao.DepartmentMapper;
import com.huatu.flowable.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
@Service
@CacheConfig(cacheNames = {"depart"})  //抽取缓存公共配置
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Override
    @Cacheable(key = "#id")
    public Department getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    @CachePut(key = "#result.id")
    public boolean save(Department entity) {
        return super.save(entity);
    }

    @Override
    @CacheEvict(key = "#id")
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }
}
