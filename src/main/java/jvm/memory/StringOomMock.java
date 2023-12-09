package jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 以2的指数级不断的生成新的字符串，这样可以比较快速的消耗内存
 * 分别在jdk1.6 jdk1.7 jdk1.8 中执行 通过异常信息查看方法区的历史变迁
 *
 * -XX:PermSize=8m -XX:MaxPermSize=8m -Xmx16m StringOomMock
 */
public class StringOomMock {
    static String base = "string";
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i=0;i< Integer.MAX_VALUE;i++){
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
    }
}
