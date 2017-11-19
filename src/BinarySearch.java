
public class BinarySearch {

	public static boolean binarySearchRecursive(int[] array, int x, int left, int right) {
		if (left > right) {
			return false;
		}
		int mid = (left + right) / 2;//left + ((right - left) / 2); to prevent overflow
		if (array[mid] == x) {
			return true;
		} else if (x < array[mid]) {
			return binarySearchRecursive(array, x, left, mid - 1);
		} else {
			return binarySearchRecursive(array, x, mid + 1, right);
		}
	}
	
	public static boolean binarySearchRecursive (int[] array, int x) {
		return binarySearchRecursive(array, x, 0, array.length - 1);
	}
	
	public static void main(String[] args) {
		System.out.println("Recursive binary search:");
		int example1[] = new int[] {1, 2, 6, 7, 8};// We need a sorted list.
		System.out.println("Found 1: "+ binarySearchRecursive(example1, 2));
		

	}

}
