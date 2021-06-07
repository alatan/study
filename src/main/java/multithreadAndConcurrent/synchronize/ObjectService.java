package multithreadAndConcurrent.synchronize;

public class ObjectService {
    public void serviceMethodA(){
        try {
            synchronized (this) {
                System.out.println("A begin time="+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end time="+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodB(){
        synchronized (this) {
            System.out.println("B begin time="+System.currentTimeMillis());
            System.out.println("B end time="+System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        ObjectService service = new ObjectService();
        Thread threadA = new Thread(){
            public void run(){
                service.serviceMethodA();
            }
        };
        Thread threadB = new Thread(){
            public void run(){
                service.serviceMethodB();
            }
        };
        threadA.start();
        threadB.start();

    }
}
