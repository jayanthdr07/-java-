import java.sql.*;
import java.util.Scanner;

public class Main {

    static String url = "jdbc:mysql://localhost:3306/college";
    static String user = "root";
    static String password = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected Successfully!");

            int choice;

            do {
                System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
                System.out.println("1. Insert Student");
                System.out.println("2. View All Students");
                System.out.println("3. Update Student Marks");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        insertStudent(con, sc);
                        break;

                    case 2:
                        viewStudents(con);
                        break;

                    case 3:
                        updateStudent(con, sc);
                        break;

                    case 4:
                        deleteStudent(con, sc);
                        break;

                    case 5:
                        System.out.println("Exiting Program...");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } while (choice != 5);

            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void insertStudent(Connection con, Scanner sc) throws Exception {

        String sql = "INSERT INTO student (roll, name, marks) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter Roll: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        ps.setInt(1, roll);
        ps.setString(2, name);
        ps.setInt(3, marks);

        ps.executeUpdate();
        System.out.println("Student Inserted Successfully!");
    }


    public static void viewStudents(Connection con) throws Exception {

        String sql = "SELECT * FROM student";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        System.out.println("\n---- Student Records ----");
        System.out.println("Roll\tName\tMarks");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("roll") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getInt("marks")
            );
        }
    }


    public static void updateStudent(Connection con, Scanner sc) throws Exception {

        String sql = "UPDATE student SET marks = ? WHERE roll = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter Roll to Update: ");
        int roll = sc.nextInt();

        System.out.print("Enter New Marks: ");
        int marks = sc.nextInt();

        ps.setInt(1, marks);
        ps.setInt(2, roll);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Student Updated Successfully!");
        else
            System.out.println("Student Not Found!");
    }


    public static void deleteStudent(Connection con, Scanner sc) throws Exception {

        String sql = "DELETE FROM student WHERE roll = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter Roll to Delete: ");
        int roll = sc.nextInt();

        ps.setInt(1, roll);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Student Deleted Successfully!");
        else
            System.out.println("Student Not Found!");
    }
}
