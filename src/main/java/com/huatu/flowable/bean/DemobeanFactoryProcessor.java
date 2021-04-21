/**
 * Copyright  HuaTu
 * 安徽华图信息科技有限公司
 * http://www.myhuatu.com/
 * All rights reserved.
 */
package com.huatu.flowable.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean的生命周期：bean工厂的实现类应该尽可能的多支持bean的生命周期接口，先完成bean的实例化过程（反射生成bean）->初始化bean(填充属性populateBean)
 * ->执行Aware接口需要实现的方法->beanPostProcessor.before->init-method方法->BeanPostProcessor.after->完整对象->销毁对象
 * @author :Cai.ChangJun
 * @version 1.0.0
 * @Description :
 * @Date : 2021/1/24
 */
public class DemobeanFactoryProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition employee = beanFactory.getBeanDefinition("employee");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        Employee bean = classPathXmlApplicationContext.getBean(Employee.class);
        //获取当前bean在容器中的名字,Aware spring中的bean对象获取容器中bean相关的属性值
        bean.getBeanName();
    }
}
