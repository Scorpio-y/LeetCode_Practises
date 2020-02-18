import java.util.Arrays;
import java.util.HashSet;

/*
https://leetcode-cn.com/problems/contains-duplicate/
 
题目难度：简单

题目：给定一个整数数组，判断是否存在重复元素。如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

示例 1:
输入: [1,2,3,1]
输出: true

示例 2:
输入: [1,2,3,4]
输出: false

示例 3:
输入: [1,1,1,3,3,4,3,2,4,2]
输出: true

 * */

public class Solution {
	public static void main(String[] args) {
		int[] arr1 = new int[] {1,2,3,1};
		int[] arr2 = new int[] {1,2,3,4};

		System.out.println(containsDuplicate1(arr1));
		System.out.println(containsDuplicate1(arr2));
		System.out.println(containsDuplicate2(arr1));
		System.out.println(containsDuplicate2(arr2));
		System.out.println(containsDuplicate3(arr1));
		System.out.println(containsDuplicate3(arr2));
	}
	
	// 1. 暴力法
	public static boolean containsDuplicate1(int[] nums) {
        if(nums==null || nums.length<2) return false;
        int len = nums.length;
        for(int i=0;i<len-1;i++) {
        	for(int j=i+1;j<len;j++) {
        		if(nums[i]==nums[j]) return true;
        	}
        }
        return false;
    }
	
	// 2. HashSet
	public static boolean containsDuplicate2(int[] nums) {
		if(nums==null || nums.length<2) return false;
		HashSet<Integer> set = new HashSet<>();
		for(int ele:nums) {
			if(set.contains(ele)) return true;
			set.add(ele);
		}
		return false;
	}
	
	// 3. 先排序再判断
	public static boolean containsDuplicate3(int[] nums) {
		if(nums==null || nums.length<2) return false;
		int len = nums.length;
		int[] nums_copy = Arrays.copyOf(nums, len);	// 原则上不对传入的数组进行修改
		Arrays.sort(nums_copy);
		for(int i=0;i<len-1;i++) {
			if(nums_copy[i]==nums_copy[i+1]) return true;
		}
		return false;
		
	}
    
}