package designPatterns.flyweight;

/**
 * 享元模式（使用共享对象可有效地支持大量的细粒度的对象。）
 *
 * 享元模式的优点和缺点
 * 享元模式是一个非常简单的模式，它可以大大减少应用程序创建的对象，降低程序内存的占用，增强程序的性能
 * 但它同时也提高了系统复杂性，需要分离出外部状态和内部状态，而且外部状态具有固化特性，不应该随内部状态改变而改变，否则导致系统的逻辑混乱。
 *
 * 享元模式的使用场景
 * ● 系统中存在大量的相似对象。
 * ● 细粒度的对象都具备较接近的外部状态，而且内部状态与环境无关，也就是说对象没有特定身份。
 * ● 需要缓冲池的场景。
 */
public class Client {
    public static void main(String[] args) {
        //初始化对象池
        for(int i=0;i<4;i++){
            String subject = "科目" + i;
            //初始化地址
            for(int j=0;j<30;j++){
                String key = subject + "考试地点"+j;
                SignInfoFactory.getSignInfo(key);
            }
        }
        SignInfo signInfo = SignInfoFactory.getSignInfo("科目1考试地点1");
    }
}
