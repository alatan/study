package designPatterns.adapter;

import java.util.Map;

/**
 *  Adaptee源角色（你想把谁转换成目标角色，这个“谁”就是源角色，它是已经存在的、运行良好的类或对象，经过适配器角色的包装，它会成为一个崭新、靓丽的角色。）
 */
public interface IOuterUser {
    //基本信息，比如名称、性别、手机号码等
    public Map getUserBaseInfo();
    //工作区域信息
    public Map getUserOfficeInfo();
    //用户的家庭信息
    public Map getUserHomeInfo();
}
