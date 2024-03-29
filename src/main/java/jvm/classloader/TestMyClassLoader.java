package jvm.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMyClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 自定义类加载器的加载路径
        HeroClassLoader hClassLoader = new HeroClassLoader("E:\\work\\java\\study\\src\\main\\java\\jvm\\classloader");
        //包名+类名
        Class c = hClassLoader.loadClass("jvm.classloader.Test");
        if(c!=null){
            Object obj = c.newInstance();
            Method method= c.getMethod("say", null);
            method.invoke(obj, null);
            System.out.println(c.getClassLoader().toString());
        }
    }
}
