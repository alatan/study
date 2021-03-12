package designPatterns.singleton;

/**
 * 懒汉模式单例
 * 是否 Lazy 初始化：是
 * 是否多线程安全：需添加synchronized实现线程安全，默认情况不是线程安全
 * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 * getInstance() 频繁调用性能会很差。
 */
public class SingletonLH {
    private SingletonLH (){}

    private static SingletonLH instance;

    public static synchronized SingletonLH getInstance() {
        if (instance == null) {
            instance = new SingletonLH();
        }
        return instance;
    }
}
