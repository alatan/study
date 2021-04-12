package designPatterns.servant;

/**
 * 具体功能-衣服清洁
 */
public class Cloth implements Cleanable{
    public void celaned(){
        System.out.println("衣服被清洁干净");
    }
}
