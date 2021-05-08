package base.annotation.distributedLock;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    // 自定义注解的使用
    @GetDistributedLock(lockKey = "userLock")
    @GetMapping("/user/getDistributedLock")
    public boolean getUserDistributedLock() {
        System.out.println("获取分布式锁...");
        // 具体的业务逻辑
        return true;
    }
}
