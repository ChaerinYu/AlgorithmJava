package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 자연수를 최대 4개 이하의 제곱수 합으로 나타낼 수 있다.
public class BOJ_17626_2 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		int min = 4;
		for (int i = 1; i <= N; i++) {
			min = 4;
			for (int j = 1; j*j <= i; j++) {
				int temp = i-j*j;
				if(min>dp[temp]) min = dp[temp]+1; // i-j*j 에 j*j 더하면 i 완성
			}
			dp[i] = min;
		}
		
		System.out.println(dp[N]);
	}

}
