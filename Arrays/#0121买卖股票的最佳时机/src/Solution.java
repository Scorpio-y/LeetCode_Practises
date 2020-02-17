import java.util.Arrays;

/*
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/

题目难度：简单

题目：
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
注意你不能在买入股票前卖出股票。

 * */

public class Solution {
	public static void main(String[] args) {
		int[] prices = new int[] {7,1,5,3,6,4};
		System.out.println(maxProfit1(prices));
		System.out.println(maxProfit2(prices));
	}
	
	// 1. 暴力法，双重循环
	public static int maxProfit1(int[] prices) {
        if(prices==null || prices.length<2) return 0;
        int len = prices.length;
        int res = 0;
        for(int i=0;i<len-1;i++) {
        	for(int j=i+1;j<len;j++) {
        		res = Math.max(res, prices[j]-prices[i]);
        	}
        }
        return res;
    }
	
	// 一次遍历
	public static int maxProfit2(int[] prices) {
        if(prices==null || prices.length<2) return 0;
        int res = 0;
        int minPrice = prices[0];
        int len = prices.length;
        for(int i=1;i<len;i++) {
        	res = Math.max(res, prices[i]-minPrice);
        	minPrice = Math.min(minPrice, prices[i]);
        }
        return res;
    }
}