/*
https://leetcode-cn.com/problems/search-insert-position/

��Ŀ�Ѷȣ���

��Ŀ��
����һ���������飨���򣩺�һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ����������������
���Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
����Լ������������ظ�Ԫ�ء�

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums1 = new int[] {1,3,5,6};
		int target = 0;
		int res1 = searchInsert1(nums1, target);
		int res2 = searchInsert2(nums1, target);
		System.out.println(res1);
		System.out.println(res2);
	}
	
	// 1. ���β�ѯ
	public static int searchInsert1(int[] nums, int target) {
        if(nums==null || nums.length==0) return 0;
        int len = nums.length;
        for(int i=0;i<len;i++) {
        	if(target<=nums[i]) return i;
        }
        return len;
    }
	
	// ���ַ���ѯ
	public static int searchInsert2(int[] nums, int target) {
		if(nums==null || nums.length==0) return 0;
        int left = 0, right = nums.length-1, mid;
        while(left<=right) {
        	mid = (left+right)/2;
        	if(target>nums[mid]) {
        		left = mid+1;
        	}else {
        		right = mid-1;
        	}
        }
        return left;
	}
}