import java.util.Random;

public class Ex4 {

	public static double[] prefixTotal1(double a[]) {
		double tmp[] = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			double sum = 0;
			for (int j = 0; j <= i; j++)
				sum = sum + a[j];
			tmp[i] = sum;
		}
		return tmp;
	}

	public static double[] prefixTotal2(double a[]) {
		double tmp[] = new double[a.length];
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
			tmp[i] = sum;
		}
		return tmp;
	}

	public static void main(String[] args) {
//		Size             Method1         Method2
//		1000             2824347         28763
//		10,000           90227240        266210
//		100,000          7748721358      2674204
//		1,000,000        800592699224    11527379
		
		Random random = new Random();
		double[] x = new double[1000000];
		for (int i = 0; i < x.length; i++) {
			x[i] = random.nextDouble(1000);
		}

		long start = System.nanoTime();
		prefixTotal1(x);
		long end = System.nanoTime();
		System.out.println("Execution time is : " + (end - start));
		
		start = System.nanoTime();
		prefixTotal2(x);
		end = System.nanoTime();
		System.out.println("Execution time is : " + (end - start));

	}

}
