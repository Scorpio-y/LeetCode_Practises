/*
https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 
��Ŀ�Ѷȣ���

��Ŀ������һ��δ��������������飬�ҵ���������ĵĵ������С�

ʾ�� 1:
����: [1,3,5,4,7]
���: 3
����: ��������������� [1,3,5], ����Ϊ3��
���� [1,3,5,7] Ҳ�������������, �������������ģ���Ϊ5��7��ԭ�����ﱻ4������ 

ʾ�� 2:
����: [2,2,2,2,2]
���: 1
����: ��������������� [2], ����Ϊ1��

ע�⣺���鳤�Ȳ��ᳬ��10000��

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums1 = new int[] {1,3,5,4,7};
		int[] nums2 = new int[] {2,2,2,2,2};
		System.out.println(findLengthOfLCIS(nums1));
		System.out.println(findLengthOfLCIS(nums2));
	}
	
	// 1.һ�α���
	public static int findLengthOfLCIS(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int len = nums.length;
		int res = 0, count = 1;
		for(int i=1;i<len;i++) {
			if(nums[i]>nums[i-1]) {
				count++;
			}
			else {
				res = Math.max(res, count);
				count = 1;
			}
		}
		res = Math.max(res, count);
		return res;
    }

}