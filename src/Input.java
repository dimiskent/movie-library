import java.util.Scanner;

public class Input {
    private final Scanner scanner;
    public Input() {
        scanner = new Scanner(System.in);
    }
    public int getInt(String message, int min, int max) {
        int n;
        while (true) {
            System.out.print(message + ": ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if(n >= min && n <= max)
                    break;
                else
                    System.out.printf("Number must be between %d and %d!\n", min, max);
            } else {
                scanner.next();
                System.out.println("Whole number required!");
            }
        }
        scanner.nextLine();
        return n;
    }
    public int getInt(String message) {
        int n;
        while (true) {
            System.out.print(message + ": ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                break;
            } else {
                scanner.next();
                System.out.println("Whole number required!");
            }
        }
        scanner.nextLine();
        return n;
    }
    public String getString(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine();
    }
}
