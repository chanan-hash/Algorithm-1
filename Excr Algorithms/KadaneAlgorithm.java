/**
 * This class in an implementation for finding Max Subarray.
 * By a given array of numbers we want to find the Max Subarray.
 * We will do it by using Divide & conquer method
 * operating it on the left side, right side and the addition of them, to get it on middle of the array also.
 * Complexity of O(n))
 *
 * This algorithm i s based on Kadane's algorithm, using 'dynamic programing' -
 * means, that we are saving the calculation every time, and reducing the run but, it using more space complexity
 *
 * This is according to the video in the link below:
 * https://www.youtube.com/watch?v=QE6xm31goN0&list=PL9syuH7KOKcZE0Tpg4xFR3NefsY57Aj7M&index=11
 */

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2, -5, 6, -2, -3, 1, 5, -6};
        int[] array = {1, -5, 7, 2, -3, -5 , 10, -7, -5, 9};
        System.out.println(kadanes(arr));
        System.out.println(kadanes(array));
    }

    public static int kadanes(int[] arr) {
        int[] local_maximum = new int[arr.length];
        int max = arr[0];
        local_maximum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            local_maximum[i] = Math.max(arr[i], arr[i] + local_maximum[i - 1]); // Or the number itself as a subArray, or the sum till it plus itself
            if (local_maximum[i] > max) {
                max = local_maximum[i];
            }
        }
        return max;
    }
}
