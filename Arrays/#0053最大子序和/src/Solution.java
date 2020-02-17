/*
https://leetcode-cn.com/problems/maximum-subarray/

题目难度：简单

题目：
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		int res1 = maxSubArray1(nums);
		int res2 = maxSubArray2(nums);
		System.out.println(res1);
		System.out.println(res2);
	}
	
	// 1. 动态规划法
	public static int maxSubArray1(int[] nums) {
		int len = nums.length;
        int now = nums[0]; // 当前阶段的最大子序和
        int res = now;	// 到目前为止的最大子序和
        for(int i=1;i<len;i++) {
        	now = Math.max(now, 0) + nums[i];
        	res = Math.max(res, now);
        }
        return res;
    }
	
	// 与上一方法相同，但更容易理解
	public static int maxSubArray2(int[] nums) {
		int len = nums.length;
        int now = nums[0]; // 当前阶段的最大子序和
        int res = now;	// 到目前为止的最大子序和
        for(int i=1;i<len;i++) {
        	if(now<0) {
        		now = nums[i];
        	}else {
        		now += nums[i];
        	}
        	res = Math.max(res, now);
        }
        return res;
    }
	
}