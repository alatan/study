package base.annotation;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 示例-反射获取注解
 */
public class Client {

    @Test
    public void testMyField(){
        // 获取类模板
        Class c = User.class;

        // 获取所有字段
        for(Field f : c.getDeclaredFields()){
            // 判断这个字段是否有MyField注解
            if(f.isAnnotationPresent(MyField.class)){
                MyField annotation = f.getAnnotation(MyField.class);
                System.out.println("字段:[" + f.getName() + "], 描述:[" + annotation.description() + "], 长度:[" + annotation.length() +"]");
            }
        }

    }
}
