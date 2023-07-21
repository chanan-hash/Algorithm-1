public class Node {

    Integer val;
    Node next;

    public Node(Integer key, Node next) {
        this.val = key;
        this.next = next;
    }

    public Node(Integer data) {
        this.val = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
