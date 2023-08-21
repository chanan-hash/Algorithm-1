import java.util.Arrays;

/**
 * This class in an implementation for finding Max Subarray.
 * By a given array of numbers we want to find the Max Subarray.
 * We will do it by using Divide & conquer method
 * operating it on the left side, right side and the addition of them, to get it on middle of the array also.
 * Complexity of O(nlog(n))
 *
 * This is according to the video in the link below:
 * https://www.youtube.com/watch?v=PgU85hgtUeo&list=PL9syuH7KOKcZE0Tpg4xFR3NefsY57Aj7M&index=2
 */

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, -5, 6, -2, -3, 1, 5, -6};

        // need to be 3 in all of permutations
        System.out.println(max3(1,2,3));
        System.out.println(max3(3,2,1));
        System.out.println(max3(2,1,3));
        System.out.println(max3(3,1,2));
        System.out.println(max3(1,3,2));
        System.out.println(max3(2,3,1));

        System.out.println("\n" + MaxCrossingSum(arr,arr.length/2));

    }

    // O(n)
    public static int MaxCrossingSum(int[] arr, int mid){
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = mid; i > 0 ; i--) {
            sum += arr[i];
            if (sum > left_sum){
                left_sum = sum;
            }
        }
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = mid; i < arr.length ; i++) {
            sum += arr[i];
            if (sum > right_sum){
                right_sum = sum;
            }
        }
        //return max3(left_sum,right_sum,left_sum+right_sum);
        return max3(right_sum + left_sum - arr[mid],right_sum,left_sum);
    }

    // Returning the maximum from 3 given numbers
    public static int max3(int n1, int n2, int n3){
        int temp = Math.max(n1,n2);
        return Math.max(temp,n3);
    }

    public static int MaxSubArr(int[] arr){ // O(nlog(n))
        if (arr.length == 1){
            return arr[0];
        }
        int mid = arr.length/2;
        int maxL = MaxSubArr(System.arraycopy(arr, 0, arr, mid, mid)); // O(log(n))
        int maxR = MaxSubArr(System.arraycopy(arr, mid, arr, arr.length-1, mid)); // O(log(n))
        int maxM = MaxCrossingSum(arr,mid); // O(n)
        return max3(maxM,maxL,maxR);
    }
}
