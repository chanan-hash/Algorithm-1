/**
 * This is an expansion for  Kadane’s algorithm, to 2D arrays using dynamic programing, meaning that we are storing our results to ease the calculation,
 * but we are allocating ,ore space of memory to save those results
 * link:
 * https://www.youtube.com/watch?v=-7poRuEvGlY&list=PL9syuH7KOKcZE0Tpg4xFR3NefsY57Aj7M&index=14
 */

public class MaximumSubMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {2, 1, -3, -4, 5},
                {0, 6, 3, 4, 1},
                {2, -2, -1, 4, -5},
                {-3, 3, 1, 0, 3}
        };

        int[][] originalMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] resultMatrix = cumulativeSumMatrix(originalMatrix);

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        int[][] sumMat = cumulativeSumMatrix(mat);
        for (int i = 0; i < sumMat.length; i++) {
            for (int j = 0; j < sumMat[0].length; j++) {
                System.out.print(sumMat[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("The maximum sum is: " + maxSumSubMatrix(mat));

        int[][] matrix =
                {
                        { -5, -6, 3, 1, 0 },
                        { 9, 7, 8, 3, 7 },
                        { -6, -2, -1, 2, -4 },
                        { -7, 5, 5, 2, -6 },
                        { 3, 2, 9, -5, 1 }
                };
        System.out.println("The maximum sum is: " + maxSumSubMatrix(matrix));

    }

    public static int[][] cumulativeSumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Create a new matrix filled with zeros
        int[][] result = new int[rows][cols];

        // Initialize the first cell with the value from the original matrix
        result[0][0] = matrix[0][0];

        // Fill the first row of the result matrix
        for (int j = 1; j < cols; j++) {
            result[0][j] = result[0][j - 1] + matrix[0][j];
        }

        // Fill the first column of the result matrix
        for (int i = 1; i < rows; i++) {
            result[i][0] = result[i - 1][0] + matrix[i][0];
        }

        // Fill the rest of the result matrix
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1] - result[i - 1][j - 1] + matrix[i][j];
            }
        }

        return result;
    }

    // Need to be updated
    public static int maxSumSubMatrix(int[][] mat){
        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;
        int[][] H = cumulativeSumMatrix(mat); // O(n^2)
        for (int i = 1; i < H.length; i++) { // O(n^4)
            for (int j = 1; j < H[i].length; j++) {
                for (int k = i; k < H.length ; k++) {
                    for (int l = j; l < H[i].length; l++) {
                        curr_sum = H[k][l] - H[k][l-1] - H[k-1][l] + H[k-1][l-1]; // for matrix (i,j)-(k-l), all kinds of middle matrices, that don;t start form (0,0)
                        // S[j+1][n+1] – S[j+1][m] – S[i][n+1] + S[i][m]
                        if (curr_sum > max_sum){
                            max_sum = curr_sum;
                        }
                    }
                }
            }
        }
        return max_sum;
    }

}

/* another solution complexity O(n^4)
form:
https://www.techiedelight.com/find-maximum-sum-submatrix-present-given-matrix/

import java.util.ArrayList;
import java.util.List;

class Main
{
    // Find the maximum sum submatrix present in a given matrix
    public static int findMaxSumSubmatrix(int[][] matrix)
    {
        // base case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        // `M × N` matrix
        int M = matrix.length;
        int N = matrix[0].length;

        // `S[i][j]` stores the sum of submatrix formed by row 0 to `i-1`
        // and column 0 to `j-1`
        int[][] S = new int[M+1][N+1];

        // preprocess the matrix to fill `S`
        for (int i = 0; i <= M; i++)
        {
            for (int j = 0; j <= N; j++)
            {
                if (i == 0 || j == 0) {
                    S[i][j] = 0;
                }
                else {
                    S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] +
                            matrix[i-1][j-1];
                }
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int rowStart = 0, rowEnd = 0, colStart = 0, colEnd = 0;

        // consider every submatrix formed by row `i` to `j`
        // and column `m` to `n`
        for (int i = 0; i < M; i++)
        {
            for (int j = i; j < M; j++)
            {
                for (int m = 0; m < N; m++)
                {
                    for (int n = m; n < N; n++)
                    {
                        // calculate the submatrix sum using `S[][]` in O(1) time
                        int submatrix_sum = S[j+1][n+1] - S[j+1][m]
                                - S[i][n+1] + S[i][m];

                        // if the submatrix sum is more than the maximum found so far
                        if (submatrix_sum > maxSum)
                        {
                            maxSum = submatrix_sum;
                            rowStart = i;
                            rowEnd = j;
                            colStart = m;
                            colEnd = n;
                        }
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = rowStart; i <= rowEnd; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = colStart; j <= colEnd; j++) {
                row.add(matrix[i][j]);
            }
            result.add(row);
        }

        System.out.println("The maximum sum submatrix is " + result);
        return maxSum;
    }

    public static void main(String[] args)
    {
        // input matrix
        int[][] mat =
        {
            { -5, -6, 3, 1, 0 },
            { 9, 7, 8, 3, 7 },
            { -6, -2, -1, 2, -4 },
            { -7, 5, 5, 2, -6 },
            { 3, 2, 9, -5, 1 }
        };

        // find the maximum sum submatrix
        System.out.print("The maximum sum is " + findMaxSumSubmatrix(mat));
    }
}

 */

    /* Naive solution from geekstogeeks
    https://www.geeksforgeeks.org/maximum-sum-submatrix/
    complexity O(n^6)

    import java.util.*;
class GFG
{

// Function to find maximum sum submatrix
static void maxSubmatrixSum(int[][] matrix)
{

    // Stores the number of rows
    // and columns in the matrix
    int r = matrix.length;
    int c = matrix[0].length;

    // Stores maximum submatrix sum
    int maxSubmatrix = 0;

    // Take each row as starting row
    for (int i = 0; i < r; i++) {

        // Take each column as the
        // starting column
        for (int j = 0; j < c; j++) {

            // Take each row as the
            // ending row
            for (int k = i; k < r; k++) {

                // Take each column as
                // the ending column
                for (int l = j; l < c; l++) {

                    // Stores the sum of submatrix
                    // having topleft index(i, j)
                    // and bottom right index (k, l)
                    int sumSubmatrix = 0;

                    // Iterate the submatrix
                    // row-wise and calculate its sum
                    for (int m = i; m <= k; m++) {
                        for (int n = j; n <= l; n++) {
                            sumSubmatrix += matrix[m][n];
                        }
                    }

                    // Update the maximum sum
                    maxSubmatrix
                        = Math.max(maxSubmatrix,
                              sumSubmatrix);
                }
            }
        }
    }

    // Print the answer
    System.out.println(maxSubmatrix);
}

// Driver Code
public static void main(String[] args)
{
    int[][] matrix = { { 0, -2, -7, 0 },
                        { 9, 2, -6, 2 },
                        { -4, 1, -4, 1 },
                        { -1, 8, 0, -2 } };

    maxSubmatrixSum(matrix);
}
}

// This code is contributed by susmitakundugoaldanga.

     */
