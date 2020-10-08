package temp;

import java.util.ArrayList;

public class Neighbourhood {
    private ArrayList<int[]> locations = new ArrayList<>();
    int count = 0;

    public int countNeighbourhoods(int[][] A) {
        int x = A.length;
        int y = A[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (A[i][j] == 1) {
                    int[] location = {i, j};
                    locations.add(location);
                }
            }
        }

        findNeighbourhood(locations.get(0), locations);

        return count;
    }

    private void findNeighbourhood(int[] restaurant, ArrayList<int[]> locations) {
        if (locations.size() == 0) {
            count++;
            return;
        }
        locations.remove(restaurant);
        int x = restaurant[0];
        int y = restaurant[1];
        for (int[] location : locations) {
            int i = location[0];
            int j = location[1];
            if (Math.abs(x - i) <=1 && Math.abs(y - j) <= 1) {
                findNeighbourhood(location, locations);
                break;
            }
        }
        count++;
    }

    public static void main(String[] args) {
        Neighbourhood solution = new Neighbourhood();
        int[] l1 = {1, 1, 0, 0, 0};
        int[] l2 = {0, 1, 0, 0, 1};
        int[] l3 = {1, 0, 0, 0, 0};
        int[] l4 = {0, 0, 0, 0, 0};
        int[] l5 = {0, 1, 0, 0, 1};
        int[][] metrix = {l1, l2, l3, l4, l5};
        int answer = solution.countNeighbourhoods(metrix);
        System.out.println(answer);
    }
}
