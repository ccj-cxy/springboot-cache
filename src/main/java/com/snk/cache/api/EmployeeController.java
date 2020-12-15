package com.snk.cache.api;


import com.snk.cache.bean.Employee;
import com.snk.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

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

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeService.deleteEmp(id);
        return "seccuss";
    }

}

