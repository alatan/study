package designPatterns.state;

/**
 * 抽象状态角色(接口或抽象类，负责对象状态定义，并且封装环境角色以实现状态切换)
 *
 * 抽象环境中声明一个环境角色，提供各个状态类自行访问，并且提供所有状态的抽象行为，由各个实现类实现。
 */
public abstract class LiftState {
    //定义一个环境角色，也就是封装状态的变化引起的功能变化
    protected Context context;
    public void setContext(Context _context){
        this.context = _context;
    }
    //首先电梯门开启动作
    public abstract void open();
    //电梯门有开启，那当然也就有关闭了
    public abstract void close();
    //电梯要能上能下，运行起来
    public abstract void run();
    //电梯还要能停下来
    public abstract void stop();
}
