package designPatterns.chainOfResponsibility;

import java.util.ArrayList;
import java.util.Random;

/**
 * 责任链模式（使多个对象都有机会处理请求，从而避免了请求的发送者和接受者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止。）
 * 优点：责任链模式非常显著的优点是将请求和处理分开。
 * 注意事项：链中节点数量需要控制，避免出现超长链的情况，一般的做法是在Handler中设置一个最大节点数量，
 *         在setNext方法中判断是否已经是超过其阈值，超过则不允许该链建立，避免无意识地破坏系统性能。
 *
 * 通过责任链模拟古代妇女三丛场景（“三从”是指“未嫁从父、既嫁从夫、夫死从子”）
 */
public class Client {
    public static void main(String[] args) {
        //随机挑选几个女性
        Random rand = new Random();
        ArrayList<IWomen> arrayList = new ArrayList();
        for(int i=0;i<5;i++){
            arrayList.add(new Women(rand.nextInt(4),"我要出去逛街"));
        }
        //定义三个请示对象
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();
        //设置请示顺序
        father.setNext(husband);
        husband.setNext(son);
        for(IWomen women:arrayList){
            father.HandleMessage(women);
        }
    }
}
