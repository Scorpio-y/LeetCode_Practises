import java.util.Arrays;

/*
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

��Ŀ�Ѷȣ���

��Ŀ��
����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�

˵���������������ԡ����á���ʽ���ݵģ�����ζ���ں������޸�����������ڵ������ǿɼ��ġ�

 * */

public class Solution {
	public static void main(String[] args) {
		int[] nums1 = new int[] {0,0,1,1,1,2,2,3,3,4};
		int[] nums2 = new int[] {0,0,1,1,1,2,2,3,3,4};
		int res1 = removeDuplicates1(nums1);
		int res2 = removeDuplicates2(nums2);
		System.out.println(res1);System.out.println(Arrays.toString(nums1));
		System.out.println(res2);System.out.println(Arrays.toString(nums2));
	}
	
	// 1. ˫ָ�뷨������ָ�룩
    public static int removeDuplicates1(int[] nums) {
    	if(nums==null || nums.length==0) return 0;
    	int len = nums.length;
    	int res = 1;	// ��ָ��
    	for(int i=1;i<len;i++) {
    		if(nums[i]!=nums[i-1]) {
    			nums[res++] = nums[i];
    		}
    	}
    	return res;
    }
    
    // 2. �½�����
    public static int removeDuplicates2(int[] nums) {
    	if(nums==null || nums.length==0) return 0;
    	int len = nums.length;
    	int[] newarray = new int[len];
    	newarray[0] = nums[0]; int res = 1;
    	for(int i=1;i<len;i++) {
    		if(nums[i]!=nums[i-1]) {
    			newarray[res++] = nums[i];
    		}
    	}
    	for(int i=0;i<res;i++) {
    		nums[i] = newarray[i];
    	}
    	return res;
    }
}