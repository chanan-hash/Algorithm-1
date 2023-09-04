/**
 * Longest Common Subsequence - using dynamic programing.
 * Ths sub string doesn't have to be continuous
 * link:
 * https://www.youtube.com/watch?v=uR989dBauaM&list=PL9syuH7KOKcZE0Tpg4xFR3NefsY57Aj7M&index=12
 */

public class LCS {

    //Naive way, we will first find the length of the longest common substring
    public static int LCS(String X, String Y) {
        if (X.length() == 0 || Y.length() == 0) {
            return 0;
        }
        if (X.charAt(0) == Y.charAt(0)) {
            return LCS(X.substring(1), Y.substring(1));
        }
        return Math.max(LCS(X.substring(1), Y), LCS(X, Y.substring(1)));
    }

    // from geeksforgeeks: complexity O(m * n)
    // https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/

    /*package whatever //do not write package name here */
    /*
    import java.io.*;

    class GFG {

        // A Top-Down DP implementation of LCS problem

        // Returns length of LCS for X[0..m-1], Y[0..n-1]
        static int lcs(String X, String Y, int m, int n,
                       int[][] dp)
        {

            if (m == 0 || n == 0)
                return 0;

            if (dp[m][n] != -1)
                return dp[m][n];

            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                dp[m][n] = 1 + lcs(X, Y, m - 1, n - 1, dp);
                return dp[m][n];
            }

            dp[m][n] = Math.max(lcs(X, Y, m, n - 1, dp),
                    lcs(X, Y, m - 1, n, dp));
            return dp[m][n];
        }

        // Drivers code
        public static void main(String args[])
        {

            String X = "AGGTAB";
            String Y = "GXTXAYB";

            int m = X.length();
            int n = Y.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i < m + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    dp[i][j] = -1;
                }
            }

            System.out.println("Length of LCS is "
                    + lcs(X, Y, m, n, dp));
        }
    }

// This code is contributed by shinjanpatra


     */

}
