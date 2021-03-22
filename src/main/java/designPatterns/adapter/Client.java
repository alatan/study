package designPatterns.adapter;

/**
 * 适配器模式（将一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。）
 *
 * 适配器模式可以让两个没有任何关系的类在一起运行，只要适配器这个角色能够搞定他们就成。
 *
 * 此案例场景为继承模式的适配器
 */
public class Client {
    public static void main(String[] args) {
        //老板一想不对呀，兔子不吃窝边草，还是找借用人员好点
        //我们只修改了这句话
        IUserInfo youngGirl = new OuterUserInfo();
        //从数据库中查到101个
        for(int i=0;i<101;i++){
            youngGirl.getMobileNumber();
        }
    }
}