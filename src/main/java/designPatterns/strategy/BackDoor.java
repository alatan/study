package designPatterns.strategy;

/**
 * 乔国老开后门（策略）
 */
public class BackDoor implements IStrategy {
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力");
    }
}