import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Codility {
    public int leastUnoccuredInt(int[] A) {
        if (A == null || A.length == 0) return 1;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i : A) {
            if (i > 0) nums.add(i);
        }

        if (nums.size() == 0) return 1;
        Collections.sort(nums);
        if (nums.get(0) > 1) return 1;
        int len = nums.size();

        for (int i = 1; i < len; i++) {
            if (nums.get(i) - nums.get(i - 1) > 1) {
                return nums.get(i - 1) + 1;
            }
        }
        return nums.get(len - 1) + 1;
    }

    public int maxGap(int N) {
        String str = Integer.toBinaryString(N);
        System.out.println(str);
        int len = str.length();
        int maxGap = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '1') {
                int gap = 0;
                for (int j = i + 1; j < len; j++) {
                    if (str.charAt(j) == '0') {
                        gap++;
                    } else {
                        maxGap = Math.max(maxGap, gap);
                        break;
                    }
                }
            }
        }
        return maxGap;
    }

    public int[] cylinder(int[] A, int K) {
        if (A == null || A.length<= 1 || K == 0) return A;
        int len = A.length;
        K = K % len;
        if (K == 0) return A;

        int[] result = new int[len];
        if (K > len) K = K % len;

        for (int i = 0; i < K; i ++) {
            result[i] = A[i + (len - K)];
        }

        for (int i = K; i < len; i++) {
            result[i] = A[i - K];
        }

        return result;
    }


    public int unpaired(int[] A) {
        if (A.length == 0) return 0;
        int len = A.length;
        Arrays.sort(A);
        for (int i = 0; i < len - 1; i = i + 2) {
            if (A[i] != A[i + 1]) {
                return A[i];
            }
        }
        return A[len - 1];
    }

    public int jumpSteps(int X, int Y, int D) {
        int distance = Math.abs(Y - X);
        if (distance % D == 0) {
            return distance / D;
        } else {
            int steps = distance / D + 1;
            return steps;
        }
    }

    public int findMissingInt(int[] A) {
        if (A == null || A.length == 0) return 1;

        Arrays.sort(A);
        int len = A.length;

        for (int i = 0; i < len; i++) {
            if (A[i] > i + 1) return i + 1;
        }
        return A[len - 1] + 1;
    }

    public int minimalDifference(int[] A) {
        if (A == null || A.length == 0) return 0;

        int len = A.length;
        if (A.length == 1) return A[0];

        int preSum = A[0], sufSum = 0;
        for (int i = 1; i < len; i++) {
            sufSum += A[i];
        }
        int minDiff = Math.abs(sufSum - preSum);

        for (int i = 1; i < len - 1; i++) {
            preSum += A[i];
            sufSum -= A[i];
            minDiff = Math.min(minDiff, Math.abs(sufSum - preSum));
        }

        return minDiff;
    }

    public int frogRiverOne(int X, int[] A) {
        if (A == null || A.length == 0) return -1;

        HashSet<Integer> res = new HashSet<>();

        int len = A.length;
        for (int i = 0; i < len; i++) {
            res.add(A[i]);
            if (res.size() == X) {
                return i;
            }
        }
        return -1;
    }

    public int[] maxCounter(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0;
        int lastUpdate = 0;
        int len = A.length;

        for (int i = 0; i < len; i++) {
            if (A[i] == N + 1) {
                lastUpdate = max;
            } else {
                int position = A[i] - 1;
                if (counters[position] < lastUpdate) {
                    counters[position] = lastUpdate + 1;
                } else {
                    counters[position]++;
                }
                max = Math.max(max, counters[position]);
            }
        }

        for (int i = 0; i < N; i++) {
            counters[i] = Math.max(counters[i], lastUpdate);
        }

        return counters;
    }

    public int missingInteger(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0) return 1;

        Arrays.sort(A);
        int len = A.length;
        if (A[len - 1] < 1) return 1;

        int index = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] < 1) {
                continue;
            } else {
                index = i;
                break;
            }
        }
        if (A[index] > 1) return 1;

        for (int i = index; i  < len - 1; i++) {
            if (A[i + 1] - A[i] > 1) {
                return A[i] + 1;
            }
        }
        return A[len - 1] + 1;
    }

    public int checkPermutation(int[] A) {
        if (A == null || A.length == 0) return 0;
        int len = A.length;
        Arrays.sort(A);
        if (A[0] != 1 || A[len - 1] != len) return 0;

        for (int i = 0; i < len - 1; i++) {
            if (A[i + 1] - A[i] != 1) return 0;
        }
        return 1;
    }

    public int countDiv(int A, int B, int K) {
        int count = 0;
        int start = A;
        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                count ++;
                start = i;
                break;
            }
        }
        count += (B - start) / K;
        return count;
    }

    public int[] genomicRangeQuery(String S, int[] P, int[] Q) {
        if (S == null || P == null || Q == null || S.length() == 0 || P.length == 0 || Q.length == 0 || P.length != Q.length ) {
            return null;
        }
        int sLen = S.length();
        int pLen = P.length;
        int[][] arr = new int[sLen][4];
        int[] res = new int[pLen];

        for (int i = 0; i < sLen; i++) {
            switch (S.charAt(i)){
                case 'A': arr[i][0] = 1;
                case 'C': arr[i][1] = 1;
                case 'G': arr[i][2] = 1;
                case 'T': arr[i][3] = 1;
            }
            if (i > 0) {
                for (int j = 0; j < 4; j++) {
                    arr[i][j] += arr[i - 1][j];
                }
            }
        }

        for (int i = 0; i < pLen; i++) {
            int x = P[i];
            int y = Q[i];
            for (int j = 0; j < 4; j++) {
                int sub = 0;
                if (x > 0) sub = arr[x - 1][j];
                if (arr[y][j] > sub) {
                    res[i] = j + 1;
                    break;
                }
            }
        }
        return res;
    }

    private boolean pair(char x, char y) {
        switch (x) {
            case '{' :
                if (y == '}') {
                    return true;
                } else {
                    return false;
                }
            case '[' :
                if (y == ']') {
                    return true;
                } else {
                    return false;
                }
            case '(' :
                if (y == ')') {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
    public int distinct(String S) {
        if (S == null) return 0;
        int len = S.length();
        if (len == 0) return 1;
        if (len % 2 != 0) return 0;
        char c0 = S.charAt(0);
        char c1 = S.charAt(1);
        char cLast = S.charAt(len - 1);

        if (pair(c0, c1)) {
            String sub = S.substring(2);
            return distinct(sub);
        } else if (pair(c0, cLast)) {
            String sub = S.substring(1, len - 1);
            return distinct(sub);
        } else {
            return 0;
        }
    }

    public int minAvgTwoSlice(int[] A) {
        double min = Double.MAX_VALUE;
        int index = 0;
        int len = A.length;
        int[] presum = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            presum[i] = presum[i - 1] + A[i - 1];
        }
        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                double avg = (double)(presum[j] - presum[i - 1]) / (j - i + 1);
                if (avg < min) {
                    min = avg;
                    index = i - 1;
                    System.out.println("i, j, avg = " + i + " " + j + " "  + avg);
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Codility codility = new Codility();
        /*int result = codility.maxGap(1041);
        System.out.println(result);

        int[] input = {1, 2, 3, 4};
        int[] arr = codility.cylinder(input, 4);
        System.out.println(Arrays.toString(arr));

        int[] oddInput = {9, 3, 9, 3, 9, 7, 9};
        int unpaired = codility.unpaired(oddInput);
        System.out.println(unpaired);

        int[] minDiffInput = {1000, -1000};
        int minDiff = codility.minimalDifference(minDiffInput);
        System.out.println(minDiff);

        int[] frogRiverInput = {1, 3, 1, 4, 2, 3, 5, 4};
        int frogJump = codility.frogRiverOne(5, frogRiverInput);
        System.out.println(frogJump);

        int[] maxCounterInput = {3, 4, 4, 6, 1, 4, 4};
        int[] maxCount = codility.maxCounter(5, maxCounterInput);
        System.out.println(Arrays.toString(maxCount));

        int[] A = {-3, 3};
        int num = codility.missingInteger(A);
        System.out.println(num);

        int count = codility.countDiv(10, 10, 5);
        System.out.println(count);

        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        int[] res = codility.genomicRangeQuery("CAGCCTA", P, Q);
        System.out.println(Arrays.toString(res));

        String S = "{[()()]}";
        System.out.println(codility.distinct(S));*/

        int[] A = {4, 2, 2, 5, 1, 5, 8};
        int minAvgIndex = codility.minAvgTwoSlice(A);
        System.out.println(minAvgIndex);
    }
}
