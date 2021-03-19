package designPatterns.strategy.enumStrategy;

/**
 * 策略枚举模式（变种在策略比较少的情况下使用）
 *
 * 策略枚举定义如下：
 * ● 它是一个枚举。
 * ● 它是一个浓缩了的策略模式的枚举。
 */
public enum Calculator {
    //加法运算
    ADD("+"){
        //策略的实现
        public int exec(int a,int b){
            return a+b;
        }
    },
    //减法运算
    SUB("-"){
        //策略的实现
        public int exec(int a,int b){
            return a - b;
        }
    };
    String value = "";
    //定义成员值类型
    private Calculator(String _value){
        this.value = _value;
    }
    //获得枚举成员的值
    public String getValue(){
        return this.value;
    }
    //声明一个抽象函数
    public abstract int exec(int a,int b);
}
