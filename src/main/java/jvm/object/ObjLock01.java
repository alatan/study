package jvm.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * 打印空对象的内存布局信息
 *
 * 首先对象头是包含MarkWord和类型指针这两部分信息的；
 * 开启指针压缩的情况下，存放Class指针的空间大小是4字节，MarkWord是8字节，对象头为12字节；
 * 新建Object对象，会在内存占用16个字节，其中Header占12个（MarkWord占8个+KlassPoint占4个），没有实例数据，补充对齐4个。
 * 结论：对象大小 = 对象头12 + 实例数据0 + 对齐填充4 = 16 bytes
 */
public class ObjLock01 {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println("new Object:" + ClassLayout.parseInstance(o).toPrintable());
    }
}
