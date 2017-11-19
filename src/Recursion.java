
public class Recursion {

	public static int fibonacci(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) { 
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static void main(String[] args) {
		System.out.println("Fibonacci: ");
		System.out.println("5 => "+ fibonacci(5));
		System.out.println("3 => "+ fibonacci(3));
		System.out.println("10 => "+ fibonacci(10));
		System.out.println("6 => "+ fibonacci(6));
	}

}
