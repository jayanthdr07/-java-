class Prime extends Thread {
    public void run() {
        for (int num = 2; num <= 50; num++) {
            boolean isPrime = true;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(Thread.currentThread().getName() + ": " + num);
            }

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Fibonacci extends Thread {
    public void run() {
        int a = 0, b = 1;

        for (int i = 1; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + a);

            int c = a + b;
            a = b;
            b = c;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        // Main thread reference
        Thread mainThread = Thread.currentThread();
        mainThread.setName("Main-Thread");
        mainThread.setPriority(Thread.NORM_PRIORITY);

        Prime p = new Prime();
        Fibonacci f = new Fibonacci();

        // Set name & priority
        p.setName("Prime-Thread");
        p.setPriority(Thread.MAX_PRIORITY);

        f.setName("Fibonacci-Thread");
        f.setPriority(Thread.MIN_PRIORITY);

        p.start();
        f.start();

        // Display main thread details
        System.out.println("Name: " + mainThread.getName());
        System.out.println("ID: " + mainThread.getId());
        System.out.println("Priority: " + mainThread.getPriority());
        System.out.println("Is Alive: " + mainThread.isAlive());
    }
}
