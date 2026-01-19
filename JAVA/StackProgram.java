import java.util.Scanner;

public class StackProgram {
    static final int MAX = 2;
    static int[] stack = new int[MAX];
    static int top = -1;

    public static void push(Scanner sc) {
        if (top == MAX - 1) {
            System.out.println("STACK OVERFLOW!");
        } else {
            System.out.print("Enter value to push: ");
            int value = sc.nextInt();
            top++;
            stack[top] = value;
            System.out.println(value + " pushed to stack.");
        }
    }

    public static void pop() {
        if (top == -1) {
            System.out.println("STACK UNDERFLOW!");
        } else {
            System.out.println(stack[top] + " popped from stack.");
            top--;
        }
    }

    public static void display() {
        if (top == -1) {
            System.out.println("STACK IS EMPTY!");
        } else {
            System.out.println("STACK ELEMENTS ARE:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n***** Stack Operation Menu *****");
            System.out.println("1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. DISPLAY");
            System.out.println("4. EXIT");
            System.out.print("Select your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    push(sc);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
