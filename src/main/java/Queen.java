import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Queen {
    public HashSet<String[]> result = new HashSet<>();
    ArrayList<String[]> resultArray = new ArrayList<>();

    public ArrayList<String[]> solveNQueens(int n) {
        if (n == 0) return resultArray;

        ArrayList<String> pool = new ArrayList<>();
        ArrayList<String> solve = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] c = new char[n];
            Arrays.fill(c, '.');
            c[i] = 'Q';
            String line = new String(c);
            pool.add(line);
        }

        build(pool, solve, n);

        resultArray = new ArrayList<>(result);
        return resultArray;
    }

    public void build(ArrayList<String> pool, ArrayList<String> solve, int n) {
        if (pool.size() == 0 && solve.size() == n) {
            String[] solveArray = new String[n];
            for (int i = 0; i  < n; i++) {
                solveArray[i] = solve.get(i);
            }
            result.add(solveArray);
            return;
        }
        if (pool.size() == 1 && solve.size() > 0) {
            int indexQ = solve.get(solve.size() - 1).indexOf("Q");
            int index1 = pool.get(0).indexOf("Q");
            if (index1 == indexQ - 1 || index1 == indexQ + 1) {
                return;
            } else {
                solve.add(pool.get(0));
                pool.remove(0);
                build(pool, solve, n);
            }
        }
        if (pool.size() == 2 && solve.size() > 0) {
            int indexQ = solve.get(solve.size() - 1).indexOf("Q");
            int index1 = pool.get(0).indexOf("Q");
            int index2 = pool.get(1).indexOf("Q");
            if ((index1 == indexQ - 1 || index1 == indexQ + 1) && (index2 == indexQ - 1 || index2 == indexQ + 1)) {
                return;
            }
        }
        if (solve.size() == 0) {
            String[] solveArr = new String[solve.size()];
            for (String s : pool) {
                ArrayList<String> solve1 = new ArrayList<>(solve);
                ArrayList<String> pool1 = new ArrayList<>(pool);
                solve1.add(s);
                pool1.remove(s);
                build(pool1, solve1, n);
            }
        } else {
            String str = solve.get(solve.size() - 1);
            int indexQ = str.indexOf("Q");
            for (String s : pool) {
                if (s.indexOf("Q") != indexQ - 1 && s.indexOf("Q") != indexQ + 1) {
                    ArrayList<String> solve1 = new ArrayList<>(solve);
                    ArrayList<String> pool1 = new ArrayList<>(pool);
                    solve1.add(s);
                    pool1.remove(s);
                    build(pool1, solve1, n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Queen solution = new Queen();
        ArrayList<String[]> answer = solution.solveNQueens(5);
        for (String[] str : answer) {
            System.out.println(Arrays.toString(str));
        }
    }
}