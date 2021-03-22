package designPatterns.composite;

/**
 * Leaf叶子构件
 */
public class Leaf extends Corp {
    //就写一个构造函数，这个是必需的
    public Leaf(String _name,String _position,int _salary){
        super(_name,_position,_salary);
    }
}