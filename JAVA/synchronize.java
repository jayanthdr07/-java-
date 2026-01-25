import java.util.*;

class Participant extends Thread{
    private int pid;
    private String pname;

    public void setpd(int id, String name) {
        this.pid = id;
        this.pname = name;
    }

    
    public synchronized void welcome( ) {
        System.out.print("\rHi " + pname + " (ID: " + pid + ") welcome to event");
        System.out.flush();
       
    }
}

class WelcomeW extends Thread {
    Participant p;

    WelcomeW(Participant p) {
        this.p = p;
    }

    public void run() {
        p.welcome();
    
    try{
        Thread.sleep(2000);
    }
    catch(InterruptedException e){
        System.out.println(e);
    }
}
}

public class Main {
    public static void main(String args[]) throws InterruptedException{
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of participants:");
        int n = sc.nextInt();

        Participant p[] = new Participant[n];
        int cid = 101;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name of participant " + (i + 1));
            String name = sc.next();

            p[i] = new Participant();          
            p[i].setpd(cid, name);             
            cid++;
        }

        for (int i = 0; i < n; i++) {
            WelcomeW w = new WelcomeW(p[i]);
            w.start();
            Thread.sleep(2000);
        }
    }
}
