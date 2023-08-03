public class Test {

	public static void main(String[] args) {
		LinkedQueue<Character> q1 = new LinkedQueue<>();

		Stack<Integer> stackInt = new LinkedStack<Integer>();
		stackInt.push(10);
		stackInt.push(20);
		stackInt.push(40);
		stackInt.push(30);
		System.out.println("searchStack: " + recursivesearchStack(stackInt, 10));
		System.out.println(postfix("57+"));
	}

//	 searchStack(Stack s, E e) that receives a stack and an element e, it
//	 returns true if the element e is in the stack, otherwise it returns false. The order of the elements in
//	 the stack should not be changed, (hint: use temporary stack). 

	public static <E> boolean searchStack(Stack<E> s, E e) {

		// create a temporary stack
		Stack<E> tmpStack = new LinkedStack<E>();
		// boolean variable for found
		boolean found = false;

		// while s is not empty
		while (!s.isEmpty()) {

			// if top element of s equalls the target then exit for loop and set found to
			// equal
			if (s.top().equals(e)) {
				found = true;
				break; // break if the top equals this
			}

			// if not then add it to tempStack and remove from s (pop it)
			tmpStack.push(s.pop()); // need to push because we need a different top
		}

		while (!tmpStack.isEmpty())
			s.push(tmpStack.pop());

		// return found
		return found;
	}

	// very similar
	public static <E> boolean remove(Stack<E> s, E e) {
		// create a temporary stack
		Stack<E> tmpStack = new LinkedStack<E>();
		boolean found = false;

		// while s is not empty
		while (!s.isEmpty()) {

			// if top equals e pop it
			if (s.top().equals(e)) {
				found = true;
				s.pop();
				break;
			}

			// otherwise push
			tmpStack.push(s.pop());
		}
		while (!tmpStack.isEmpty())
			s.push(tmpStack.pop());
		return found;
	}

	public static <E> boolean searchQueue(Queue<E> q, E e) {
		Queue<E> tmp = new LinkedQueue<E>();
		boolean found = false;
		while (!q.isEmpty()) {
			if (q.first().equals(e)) {
				found = true;
				break;
			}
			tmp.enqueue(q.dequeue()); // check
		}
		while (!tmp.isEmpty())
			q.enqueue(tmp.dequeue());
		return found;
	}

	// can reverse an array similarly
	public static <E> void reverseQueue(Queue<E> q) {

		Stack<E> tmpStack = new LinkedStack<E>();
		while (!q.isEmpty())
			tmpStack.push(q.dequeue());
		while (!tmpStack.isEmpty())
			q.enqueue(tmpStack.pop());
	}

	// remove even from stack
	public static <E> void removeEven(Stack<Integer> s) {
		// create temp stack
		Stack<Integer> tmp = new LinkedStack<Integer>();

		// while s is not empty
		while (!s.isEmpty()) {
			// if not even
			if (s.top() % 2 != 0)
				// add to temp stack
				tmp.push(s.pop());
			else
				// just remove otherwise
				s.pop();
		}
		// put it back
		while (!tmp.isEmpty())
			s.push(tmp.pop());
	}

	public static <E> boolean recursivesearchStack(Stack<E> s, E e) { // recursive methods for searching
		if (s.isEmpty()) // if empty return false
			return false;

		if (s.top().equals(e)) // if found, return true
			return true;

		E t = s.pop(); // have top in a variables
		boolean found = recursivesearchStack(s, e); // have found in a variable
		s.push(t); // keep pushing top
		return found; // return found value
	}

	public static double postfix(String s) {
		Stack<Double> st = new LinkedStack<Double>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				double x = c - '0';
				st.push(x);
				// st.push((double) c);
			} else {
				double val1 = st.pop();
				double val2 = st.pop();
				switch (c) {
				case '+':
					st.push(val1 + val2);
					break;
				case '-':
					st.push(val1 - val2);
					break;
				case '*':
					st.push(val1 * val2);
					break;
				case '/':
					st.push(val1 / val2);
					break;
				}
			}
		}
		return st.pop();
	}
}