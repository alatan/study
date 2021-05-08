package base.annotation.distributedLock;

public class RedisService {
    public boolean tryGetDistributedLock(String lockKey, String lockValue, int expireTime) {
        //模拟实现Redis锁
        return true;
    }

    public void releaseDistributedLock(String lockKey, String lockValue) {
        //模拟实现Redis解锁
    }
}
