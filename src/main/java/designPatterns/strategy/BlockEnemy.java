package designPatterns.strategy;

/**
 * 孙夫人断后（策略）
 */
public class BlockEnemy implements IStrategy {
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}