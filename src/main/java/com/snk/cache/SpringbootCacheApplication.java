package com.snk.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 1.开启基于注解的缓存
 * 2.标注注解缓存
 * 3.@CacheAble
 *   @CacheEvict
 *   @CachePut
 *整个redis作为缓存
 * @author Cai.ChangJun
 * @Date 2020/12/12 16:37
 */
@SpringBootApplication
@EnableCaching
public class SpringbootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCacheApplication.class, args);
    }

}
