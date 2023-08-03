import java.util.Arrays;

public class MyArrays<e> {

	private e element;

	public MyArrays(e element) {
		this.element = element;
	}

	public static <e> void displayElement(e element) {
		System.out.println(element.getClass().getSimpleName());
	}

	public e getElement() {
		return element;
	}

	public void setElement(e element) {
		this.element = element;
	}

	public static void main(String[] args) {

		// Arrays

		int[] x = new int[5];
		Arrays.fill(x, 3);
		System.out.println(Arrays.toString(x));
		int[] ragged = Arrays.copyOfRange(x, 0, 2);

		System.out.println(Arrays.toString(ragged));

	}

}
