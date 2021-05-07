package base.reflection;

import java.lang.reflect.*;

/**
 * 反射 (Reflection) 是 Java 的特征之一，它允许运行中的 Java 程序获取自身的信息，并且可以操作类或对象的内部属性。
 */
public class Client {
    public static void main(String[] args) {
        try {
            Class appleClass = Class.forName("base.reflection.Apple");
            /**
             *  类名
             */
            System.out.println("name:"+appleClass.getName());
            System.out.println("simplename:"+appleClass.getSimpleName());
            /**
             *  1.构造方法
             */
            //1.1 getDeclaredConstructors
            System.out.println("**********getDeclaredConstructors**********");
            Constructor[] declaredConstructors = appleClass.getDeclaredConstructors();
            for(Constructor constructor: declaredConstructors){
                System.out.println(constructor.toString());
            }
            //1.2 getConstructors
            System.out.println("**********getConstructors**********");
            Constructor[] constructors=appleClass.getConstructors();
            for(Constructor constructor:constructors){
                System.out.println(constructor.toString());
            }
            //1.3 通过无参构造来获取该类对象 newInstance()
            try {
                Apple apple= (Apple)appleClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            //1.4 通过有参构造来获取该类对象 newInstance
            try {
                Constructor constructor = appleClass.getConstructor(String.class,int.class,int.class);
                Apple apple=(Apple)constructor.newInstance("红色",10,5);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            /**
             * 2. 属性
             */
            //2.1 getDeclaredFields所有已声明的成员变量，但不能得到其父类的成员变量
            System.out.println("**********getDeclaredFields**********");
            Field[] declaredFields = appleClass.getDeclaredFields();
            for(Field field : declaredFields){
                System.out.println(field.toString());
            }
            //2.2 getFields访问公有的成员变量
            System.out.println("**********getFields**********");
            Field[] fields = appleClass.getFields();
            for(Field field:fields){
                System.out.println(field.toString());
            }
            /**
             * 3.方法
             */
            //3.1 getDeclaredMethods 方法返回类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
            System.out.println("**********getDeclaredMethods**********");
            Method[] declaredMethods = appleClass.getDeclaredMethods();
            for(Method method: declaredMethods){
                System.out.println(method.toString());
            }
            //3.2 getMethods方法返回某个类的所有公用（public）方法，包括其继承类的公用方法。
            System.out.println("**********getMethods**********");
            Method[] methods = appleClass.getMethods();
            for(Method method:methods){
                System.out.println(method.toString());
            }
            //3.3 反射通过invoke调用方法
            try {
                Constructor constructor = appleClass.getConstructor(String.class,int.class,int.class);
                Apple apple = (Apple)constructor.newInstance("红色",10,5);
                //获取toString方法并调用
                Method method = appleClass.getDeclaredMethod("toString");
                String str = (String)method.invoke(apple);
                System.out.println(str);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //4 利用反射创建数组
            Class<?> cls = Class.forName("java.lang.String");
            Object array = Array.newInstance(cls,5);
            //往数组里添加内容
            Array.set(array,0,"hello");
            Array.set(array,1,"Java");
            Array.set(array,2,"fuck");
            Array.set(array,3,"Scala");
            Array.set(array,4,"Clojure");
            //获取某一项的内容
            System.out.println(Array.get(array,3));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
