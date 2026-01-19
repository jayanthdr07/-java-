import java.util.*;

class BankAccount {
    private int accNo;
    private String name;
    private String password;
    private double balance;

    public BankAccount(int accNo, String name, String password, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public int getAccNo() {
        return accNo;
    }

    public boolean checkPassword(String pass) {
        return password.equals(pass);
    }

    public void deposit(double amt) {
        balance += amt;
        System.out.println("Amount deposited successfully");
    }

    public void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdraw successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void display() {
        System.out.println("\nAccount No: " + accNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        while (true) {
            System.out.println("\n--- BANK SYSTEM ---");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Set Password: ");
                    String pass = sc.next();

                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();

                    accounts.add(new BankAccount(accNo, name, pass, bal));
                    System.out.println("Account created successfully");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int loginAcc = sc.nextInt();

                    System.out.print("Enter Password: ");
                    String loginPass = sc.next();

                    BankAccount loggedIn = null;

                    for (BankAccount acc : accounts) {
                        if (acc.getAccNo() == loginAcc && acc.checkPassword(loginPass)) {
                            loggedIn = acc;
                            break;
                        }
                    }

                    if (loggedIn == null) {
                        System.out.println("Invalid account number or password");
                        break;
                    }

                    // Account menu
                    while (true) {
                        System.out.println("\n--- ACCOUNT MENU ---");
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Display");
                        System.out.println("4. Logout");
                        System.out.print("Enter choice: ");

                        int ch = sc.nextInt();

                        if (ch == 1) {
                            System.out.print("Enter amount: ");
                            loggedIn.deposit(sc.nextDouble());
                        } else if (ch == 2) {
                            System.out.print("Enter amount: ");
                            loggedIn.withdraw(sc.nextDouble());
                        } else if (ch == 3) {
                            loggedIn.display();
                        } else if (ch == 4) {
                            System.out.println("Logged out successfully");
                            break;
                        } else {
                            System.out.println("Invalid choice");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using Bank System");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
