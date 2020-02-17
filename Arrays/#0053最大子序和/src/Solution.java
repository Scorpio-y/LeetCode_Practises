/*
https://leetcode-cn.com/problems/maximum-subarray/

��Ŀ�Ѷȣ���

��Ŀ��
����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		int res1 = maxSubArray1(nums);
		int res2 = maxSubArray2(nums);
		System.out.println(res1);
		System.out.println(res2);
	}
	
	// 1. ��̬�滮��
	public static int maxSubArray1(int[] nums) {
		int len = nums.length;
        int now = nums[0]; // ��ǰ�׶ε���������
        int res = now;	// ��ĿǰΪֹ����������
        for(int i=1;i<len;i++) {
        	now = Math.max(now, 0) + nums[i];
        	res = Math.max(res, now);
        }
        return res;
    }
	
	// ����һ������ͬ�������������
	public static int maxSubArray2(int[] nums) {
		int len = nums.length;
        int now = nums[0]; // ��ǰ�׶ε���������
        int res = now;	// ��ĿǰΪֹ����������
        for(int i=1;i<len;i++) {
        	if(now<0) {
        		now = nums[i];
        	}else {
        		now += nums[i];
        	}
        	res = Math.max(res, now);
        }
        return res;
    }
	
}