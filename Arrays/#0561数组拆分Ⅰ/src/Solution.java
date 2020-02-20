import java.util.Arrays;

/*
https://leetcode-cn.com/problems/array-partition-i/
 
题目难度：简单

题目：给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。

示例 1：
输入: [1,4,3,2]
输出: 4
解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).

提示:
n 是正整数,范围在 [1, 10000].
数组中的元素范围在 [-10000, 10000].

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[] {1,4,3,2};
		System.out.println(arrayPairSum(nums));
	}
	
	/*拿{1,2,3,4,5,6}举例，1作为最小值，不管跟谁配对最后都会取到1的值，所以为了优化，
	就要把倒数第二大的值，也就是2，尽可能的弄没，所以让他跟1一组，这样就把倒数第二
	大的值消除了，现在剩下的里面最小的也是倒数第三小的也就是3，同样的，3作为最小值
	也无法被避免取到，所以得找这里倒数第二大的也就是4，跟他配对。这样一层一层的，
	也就成了奇数位即为所求了。*/
	// 1. 先排序再计算
	public static int arrayPairSum(int[] nums) {
        int len = nums.length;
        int[] nums_copy = Arrays.copyOf(nums, len);
        Arrays.sort(nums_copy);
        int res = 0;
        for(int i=0;i<len;i+=2) res += nums_copy[i];
        return res;
    }

}