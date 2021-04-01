package designPatterns.commandAndChain;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令配置对象
 */
public enum CommandEnum {
    ls("com.cbf4life.common.command.LSCommand");
    private String value = "";
    //定义构造函数，目的是Data(value)类型的相匹配
    private CommandEnum(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
    //返回所有的enum对象
    public static List getNames(){
        CommandEnum[] commandEnum = CommandEnum.values();
        List names = new ArrayList();
        for(CommandEnum c:commandEnum){
            names.add(c.name());
        }
        return names;
    }
}
