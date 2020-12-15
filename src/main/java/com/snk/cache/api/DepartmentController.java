package com.snk.cache.api;


import com.snk.cache.bean.Department;
import com.snk.cache.bean.Employee;
import com.snk.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department geyById(@PathVariable("id") Integer id) {
        return departmentService.getById(id);
    }
}

