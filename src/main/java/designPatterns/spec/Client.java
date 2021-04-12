package designPatterns.spec;

import java.util.ArrayList;

/**
 * 规格模式
 *
 * 类似多个对象中筛选查找，或者业务规则不适于放在任何已有实体或值对象中，而且规则的变化和组合会掩盖那些领域对象的基本含义，
 * 或者是想自己编写一个类似LINQ的语言工具的时候就可以照搬这部分代码，只要实现自己的逻辑规格书即可。
 */
public class Client {
    public static void main(String[] args) {
        //首先初始化一批用户
        ArrayList userList = new ArrayList();
        userList.add(new User("苏国庆",23));
        userList.add(new User("国庆牛",82));
        userList.add(new User("张国庆三",25));
        userList.add(new User("李四",10));
        //定义一个用户查询类
        IUserProvider userProvider = new UserProvider(userList);
        //打印出名字包含"国庆"的人员
        System.out.println("===名字包含国庆的人员===");
        //定义一个规格书
        IUserSpecification spec = new UserByAgeThan(24);
        IUserSpecification spec2 = new UserByNameLike("%国庆%");
        for(User u:userProvider.findUser(spec.and(spec2))){
            System.out.println(u);
        }
    }
}
