package multithreadAndConcurrent.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 *  必须先让t2先进行启动 使用wait 和 notify 进行相互通讯，wait会释放锁，notify不会释放锁
 */
public class T2 {

    volatile   List list = new ArrayList();

    public void add (int i){
        list.add(i);
    }

    public int getSize(){
        return list.size();
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        Object lock = new Object();

        new Thread(() -> {
            synchronized(lock){
                System.out.println("t2 启动");
                if(t2.getSize() != 5){
                    try {
                        /**会释放锁*/
                        System.out.println("t2等待计算");
                        lock.wait();
                        System.out.println("t2等待结束");
                        System.out.println("t2 end，size：" + t2.getSize());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        },"t2").start();

        new Thread(() -> {
            synchronized (lock){
                System.out.println("t1 启动");
                for (int i=0;i<9;i++){
                    t2.add(i);
                    System.out.println("add"+i);
                    if(t2.getSize() == 5){
                        /**不会释放锁*/
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
