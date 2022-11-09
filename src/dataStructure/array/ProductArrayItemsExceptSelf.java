package dataStructure.array;

import java.util.Arrays;

public class ProductArrayItemsExceptSelf {

	/*
	 * Function to print product array for a given array arr[] of size n
	 */
	static void productArray(int arr[], int n) {

		// Base case
		if (n == 1) {
			System.out.print(0);
			return;
		}
		// Initialize memory to all arrays
		int left[] = new int[n];
		int right[] = new int[n];
		int prod[] = new int[n];

		int i, j;

		/*
		 * Left most element of left array is always 1
		 */
		left[0] = 1;

		/*
		 * Right most element of right array is always 1
		 */
		right[n - 1] = 1;

		/* Construct the left array */
		for (i = 1; i < n; i++)
			left[i] = arr[i - 1] * left[i - 1];
		System.out.println("Left Array:"+ Arrays.toString(left) );

		/* Construct the right array */
		for (j = n - 2; j >= 0; j--)
			right[j] = arr[j + 1] * right[j + 1];
		System.out.println("right Array:"+ Arrays.toString(right) );
		/*
		 * Construct the product array using left[] and right[]
		 */
		for (i = 0; i < n; i++)
			prod[i] = left[i] * right[i];

		/* print the constructed prod array */
		System.out.println("prod Array:"+ Arrays.toString(prod) );

		return;
	}
	public static int[] productExceptSelf(int[] nums) { 
		//https://leetcode.com/problems/product-of-array-except-self/discussion/
        int[] ans = new int[nums.length];
        int left = 1;
        
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left;
            left *= nums[i];
        }
        System.out.println("ans Array:"+ Arrays.toString(ans) );
        
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }
        System.out.println("ans Array:"+ Arrays.toString(ans) );
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = { 4, 3, 2 };
		int n=array.length;
		productArray1(array,n);
		//productArray(array,n);
		productExceptSelf(array);
	}

	private static void productArray1(int array[], int len) {
		int[] temp = new int[len];
		for (int i = 0; i < len; i++) {
			int multiply = 1;
			for (int j = 0; j < len; j++) {
				if (j != i)
					multiply = multiply * array[j];
			}
			temp[i] = multiply;
		}
		System.out.println(Arrays.toString(array) + ":Result:" + Arrays.toString(temp));
	}
}
