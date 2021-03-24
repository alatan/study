package designPatterns.state;

/**
 * 状态模式（当一个对象内在状态改变时允许其改变行为，这个对象看起来像改变了其类。）
 *
 * 状态模式的使用场景
 * ● 行为随状态改变而改变的场景
 *   这也是状态模式的根本出发点，例如权限设计，人员的状态不同即使执行相同的行为结果也会不同，在这种情况下需要考虑使用状态模式。
 * ● 条件、分支判断语句的替代者
 *   在程序中大量使用switch语句或者if判断语句会导致程序结构不清晰，逻辑混乱，使用状态模式可以很好地避免这一问题，它通过扩展子类实现了条件的判断处理。
 *
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
