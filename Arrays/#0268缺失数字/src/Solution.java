import java.util.Arrays;
import java.util.HashSet;

/*
https://leetcode-cn.com/problems/missing-number/
 
��Ŀ�Ѷȣ���

��Ŀ������һ������ 0, 1, 2, ..., n �� n ���������У��ҳ� 0 .. n ��û�г����������е��Ǹ�����

ʾ�� 1:
����: [3,0,1]
���: 2

ʾ�� 2:
����: [9,6,4,2,3,5,7,0,1]
���: 8

 * */

public class Solution {
	public static void main(String[] args) {
		int[] arr1 = new int[] {3,0,1};
		int[] arr2 = new int[] {9,6,4,2,3,5,7,0,1};

		System.out.println(missingNumber1(arr1));
		System.out.println(missingNumber1(arr2));
		System.out.println(missingNumber2(arr1));
		System.out.println(missingNumber2(arr2));
		System.out.println(missingNumber3(arr1));
		System.out.println(missingNumber3(arr2));
		System.out.println(missingNumber4(arr1));
		System.out.println(missingNumber4(arr2));
	}
	
	// 1. ������
	public static int missingNumber1(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int len = nums.length;
        for(int i=0;i<=len;i++) {
        	int j;
        	for(j=0;j<len;j++) {
        		if(nums[j]==i) break;
        	}
        	if(j==len) return i;
        }
        return -1;	// ��㷵��һ�����֣���Ϊ������ִ�е���һ��
    }
	
	// 2. �������ٲ���
	public static int missingNumber2(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int len = nums.length;
		int[] nums_copy = Arrays.copyOf(nums, len);
		Arrays.sort(nums_copy);
		for(int i=0;i<len;i++) {
			if(nums_copy[i]!=i) return i;
		}
		return len;
	}

	// 3. HashSet
	public static int missingNumber3(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int len = nums.length;
		HashSet<Integer> set = new HashSet<>();
		for(int ele:nums) set.add(ele);
		for(int i=0;i<=len;i++) {
			if(!set.contains(i)) return i;
		}
		return -1;
	}
	
	// 4. ��ѧ����
	public static int missingNumber4(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int len = nums.length;
		long sum_nums = 0;
		for(int ele:nums) sum_nums+=ele;
		long sum = len*(len+1)/2;
		return  (int) (sum-sum_nums);
	}
    
}