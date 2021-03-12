package designPatterns.singleton;

/**
 * 双重校验锁单例
 * 懒汉模式单例虽然实现了懒加载和线程安全，但是每次获取调用方法都用到线程锁，如果多次调用就会导致性能很差。
 * 双重校验模式只有在实例为空时候才会去加锁创建对象，多并发环境下性能表现更好。
 */
public class SingletonDoubleCheck {
    private SingletonDoubleCheck(){}
    /**
     * Java中的指令重排优化。
     * 所谓指令重排优化是指在不改变原语义的情况下，通过调整指令的执行顺序让程序运行的更快。
     * JVM中并没有规定编译器优化相关的内容，也就是说JVM可以自由的进行指令重排序的优化。
     * 这个问题的关键就在于由于指令重排优化的存在，导致初始化Singleton和将对象地址赋给instance字段的顺序是不确定的。
     * 在某个线程创建单例对象时，在构造方法被调用之前，就为该对象分配了内存空间并将对象的字段设置为默认值。
     * 此时就可以将分配的内存地址赋值给instance字段了，然而该对象可能还没有初始化。
     * 若紧接着另外一个线程来调用getInstance，取到的就是状态不正确的对象，程序就会出错。
     * 在JDK1.4之前没有volatile关键字时指令重排导致双重校验锁失效。
     *
     * JDK1.5之后 加入volatile 禁止指令重排序优化 保证instance变量被赋值的时候对象已经是初始化过的，从而避免了上面说到的问题。
     */
    private static volatile SingletonDoubleCheck instance = null;

    /**
     * 假如两个线程A、B，A执行了if (instance == null)语句，
     * 它会认为单例对象没有创建，此时线程切到B也执行了同样的语句，
     * B也认为单例对象没有创建，然后两个线程依次执行同步代码块，并分别创建了一个单例对象。
     * 为了解决这个问题，还需要在同步代码块中增加if (instance == null)语句
     */
    public static SingletonDoubleCheck getInstance() {
        if (instance == null) { // Single Checked 第一次验证
            synchronized (SingletonDoubleCheck.class) {
                if (instance == null) { // Double checked 第二次验证
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
