package designPatterns.mediator;

/**
 * 中介者模式也叫做调停者模式（在多个对象依赖的情况下，通过加入中介者角色，取消了多个对象的关联或依赖关系，减少了对象的耦合性。）
 *
 * 实际应用
 * 机场调度中心
 * MVC框架（大家都应该使用过Struts，MVC框架，其中的C（Controller）就是一个中介者）
 */
public class Client {
    public static void main(String[] args) {
        AbstractMediator mediator = new Mediator();
        //采购人员采购电脑
        System.out.println("------采购人员采购电脑--------");
        Purchase purchase = new Purchase(mediator);
        purchase.buyIBMcomputer(100);
        //销售人员销售电脑
        System.out.println("\n------销售人员销售电脑--------");
        Sale sale = new Sale(mediator);
        sale.sellIBMComputer(1);
        //库房管理人员管理库存
        System.out.println("\n------库房管理人员清库处理--------");
        Stock stock = new Stock(mediator);
        stock.clearStock();
    }
}
