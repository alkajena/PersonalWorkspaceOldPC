package miscellaneous;

/*Given an integer x. The task is to find the square root of x. If x is not a perfect square, then return floor(√x).

Input:
First line of input contains number of testcases T. For each testcase, the only line contains the number x.

Output:
For each testcase, print square root of given integer.

Your Task:
The task is to complete the function floorSqrt() which should return the square root of given number x.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ T ≤ 10000
1 ≤ x ≤ 107

Example:
Input:
2
5
4
Output:
2
2
 */
public class Squareroot {

	public static void main(String[] args) {
		long l=4;
		System.out.println(floorSqrt(l));

	}
	static long floorSqrt(long x)
	 {
	   return Math.round(Math.floor(Math.sqrt(x)));//Math.floor(Math.sqrt(x)) will give double value so by using Math.round we change that to long
	 }
}
