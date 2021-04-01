package designPatterns.factoryAndStrategy;

/**
 * 固定扣款策略
 * 固定扣款的规则是固定金额和自由金额各扣除交易金额的一半
 */
public class SteadyDeduction implements IDeduction {
    //固定性交易扣款
    public boolean exec(Card card, Trade trade) {
        //固定金额和自由金额各扣除50%
        int halfMoney = (int)Math.rint(trade.getAmount() / 2.0);
        card.setFreeMoney(card.getFreeMoney() - halfMoney);
        card.setSteadyMoney(card.getSteadyMoney() - halfMoney);
        return true;
    }
}