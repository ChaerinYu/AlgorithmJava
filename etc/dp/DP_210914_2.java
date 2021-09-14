package etc.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 막대 색칠하기 
 * @author ChaerinYu
 * 2021.09.03 DP를 이용
 * 1cm 짜리 파란 막대와 1cm 짜리 노란 막대 그리고 2cm 짜리 빨간 막대가 있다. 
 * 이 막대들을 연결하여 길이가 ncm 인 막대를 만드는 방법의 수를 f(n)이라 하자.
 */
public class DP_210914_2 {

	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		dp[1] = 2;
		dp[2] = 5;
		
		go(N);
		
		System.out.println(dp[N]);
	}
	
	static int go (int n) {
		for (int i = 3; i <= n; i++) {
			if(i>2 && dp[i]==0) {
				dp[i] = dp[i-1]*2+dp[i-2];
			}
		}
		return dp[n];
	}

}
