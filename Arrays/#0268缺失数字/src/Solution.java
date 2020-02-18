import java.util.Arrays;
import java.util.HashSet;

/*
https://leetcode-cn.com/problems/missing-number/
 
题目难度：简单

题目：给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:
输入: [3,0,1]
输出: 2

示例 2:
输入: [9,6,4,2,3,5,7,0,1]
输出: 8

 * */

public class Solution {
	public static void main(String[] args) {
		int[] arr1 = new int[] {3,0,1};
		int[] arr2 = new int[] {9,6,4,2,3,5,7,0,1};

		System.out.println(missingNumber1(arr1));
		System.out.println(missingNumber1(arr2));
		System.out.println(missingNumber2(arr1));
		System.out.println(missingNumber2(arr2));
		System.out.println(missingNumber3(arr1));
		System.out.println(missingNumber3(arr2));
		System.out.println(missingNumber4(arr1));
		System.out.println(missingNumber4(arr2));
	}
	
	// 1. 暴力法
	public static int missingNumber1(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int len = nums.length;
        for(int i=0;i<=len;i++) {
        	int j;
        	for(j=0;j<len;j++) {
        		if(nums[j]==i) break;
        	}
        	if(j==len) return i;
        }
        return -1;	// 随便返回一个数字，因为不可能执行到这一步
    }
	
	// 2. 先排序再查找
	public static int missingNumber2(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int len = nums.length;
		int[] nums_copy = Arrays.copyOf(nums, len);
		Arrays.sort(nums_copy);
		for(int i=0;i<len;i++) {
			if(nums_copy[i]!=i) return i;
		}
		return len;
	}

	// 3. HashSet
	public static int missingNumber3(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int len = nums.length;
		HashSet<Integer> set = new HashSet<>();
		for(int ele:nums) set.add(ele);
		for(int i=0;i<=len;i++) {
			if(!set.contains(i)) return i;
		}
		return -1;
	}
	
	// 4. 数学方法
	public static int missingNumber4(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int len = nums.length;
		long sum_nums = 0;
		for(int ele:nums) sum_nums+=ele;
		long sum = len*(len+1)/2;
		return  (int) (sum-sum_nums);
	}
    
}