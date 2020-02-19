import java.util.Arrays;
import java.util.HashSet;

/*
https://leetcode-cn.com/problems/find-the-duplicate-number/
 
题目难度：中等

题目：给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

示例 1:
输入: [1,3,4,2,2]
输出: 2

示例 2:
输入: [3,1,3,4,2]
输出: 3

说明：
不能更改原数组（假设数组是只读的）。
只能使用额外的 O(1) 的空间。
时间复杂度小于 O(n2) 。
数组中只有一个重复的数字，但它可能不止重复出现一次。

 * */

public class Solution {
	public static void main(String[] args) {
		int[] arr1 = new int[] {1,3,4,2,2};
		int[] arr2 = new int[] {3,1,3,4,2};
		System.out.println(findDuplicate1(arr1));
		System.out.println(findDuplicate1(arr2));
		System.out.println(findDuplicate2(arr1));
		System.out.println(findDuplicate2(arr2));
		System.out.println(findDuplicate3(arr1));
		System.out.println(findDuplicate3(arr2));
	}
	
	// 1. 暴力法
	public static int findDuplicate1(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++) {
        	for(int j=i+1;j<len;j++) {
        		if(nums[i]==nums[j]) return nums[i];
        	}
        }
        return -1;
    }
	
	// 2. 先排序再查找
	public static int findDuplicate2(int[] nums) {
		int len = nums.length;
        int[] nums_copy = Arrays.copyOf(nums, len);
        Arrays.sort(nums_copy);
        for(int i=0;i<len-1;i++) {
        	if(nums_copy[i]==nums_copy[i+1]) return nums_copy[i];
        }
        return -1;
    }
	
	// 3. HashSet
	public static int findDuplicate3(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for(int ele:nums) {
			if(set.contains(ele)) return ele;
			set.add(ele);
		}
		return -1;
    }
	
}