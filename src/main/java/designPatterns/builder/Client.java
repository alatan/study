package designPatterns.builder;

import java.util.ArrayList;

/**
 * 建造者模式，也叫生成器模式。
 * 建造者模式关注的是零件类型和装配工艺（顺序），这是它与工厂方法模式最大不同的地方，虽然同为创建类模式，但是注重点不同。
 * 建造者模式最主要的功能是基本方法的调用顺序安排，也就是这些基本方法已经实现了，通俗地说就是零件的装配，顺序不同产生的对象也不同。
 * 而工厂模式的重点是创建，创建零件是它的主要职责，组装顺序则不是它关心的。
 */
public class Client {

    public static void main(String[] args) {
        Director director = new Director();
        //1万辆A类型的奔驰车
        for(int i=0;i<10000;i++){
            director.getABenzModel().run();
        }
        //100万辆B类型的奔驰车
        for(int i=0;i<1000000;i++){
            director.getBBenzModel().run();
        }
        //1000万辆C类型的宝马车
        for(int i=0;i<10000000;i++){
            director.getCBMWModel().run();
        }
    }
}
