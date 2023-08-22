
public class Point {
	private final double x, y;
	 public Point (double x, double y){
	 this.x = x;
	 this.y = y;
	 }
	 public double x() {return this.x;}
	 public double y() {return this.y;}
	 public String toString() {
	 return " [" + this.x + "," + this.y+"]";
	 }
	 public boolean equals(Point p){
	 return p.x==this.x && p.y==this.y;
	 }
}
