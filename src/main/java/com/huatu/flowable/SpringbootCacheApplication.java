package com.huatu.flowable;

import com.huatu.flowable.bean.Department;
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
 * 4.测试缓存
 *  原理：CacheManager == Cache 缓存组件来实际给缓存中存取数据
 *  1）引入redis的starter,容器中保存的是RedisCacheManager
 *  2）RedisCacheManager帮我们创建RedisCache来作为缓存组件，RedisCache通过操作redis缓存数据
 *  3）默认保存数据k-v都是object利用序列化保存；
 *         引入了redis的starter,CacheManager变为redisCacheManager;
 *         默认创建的RedisCacheManager，操作redis的时候使用的是RedisTemplate<Object,Object>
 *         RedisTemplate<Object,Object>是默认使用jdk序列化机制
 *         自定义CacheManager
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
