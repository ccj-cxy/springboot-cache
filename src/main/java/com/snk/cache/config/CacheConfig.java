/**
 * Copyright  HuaTu
 * 安徽华图信息科技有限公司
 * http://www.myhuatu.com/
 * All rights reserved.*/


package com.snk.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Description: 缓存配置
 * @Date: 2020/12/13
 * @author：Cai.ChangJun
 */
@Configuration
public class CacheConfig {
    @Bean("applicationKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator(){
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName()+"["+ Arrays.asList(objects).toString()+"]";
            }
        };
    }
}
