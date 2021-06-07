package multithreadAndConcurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * 可以看到，在先调用unpark，再调用park时，仍能够正确实现同步，不会造成由wait/notify调用顺序不当所引起的阻塞。
 * 因此park/unpark相比wait/notify更加的灵活
 *
 * 对比WaitAndNotifyDemo
 */
class ParkAndUnparkDemoMyThread extends Thread {
    private Object object;

    public ParkAndUnparkDemoMyThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        System.out.println("before unpark");
        // 释放许可
        LockSupport.unpark((Thread) object);
        System.out.println("after unpark");
    }
}

public class ParkAndUnparkDemo {
    public static void main(String[] args) {
        ParkAndUnparkDemoMyThread myThread = new ParkAndUnparkDemoMyThread(Thread.currentThread());
        myThread.start();
        try {
            // 主线程睡眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }
}
