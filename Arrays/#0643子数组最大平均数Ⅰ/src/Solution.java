/*
https://leetcode-cn.com/problems/maximum-average-subarray-i/
 
��Ŀ�Ѷȣ���

��Ŀ������ n ���������ҳ�ƽ��������ҳ���Ϊ k �����������飬����������ƽ������

ʾ�� 1:
����: [1,12,-5,-6,50,3], k = 4
���: 12.75
����: ���ƽ���� (12-5-6+50)/4 = 51/4 = 12.75

ע��:
1 <= k <= n <= 30,000��
�������ݷ�Χ [-10,000��10,000]��

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[] {1,12,-5,-6,50,3};
		int k = 4;
		System.out.println(findMaxAverage1(nums,k));
		System.out.println(findMaxAverage2(nums,k));
	}
	
	// 1.������
	public static double findMaxAverage1(int[] nums, int k) {
		double res = Double.MIN_VALUE;
		int len = nums.length;
		for(int i=0;i<=len-k;i++) {
			res = Math.max(res, nums[i]+nums[i+1]+nums[i+2]+nums[i+3]);
		}
		return res/k;
    }
	
	// ����1���Ż������ͼ�����
	public static double findMaxAverage2(int[] nums, int k) {
		double res = 0;
		for(int i=0;i<k;i++) res += nums[i];
		int len = nums.length;
		for(int i=1;i<=len-k;i++) {
			res = Math.max(res, res-nums[i-1]+nums[i+k-1]);
		}
		return res/k;
	}

}