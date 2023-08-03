import java.util.Arrays;

public class ArrayMethods {

	// Method to check if two arrays are equal
	public static boolean equal(int[] a, int[] b) {
		if (a.length != b.length)
			return false;
		for (int i = 0; i < a.length; i++) { // go through array a and return false if not mathc
			if (a[i] != b[i]) {
				return false;
			}
		}

		// can use Arrays.equals(Array1, Array2);

		return true;
	}

	// Method to check if two arrays have the same elements regardless of their
	// positions
	public static boolean sameElements(int[] a, int[] b) {
		if (a.length != b.length) {
			return false;
		}

		// Sort the arrays is the best option
		Arrays.sort(a);
		Arrays.sort(b);
		// Check if the sorted arrays are equal
		return Arrays.equals(a, b);
	}

	//remove duplicate :
	// go through array and have boolean isduplicate. go thorugh array again. if not duplicate then add to unique array
	
	
	// Main method to test the class
	public static void main(String[] args) {
	}
}
