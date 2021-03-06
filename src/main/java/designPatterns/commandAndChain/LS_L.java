package designPatterns.commandAndChain;

/**
 * ls-l命令
 */
public class LS_L extends AbstractLS {
    protected String echo(CommandVO vo) {
        return FileManager.ls_l(vo.formatData());
    }
    //l选项
    protected String getOperateParam() {
        return super.L_PARAM;
    }
}
