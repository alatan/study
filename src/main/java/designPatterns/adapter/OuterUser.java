package designPatterns.adapter;

import java.util.HashMap;
import java.util.Map;

/**
 *  Adaptee源角色（你想把谁转换成目标角色，这个“谁”就是源角色，它是已经存在的、运行良好的类或对象，经过适配器角色的包装，它会成为一个崭新、靓丽的角色。）
 */
public class OuterUser implements IOuterUser {
    /**
     * 用户的基本信息
     */
    public Map getUserBaseInfo() {
            HashMap baseInfoMap = new HashMap();
            baseInfoMap.put("userName", "这个员工叫混世魔王...");
            baseInfoMap.put("mobileNumber", "这个员工电话是...");
            return baseInfoMap;
    }
    /*
     * 员工的家庭信息
     */
    public Map getUserHomeInfo() {
            HashMap homeInfo = new HashMap();
            homeInfo.put("homeTelNumbner", "员工的家庭电话是...");
            homeInfo.put("homeAddress", "员工的家庭地址是...");
            return homeInfo;
    }
    /*
     * 员工的工作信息，比如，职位等
     **/
    public Map getUserOfficeInfo() {
        HashMap officeInfo = new HashMap();
        officeInfo.put("jobPosition","这个人的职位是BOSS...");
        officeInfo.put("officeTelNumber", "员工的办公电话是...");
        return officeInfo;
    }
}