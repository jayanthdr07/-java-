import java.io.*;
import java.util.*;

class FileOperations {

    Scanner sc = new Scanner(System.in);

    void create() {
        System.out.println("Enter file name:");
        String txt = sc.next();
        try {
            File f = new File(txt);
            System.out.println(f.createNewFile() ? "File Created" : "Already Exists");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void write() {
        System.out.println("Enter file name:");
        String txt = sc.next();

        try (FileWriter w = new FileWriter(txt)) {
            System.out.println("Enter text:");
            sc.nextLine();
            String data = sc.nextLine();
            w.write(data);
            System.out.println("Written Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void read() {
        System.out.println("Enter file name:");
        String txt = sc.next();

        try (Scanner fr = new Scanner(new File(txt))) {
            fr.forEachRemaining(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void append() {
        System.out.println("Enter file name:");
        String txt = sc.next();

        try (FileWriter fw = new FileWriter(txt, true)) {
            System.out.println("Enter text:");
            sc.nextLine();
            fw.write("\n" + sc.nextLine());
            System.out.println("Append Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void delete() {
        System.out.println("Enter file name:");
        String txt = sc.next();
        File f = new File(txt);
        System.out.println(f.delete() ? "File Deleted" : "Delete Failed");
    }
}

public class Main {
    public static void main(String[] args) {

        FileOperations obj = new FileOperations();
        Scanner sc = new Scanner(System.in);

        Map<Integer, Runnable> menu = new HashMap<>();

        menu.put(1, () -> obj.create());
        menu.put(2, () -> obj.write());
        menu.put(3, () -> obj.read());
        menu.put(4, () -> obj.append());
        menu.put(5, () -> obj.delete());
        menu.put(6, () -> System.exit(0));

        System.out.println("1.CREATE  2.WRITE  3.READ  4.APPEND  5.DELETE  6.EXIT");

        while (true) {
            System.out.println("Enter choice:");
            int choice = sc.nextInt();

            menu.getOrDefault(choice,
                    () -> System.out.println("Invalid Choice")).run();
        }
    }
}
