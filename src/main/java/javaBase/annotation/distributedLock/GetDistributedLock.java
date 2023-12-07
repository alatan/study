package javaBase.annotation.distributedLock;

import java.lang.annotation.*;

/**
 * 获取redis分布式锁 注解
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GetDistributedLock {

    // 分布式锁 key
    String lockKey();

    // 分布式锁 value，默认为 lockValue
    String lockValue() default "lockValue";

    // 过期时间，默认为 300秒
    int expireTime() default 300;

}