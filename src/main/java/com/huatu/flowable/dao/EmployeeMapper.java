package com.huatu.flowable.dao;

import com.huatu.flowable.bean.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Cai.ChangJun
 * @since 2020-12-12
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("update employee set last_name = #{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id = #{id}")
    public void updateEmp(Employee employee);

    @Delete("delete from employee where id = #{id}")
    public void deleteEmpById(Integer id);

    @Insert("insert into employee(last_name,email,gender,d_id) values(#{lastName},#{email},#{gender},d_id=#{dId})")
    public void insertEmployee(Employee employee);

    @Select("select * from employee where last_name = #{lastName}")
    public Employee getEmpBylastName(String lastName);
}
