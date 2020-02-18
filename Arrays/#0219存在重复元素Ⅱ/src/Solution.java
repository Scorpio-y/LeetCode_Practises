import java.util.HashMap;
import java.util.HashSet;

/*
https://leetcode-cn.com/problems/contains-duplicate-ii/
 
题目难度：简单

题目：给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

示例 1:
输入: nums = [1,2,3,1], k = 3
输出: true

示例 2:
输入: nums = [1,0,1,1], k = 1
输出: true

示例 3:
输入: nums = [1,2,3,1,2,3], k = 2
输出: false

 * */

public class Solution {
	public static void main(String[] args) {
		int[] arr1 = new int[] {1,2,3,1};
		int[] arr2 = new int[] {1,2,3,1,2,3};

		System.out.println(containsNearbyDuplicate1(arr1,3));
		System.out.println(containsNearbyDuplicate1(arr2,2));
		System.out.println(containsNearbyDuplicate2(arr1,3));
		System.out.println(containsNearbyDuplicate2(arr2,2));
		System.out.println(containsNearbyDuplicate3(arr1,3));
		System.out.println(containsNearbyDuplicate3(arr2,2));
	}
	
	// 1. 暴力法
	public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        if(nums==null || nums.length<2) return false;
        int len = nums.length;
        for(int i=0;i<len-1;i++) {
        	for(int j=i+1;j<len;j++) {
        		if(nums[i]==nums[j] && j-i<=k) return true;
        	}
        }
        return false;
    }
	
	// 2. HashMap
	public static boolean containsNearbyDuplicate2(int[] nums, int k) {
		if(nums==null || nums.length<2) return false;
        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++) {
        	if(map.containsKey(nums[i]) && i-map.get(nums[i])<=k) return true;
        	map.put(nums[i], i);
        }
        return false;
	}
	
	// 3. HashSet
	public static boolean containsNearbyDuplicate3(int[] nums, int k) {
		if(nums==null || nums.length<2) return false;
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<len;i++) {
        	if(set.contains(nums[i])) return true;
        	set.add(nums[i]);
        	if(set.size()>k) set.remove(nums[i-k]);
        }
        return false;
	}
    
}