package etc.dp;

import java.util.Scanner;

public class DP2_LISTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] LIS = new int[N]; // 각 원소를 끝으로 하는 최장 길이
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int max = 0; // 전체 중의 최대 길이
		// O(n^2) // n(n-1)/2 --> 코드가 복잡하진 않지만 n이 커질수록 불리하다.
		// 시간상으로는 효율적이지 않음.
		for (int i = 0; i < N; i++) { // N번
			LIS[i] = 1; // 자기 자신만 있는 경우
			
			// 앞에 있는 애들과 비교
			for (int j = 0; j < i; j++) { // j: i의 앞 쪽 원소 // 1, 2, ... N-1번
				// LIS[i]: 단계별로 최대값 갱신
				if(arr[j] < arr[i] && LIS[i] < LIS[j]+1) {
					LIS[i] = LIS[j]+1;
				}
			} // i를 끝으로 하는 최장길이 값 계산 완료
			if(max<LIS[i]) max = LIS[i];
//			max = Math.max(max, LIS[i]);
		}
		System.out.println(max);
	}
}
/**
6
3 2 6 4 5 1

3
*/