package designPatterns.visitor;

/**
 * 展示表接口
 */
public interface IShowVisitor  extends IVisitor {
    //展示报表
    public void report();
}
