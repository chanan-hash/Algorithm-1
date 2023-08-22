import java.util.Stack;

public class Queue2Stacks {
	Stack  <Integer>  stack1, stack2;
	int  size;
	public Queue2Stacks (){
		this.stack1= new Stack<Integer>();
		this.stack2=new Stack<Integer>();
	}
	// Function to enqueue an item to the queue O(1).
	public void enQueue(int x) {
		stack1.add(x);
		size++;
		stack2.add(stack1.pop());
		
	}
	
	// Function to deQueue an item from queue O(N) in general
	public int deQueue() {
		while(!stack1.isEmpty()) {
			stack2.add(stack1.pop());
		}
		size--;
		return stack2.remove(0);
	}
	// Function returns true if the queue is empty,
	// otherwise it returns false.
	public boolean isEmpty(){// O(1).

		return stack2.size()==0;
	} 
	// Function returns the number of items, stored in the queue.
	public int size(){// O(1).

		return this.size;

	}

}


