package multithreadAndConcurrent.lock.reentrant;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Depot {
    //仓库实际库存
    private int size;
    //仓库最大容量
    private int capacity;
    private Lock lock;
    private Condition fullCondition;
    private Condition emptyCondition;

    public Depot(int capacity) {
        this.capacity = capacity;
        lock = new ReentrantLock();
        fullCondition = lock.newCondition();
        emptyCondition = lock.newCondition();
    }

    public void produce(int no) {
        lock.lock();//获得锁
        //要生产的产品数量
        int left = no;
        try {
            while (left > 0) {
                while (size >= capacity)  {
                    System.out.println(Thread.currentThread().getName() + ",库存已满，生产者等待开始，消费者准备启动");
                    fullCondition.await();//调用此方法后生产者等待并释放锁，消费者获得锁执行消费动作
                    System.out.println(Thread.currentThread().getName() + ",生产者等待结束");
                }
                int inc = (left + size) > capacity ? (capacity - size) : left;
                left -= inc;
                size += inc;
                System.out.println(Thread.currentThread().getName() + ",这次生产了：" + inc + ", 库存： " + size);
                emptyCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume(int no) {
        lock.lock();
        //要消费的数量
        int left = no;
        try {
            while (left > 0) {
                while (size <= 0) {
                    System.out.println(Thread.currentThread().getName() + ",库存已空，消费者等待开始，生产者准备启动");
                    emptyCondition.await();//调用此方法后消费者等待并释放锁，生产者获得锁执行生产动作
                    System.out.println(Thread.currentThread().getName() + ",消费者等待结束");
                }
                int dec = (size - left) > 0 ? left : size;
                left -= dec;
                size -= dec;
                System.out.println(Thread.currentThread().getName() + ",此次消费了：" + dec + ", 库存：" + size);
                fullCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
