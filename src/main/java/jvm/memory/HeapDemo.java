package jvm.memory;

/**
 * -Xms100m -Xmx100m
 *
 * 分别使用不同的jdk版本编译，运行查看堆内存分布
 */
public class HeapDemo {
    public static void main(String[] args) {
        System.out.println("======start=========");
        try {
            Thread.sleep(1000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("========end=========");
    }
}
