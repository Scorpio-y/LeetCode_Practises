import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 https://leetcode-cn.com/problems/two-sum/
 
 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例：
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

 * */
public class Solution {
	public static void main(String[] args) {
		int[] res1 = twoSum1(new int[] {2,7,11,15},13);
		int[] res2 = twoSum2(new int[] {2,7,11,15},13);
		System.out.println(Arrays.toString(res1));
		System.out.println(Arrays.toString(res2));
	}
	
	// 1.暴力法，双重循环
    public static int[] twoSum1(int[] nums, int target) {
    	int len = nums.length;
    	for(int i=0;i<len-1;i++) {
    		for(int j=i+1;j<len;j++) {
    			if(nums[i]+nums[j]==target) return new int[] {i,j};
    		}
    	}
//    	return new int[] {};
    	throw new IllegalArgumentException("No two sum solution");	// 无答案
    }
    
	// 2.HashMap，一遍哈希表
    public static int[] twoSum2(int[] nums, int target) {
    	int len = nums.length;
    	Map<Integer,Integer> map = new HashMap<>();
    	for(int i=0;i<len;i++) {
    		int tmp = target-nums[i];
    		if(map.containsKey(tmp)) {
    			return new int[] {map.get(tmp),i};
    		}map.put(nums[i],i);
    	}
    	throw new IllegalArgumentException("No two sum solution");	// 无答案
    }
}