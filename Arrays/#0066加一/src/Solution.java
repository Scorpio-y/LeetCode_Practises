import java.util.Arrays;

/*
https://leetcode-cn.com/problems/plus-one/

题目难度：简单

题目：
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

 * */

public class Solution {
	public static void main(String[] args) {
		int[] digits = new int[] {9,9,9,9};
		int[] res = plusOne(digits);
		System.out.println(Arrays.toString(res));
	}
	
	// 1. 从后向前遍历
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