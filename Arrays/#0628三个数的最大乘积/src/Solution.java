import java.util.Arrays;

/*
https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 
题目难度：简单

题目：给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

示例 1:
输入: [1,2,3]
输出: 6

示例 2:
输入: [1,2,3,4]
输出: 24

注意:
给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums1 = new int[] {1,2,3,4};
		int[] nums2 = new int[] {-5,-4,-3,-2,-1,1,2,3};
		System.out.println(maximumProduct1(nums1));
		System.out.println(maximumProduct1(nums2));
		System.out.println(maximumProduct2(nums1));
		System.out.println(maximumProduct2(nums2));
		System.out.println(maximumProduct3(nums1));
		System.out.println(maximumProduct3(nums2));
	}
	
	// 1. 暴力法
	public static int maximumProduct1(int[] nums) {
		int len = nums.length;
		int res = Integer.MIN_VALUE;
		for(int i=0;i<len-2;i++) {
			for(int j=i+1;j<len-1;j++) {
				for(int m=j+1;m<len;m++) {
					res = Math.max(res, nums[i]*nums[j]*nums[m]);
				}
			}
		}
		return res;
    }
	
	// 2.先排序再查找
	public static int maximumProduct2(int[] nums) {
		int len = nums.length;
		int[] nums_copy = Arrays.copyOf(nums, len);
		Arrays.sort(nums_copy);
		return Math.max(nums_copy[0]*nums_copy[1]*nums_copy[len-1], nums_copy[len-1]*nums_copy[len-2]*nums_copy[len-3]);
	}
	
	// 3. 一次遍历找出最大的三个值和最小的两个值
	public static int maximumProduct3(int[] nums) {
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		for(int ele:nums) {
			if(ele>=max1) {
				max3 = max2;
				max2 = max1;
				max1 = ele;
			}else if(ele>=max2) {
				max3 = max2;
				max2 = ele;
			}else if(ele>=max3) {
				max3 = ele;
			}
			if(ele<=min1) {
				min2 = min1;
				min1 = ele;
			}else if(ele<=min2) {
				min2 = ele;
			}
		}
		return Math.max(max1*max2*max3, max1*min1*min2);
	}
}