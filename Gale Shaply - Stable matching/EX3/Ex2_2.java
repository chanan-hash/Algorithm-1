import java.util.Arrays;

public class Ex2_2 {

	public static void main(String[] args) {
		// test case of values
		int[] data = {45, -2, -45, 78, 30, -42, 10, 19, 73, 93};
		mergeSort3(data);
		System.out.println("After 3 way merge sort: ");
		for (int d : data) System.out.print(d + " ");
	}
	public static void mergeSort3(int[] arr){//O(nlogn)
		int length=arr.length;
		if(length<=1) {return;}
		int part=(length+2)/3;
		int [] left = new int [part];
		int [] middle = new int [part];
		int [] right = new int [length-2*part];

		int i=0;//left
		int j=0;//right
		int m=0;//middle
		for ( ; i < length; i++) {
			if(i < part) {
				left[i]=arr[i];
			}
			else if((i >= part&&i<2*part))
			{
				middle[m]=arr[i];
				m++;
			}
			else {
				right[j]=arr[i];
				j++;

			}
		}
		mergeSort3(left);

		mergeSort3(middle);

		mergeSort3(right);

		merge3(left,right,middle , arr);



	}

	public static void merge3(int[] left, int[] middle, int[] right, int[] result) {//O(n)
		int l = 0, m = 0, r = 0, i = 0;

		while (l < left.length || m < middle.length || r < right.length) {//As long as we haven't gone through all the arrays
			//sum the diffrent lengths is arr.length so O(n)
			int min = Integer.MAX_VALUE;//parameter for comparison

			if (l < left.length) {min = Math.min(min, left[l]);}//O(1)
			if (m < middle.length) {min = Math.min(min, middle[m]);}//O(1)
			if (r < right.length) {min = Math.min(min, right[r]);}//O(1)

			result[i] = min;//The smallest value compared to all arrays

			//As long as we have not exceeded the size of the array and the value
			//in the array is also chosen to be min, advance the index
			if (l < left.length && left[l] == min) {l++;} //O(1)
			if (m < middle.length && middle[m] == min) {m++;}//O(1)
			if (r < right.length && right[r] == min) {r++;}//O(1)

			i++;//Advance the pointer in the original array
		}
	}
}





