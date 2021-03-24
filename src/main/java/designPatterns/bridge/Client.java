package designPatterns.bridge;

/**
 * 桥梁模式（将抽象和实现解耦，使得两者可以独立地变化。）
 *
 * 桥梁模式的使用场景
 * ● 不希望或不适用使用继承的场景
 *    例如继承层次过渡、无法更细化设计颗粒等场景，需要考虑使用桥梁模式。
 * ● 接口或抽象类不稳定的场景
 *    明知道接口不稳定还想通过实现或继承来实现业务需求，那是得不偿失的，也是比较失败的做法。
 * ● 重用性要求较高的场景
 *    设计的颗粒度越细，则被重用的可能性就越大，而采用继承则受父类的限制，不可能出现太细的颗粒度。
 *
 * 进行系统设计时，发现类的继承有N层时，可以考虑使用桥梁模式。
 */
public class Client {
    public static void main(String[] args) {
        House house = new House();
        System.out.println("-------房地产公司是这样运行的-------");
        //先找到房地产公司
        HouseCorp houseCorp =new HouseCorp(house);
        //看我怎么挣钱
        houseCorp.makeMoney();
        System.out.println("\n");
        //山寨公司生产的产品很多，不过我只要指定产品就成了
        System.out.println("-------山寨公司是这样运行的-------");
        ShanZhaiCorp shanZhaiCorp = new ShanZhaiCorp(new IPod());
        shanZhaiCorp.makeMoney();
    }
}
