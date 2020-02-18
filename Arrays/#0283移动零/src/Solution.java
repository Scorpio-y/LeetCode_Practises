import java.util.Arrays;

/*
https://leetcode-cn.com/problems/move-zeroes/
 
题目难度：简单

题目：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例 :
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]

说明:
必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

 * */

public class Solution {
	public static void main(String[] args) {
		int[] arr1 = new int[] {0,1,0,3,12};
		int[] arr2 = new int[] {0,1,0,3,12};
		moveZeroes1(arr1);
		moveZeroes1(arr2);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}
	
	// 1. 双指针法
	public static void moveZeroes1(int[] nums) {
        if(!(nums==null || nums.length==0)) {
        	int len = nums.length;
        	int slow = 0;
        	for(int fast=0;fast<len;fast++) {
        		if(nums[fast]!=0) nums[slow++] = nums[fast];
        	}
        	for(;slow<len;slow++) nums[slow] = 0;
        }
    }
	
	// 2. 双指针法，简化版，该方法免去了方法1的最后一个循环补零操作。此方法slow指向的元素值总是为0
	public static void moveZeroes2(int[] nums) {
        if(!(nums==null || nums.length==0)) {
        	int len = nums.length;
        	int slow = 0;
        	for(int fast=0;fast<len;fast++) {
        		if(nums[fast]!=0) {
        			int tmp = nums[slow];
        			nums[slow++] = nums[fast];
        			nums[fast] = tmp;
        		}
        	}
        }
	}
}