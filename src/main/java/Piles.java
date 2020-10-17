import java.io.*;
import java.util.ArrayList;

class Piles {
    public ArrayList<Integer> split(ArrayList<Integer> heights, int max) {
        ArrayList<Integer> resHeights = new ArrayList<>();
        for (int height : heights) {
            if (height > max) {
                ArrayList<Integer> tmp = new ArrayList<>();
                int n1 = height / 2;
                int n2 = height - n1;
                tmp.add(n1);
                tmp.add(n2);
                resHeights.addAll(split(tmp, max));
            } else {
                resHeights.add(height);
            }
        }
        return resHeights;
    }

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int starting_stack_size = Integer.parseInt(inputs[0]);
        int max_stable_height = Integer.parseInt(inputs[1]);
        int partition = Integer.parseInt(inputs[2]);

        Piles solution = new Piles();

        // TODO: Implement your logic here
        int actual_partition = 0;
        if (starting_stack_size < partition) {
            actual_partition = starting_stack_size;
        } else {
            int avgHeight = starting_stack_size / partition;
            int maxHeight = avgHeight + 1;
            int maxNum = starting_stack_size % partition;
            ArrayList<Integer> heights = new ArrayList<>();
            for (int i = 0; i < maxNum; i++) {
                heights.add(maxHeight);
                System.out.print(maxHeight + " ");
            }
            for (int i = maxNum; i < partition; i++) {
                heights.add(avgHeight);
                System.out.print(avgHeight + " ");
            }

            actual_partition = solution.split(heights, max_stable_height).size();
        }

        System.out.println(actual_partition);
    }
}
