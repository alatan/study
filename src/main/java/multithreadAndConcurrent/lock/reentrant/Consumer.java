package multithreadAndConcurrent.lock.reentrant;

/**
 * 消费者
 */
class Consumer {
    private Depot depot;

    public Consumer(Depot depot) {
        this.depot = depot;
    }

    public void consume(int no) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                depot.consume(no);
            }
        }, no + "消费者").start();
    }
}
