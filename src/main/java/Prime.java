import java.io.*;
import java.util.*;

public class Prime {
    public static boolean checkPrime(int num) {
        if (num == 1) return false;
        int mid = (int)Math.round(Math.sqrt(num));
        for (int i = 2; i <= mid; i++) {
            if (num % i == 0) {
                System.out.println(i);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            boolean prime = checkPrime(scanner.nextInt());
            if (prime) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }
}