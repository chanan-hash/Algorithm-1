/**
 * This class in an implementation for finding Counting Inversion.
 * By a given array of numbers we want to find the Inversions:
 * Inversion - every time the index i < j, but Arr[i] > Arr[j]
 * exmp, arr =[38,27,43,3,9,82,10]
 * '27', is in index 1, and '3' in index 3
 * 1 < 3 (i <j ), but 27 > 3 (Arr[i] > Arr[j]).
 *
 * Counting inversion in the array, can tell us how much is it sorted already
 *  IF it equals to 0, menas the array is sorted, and if it equals to the '2n' (arr.length*2) means it sorted in the opposite way
 *  We will do it by updating the idea of mergeSort
 * operating it on the left side, right side and the addition of them, to get it on middle of the array also.
 * Complexity of O(nlog(n))
 *
 * This is according to the video in the link below:
 * https://www.youtube.com/watch?v=L_k9_bBFidA&list=PL9syuH7KOKcZE0Tpg4xFR3NefsY57Aj7M&index=3
 */

public class CountingReverse {
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println(CountingInversion(array,0,array.length-1));
    }

    // complexity // O(nlog(n))
    public static int CountingInversion(int[] arr, int L, int R) {
        int count = 0;
        if (L < R) {
            // finding mid
            int M = (L + R) / 2;
            // finding number of inversion on the left side
            int A_L = CountingInversion(arr, L, M); // O(log(n))
            // the same on the right side
            int A_R = CountingInversion(arr, M + 1, R); // O(log(n))

            // O(n)
            int A_M = merge(arr, L, M, R); // merging two sorted arrays, and counting also inversion from left side to right side

            count = A_L + A_M + A_R;
        }
        return count;
    }
    /**
     * We added in the regular merge function, a counter for the inversion.
     * each time the we adding the left side before the right side, means we have an inversion
     * (because we are actually working on the sane array bud dividing it to two part, so it will be like "two arrays").
     */
    public static int merge(int[] a, int l, int m, int h) {
        int countInv = 0;
        int a1[] = new int[m - l + 1];
        int a2[] = new int[h - m];

        // fill the left and right array
        for (int i = 0; i < a1.length; i++) {
            a1[i] = a[l + i];
        }
        for (int j = 0; j < a2.length; j++) {
            a2[j] = a[m + 1 + j];
        }

        int i = 0; // left side
        int j = 0; // right side
        int k = l;

        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                a[k++] = a1[i++];
            } else {
                a[k++] = a2[j++];
                countInv++; // means left side is bigger than right side
            }
        }
        while (i < a1.length) {
            a[k++] = a1[i++];
        }
        while (j < a2.length) {
            a[k++] = a2[j++];
            countInv++; // according to the other big numbers from the left side
        }
        return countInv;
    }
}