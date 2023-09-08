/**
 * BY a given array and a number, we want to see if we can combine this number form the numbers in the array.
 * By using dynamic programing we're going to reduce the running time (complexity) from O(2^n) to....
 * link:
 * https://www.youtube.com/watch?v=6CyBUAetXhk&list=PL9syuH7KOKcZE0Tpg4xFR3NefsY57Aj7M&index=15
 */
public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int sum = 7;
        System.out.println(subsetSum(arr, arr.length, sum));
    }

    // Complexity O(2^n) --> going over all the subset we have
    public static boolean subsetSum(int[] arr, int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) { // sum != 0
            return false;
        }
        return subsetSum(arr, n - 1, sum) || subsetSum(arr, n - 1, sum - arr[n - 1]);
    }
}
