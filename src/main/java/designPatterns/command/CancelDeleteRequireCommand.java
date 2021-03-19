package designPatterns.command;

public class CancelDeleteRequireCommand extends Command {
    //撤销一项需求
    public void execute() {
        //剔除需求
        super.rg.rollBack();
        //删除页面
        super.pg.rollBack();
        //删除代码
        super.cg.rollBack();
    }
}