import java.util.*;
import java.sql.*;

class CompanyDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "root";
        Scanner sc = new Scanner(System.in);

        System.out.println("--- CRUD OPERATIONS ---");
        System.out.println("1. INSERT\n2. DISPLAY\n3. UPDATE\n4. DELETE");
        System.out.print("Select your choice: ");
        int ch = sc.nextInt();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            switch (ch) { // Parentheses added
                case 1:
                    PreparedStatement p = conn.prepareStatement("INSERT INTO employee(empid, empname, domain, salary) VALUES(?,?,?,?)");
                    System.out.print("Enter total employees: ");
                    int e = sc.nextInt();
                    for (int i = 0; i < e; i++) {
                        System.out.print("ID: "); int id = sc.nextInt();
                        System.out.print("Name: "); String name = sc.next();
                        System.out.print("Dept: "); String dept = sc.next();
                        System.out.print("Salary: "); int sal = sc.nextInt();
                        p.setInt(1, id); p.setString(2, name); p.setString(3, dept); p.setInt(4, sal);
                        p.executeUpdate();
                    }
                    System.out.println("Inserted successfully.");
                    break; // break prevents falling into Case 2

                case 2:
                    PreparedStatement dis = conn.prepareStatement("SELECT * FROM employee");
                    ResultSet r = dis.executeQuery();
                    System.out.println("ID\tName\tDept\tSalary");
                    while (r.next()) {
                        System.out.println(r.getInt(1) + "\t" + r.getString(2) + "\t" + r.getString(3) + "\t" + r.getInt(4));
                    }
                    break;

                case 3:
                    PreparedStatement up = conn.prepareStatement("UPDATE employee SET salary=? WHERE empid=?");
                    System.out.print("Enter employee id: ");
                    int upId = sc.nextInt();
                    System.out.print("Enter new salary: ");
                    int upSal = sc.nextInt();
                    up.setInt(1, upSal);
                    up.setInt(2, upId);
                    if (up.executeUpdate() > 0) System.out.println("Update successful");
                    else System.out.println("ID not found");
                    break;

                case 4:
                    PreparedStatement d = conn.prepareStatement("DELETE FROM employee WHERE empid=?");
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    d.setInt(1, delId);
                    if (d.executeUpdate() > 0) System.out.println("Delete successful");
                    else System.out.println("ID not found");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}