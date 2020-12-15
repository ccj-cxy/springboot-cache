package com.snk.cache.service;

import com.snk.cache.bean.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Cai.ChangJun
 * @since 2020-12-12
 */
public interface EmployeeService extends IService<Employee> {

    Employee updateEmp(Employee employee);

    void deleteEmp(Integer id);

    Employee getEmpByLastName(String lastName);
}
