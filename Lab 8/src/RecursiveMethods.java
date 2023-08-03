import java.util.ArrayList;
import java.util.Arrays;

public class RecursiveMethods {

	// Method void printDecending(int n): that prints the numbers from n to 0.
	public static void printDescending(int n) {
		if (n < 0) { // base case, when to stop
			return;
		}
		System.out.println(n);
		printDescending(n - 1);
	}

	// Method void printAcending(int n): that prints the numbers from 0 to n.
	public static void printAscending(int n) {
		if (n < 0) {
			return;
		}
		printAscending(n - 1);
		System.out.println(n);
	}

	// Method int total(int n) that returns the total of 1+2+3+..+n
	public static int total(int n) {
		if (n == 1) {
			return 1;
		}
		return n + total(n - 1);
	}

	// Method that returns total digits
	public static int totalDigits(int n) {
		if (n < 10) {
			return 1;
		}
		return 1 + totalDigits(n / 10);
	}

	public static void reverseArray(int[] a, int i, int j) {
		if (i >= j) { // base case
			return;
		}
		int temp = a[i]; // switch bottom and top
		a[i] = a[j];
		a[j] = temp;
		reverseArray(a, i + 1, j - 1); // bottom++ and top--
	}

	public static void reverseArrayList(ArrayList<Integer> a) {
		if (a.size() <= 1) { // base case: stop recursion when the ArrayList has 1 or 0 elements
			return;
		}
		int temp = a.get(0); // swap the first and last elements
		a.set(0, a.get(a.size() - 1));
		a.set(a.size() - 1, temp);
		reverseArrayList((ArrayList<Integer>) a.subList(1, a.size() - 1));
	}

	public static void printArray(int[] x, int i) {
		if (i == x.length) { // this is the base case
			return;
		}

		System.out.println(x[i]);
		printArray(x, i + 1);
	}

	public static void main(String[] args) {
		printDescending(3);
//		printAscending(5);
//		System.out.println(total(5));
//		System.out.println(totalDigits(10));
//
		int[] x = { 9, 8, 7, 6 };
//		printArray(x, 0);
//		reverseArray(x, 0, 3);
//		System.out.println(Arrays.toString(x));
	}

}
