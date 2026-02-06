import java.io.*;
import java.util.*;

class FileOperations {

    Scanner sc = new Scanner(System.in);

    void create() {
        System.out.println("Enter file name:");
        String txt = sc.next();

        try {
            File f = new File(txt);
            if (f.createNewFile()) {
                System.out.println("File Created");
            } else {
                System.out.println("Already Exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void write() {
        System.out.println("Enter file name:");
        String txt = sc.next();

        try {
            FileWriter w = new FileWriter(txt);

            System.out.println("Enter text:");
            sc.nextLine();
            String data = sc.nextLine();

            w.write(data);
            w.close();

            System.out.println("Written Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void read() {
        System.out.println("Enter file name:");
        String txt = sc.next();

        try {
            File f = new File(txt);
            Scanner fr = new Scanner(f);

            while (fr.hasNextLine()) {
                System.out.println(fr.nextLine());
            }

            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void append() {
        System.out.println("Enter file name:");
        String txt = sc.next();

        try {
            FileWriter fw = new FileWriter(txt, true);

            System.out.println("Enter text to append:");
            sc.nextLine();
            String data = sc.nextLine();

            fw.write("\n" + data);
            fw.close();

            System.out.println("Append Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void delete() {
        System.out.println("Enter file name:");
        String txt = sc.next();

        File f = new File(txt);

        if (f.delete()) {
            System.out.println("File Deleted");
        } else {
            System.out.println("Delete Failed");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        FileOperations obj = new FileOperations();
        Scanner sc = new Scanner(System.in);

        System.out.println("**********File operation***********");
        System.out.println("SELECT YOUR CHOICE");
        System.out.println("1.CREATE");
        System.out.println("2.WRITE");
        System.out.println("3.READ");
        System.out.println("4.APPEND");
        System.out.println("5.DELETE");
        System.out.println("6.EXIT");

        while (true) {
            System.out.println("Enter your choice:");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    obj.create();
                    break;
                case 2:
                    obj.write();
                    break;
                case 3:
                    obj.read();
                    break;
                case 4:
                    obj.append();
                    break;
                case 5:
                    obj.delete();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
