import java.util.Random;

public class Sorting {

	public static void main(String[] args) {
		
		/*
		 * Bubble Sort : (time in ns)
		 *  1000 : 6508359
		 *  100000 : 18504916850
		 *  500000 : 476430279673 (8 min)
		 *  1000000 :1884373202913 (32 min)
		 */
		
		/*
		 * Selection Sort :
		 *  1000 : 3976329
		 *  100000 : 3435633446
		 *  500000 : 89128938846
		 */
		
		/*
		 * Insertion Sort :
		 *  1000 : 2997965
		 *  100000 : 4400435147
		 *  500000 : 115559552101
		 */
		
		Random random = new Random();
		int[] x = new int[10];
		for (int i = 0; i < x.length; i++) {
			x[i] = random.nextInt(1000);
		}
		int[]y=x.clone();
		int[]z=x.clone();


		long start = System.nanoTime();
		bubbleSort(x);
		long end = System.nanoTime();
		System.out.println("Execution time is : " + (end - start));
		
		start = System.nanoTime();
		selectionSort(y);
		end = System.nanoTime();
		System.out.println("Execution time is : " + (end - start));
		
		start = System.nanoTime();
		insertionSort(z);
		end = System.nanoTime();
		System.out.println("Execution time is : " + (end - start));
		

	}

	public static void bubbleSort(int[] a) {
		int outer, inner, swap_operations=0;
		for (outer = a.length - 1; outer > 0; outer--) { // counting down
			boolean sorted = true;
			for (inner = 0; inner < outer; inner++) { // bubbling up
				if (a[inner] > a[inner + 1]) { // if out of order...
					int temp = a[inner]; // ...then swap
					a[inner] = a[inner + 1];
					a[inner + 1] = temp;
					sorted = false;
					swap_operations++;
				}
			}
			if (sorted)
				return;
		}
		System.out.println("Swap Operations : "+swap_operations);
	}

	public static void selectionSort(int[] a) {
		int outer, inner, min, swap_operations=0;
		for (outer = 0; outer < a.length - 1; outer++) { // outer counts down
			min = outer;
			for (inner = outer + 1; inner < a.length; inner++)
				if (a[inner] < a[min])
					min = inner;
			int temp = a[outer];
			a[outer] = a[min];
			a[min] = temp;
			swap_operations++;
		}
		System.out.println("Swap Operations : "+swap_operations);

	}

	public static void insertionSort(int[] array) {
		int inner, outer;
		for (outer = 1; outer < array.length; outer++) {
			int temp = array[outer];
			inner = outer;
			while (inner > 0 && array[inner - 1] >= temp) {
				array[inner] = array[inner - 1];
				inner--;
			}
			array[inner] = temp;

		}
	}

}
