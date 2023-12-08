package jvm.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * 打印空对象和赋值后的对象内存布局信息
 *
 * 新建对象Hero时，对象头占12个（MarkWord占8个+KlassPoint占4个）
 * 实例数据中 boolean占一个字节，会补齐三个，int占4个，String占4个，无需补充对齐。
 * 结论：对象的大小 = 12对象头 + 4*3的实例数据 + 0的填充 = 24bytes
 */
public class ObjLock02 {
    public static void main(String[] args) {
        Hero a = new Hero();
        System.out.println("new A:" +
                ClassLayout.parseInstance(a).toPrintable());
        a.setFlag(true);
        a.setI(1);
        a.setStr("ABC");
        System.out.println("赋值 A:" +
                ClassLayout.parseInstance(a).toPrintable());
    }
    static class Hero {
        private boolean flag;
        private int i;
        private String str;
        public void setFlag(boolean flag) {
            this.flag = flag;
        }
        public void setStr(String str) {
            this.str = str;
        }
        public void setI(int i) {
            this.i = i;
        }
    }
}
