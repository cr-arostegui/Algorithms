
public class DynamicProgramming {
	
	public static int memory[] = new int[100];// The limit to remember fibonacci is 100

	public static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (memory[n] == 0) {
			memory[n] = fibonacci(n - 1) + fibonacci(n - 2);
		}
		return memory[n];
	}
	
	public static void main(String[] args) {
		System.out.println("Fibonacci: ");
		System.out.println("5 => "+ fibonacci(5));
		System.out.println("3 => "+ fibonacci(3));
		System.out.println("10 => "+ fibonacci(10));
		System.out.println("6 => "+ fibonacci(6));
		System.out.println("Memory (showing only memorized values):");
		for (int i = 0; i < memory.length; i++) {
			if (memory[i] != 0) {
				System.out.println("memory["+i+"] => "+memory[i]);
			}
		}
	}

}
