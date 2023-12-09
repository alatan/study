package jvm.memory;

import java.util.concurrent.TimeUnit;

/**
 * 补充案例：用来演示大量创建线程撑爆内存会发生什么！
 * 如果创建海量线程线程的时候，同时每个线程疯狂递归，请问到底是先OOM还是StackOverflowError？
 */
public class TestThread {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new Thread("Thread-" + i) {
                @Override
                public void run() {
                    try {
                        String name = Thread.currentThread().getName();
                        System.out.println(name);
                        recurive(30000);
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println();
                }
            }.start();
        }
    }
    public static void recurive(double d){
        if (d ==0)
            return;
        recurive(d - 1);
    }
}
