
public class Merge_sort {

    public static void mergeSort3(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (high - low < 2) {
            return;
        }//there is no high
        if (high <= low) {
            return;
        }

        int middle_L = low + ((high - low) / 3);
        int middle_R = low + 2 * ((high - low) / 3) + 1;

        mergeSort(arr, low, middle_L);
        mergeSort(arr, middle_L, middle_R);
        mergeSort(arr, middle_R, high);

        merge(arr, low, middle_L, middle_R, high);
    }

    private static void merge(int[] arr, int low, int middle_L, int middle_R, int high) {
        int[] temp = new int[high - low + 1];

        int i = low, j = middle_L, k = middle_R, l = 0;

        //Comparisons between three subsets and their application in the original array in ascending order
        while ((i < middle_L) && (j < middle_R) && (k < high)) {
            if (arr[i] < arr[j]) {
                if (arr[i] < arr[k]) {
                    temp[l++] = arr[i++];
                } else {
                    temp[l++] = arr[k++];
                }
            } else {
                if (arr[j] < arr[k]) {
                    temp[l++] = arr[j++];
                } else {
                    temp[l++] = arr[k++];
                }
            }
        }

        //If we haven't finished going through all the indexes of two arrays while the third one is finished
        while ((i < middle_L) && (j < middle_R)) {
            if (arr[i] < arr[j]) {
                temp[l++] = arr[i++];
            } else {
                temp[l++] = arr[j++];
            }
        }
        while ((j < middle_R) && (k < high)) {
            if (arr[j] < arr[k]) {
                temp[l++] = arr[j++];
            } else {
                temp[l++] = arr[k++];
            }
        }
        while ((i < middle_L) && (k < high)) {
            if (arr[i] < arr[k]) {
                temp[l++] = arr[i++];
            } else {
                temp[l++] = arr[k++];
            }
        }

        //If we still haven't finished going through all the indexes of one array while we finished going through two others
        while (i < middle_L) {
            temp[l++] = arr[i++];
        }
        while (j < middle_R) {
            temp[l++] = arr[j++];
        }
        while (k < high) {
            temp[l++] = arr[k++];
        }


        if (temp.length - 1 >= 0) System.arraycopy(temp, 0, arr, low, temp.length - 1);
        /*for (int m = 0; m < temp.length-1; m++) {
            arr[low+m]=temp[m];
        }*/
    }

    public static void main(String[] args) {
        int[] data = {45, -2, -45, 78, 30, -42, 10, 19, 73, 93};
        int[] data1 = {-40, 50, 60, 8, 30, -9, 78};
        int[] data2 = {-4, 5, 6, -8, 30, -9, 78, 99, 1, -45, 43, -54, -92, 4, 66};
        int[] data3 = {1};
        mergeSort3(data);
        mergeSort3(data1);
        mergeSort3(data2);
        mergeSort3(data3);
        System.out.println("After 3 way merge sort: ");
        for (int d : data) System.out.print(d + " ");
        System.out.println();
        System.out.println("After 3 way merge sort: ");
        for (int f : data1) System.out.print(f + " ");
        System.out.println();
        System.out.println("After 3 way merge sort: ");
        for (int s : data2) System.out.print(s + " ");
        System.out.println();
        System.out.println("After 3 way merge sort: ");
        for (int p : data3) System.out.print(p + " ");
    }

}
