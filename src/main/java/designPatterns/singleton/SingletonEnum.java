package designPatterns.singleton;

/**
 * 枚举形式单例模式
 * 首先，在枚举中我们明确了构造方法限制为私有，在我们访问枚举实例时会执行构造方法。
 * 同时每个枚举实例都是static final类型的，也就表明只能被实例化一次。
 * 在调用构造方法时，我们的单例被实例化。
 * 也就是说，因为enum中的实例被保证只会被实例化一次，所以我们的INSTANCE也被保证实例化一次。
 * 详细介绍：https://blog.csdn.net/fly910905/article/details/79286680
 *
 * 其他四种实现单例的方式都有共同的缺点：
 *     1）需要额外的工作来实现序列化，否则每次反序列化一个序列化的对象时都会创建一个新的实例。
 *     2）可以使用反射强行调用私有构造器（如果要避免这种情况，可以修改构造器，让它在创建第二个实例的时候抛异常）。
 * 而枚举类很好的解决了这两个问题，使用枚举除了线程安全和防止反射调用构造器之外，还提供了自动序列化机制，防止反序列化的时候创建新的对象。
 */
public class SingletonEnum {
    private SingletonEnum(){}
    public static SingletonEnum getInstance(){
        return Singleton.INSTANCE.getInstance();
    }
    private static enum Singleton{
        INSTANCE;
        private SingletonEnum singleton;
        //JVM会保证此方法绝对只调用一次
        private Singleton(){
            singleton = new SingletonEnum();
        }
        public SingletonEnum getInstance(){
            return singleton;
        }
    }
    public static void main(String[] args) {
        SingletonEnum obj1 = SingletonEnum.getInstance();
        SingletonEnum obj2 = SingletonEnum.getInstance();
        //输出结果：obj1==obj2?true
        System.out.println("obj1 == obj2 ? " + (obj1==obj2));
    }
}
