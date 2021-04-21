package com.huatu.flowable.api;


import com.huatu.flowable.bean.Employee;
import com.huatu.flowable.faced.FlowableUtil;
import com.huatu.flowable.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Cai.ChangJun
 * @since 2020-12-12
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee geyById(@PathVariable("id") Integer id) {
        return employeeService.getById(id);
    }

    @GetMapping("/emp/lastName/{lastName}")
    public Employee geyById(@PathVariable("lastName") String lastName) {
        return employeeService.getEmpByLastName(lastName);
    }

    @GetMapping("/emp")
    public Employee update(Employee employee){
        return employeeService.updateEmp(employee);
    }

    @Autowired
    FlowableUtil flowableUtil;
    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        flowableUtil.image("123123");
        employeeService.deleteEmp(id);
        return "seccuss";
    }

}

