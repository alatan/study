package designPatterns.commandAndChain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 命令模式 + 责任链模式
 *
 * ● 责任链模式
 * 负责对命令的参数进行解析，而且所有的扩展都是增加链数量和节点，不涉及原有的代码变更。
 *
 * ● 命令模式
 * 负责命令的分发，把适当的命令分发到指定的链上。
 *
 * ● 模板方法模式
 * 在Command类以及子类中，buildChain方法是模板方法，只是没有基本方法而已；在责任链模式的CommandName类中，
 * 用了一个典型的模板方法handlerMessage，它调用了基本方法，基本方法由各个实现类实现，非常有利于扩展。
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Invoker invoker = new Invoker();
        while(true){
            //UNIX下的默认提示符号
            System.out.print("#");
            //捕获输出
            String input = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            //输入quit或exit则退出
            if(input.equals("quit") || input.equals("exit")){
                return;
            }
            System.out.println(invoker.exec(input));
        }
    }
}
