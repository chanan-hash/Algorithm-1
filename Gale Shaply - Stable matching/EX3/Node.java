
public class Node {
	private int data;
	 public Node left, right;
	 public int max;
	 Node(int data){
	 this.data = data;
	 this.left = null;
	 this.right = null;
	 }
	 public String toString(){return ""+data +", ";}
	 public Integer getData() {return data;}
	 public Node getLeft() {return left;}
	 public Node getRight() {return right;}
}
