package multithreadAndConcurrent.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cb = new CyclicBarrier(3, new Thread("barrierAction") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " barrier action");

            }
        });
        CyclicBarrierThread t1 = new CyclicBarrierThread("t1", cb);
        CyclicBarrierThread t2 = new CyclicBarrierThread("t2", cb);
        CyclicBarrierThread t3 = new CyclicBarrierThread("t3", cb);
        t1.start();
        t2.start();
        t3.start();
    }
}


class CyclicBarrierThread extends Thread {
    private CyclicBarrier cb;
    public CyclicBarrierThread(String name, CyclicBarrier cb) {
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