package multithreadAndConcurrent.threadLocal;

import java.util.Random;

/**
 * 我们可以发现对于不同的对象k的值是不同的，但是k2的值却是相同的，这是为什么呢?
 * 因为static关键字所修饰的字段并不属于一个对象，而是属于这个类的。
 * 也可简单的理解为static final所修饰的字段仅占据内存的一个一份空间，一旦被初始化之后便不会被更改。
 */
public class StaticExample {
    static Random r = new Random();
    final int k = r.nextInt(10);
    static final int k2 = r.nextInt(10);
    public static void main(String[] args) {
        StaticExample t1 = new StaticExample();
        System.out.println("k="+t1.k+" k2="+t1.k2);
        StaticExample t2 = new StaticExample();
        System.out.println("k="+t2.k+" k2="+t2.k2);
    }
}