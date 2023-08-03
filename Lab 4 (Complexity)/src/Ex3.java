import java.util.Random;

public class Ex3 {

	public static int max(int a[]) {
		int m = a[0];
		for (int i = 0; i < a.length; i++)
			if (a[i] > m)
				m = a[i];
		return m;
	}

	public static void main(String[] args) {
//		Size                 Best case                Worst case
//		10,000               167110                   172078
//		100,000              1437343                  464448    
//		500,000              3597235                  1238745
//		1000,000             6087516                  618435
//		2000,000             7188954                 4806651
		
		Random random = new Random();
		int[] bestCase = new int[2000000];
		for (int i = 0; i < bestCase.length; i++) {
			bestCase[i] = random.nextInt(1000);
		}
		bestCase[0]=1000000;

		long start = System.nanoTime();
		max(bestCase);
		long end = System.nanoTime();
		System.out.println("Execution time is : " + (end - start));
		
		int[] worstCase = new int[2000000];
		for (int i = 0; i < worstCase.length; i++) {
			worstCase[i] = random.nextInt(1000);
		}
		worstCase[worstCase.length-1]=10000;

		start = System.nanoTime();
		max(worstCase);
		end = System.nanoTime();
		System.out.println("Execution time is : " + (end - start));

	}

}
