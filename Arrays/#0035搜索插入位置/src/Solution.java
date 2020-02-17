/*
https://leetcode-cn.com/problems/search-insert-position/

题目难度：简单

题目：
给定一个排序数组（升序）和一个目标值，在数组中找到目标值，并返回其索引。
如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums1 = new int[] {1,3,5,6};
		int target = 0;
		int res1 = searchInsert1(nums1, target);
		int res2 = searchInsert2(nums1, target);
		System.out.println(res1);
		System.out.println(res2);
	}
	
	// 1. 依次查询
	public static int searchInsert1(int[] nums, int target) {
        if(nums==null || nums.length==0) return 0;
        int len = nums.length;
        for(int i=0;i<len;i++) {
        	if(target<=nums[i]) return i;
        }
        return len;
    }
	
	// 二分法查询
	public static int searchInsert2(int[] nums, int target) {
		if(nums==null || nums.length==0) return 0;
        int left = 0, right = nums.length-1, mid;
        while(left<=right) {
        	mid = (left+right)/2;
        	if(target>nums[mid]) {
        		left = mid+1;
        	}else {
        		right = mid-1;
        	}
        }
        return left;
	}
}