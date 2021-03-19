package designPatterns.strategy;

/**
 * 吴国太开绿灯（策略）
 */
public class GivenGreenLight  implements IStrategy {
    public void operate() {
        System.out.println("求吴国太开绿灯,放行！");
    }
}