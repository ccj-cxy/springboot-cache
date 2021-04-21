package com.huatu.flowable.bean;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.BeanNameAware;

/**
 * <p>
 * 
 * </p>
 *
 * @author Cai.ChangJun
 * @since 2020-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Employee implements Serializable, BeanNameAware {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String lastName;

    private String email;

    private String gender;

    private Integer dId;

    private String beanName;
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

}
