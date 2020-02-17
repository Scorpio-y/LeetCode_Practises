import java.util.Arrays;

/*
https://leetcode-cn.com/problems/plus-one/

��Ŀ�Ѷȣ���

��Ŀ��
����һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��
���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢�������֡�
����Լ���������� 0 ֮�⣬��������������㿪ͷ��

 * */

public class Solution {
	public static void main(String[] args) {
		int[] digits = new int[] {9,9,9,9};
		int[] res = plusOne(digits);
		System.out.println(Arrays.toString(res));
	}
	
	// 1. �Ӻ���ǰ����
	public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i=len-1;i>=0;i--) {
        	if(digits[i]<9) {
        		digits[i]++;
        		return digits;
        	}
        	digits[i]=0;
        }
        int[] res =  new int[len+1];
        res[0] = 1;
        return res;
    }
	
}