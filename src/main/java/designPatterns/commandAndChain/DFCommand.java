package designPatterns.commandAndChain;

public class DFCommand extends Command {
    public String execute(CommandVO vo) {
        return super.buildChain(AbstractDF.class).get(0).handleMessage(vo);
    }
}