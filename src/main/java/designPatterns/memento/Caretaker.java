package designPatterns.memento;

/**
 * 备忘录管理员角色
 */
public class Caretaker {
    //发起人对象
    private Memento memento;
    public Memento getMemento() {
        return this.memento;
    }
    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
