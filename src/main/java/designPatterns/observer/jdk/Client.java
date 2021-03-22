package designPatterns.observer.jdk;

/**
 * 通过JDK内部的类实现观察者模式
 */
public class Client {
    public static void main(String[] args) {
        //三个观察者产生出来
        LiSi liSi = new LiSi();
        //定义出韩非子
        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.addObserver(liSi);
        //然后这里我们看看韩非子在干什么
        hanFeiZi.haveBreakfast();
    }
}
