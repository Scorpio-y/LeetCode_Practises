/*
https://leetcode-cn.com/problems/non-decreasing-array/
 
题目难度：简单

题目：给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。

示例 1:
输入: [4,2,3]
输出: True
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。

示例 2:
输入: [4,2,1]
输出: False
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。

说明:  n 的范围为 [1, 10,000]。

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,4,5,3};
		System.out.println(checkPossibility1(nums));
		System.out.println(checkPossibility2(nums));
	}
	
	// 1.暴力法
	public static boolean checkPossibility1(int[] nums) {
		int len = nums.length;
		if(len<=2) return true;
		for(int i=0;i<len;i++) {
			int j;
			int tmp = nums[i];
			if(i==0) nums[i]=nums[i+1];
			else nums[i]=nums[i-1];
			for(j=0;j<len-1;j++) {
				if(nums[j]>nums[j+1]) {
					nums[i]=tmp;
					break;
				}
			}
			if(j==len-1) return true;
		}
		return false;
    }
	
	// 一次遍历
	public static boolean checkPossibility2(int[] nums) {
		int len = nums.length;
		int count=0;
		for(int i=0;i<len-1;i++) {
			if(nums[i]>nums[i+1]) {
				int tmp = nums[i];
				if(i==0) nums[i]=nums[i+1];  // 如果是第一个数，就将nums[0]改为nums[1]
				else nums[i]=nums[i-1]; // 如果不是第一个数，就将nums[i]改为前一个数，这是nums[i]所能取到的最小值了
				if(nums[i]>nums[i+1]) {  // 如果nums[i]改完值后，还是不满足条件
					nums[i] = tmp;  // 还原nums[i]原先的值
					nums[i+1] = nums[i];  // 只能将nums[i+1]改为nums[i]了，这样一定符合条件
				}
				count++;  // 改动次数加1
				if(count>1) return false;
			}
		}
		return true;
	}

}