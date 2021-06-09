package multithreadAndConcurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * 该流程在购物APP上非常常见，当你准备支付时放弃，会有一个支付失效，在支付失效期内可以随时回来支付，过期后需要重新选取支付商品。
 * 这里基于LockSupport中park和unpark控制线程状态，实现的等待通知机制。
 */
public class LockSupportDemo {
    public static void main(String[] args) throws Exception {
        OrderPay orderPay = new OrderPay("UnPaid") ;
        Thread orderThread = new Thread(orderPay) ;
        orderThread.start();
        Thread.sleep(3000);
        System.out.println("模拟支付订单中... ");
        orderPay.changeState("Pay");
        //模拟支付完成后，唤醒订单支付流程继续他的后续操作
        LockSupport.unpark(orderThread);
    }
}
class OrderPay implements Runnable {
    // 支付状态
    private String orderState ;
    public OrderPay (String orderState){
        this.orderState = orderState ;
    }
    public synchronized void changeState (String orderState){
        this.orderState = orderState ;
    }
    @Override
    public void run() {
        if (orderState.equals("UnPaid")){
            System.out.println("订单等待支付中... 订单状态："+orderState);
            LockSupport.park(orderState);
        }
        System.out.println("订单状态："+orderState);
        System.out.println("订单准备发货...");
    }
}