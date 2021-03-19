package designPatterns.strategy;

/**
 * 策略模式（定义一组算法，将每个算法都封装起来，并且使它们之间可以互换。）
 *
 * 使用周瑜赔了夫人又折兵来模拟策略模式（诸葛亮给赵云的三个妙计分别是：找乔国老帮忙（也就是走后门了），求吴国太放行（诉苦），孙夫人断后）
 */
public class ZhaoYun {
    //赵云出场了，他根据诸葛亮给他的交代，依次拆开妙计
    public static void main(String[] args) {
        Context context;
        //刚刚到吴国的时候拆第一个
        System.out.println("---刚刚到吴国的时候拆第一个---");
        context = new Context(new BackDoor()); //拿到妙计
        context.operate();  //拆开执行
        System.out.println("\n");
        //刘备乐不思蜀了，拆第二个了
        System.out.println("---刘备乐不思蜀了，拆第二个了---");
        context = new Context(new GivenGreenLight());
        context.operate();  //执行了第二个锦囊
        System.out.println("\n");
        //孙权的小兵追来了，咋办？拆第三个
        System.out.println("---孙权的小兵追来了，咋办？拆第三个---");
        context = new Context(new BlockEnemy());
        context.operate();  //孙夫人退兵
        System.out.println("\n");
    }
}
