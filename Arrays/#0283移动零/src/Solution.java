import java.util.Arrays;

/*
https://leetcode-cn.com/problems/move-zeroes/
 
��Ŀ�Ѷȣ���

��Ŀ������һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��

ʾ�� :
����: [0,1,0,3,12]
���: [1,3,12,0,0]

˵��:
������ԭ�����ϲ��������ܿ�����������顣
�������ٲ���������

 * */

public class Solution {
	public static void main(String[] args) {
		int[] arr1 = new int[] {0,1,0,3,12};
		int[] arr2 = new int[] {0,1,0,3,12};
		moveZeroes1(arr1);
		moveZeroes1(arr2);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}
	
	// 1. ˫ָ�뷨
	public static void moveZeroes1(int[] nums) {
        if(!(nums==null || nums.length==0)) {
        	int len = nums.length;
        	int slow = 0;
        	for(int fast=0;fast<len;fast++) {
        		if(nums[fast]!=0) nums[slow++] = nums[fast];
        	}
        	for(;slow<len;slow++) nums[slow] = 0;
        }
    }
	
	// 2. ˫ָ�뷨���򻯰棬�÷�����ȥ�˷���1�����һ��ѭ������������˷���slowָ���Ԫ��ֵ����Ϊ0
	public static void moveZeroes2(int[] nums) {
        if(!(nums==null || nums.length==0)) {
        	int len = nums.length;
        	int slow = 0;
        	for(int fast=0;fast<len;fast++) {
        		if(nums[fast]!=0) {
        			int tmp = nums[slow];
        			nums[slow++] = nums[fast];
        			nums[fast] = tmp;
        		}
        	}
        }
	}
}