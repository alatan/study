package designPatterns.observerAndMediator;

/**
 * 观察者模式+中介者模式
 *
 * ● 工厂方法模式
 * 负责产生产品对象，方便产品的修改和扩展，并且实现了产品和工厂的紧耦合，避免产品随意被创建而无触发事件的情况发生。
 *
 * ● 桥梁模式
 * 在产品和事件两个对象的关系中我们使用了桥梁模式，如此设计后，两者都可以自由地扩展（前提是需要抽取抽象化）而不会破坏原有的封装。
 *
 * ● 观察者模式
 * 观察者模式解决了事件如何通知处理者的问题，而且观察者模式还有一个优点是可以有多个观察者，也就是我们的架构是可以有多层级、多分类的处理者。
 * 想重新扩展一个新类型（新接口）的观察者？没有问题，扩展ProductEvent即可。
 *
 * ● 中介者模式
 * 事件有了，处理者也有了，这些都会发生变化，并且处理者之间也有耦合关系，中介者则可以完美地处理这些复杂的关系。
 */
public class Client {
    public static void main(String[] args) {
        //获得事件分发中心
        EventDispatch dispatch = EventDispatch.getEventDispatch();
        //接受乞丐对事件的处理
        dispatch.registerCustomer(new Beggar());
        //接受平民对事件的处理
        dispatch.registerCustomer(new Commoner());
        //接受贵族对事件的处理
        dispatch.registerCustomer(new Nobleman());
        //建立一个原子弹生产工厂
        ProductManager factory = new ProductManager();
        //制造一个产品
        System.out.println("=====模拟创建产品事件========");
        System.out.println("创建一个叫做小男孩的原子弹");
        Product p = factory.createProduct("小男孩原子弹");
        //修改一个产品
        System.out.println("\n=====模拟修改产品事件========");
        System.out.println("把小男孩原子弹修改为胖子号原子弹");
        factory.editProduct(p, "胖子号原子弹");
        //再克隆一个原子弹
        System.out.println("\n=====模拟克隆产品事件========");
        System.out.println("克隆胖子号原子弹");
        factory.clone(p);
        //遗弃一个产品
        System.out.println("\n=====模拟销毁产品事件========");
        System.out.println("遗弃胖子号原子弹");
        factory.abandonProduct(p);
    }
}
