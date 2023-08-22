import java.util.ArrayList;

public class Ex2_4 {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(new Node(6));
		Node root = bt.getRoot();
		root.left = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right = new Node(9);
		root.right.right = new Node(11);
		root.right.left = new Node(7);
		root.right.left.left = new Node(13);
		ArrayList<String> pathRL =new ArrayList<>();
		maxSum(bt.getRoot());
		String path = maxSumPath(bt,pathRL);
		System.out.println();
		System.out.println("max sum path = "+path);
	//	System.out.println(pathRL);
		String s= "";
		for (int i = 0; i < pathRL.size(); i++) {
			s=s+pathRL.get(i);
		}
		System.out.println("path:"+ s);
	}
	

	public static int maxSum(Node bt) {
		if(bt==null) {
			return 0;
		}
		bt.max = bt.getData() + Math.max(maxSum(bt.left), maxSum(bt.right));
		return bt.max;
	}

	static String maxSumPath(BinaryTree tree,ArrayList<String> pathRL) {//O(n)
		if(tree.getRoot()==null) {
			return "";
		}
		return "" + maxSumPath(tree.getRoot(),pathRL);
	}

	
	
	public static int maxSumPath(Node bt,ArrayList<String> pathRL) {
		if(bt==null) {
			return 0;
		}
		if(bt.left==null && bt.right==null) {
			return bt.getData();
		}
		if(bt.left==null) {
			pathRL.add("R");
			return bt.getData()+maxSumPath(bt.getRight(),pathRL);
		}
		if(bt.right==null) {
			pathRL.add("L");
			return bt.getData()+maxSumPath(bt.getLeft(),pathRL);
		}
		if(bt.left.max> bt.right.max) {
			pathRL.add("L");
			return bt.getData()+maxSumPath(bt.getLeft(),pathRL);
		}
		pathRL.add("R");
		return bt.getData()+maxSumPath(bt.getRight(),pathRL);
	}
}




