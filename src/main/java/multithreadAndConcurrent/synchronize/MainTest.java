package multithreadAndConcurrent.synchronize;

public class MainTest {

    public static void main(String[] args) {
        ObjectService serviceA = new ObjectService();
        ObjectService serviceB = new ObjectService();
        Thread threadA = new Thread(){
            public void run(){
                serviceA.serviceMethodA();
            }
        };

        Thread threadB = new Thread(){
            public void run(){
                serviceB.serviceMethodB();
            }
        };
        threadA.start();
        threadB.start();

    }
}
