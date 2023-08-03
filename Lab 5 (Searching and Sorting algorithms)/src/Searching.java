import java.util.Arrays;
import java.util.Random;

public class Searching {

	public static void main(String[] args) {
		
		/*
		 * Linear Search : (time in ns)
		 *  1000 : 18987
		 *  100000 : 640513
		 *  500000 : 4988593
		 *  1000000 : 5448807
		 */
		
		/*
		 * Binary Search :
		 *  1000 : 18987
		 *  100000 : 640513
		 *  500000 : 8639
		 *  1000000 : 12133
		 */
		
		
		Random random = new Random();
		int[] x = new int[500000];
		for (int i = 0; i < x.length; i++) {
			x[i] = random.nextInt(1000);
		}
		
		long start = System.nanoTime();
		linearSearch(x,2000);
		long end = System.nanoTime();
		System.out.println("Execution time is : " + (end - start));
		
		int[]y=x.clone();
		Arrays.sort(y);

		start = System.nanoTime();
		binarySearch(y,2000);
		end = System.nanoTime();
		System.out.println("Execution time is : " + (end - start));

	}

	public static int linearSearch(int[] a, int x) {
		int i;
		for (i = 0; i < a.length; i++) {
			if (a[i] == x)
				return i;
		}
		return -1;
	}

	public static int binarySearch(int a[], int x) {
		int lo = 0;
		int hi = a.length - 1;
		int mid;
		while (lo <= hi) {
			mid = (lo + hi) / 2;
			if (a[mid] == x)
				return mid; // found it
			else {
				if (a[mid] < x) // decide which half to search in
					lo = mid + 1; // it in the upper half
				else
					hi = mid - 1; // it is in the lower half
			}
		}
		return -1; // not found
	}

}
