/*
https://leetcode-cn.com/problems/maximum-average-subarray-i/
 
题目难度：简单

题目：给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

示例 1:
输入: [1,12,-5,-6,50,3], k = 4
输出: 12.75
解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75

注意:
1 <= k <= n <= 30,000。
所给数据范围 [-10,000，10,000]。

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[] {1,12,-5,-6,50,3};
		int k = 4;
		System.out.println(findMaxAverage1(nums,k));
		System.out.println(findMaxAverage2(nums,k));
	}
	
	// 1.暴力法
	public static double findMaxAverage1(int[] nums, int k) {
		double res = Double.MIN_VALUE;
		int len = nums.length;
		for(int i=0;i<=len-k;i++) {
			res = Math.max(res, nums[i]+nums[i+1]+nums[i+2]+nums[i+3]);
		}
		return res/k;
    }
	
	// 方法1的优化，降低计算量
	public static double findMaxAverage2(int[] nums, int k) {
		double res = 0;
		for(int i=0;i<k;i++) res += nums[i];
		int len = nums.length;
		for(int i=1;i<=len-k;i++) {
			res = Math.max(res, res-nums[i-1]+nums[i+k-1]);
		}
		return res/k;
	}

}