import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Even {

    // Complete the stoneDivision function below.
    static long stoneDivision(long n, long[] s) {
        long piles = 1;
        long moves = 0;
        long stones = n;
        Arrays.sort(s);
        System.out.println(Arrays.toString(s));
        int index = s.length - 1;
        for (int i = index; i >= 0; i--) {
            if (s[i] < stones) {
                System.out.println("moves=" + moves + ", piles=" + piles + ", stones=" + stones);
                long cuts = stones / s[i];
                System.out.println("|-- cuts=" + cuts + ", s[i]=" + s[i]);
                if (cuts * s[i] == stones) {
                    moves += piles;
                    piles = piles * cuts;
                    stones = s[i];
                } else {
                    continue;
                }
            }
        }
        return moves;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\agnes\\Desktop\\myfile.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fw);

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            long n = Long.parseLong(nm[0]);

            int m = Integer.parseInt(nm[1]);

            long[] s = new long[m];

            String[] sItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m; i++) {
                long sItem = Long.parseLong(sItems[i]);
                s[i] = sItem;
            }

            long result = stoneDivision(n, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
