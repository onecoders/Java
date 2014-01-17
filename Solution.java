package com.solution;

/**
 * Created on Jan 14, 2014
 * 
 * @author Roy Sun onecoders@gmail.com
 * 
 * @TaskDescription
 * 
 * An integer K and a non-empty zero-indexed array A consisting of N integers are given.
	A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.
	A bounded_slice is a slice in which the difference between the maximum and minimum values in the slice is less than or equal to K. More precisely it is a slice, such that max(A[P], A[P + 1], ..., A[Q]) − min(A[P], A[P + 1], ..., A[Q]) ≤ K.
	The goal is to calculate the number of bounded_slices.
	For example, consider K = 2 and array A such that:
    	A[0] = 3
    	A[1] = 5
    	A[2] = 7
    	A[3] = 6
    	A[4] = 3
	There are exactly nine bounded_slices: (0, 0), (0, 1), (1, 1), (1, 2), (1, 3), (2, 2), (2, 3), (3, 3), (4, 4).
	Write a function:
	class Solution { public int solution(int K, int[] A); }
	that, given an integer K and a non-empty zero-indexed array A of N integers, returns the number of bounded_slices of array A.
	If the number of bounded_slices is greater than 1,000,000,000, the function should return 1,000,000,000.
	For example, given:
	    A[0] = 3
	    A[1] = 5
	    A[2] = 7
	    A[3] = 6
	    A[4] = 3
	the function should return 9, as explained above.
	Assume that:
	N is an integer within the range [1..100,000];
	K is an integer within the range [0..1,000,000,000];
	each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
	Elements of input arrays can be modified.
 *
 */

public class Solution {

	public int solution(int K, int[] A) {
		int total = 0;
		for (int P = 0; P < A.length; P++) {
			total += getSliceCountByP(P, A, K);
		}
		return total;
	}

	private int getSliceCountByP(int P, int[] A, int K) {
		int count = 0;
		for (int Q = P; Q < A.length; Q++) {
			if (getMaxDiff(A, P, Q) > K)
				break;
			count++;
		}
		return count;
	}

	private int getMaxDiff(int[] A, int P, int Q) {
		int min = A[P], max = A[P];
		for (int i = P; i <= Q; i++) {
			max = A[i] > max ? A[i] : max;
			min = A[i] < min ? A[i] : min;
		}
		return max - min;
	}

	private int totalDecreasing(int num) {
		if (num == 1) {
			return 1;
		} else {
			return num + totalDecreasing(num - 1);
		}
	}

	/**
	 * @Test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int K = 2;
		int[] A = { 3, 5, 7, 6, 3 };
		int result = new Solution().solution(K, A);
		System.out.println("result is:" + result);
		System.out.println("total of 1-100 is:" + new Solution().totalDecreasing(100));
	}

}
