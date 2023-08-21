package EX3;

public class main {
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
        String path = maxSumPath(bt);
        System.out.println("max sum path = " + path);

        BinaryTree bt1 = new BinaryTree(new Node(1));
        Node root1 = bt1.getRoot();
        root1.left = new Node(2);
        root1.left.left = new Node(20);
        root1.left.right = new Node(12);
        root1.left.right.left = new Node(3);
        root1.left.right.right = new Node(0);
        root1.right = new Node(4);

        String path1 = maxSumPath(bt1);
        System.out.println("max sum path2 = " + path1);
    }


    public static String maxSumPath(BinaryTree tree) {//O(n)
        if (tree.getRoot() == null) {
            return "";
        }
        return "" + maxSumPath(tree.getRoot());
    }


    public static int maxSumPath(Node bt) {
		if (bt == null) {
			return 0;
		}
		if (bt.left == null) {
			System.out.print("R, ");
			return bt.getData() + maxSumPath(bt.getRight());
		}
		if (bt.right == null) {
			System.out.print("L, ");
			return bt.getData() + maxSumPath(bt.getLeft());
		}
		int leftP = bt.getData() + maxSumPath(bt.getLeft());
		int rightP = bt.getData() + maxSumPath(bt.getRight());
		if (leftP > rightP) {
//            System.out.print("L, ");
			return leftP;
		} else {
//            System.out.print("R, ");
			return rightP;
		}
//        return bt.getData() + Math.max(maxSumPath(bt.getLeft()),
//                maxSumPath(bt.getRight()));
//    }
	}

    public static int maxSumPathLeft(Node bt) {
        if (bt.left == null) {
            return 0;
        }
        if (bt.left == null) {
            //	System.out.print("R");

            return bt.getData() + maxSumPath(bt.getRight());
        }
        if (bt.right == null) {
            //	System.out.print("L");
            return bt.getData() + maxSumPath(bt.getLeft());
        }
        return bt.getData() + Math.max(maxSumPath(bt.getLeft()),
                maxSumPath(bt.getRight()));
    }
}

