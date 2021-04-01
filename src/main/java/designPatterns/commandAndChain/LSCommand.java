package designPatterns.commandAndChain;

/**
 * 具体的ls命令
 */
public class LSCommand extends Command{
    public String execute(CommandVO vo){
        //返回链表的首节点
        CommandName firstNode = super.buildChain(AbstractLS.class).get(0);
        return firstNode.handleMessage(vo);
    }
}
