/*
https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 
题目难度：简单

题目：有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。

示例 1:
输入: bits = [1, 0, 0]
输出: True
解释: 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。

示例 2:
输入: bits = [1, 1, 1, 0]
输出: False
解释: 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。

注意:
1 <= len(bits) <= 1000.
bits[i] 总是0 或 1.

 * */

public class Solution {
	public static void main(String[] args) {
		int[] bits1 = new int[] {1, 1, 0};
		int[] bits2 = new int[] {1, 1, 1, 0};
		System.out.println(isOneBitCharacter1(bits1));
		System.out.println(isOneBitCharacter1(bits2));
		System.out.println(isOneBitCharacter2(bits1));
		System.out.println(isOneBitCharacter2(bits2));
		System.out.println(isOneBitCharacter3(bits1));
		System.out.println(isOneBitCharacter3(bits2));
	}
	
	// 一次遍历
	public static boolean isOneBitCharacter1(int[] bits) {
		int len = bits.length, i = 0;
		while(i<len-1) {
			if(bits[i]==1) i++;
			i++;
		}
		return i==len-1;
    }
	
	// 一次遍历，优化版
	public static boolean isOneBitCharacter2(int[] bits) {
		int len = bits.length, i = 0;
		while(i<len-1) {
			i += bits[i] + 1;
		}
		return i==len-1;
	}
	
	// 贪心法
	public static boolean isOneBitCharacter3(int[] bits) {
		int len=bits.length, i=len-2;
		while(i>=0 && bits[i]==1) i--;
		return (len-2-i)%2==0;  // 可以进一步写为return (len-i)%2==0;
	}
}