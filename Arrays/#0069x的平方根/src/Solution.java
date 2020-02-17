/*
https://leetcode-cn.com/problems/sqrtx/

题目难度：简单

题目：
实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

 * */

public class Solution {
	public static void main(String[] args) {
		int res1 = mySqrt1(1000);
		int res2 = mySqrt2(1000);
		int res3 = mySqrt3(1000);
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
	
	// 1. 直接用自带的方法
	public static int mySqrt1(int x) {
		return (int)Math.sqrt(x);
	}
	
	// 2. 二分法
	public static int mySqrt2(int x) {
		int left = 0, right = x, mid;
		while(left<=right) {
			mid = left+(right-left)/2;
			if((long)mid*mid<=x) left = mid+1;	// 当取小于号时，left=mid+1可能得不到正确的left
			else right = mid-1;		// 当取大于号时，right=mid-1一定是正确的right，所以等号放在上面
		}
		return right;
	}
	
	// 3. 牛顿法
	public static int mySqrt3(int x) {
		double x0 = x;
		double x1 = 0.5*(x0+x/x0);
		while(Math.abs(x0-x1)>=1) {
			x0 = x1;
			x1 = 0.5*(x0+x/x0);
		}
		return (int)x1;
	}
	
}