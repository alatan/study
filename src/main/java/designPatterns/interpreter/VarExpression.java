package designPatterns.interpreter;

import java.util.HashMap;

/**
 * 抽象运算符号解析器（终结符表达式）
 */
public class VarExpression extends Expression {
    private String key;
    public VarExpression(String _key){
        this.key = _key;
    }
    //从map中取之
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
