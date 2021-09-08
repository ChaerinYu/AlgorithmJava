package test;

import java.io.IOException;

/**
 * 정수 2개부터 17개까지 주어졌을 때 두 묶음으로 나눠서 두 묶음의 차이의 최솟값 구하기
 * @author user
 * (1,2,3,5) 는 답 1
 * (-1, -2, 1, 2) 는 답 0
 * (50, -50) 는 답 100
 */
public class TwoSetDiffTest {
//	static int[] arr = {1, 2, 3, 5};
	static int[] arr = {50, -50};
	static int n = arr.length/2; // 묶음 당 개수
	
	static int[] temp = new int[n];
	static int[] other = new int[n];
	static int[] tempIndex = new int[arr.length];
	
	static int res = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		combination(0, 0);
		
		System.out.println(res);
	}
	
	static void combination(int index, int cnt) {
		if(cnt == n) {
//			System.out.println(Arrays.toString(temp));
			// 다른 묶음 집합 구하기
			tempIndex = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < temp.length; j++) {
					if(temp[j]==arr[i]) {
						tempIndex[i] = 1;
						break;
					}
				}
			}
			int idx=0;
			for (int i = 0; i < tempIndex.length; i++) {
				if(tempIndex[i]==0) {
					other[idx++]=arr[i];
				}
			}
			
			// 각 묶음 합 구하기
			int tempSum = 0;
			for (int i = 0; i < temp.length; i++) {
				tempSum += temp[i];
			}
			int otherSum = 0;
			for (int i = 0; i < other.length; i++) {
				otherSum += other[i];
			}
//			System.out.println(Arrays.toString(other));
			res = Math.min(res, Math.abs(tempSum-otherSum));
//			System.out.println("res: "+res+", -: "+Math.abs(tempSum-otherSum));
			
			return;
		}
		
		for (int i = index; i < arr.length; i++) {
			temp[cnt] = arr[i];
			
			combination(i+1, cnt+1);
		}
	}
}
