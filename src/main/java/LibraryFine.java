import java.io.*;
import java.util.*;

public class LibraryFine {

    static int calculateFine(int returnDay, int returnMonth, int returnYear, int dueDay, int dueMonth, int dueYear) {

        if (returnYear != dueYear) {
            return returnYear > dueYear? 10000 : 0;
        } else if (returnMonth != dueMonth) {
            return returnMonth > dueMonth? (returnMonth - dueMonth) * 500 : 0;
        } else if (returnDay != dueDay) {
            return returnDay > dueDay? (returnDay - dueDay) * 15 : 0;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int returnDay = scanner.nextInt();
        int returnMonth = scanner.nextInt();
        int returnYear = scanner.nextInt();
        scanner.nextLine();
        int dueDay = scanner.nextInt();
        int dueMonth = scanner.nextInt();
        int dueYear = scanner.nextInt();
        scanner.close();

        int fine = calculateFine(returnDay, returnMonth, returnYear, dueDay, dueMonth, dueYear);
        System.out.println(fine);
    }
}