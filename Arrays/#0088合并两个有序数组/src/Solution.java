import java.util.Arrays;

/*
https://leetcode-cn.com/problems/merge-sorted-array/

题目难度：简单

题目：
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明：
初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums11 = new int[] {1,2,7,0,0,0,0};
		int[] nums12 = new int[] {1,2,7,0,0,0,0};
		int[] nums21 = new int[] {2,5,6};
		int[] nums22 = new int[] {2,5,6};
		merge1(nums11,3,nums21,3);
		merge2(nums12,3,nums22,3);
		System.out.println(Arrays.toString(nums11));
		System.out.println(Arrays.toString(nums12));
	}
	
	// 1. 先合并数组，再排序
	public static void merge1(int[] nums1, int m, int[] nums2, int n) {
//        for(int i=0;i<n;i++) nums1[i+m] = nums2[i];
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1, 0, m+n);
    }
	
	// 2. 双指针法
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		int[] nums1_copy = Arrays.copyOf(nums1, m);		// 复制数组
		int i=0, j=0, idx=0;	// 双指针
		while(i<m && j<n) {
			if(nums1_copy[i]<nums2[j]) {
				nums1[idx++] = nums1_copy[i++];
			}else {
				nums1[idx++] = nums2[j++];
			}
		}
		if(i==m) {
			System.arraycopy(nums2,j,nums1,idx,n-j);
		}else {
			System.arraycopy(nums1_copy,i,nums1,idx,m-i);
		}
	}
	
}