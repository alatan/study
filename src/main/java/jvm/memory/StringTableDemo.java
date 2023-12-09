package jvm.memory;

import java.util.HashMap;

/**
 * 总结：
 * 单独使用””引号创建的字符串都是常量，编译期就已经确定存储到String Pool中。
 * 使用new String(“”)创建的对象会存储到heap中，是运行期新创建的。
 * 使用只包含常量的字符串连接符如”aa”+”bb”创建的也是常量，编译期就能确定已经存储到StringPool中。
 * 使用包含变量的字符串连接如”aa”+s创建的对象是运行期才创建的，存储到heap中。
 * 运行期调用String的intern()方法可以向String Pool中动态添加对象。
 */
public class StringTableDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("hello", 53);
        map.put("world", 35);
        map.put("java", 55);
        map.put("world", 52);
        map.put("通话", 51);
        map.put("重地", 55);
    //出现哈希冲突怎么办？
    //System.out.println("map = " + map);//
            test();
        }
    public static void test() {
        String str1 = "abc";
        String str2 = new String("abc");
        System.out.println(str1 == str2);//false
        String str3 = new String("abc");
        System.out.println(str3 == str2);//false
        String str4 = "a" + "b";
        System.out.println(str4 == "ab");//true
        String s1 = "a";
        String s2 = "b";
        String str6 = s1 + s2;
        System.out.println(str6 == "ab");//false
        String str7 = "abc".substring(0,2);
        System.out.println(str7 == "ab");//false
        String str8 = "abc".toUpperCase();
        System.out.println(str8 == "ABC");//false
        String s5 = "a";
        String s6 = "abc";
        String s7 = s5 + "bc";
        System.out.println(s6 == s7.intern());//true
    }
}
