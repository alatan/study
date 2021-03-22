package designPatterns.adapter.compositeAdapter;

import designPatterns.adapter.IUserInfo;

/**
 * 此案例场景为对象适配器模式
 *
 * 对象适配器和类适配器的区别是：类适配器是类间继承，对象适配器是对象的合成关系，也可以说是类的关联关系，这是两者的根本区别。
 * 二者在实际项目中都会经常用到，由于对象适配器是通过类间的关联关系进行耦合的，
 * 因此在设计时就可以做到比较灵活，比如修补源角色的隐形缺陷，关联其他对象等，
 * 而类适配器就只能通过覆写源角色的方法进行扩展，在实际项目中，对象适配器使用到场景相对较多。
 */
public class Client {
    public static void main(String[] args) {
        //外系统的人员信息
        IOuterUserBaseInfo baseInfo = new OuterUserBaseInfo();
        IOuterUserHomeInfo homeInfo = new OuterUserHomeInfo();
        IOuterUserOfficeInfo officeInfo = new OuterUserOfficeInfo();
        //传递三个对象
        IUserInfo youngGirl = new OuterUserInfo(baseInfo,homeInfo,officeInfo);
        //从数据库中查到101个
        for(int i=0;i<101;i++){
            youngGirl.getMobileNumber();
        }
    }
}
