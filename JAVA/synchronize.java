import java.util.*;

class Participant {
    private int pid;
    private String pname;

    public void setpd(int id, String name) {
        this.pid = id;
        this.pname = name;
    }

    // synchronized method
    public synchronized void welcome() {
        System.out.println("Hi " + pname + " (ID: " + pid + ") welcome to event");
    }
}

class WelcomeThread extends Thread {
    Participant p;

    WelcomeThread(Participant p) {
        this.p = p;
    }

    public void run() {
        p.welcome();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of participants:");
        int n = sc.nextInt();

        Participant[] p = new Participant[n];
        int cid = 101;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter name of participant " + (i + 1));
            String name = sc.next();

            p[i] = new Participant();
            p[i].setpd(cid, name);
            cid++;
        }

        for (int i = 0; i < n; i++) {
            WelcomeThread w = new WelcomeThread(p[i]);
            w.start();
        }
    }
}
