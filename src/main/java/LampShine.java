public class LampShine {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0) return 0;

        int counts = 0;
        int len = A.length;
        boolean[] turnOns = new boolean[len];
        int index = 0;

        for (int i = 0; i < len; i++) {
            int position = A[i] - 1;
            turnOns[position] = true;
            boolean allShine = true;
            for (int j = index; j < position; j++) {
                if (! turnOns[j]) {
                    allShine = false;
                    break;
                }
            }
            if (allShine) {
                index = position + 1;
                counts ++;
            }
        }

        return counts;
    }

    public static void main(String[] args) {
        LampShine test = new LampShine();
        int[] input = {2, 1, 3, 5, 4};
        int times = test.solution(input);
        System.out.println(times);
    }
}
