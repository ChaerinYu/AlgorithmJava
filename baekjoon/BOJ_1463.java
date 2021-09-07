package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 1463. 1로 만들기
 * @author ChaerinYu
 * DP: bottom-up
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 * 
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 
 * 연산을 사용하는 횟수의 최솟값을 출력하시오.
 * 
 * 입력
 * 첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.
 * 
 * 출력
 * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 */
public class BOJ_1463 {
	
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		
		go(N);
		
		System.out.println(dp[N]);
	}
	
	static int go(int n) {
		if(n==1) {
			dp[n] = 0;
		} else {
			
			for (int i = 2; i <= N; i++) {
				// -1
				dp[i] = dp[i-1] + 1;
				
				// 3으로 나눴을 때 나눠질 때
				if(i%3==0 && dp[i] > dp[i/3]+1) {
					dp[i] = dp[i/3]+1;
				}
				// 2으로 나눴을 때 나눠질 때
				else if(i%2==0 && dp[i] > dp[i/2]+1) {
					dp[i] = dp[i/2]+1;
				}
			}
			
		}
		return dp[n];
	}
}
