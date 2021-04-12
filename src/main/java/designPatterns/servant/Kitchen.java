package designPatterns.servant;

/**
 * 具体功能-厨房清洁
 */
public class Kitchen implements Cleanable{
    public void celaned(){
        System.out.println("厨房被清洁干净");
    }
}
