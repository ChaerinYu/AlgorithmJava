package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1463. 1로 만들기
 * @author ChaerinYu
 * 2021.09.14
 */
public class BOJ_1463_2 {

	static int[] dp;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
		
		go(N);
		
		System.out.println(dp[N]);
	}
	
	static int go(int n) {
		dp[1] = 0;
			
        for (int i = 2; i <= N; i++) {

            dp[i] = dp[i-1]+1;

            if(i%2==0) {
                dp[i] = Math.min(dp[i],  dp[i/2]+1);
            }
            if(i%3==0) {
                dp[i] = Math.min(dp[i],  dp[i/3]+1);
            }
        }
			
		return dp[n];
	}
}
