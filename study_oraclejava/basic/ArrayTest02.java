package basic;

public class ArrayTest02 {
	public static void main(String[] args) {
		/**
		 * 동일한 자료형의 연속적인 집합
		 */
		// int[] arr = new int[]{ 100, 200, 300 };
		int[] arr = { 100, 200, 300 };
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr: " + arr[i]);
		}
	}
}
