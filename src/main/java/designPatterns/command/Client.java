package designPatterns.command;

/**
 * 命令模式（命令对象可以把行动及其参数封装起来，于是这些行动可以被重复多次执行 取消后又再重做 这些都是现代大型应用程序所必须的功能，即“撤销”及“重复”。）
 */
public class Client {
    public static void main(String[] args) {
        //定义项目总体负责人
        Invoker xiaoSan = new Invoker();
        //客户要求增加一项需求
        System.out.println("------------客户要求增加一项需求---------------");
        //客户给我们下命令来
        Command command = new AddRequirementCommand();
        //接头人接收到命令
        xiaoSan.setCommand(command);
        //接头人执行命令
        xiaoSan.action();
    }
}
