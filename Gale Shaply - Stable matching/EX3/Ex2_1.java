import java.util.ArrayList;
import java.util.Arrays;

public class Ex2_1 {
public static void main(String[] args) {
		
	Point [] points =new Point [9] ;
	points[0]=new Point(7,2);
	points[1]=new Point(1,4);
	points[2]=new Point(2,6);
	points[3]=new Point(3,1);
	points[4]=new Point(5,7);
	points[5]=new Point(8,6);
	points[6]=new Point(9,3);
	points[7]=new Point(6,9);
	points[8]=new Point(4,5);
	

	maxima(points);
		
	
	}
	

	public static ArrayList<Point> maxima(Point[] points) {//O(nlogn)
		int minX =Integer.MIN_VALUE;
		mergeSort(points);//O(nlogn)
		ArrayList<Point> maxima=new ArrayList<Point>();
		for (int i =points.length-1 ; i > 0; i--) {//O(n)
			if(points[i].x()>minX) {
				maxima.add(points[i]);
				minX =(int) points[i].x();
			}
		}
		for (int i = 0; i < maxima.size(); i++) {
            System.out.println("Point " + i + ": (" + maxima.get(i).x() + ", " + maxima.get(i).y() + ")");
        }
		
			
		
	    


		return maxima;

}
	public static void mergeSort(Point[] arr) {//O(nlogn)
		int length=arr.length;
		if(length<=1) {return;}

		int middle=length/2;
		Point[] left = new Point [middle];
		Point[] right = new Point [length-middle];

		int i=0;//left
		int j=0;//right
		for ( ; i < length; i++) {
			if(i < middle) {
				left[i]=arr[i];
			}
			else{
				right[j]=arr[i];
				j++;
			}

		}

		mergeSort(left);


		mergeSort(right);

		merge(left,right,arr);


	}
	public static void merge(Point[] left,Point[] right , Point[] arr) {
		int Lleft=arr.length/2;
		int Lright=arr.length-Lleft;
		int i=0 ,l=0,r=0;
		while(l<Lleft&&r<Lright) {
			if(left[l].y()==right[r].y()) {
				if(left[l].x()<right[r].x()) {
				arr[i] = left[l];
				i++;
				l++;
				}
			}
			else if(left[l].y()<right[r].y()) {
				arr[i] = left[l];
				i++;
				l++;
			}
			else {
				arr[i] = right[r];
				i++;
				r++;
			}
		}
		while(l<Lleft) {
			arr[i]=left[l];
			i++;
			l++;

		}
		while(r<Lright) {
			arr[i]=right[r];
			i++;
			r++;

		}

	}
}

