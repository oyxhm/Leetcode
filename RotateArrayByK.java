/* 
Rotate an array to the right by k steps in-place without allocating extra space. 
For instance, with k = 3, the array [0, 1, 2, 3, 4, 5, 6] is rotated to [4, 5, 6, 0, 1, 2, 3].
*/

class RotateArrayByK {
	// O(nk) runtime, O(1) space

	public static void rotateArrayByK(int[] num, int k) {
		while (k-- > 0) {
			rotateArrayByOne(num);
		}
	}

	public static void rotateArrayByOne(int[] num) {
		int temp = num[num.length - 1];
		for (int i = num.length - 2; i >= 0; i--) {
			num[i + 1] = num[i];
		} 
		num[0] = temp;
	}

	public static void main(String[] args) {
		int[] testCase = {0 ,1, 2, 3, 4, 5, 6};
		rotateArrayByK(testCase, 3);
		for (int i = 0; i < testCase.length; i++) {
			if (i != 0) {
				System.out.printf(", ");
			}
			System.out.printf("%d", testCase[i]);	
		}
		System.out.printf("%n");
	}
}