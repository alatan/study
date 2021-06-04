package multithreadAndConcurrent.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class MyThread1 extends Thread {
    private CyclicBarrier cb;
    public MyThread1(String name, CyclicBarrier cb) {
        super(name);
        this.cb = cb;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " going to await");
        try {
            cb.await();
            System.out.println(Thread.currentThread().getName() + " continue");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cb = new CyclicBarrier(3, new Thread("barrierAction") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " barrier action");

            }
        });
        MyThread1 t1 = new MyThread1("t1", cb);
        MyThread1 t2 = new MyThread1("t2", cb);
        MyThread1 t3 = new MyThread1("t3", cb);
        t1.start();
        t2.start();
        t3.start();
    }
}
