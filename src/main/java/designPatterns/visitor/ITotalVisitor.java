package designPatterns.visitor;

public interface ITotalVisitor extends IVisitor {
    //统计所有员工工资总和
    public void totalSalary();
}