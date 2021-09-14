package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1463. 1로 만들기
 * @author ChaerinYu
 * 2021.09.14
 */
public class BOJ_1463_3 {

	static int[] dp;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		go(N);
		
		System.out.println(dp[N]);
	}
	
	static void go(int n) {
		
		if(n<=1) {
			dp[n] = 0;
		} else {
		
			for (int i = 2; i <= N; i++) {
			    //bottom up
			    // 1을 뺴는 계산부터 시작해서 작은 계산을 통해 미리 arr[i]에 (최대)값을 메모이제이션
			    // 2로 나누어 떨어지는지 3으로 나누어 떨어지는 경우에 
				// 앞에 계산한 arr[i/2]와 arr[i/3]과 현재의 arr[i]와 비교를 하여
			    // 그 중 최소 값을 arr[i]에 다시 저장(메모이제이션)한다.
				dp[i] = dp[i-1]+1;
				
				if(i%2==0) {
					dp[i] = Math.min(dp[i],  dp[i/2]+1);
				}
				if(i%3==0) {
					dp[i] = Math.min(dp[i],  dp[i/3]+1);
				}
			}
		}
	}
}
