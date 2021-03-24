package designPatterns.bridge;

public class Clothes extends Product {
    public void beProducted() {
        System.out.println("生产出的衣服是这样的...");
    }
    public void beSelled() {
        System.out.println("生产出的衣服卖出去了...");
    }
}