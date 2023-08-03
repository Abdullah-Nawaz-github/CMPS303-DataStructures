
public class Ex2 {

	public static String repeat1(char c, int n) {
		String s = "";
		for (int i = 0; i < n; i++)
			s = s + c;
		return s;
	}

	public static String repeat2(char c, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(c);
		return sb.toString();
	}

	public static void main(String[] args) {
//		n         repeat1            repeat2
//		50,000    446084168          3230146 
//		100,000   1509264800         4115337
//		200,000   5545650690         6462046
//		400,000   22579926953        8233857
//		800,000   89694113449        11753357
		
		long start = System.nanoTime();
		repeat1('a',800000);
		long end = System.nanoTime();
		System.out.println("Execution time is : " + (end - start));
		
		start = System.nanoTime();
		repeat2('a',800000);
		end = System.nanoTime();
		System.out.println("Execution time is : " + (end - start));

	}

}
