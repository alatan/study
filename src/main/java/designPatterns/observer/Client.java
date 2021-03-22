package designPatterns.observer;

/**
 *观察者模式（定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新。）
 *
 * 观察者模式的使用场景
 * ● 关联行为场景。需要注意的是，关联行为是可拆分的，而不是“组合”关系。
 * ● 事件多级触发场景。
 * ● 跨系统的消息交换场景，如消息队列的处理机制。
 */
public class Client {
    public static void main(String[] args) {
        //三个观察者产生出来
        Observer liSi = new LiSi();
        Observer wangSi = new WangSi();
        Observer liuSi = new LiuSi();
        //定义出韩非子
        HanFeiZi hanFeiZi = new HanFeiZi();
        //我们后人根据历史，描述这个场景，有三个人在观察韩非子
        hanFeiZi.addObserver(liSi);
        hanFeiZi.addObserver(wangSi);
        hanFeiZi.addObserver(liuSi);
        //然后这里我们看看韩非子在干什么
        hanFeiZi.haveBreakfast();
    }
}
