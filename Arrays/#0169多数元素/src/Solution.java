import java.util.Arrays;
import java.util.HashMap;

/*
https://leetcode-cn.com/problems/majority-element/
 
题目难度：简单

题目：给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:
输入: [3,2,3]
输出: 3

示例 2:
输入: [2,2,1,1,1,2,2]
输出: 2

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums1 = new int[] {3,2,3};
		int[] nums2 = new int[] {2,2,1,1,1,2,2};
		System.out.println(majorityElement1(nums1));
		System.out.println(majorityElement1(nums2));
		System.out.println(majorityElement2(nums1));
		System.out.println(majorityElement2(nums2));
}
	
	// 1.HashMap
	public static int majorityElement1(int[] nums) {
		if(nums==null || nums.length==0) return -1;
		int len = nums.length;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<len;i++) {
			if(!map.containsKey(nums[i])) map.put(nums[i], 1);
			else map.put(nums[i], map.get(nums[i])+1);
			if(map.get(nums[i])>len/2) return nums[i];
		}
		return -1;
    }
	
	// 2. 先排序再取中间值
	public static int majorityElement2(int[] nums) {
		if(nums==null || nums.length==0) return -1;
		Arrays.sort(nums);
		return nums[nums.length/2];
	}

}