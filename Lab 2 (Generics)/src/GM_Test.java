
public class GM_Test {

	/*
	 * generic method called swapFirstLast, it receives a generic type array, and
	 * swaps the last element in the array with the first one.
	 */
	public static <E> E[] swapFirstLast(E[] inputArray) { // have angle brackets before return type
		// save firstElement because it will be changed
		E firstElement = inputArray[0];
		// set firstElement to last element
		inputArray[0] = inputArray[inputArray.length - 1];
		// set lastElement to original value of firstElement
		inputArray[inputArray.length - 1] = firstElement;

		return inputArray;
	}

	/*
	 * generic method called reverse, it receives a generic type array, and reverse
	 * the order of the elements in the array.
	 */
	public static <E> E[] reverse(E[] inputArray) {
		int left = 0; // leftIndex
		int right = inputArray.length - 1; // rightIndex
		while (left < right) {
			E temp = inputArray[left];
			inputArray[left] = inputArray[right];
			inputArray[right] = temp;
			left++;
			right--;
		}

		// for(int first=0,last=inputArray.length - 1;first<last;first++,last--) {
		//
		// split between sections (initialize;condition;variable update
		//
		// }

		return inputArray;
	}

	/*
	 * Generic method shift that receives an a generic type array and shifts its
	 * element one position to the left
	 */
	public static <E> E[] shift(E[] inputArray) {
		E temp = inputArray[0];
		for (int i = 0; i < inputArray.length - 1; i++) {
			inputArray[i] = inputArray[i + 1]; // shift to the left
		}
		inputArray[inputArray.length - 1] = temp; // first element will become the last element

		return inputArray;
	}

	/*
	 * Generic method print that receives a generic type array and prints its
	 * elements.
	 */
	public static <E> void print(E[] inputArray) {
		for (E element : inputArray) {
			System.out.println(element.toString());

		}
	}

	public static void main(String[] args) {
		Student[] students = new Student[3];
		students[0] = new Student(231313, "Ahmed", 3.1);
		students[1] = new Student(899849, "Hasan", 3.8);
		students[2] = new Student(93402348, "Khaled", 2.3);

		Car[] cars = new Car[4];
		cars[0] = new Car(93402348, "Honda");
		cars[1] = new Car(899849, "BMW");
		cars[2] = new Car(231313, "Nissan");
		cars[3] = new Car(3123, "Chevrolet");

		System.out.println("Array of students: ");
		print(students);
		System.out.println();
		System.out.println("Array swapFirstLast :");
		print(swapFirstLast(students));
		System.out.println();
		System.out.println("Array reverse :");
		print(reverse(students));
		System.out.println();
		System.out.println("Array shift :");
		print(shift(students));
		System.out.println();

		System.out.println("Array of cars: ");
		print(cars);
		System.out.println("Array swapFirstLast :");
		print(swapFirstLast(cars));
		System.out.println();
		System.out.println("Array reverse :");
		print(reverse(cars));
		System.out.println();
		System.out.println("Array shift :");
		print(shift(cars));
		System.out.println();

	}

}
