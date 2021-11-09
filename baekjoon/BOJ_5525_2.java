package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 5525. IOIOI
 * 
 * @author ChaerinYu 2021.11.8
 */
public class BOJ_5525_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 정수 N
		int M = Integer.parseInt(br.readLine()); // 문자열 S길이
		char[] arrS = br.readLine().toCharArray();
		
		int[] dp = new int[M];
		int answer = 0;

		for (int i = 1; i < M-1; i++) {
			if(arrS[i]=='O' && arrS[i+1]=='I') {
				dp[i+1] = dp[i-1]+1;
				
				if(dp[i+1] >= N && arrS[i+1-2*N] == 'I')
					answer++;
			}
		}
		
		System.out.println(answer);
	}
}
