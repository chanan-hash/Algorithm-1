import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int[][] mat = new int[5][5];
        BFS_update(mat);
        System.out.println(Arrays.deepToString(mat));
    }


    public static void BFS_update(int[][] mat) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(mat[0][0]);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            // adding condition for not getting out of bounds
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    // trying to handle the out of bounds
                    if ((i != 0 || j != 0) && (Math.abs(i) + Math.abs(j) < 2)) {
                        if (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length) {
                            mat[x + i][x + j] += 1;
                            queue.add(mat[x + i][x + j]);
                        }
                    }
                }
            }
        }
    }
}
