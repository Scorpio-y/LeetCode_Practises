/*
https://leetcode-cn.com/problems/fibonacci-number/
 
��Ŀ�Ѷȣ���

��Ŀ��쳲���������ͨ���� F(n) ��ʾ���γɵ����г�Ϊ쳲��������С�
�������� 0 �� 1 ��ʼ�������ÿһ�����ֶ���ǰ���������ֵĺ͡�Ҳ���ǣ�
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), ���� N > 1.
���� N������ F(N)��

ʾ�� 1��
���룺2
�����1
���ͣ�F(2) = F(1) + F(0) = 1 + 0 = 1.

ʾ�� 2��
���룺3
�����2
���ͣ�F(3) = F(2) + F(1) = 1 + 1 = 2.

ʾ�� 3��
���룺4
�����3
���ͣ�F(4) = F(3) + F(2) = 2 + 1 = 3.

��ʾ��
0 �� N �� 30

 * */

public class Solution {
	public static void main(String[] args) {
		System.out.println(fib1(20));
		System.out.println(fib2(20));
	}
	
	// 1. �ݹ�
	public static int fib1(int N) {
        if(N<=1) return N;
        return fib1(N-1)+fib1(N-2);
    }
	
	// 2. �ǵݹ�
	public static int fib2(int N) {
		if(N<=1) return N;
		int pre1 = 1;  // ��ǰ��һ��
		int pre2 = 0;  // ��ǰ������
		int res = 0;
		for(int i=2;i<=N;i++) {
			res = pre1+pre2;
			pre2 = pre1;
			pre1 = res;
		}
		return res;
	}
}