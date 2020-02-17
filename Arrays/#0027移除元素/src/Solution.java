import java.util.Arrays;

/*
https://leetcode-cn.com/problems/remove-element/

题目难度：简单

题目：
给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

说明：输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums1 = new int[] {0,1,2,2,3,0,4,2};
		int[] nums2 = new int[] {0,1,2,2,3,0,4,2};
		int val = 2;
		int res1 = removeElement1(nums1, val);
		int res2 = removeElement2(nums2, val);
		System.out.println(res1);System.out.println(Arrays.toString(nums1));
		System.out.println(res2);System.out.println(Arrays.toString(nums2));
	}
	
	// 1. 双指针（快慢指针），未改变元素相对顺序
	public static int removeElement1(int[] nums, int val) {
		if(nums==null || nums.length==0) return 0;
		int len = nums.length;
		int res = 0;	// res为慢指针
		for(int i=0;i<len;i++) {	// i为快指针
			if(nums[i]!=val) {
				nums[res++] = nums[i];
			}
		}
		return res;
	}
	
	// 2. 双指针（首尾指针），改变了元素的相对顺序
	public static int removeElement2(int[] nums, int val) {
		if(nums==null || nums.length==0) return 0;
		int left = 0, right = nums.length-1;	// 首尾指针
		while(left<=right) {
			if(nums[left]==val) {
				nums[left] = nums[right];
				right--;
			}else {
				left++;
			}
		}
		return left;
	}

}