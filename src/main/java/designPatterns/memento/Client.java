package designPatterns.memento;

/**
 * 备忘录模式（在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。）
 *
 * 通俗地说，备忘录模式就是一个对象的备份模式，提供了一种程序数据的备份方法。
 *
 * 备忘录模式的使用场景
 * ● 需要保存和恢复数据的相关状态场景。
 * ● 提供一个可回滚（rollback）的操作；比如Word中的CTRL+Z组合键，IE浏览器中的后退按钮，文件管理器上的backspace键等。
 * ● 需要监控的副本场景中。例如要监控一个对象的属性，但是监控又不应该作为系统的主业务来调用，它只是边缘应用，即使出现监控不准、
 *      错误报警也影响不大，因此一般的做法是备份一个主线程中的对象，然后由分析程序来分析。
 * ● 数据库连接的事务管理就是用的备忘录模式，想想看，如果你要实现一个JDBC驱动，你怎么来实现事务？还不是用备忘录模式嘛！
 */
public class Client {
    public static void main(String[] args) {
        //定义出发起人
        Originator ori = new Originator();
        //定义出备忘录管理员
        Caretaker caretaker = new Caretaker();
        //初始化
        ori.setState1("中国");
        ori.setState2("强盛");
        ori.setState3("繁荣");
        System.out.println("===初始化状态===\n"+ori);
        //创建一个备忘录
        caretaker.setMemento(ori.createMemento());
        //修改状态值
        ori.setState1("软件");
        ori.setState2("架构");
        ori.setState3("优秀");
        System.out.println("\n===修改后状态===\n"+ori);
        //恢复一个备忘录
        ori.restoreMemento(caretaker.getMemento());
        System.out.println("\n===恢复后状态===\n"+ori);
    }
}
