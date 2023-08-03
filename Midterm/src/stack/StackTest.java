package stack;

public class StackTest {

	public static void swapLastBottom(LinkedStack<Integer> stack) {
		Integer topBefore = stack.pop();

		LinkedStack<Integer> ts = new LinkedStack<>();

		while (stack.size() > 1) {
			ts.push(stack.pop());
		}

		Integer topAfter = stack.pop();

		stack.push(topBefore);
		while (!ts.isEmpty()) {
			stack.push(ts.pop());
		}
		stack.push(topAfter);

	}


	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		// to print stack
//		while(!stack.isEmpty()) {
//			System.out.println(stack.pop());
//		}
		
		swapLastBottom(stack);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}
}