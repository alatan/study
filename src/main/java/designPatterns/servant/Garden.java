package designPatterns.servant;

/**
 * 具体功能-花园清洁
 */
public class Garden implements Cleanable{
    public void celaned(){
        System.out.println("花园被清洁干净");
    }
}