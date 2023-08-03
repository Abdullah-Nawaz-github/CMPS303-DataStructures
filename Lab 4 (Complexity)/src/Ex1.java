import java.util.Random;

public class Ex1 {

	public static int total(int x[]) {
		int sum = 0;
		for (int i = 0; i < x.length; i++)
			sum = sum + x[i];
		return sum;
	}

	public static void main(String[] args) {

		Random random = new Random();
		int[] x = new int[1000];
		for (int i = 0; i < x.length; i++) {
			x[i] = random.nextInt(1000);
		}

		long start = System.nanoTime();
		total(x);
		long end = System.nanoTime();
		System.out.println("Execution time is : " + (end - start));

		int[] y = new int[10000];
		for (int i = 0; i < y.length; i++) {
			y[i] = random.nextInt(1000);
		}

	}

}
