import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

    public static void main(String[] args) {
        Codility codility = new Codility();
        int result = codility.maxGap(1041);
        System.out.println(result);

        int[] input = {1, 2, 3, 4};
        int[] arr = codility.cylinder(input, 4);
        System.out.println(Arrays.toString(arr));

        int[] oddInput = {9, 3, 9, 3, 9, 7, 9};
        int unpaired = codility.unpaired(oddInput);
        System.out.println(unpaired);

    }
}
