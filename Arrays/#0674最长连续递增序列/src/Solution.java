/*
https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 
题目难度：简单

题目：给定一个未经排序的整数数组，找到最长且连续的的递增序列。

示例 1:
输入: [1,3,5,4,7]
输出: 3
解释: 最长连续递增序列是 [1,3,5], 长度为3。
尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。 

示例 2:
输入: [2,2,2,2,2]
输出: 1
解释: 最长连续递增序列是 [2], 长度为1。

注意：数组长度不会超过10000。

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums1 = new int[] {1,3,5,4,7};
		int[] nums2 = new int[] {2,2,2,2,2};
		System.out.println(findLengthOfLCIS(nums1));
		System.out.println(findLengthOfLCIS(nums2));
	}
	
	// 1.一次遍历
	public static int findLengthOfLCIS(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int len = nums.length;
		int res = 0, count = 1;
		for(int i=1;i<len;i++) {
			if(nums[i]>nums[i-1]) {
				count++;
			}
			else {
				res = Math.max(res, count);
				count = 1;
			}
		}
		res = Math.max(res, count);
		return res;
    }

}