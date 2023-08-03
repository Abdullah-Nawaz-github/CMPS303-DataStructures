import java.util.Arrays;

public class ArrayMethods {

	// take two arrays and return if arrays are equal or not
	public static boolean equal(int a[], int b[]) {
		// automatically false if length is not equal
		if (a.length != b.length) {
			return false;
		}

		// iterate over one array and compare a[i] with b[i]. return false if not same
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}

		// otherwise return true
		return true;
	}

	// check if arrays have save elements or not
	public static boolean sameElements(int a[], int b[]) {
		// automatically false if length is not equal
		if (a.length != b.length) {
			return false;
		}

		// iterate over one array
		for (int i = 0; i < a.length; i++) {

			// declare boolean variable found
			boolean found = false;

			// go through second array
			for (int j = 0; j < b.length; j++) {
				// if an element of second array equals a[i], then found is true
				if (a[i] == b[j]) {
					found = true;
					break; // exits for loop
				}
			}

			// return false if not found
			if (!found) {
				return false;
			}
		}

		return true;
	}

	public static int[] removeDuplicate(int x[]) {

		// have index for result array
		int count = 0;
		// create a result array
		int[] result = new int[x.length]; // create temp array makes problems easier

		// go through the array
		for (int i = 0; i < x.length; i++) {
			// have boolean for found
			boolean found = false;
			// go through result array and check if it exists there
			for (int j = 0; j < result.length; j++) {
				if (result[j] == x[i]) {
					found = true;
					break;
				}
			}

			// does not exist in result array so add it and increment index of result array
			if (!found) {
				result[count] = x[i];
				count++;
			}
		}

		// need new array to be the correct size so create result 2 with count length
		int[] result2 = new int[count];
		// copy elements
		for (int i = 0; i < count; i++) {
			result2[i] = result[i];
		}

		// return result2
		return result2;

	}

	public static void main(String[] args) {
		int[] x = { 3, 2, 5, 3, 2, 2 };
		int[] y = { 3, 2, 5, 2, 3, 2 };
		System.out.println(equal(x, y));
		System.out.println(sameElements(x, y));
		removeDuplicate(x);
		System.out.println(Arrays.toString(removeDuplicate(x)));

	}

}
