import java.util.Arrays;

/*
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

题目难度：简单

题目：
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

说明：输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums1 = new int[] {0,0,1,1,1,2,2,3,3,4};
		int[] nums2 = new int[] {0,0,1,1,1,2,2,3,3,4};
		int res1 = removeDuplicates1(nums1);
		int res2 = removeDuplicates2(nums2);
		System.out.println(res1);System.out.println(Arrays.toString(nums1));
		System.out.println(res2);System.out.println(Arrays.toString(nums2));
	}
	
	// 1. 双指针法（快慢指针）
    public static int removeDuplicates1(int[] nums) {
    	if(nums==null || nums.length==0) return 0;
    	int len = nums.length;
    	int res = 1;	// 慢指针
    	for(int i=1;i<len;i++) {
    		if(nums[i]!=nums[i-1]) {
    			nums[res++] = nums[i];
    		}
    	}
    	return res;
    }
    
    // 2. 新建数组
    public static int removeDuplicates2(int[] nums) {
    	if(nums==null || nums.length==0) return 0;
    	int len = nums.length;
    	int[] newarray = new int[len];
    	newarray[0] = nums[0]; int res = 1;
    	for(int i=1;i<len;i++) {
    		if(nums[i]!=nums[i-1]) {
    			newarray[res++] = nums[i];
    		}
    	}
    	for(int i=0;i<res;i++) {
    		nums[i] = newarray[i];
    	}
    	return res;
    }
}