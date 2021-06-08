package multithreadAndConcurrent.lock.reentrant;

/**
 * 生产者
 */
class Producer {
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    public void produce(int no) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                depot.produce(no);
            }
        }, no + "生产者").start();
    }
}
