
public class Ex2_3 {

	public static void main(String[] args) {
		Queue2Stacks q = new Queue2Stacks();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		System.out.println(q.deQueue());
		q.enQueue(4);
		while(q.size() > 0) {
			System.out.print(q.deQueue() + ", ");
			System.out.print(q.deQueue() + ", ");
			System.out.println(q.deQueue() + ", ");
		}
	}

}


