/*
https://leetcode-cn.com/problems/can-place-flowers/
 
题目难度：简单

题目：假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？
能则返回True，不能则返回False。

示例 1:
输入: flowerbed = [1,0,0,0,0,1], n = 1
输出: True

示例 2:
输入: flowerbed = [1,0,0,0,0,1], n = 2
输出: False

注意:
数组内已种好的花不会违反种植规则。
输入的数组长度范围为 [1, 20000]。
n 是非负整数，且不会超过输入数组的大小。

 * */

public class Solution {
	public static void main(String[] args) {
		int[] flowerbed1 = new int[] {1,0,0,0,0,1};
		int[] flowerbed2 = new int[] {1,0,0,0,0,1};
		int n1 = 1;
		int n2 = 2;
		System.out.println(canPlaceFlowers1(flowerbed1,n1));
		System.out.println(canPlaceFlowers1(flowerbed1,n2));
		System.out.println(canPlaceFlowers2(flowerbed2,n1));
		System.out.println(canPlaceFlowers2(flowerbed2,n2));
	}
	
	// 1. 判断每个元素的两边是否都为0
	public static boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int count = 0;
        for(int i=0;i<len;i++) {
        	if(i==0 && flowerbed[i]==0 && flowerbed[Math.min(i+1, len)]==0) {
        		count++;
        		flowerbed[i]=1;
        	}
        	else if(i==len-1 && flowerbed[i]==0 && flowerbed[i-1]==0) {
        		count++;
        		flowerbed[i]=1;
        	}
        	else if(flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0) {
        		count++;
        		flowerbed[i]=1;
        	}
        }
        return count>=n?true:false;
    }
	
	// 2. 方法1的简化版
		public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
	        int len = flowerbed.length;
	        int count = 0;
	        for(int i=0;i<len;i++) {
	        	if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==len-1 || flowerbed[i+1]==0)) {
	        		count++;
	        		flowerbed[i]=1;
	        	}
	        }
	        return count>=n?true:false;
	    }

}