package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 5525. IOIOI
 * 
 * @author ChaerinYu 2021.11.8
 */
public class BOJ_5525 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 정수 N
		int M = Integer.parseInt(br.readLine()); // 문자열 S길이
		String S = br.readLine();
		
		int[] dp = new int[M];
		int answer = 0;

		for (int i = 2; i < M; i++) {
			String temp = S.substring(i-2, i+1);
			if(temp.equals("IOI"))
				dp[i] = dp[i-2]+1;
			if(dp[i] >= N)
				answer++;
		}
		
		System.out.println(answer);
	}
}
