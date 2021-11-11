package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 17626 Four Squares
 * @author chaerin yu
 * 2021.11.11
 * bottom-up dp
 */
public class BOJ_17626 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 자연수
		int[] dp = new int[n+1];
		
		int min = 4; // 최대 4개의 수로 표현 가능하니까 최대 4
		for (int i = 1; i <= n; i++) {
			min = 4;
			for (int j = 1; j*j <= i; j++) {
				int temp = i - j*j;
				if(min>dp[temp]) min = dp[temp]+1;
			}
			
			dp[i] = min;
		}
		
		System.out.println(dp[n]);
	}

}
