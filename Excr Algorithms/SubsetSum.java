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

    /**
     *  From geeksforgeeks:
     * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
     * Time Complexity O(sum * n) where n is the size of the array.
     * Auxiliary Space: O(sum), as the size of the 1-D array is sum+1.
     */

    /*
    // A Dynamic Programming solution for subset
// sum problem
import java.io.*;
class GFG {

    // Returns true if there is a subset of
    // set[] with sum equal to given sum
    static boolean isSubsetSum(int set[], int n, int sum)
    {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum + 1][n + 1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in bottom
        // up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j]
                        = subset[i][j]
                          || subset[i - set[j - 1]][j - 1];
            }
        }

        return subset[sum][n];
    }

    // Driver code
    public static void main(String args[])
    {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                               + " with given sum");
        else
            System.out.println("No subset with"
                               + " given sum");
    }
}

/* This code is contributed by Rajat Mishra */


}
