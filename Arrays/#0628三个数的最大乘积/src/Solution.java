import java.util.Arrays;

/*
https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 
��Ŀ�Ѷȣ���

��Ŀ������һ���������飬���������ҳ�����������ɵ����˻������������˻���

ʾ�� 1:
����: [1,2,3]
���: 6

ʾ�� 2:
����: [1,2,3,4]
���: 24

ע��:
�������������鳤�ȷ�Χ��[3,104]�����������е�Ԫ�ط�Χ��[-1000, 1000]��
����������������������ĳ˻����ᳬ��32λ�з��������ķ�Χ��

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
	
	// 1. ������
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
	
	// 2.�������ٲ���
	public static int maximumProduct2(int[] nums) {
		int len = nums.length;
		int[] nums_copy = Arrays.copyOf(nums, len);
		Arrays.sort(nums_copy);
		return Math.max(nums_copy[0]*nums_copy[1]*nums_copy[len-1], nums_copy[len-1]*nums_copy[len-2]*nums_copy[len-3]);
	}
	
	// 3. һ�α����ҳ���������ֵ����С������ֵ
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