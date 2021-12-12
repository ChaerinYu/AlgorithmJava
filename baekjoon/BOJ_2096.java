package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 2096. 내려가기
 * @author Chaerin Yu
 * 2021.12.10
 * Study 14week
 */
public class BOJ_2096 {

	static int N; // N줄에 숫자 3개씩
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // N줄
		int[][][] dp = new int[N+1][3][2]; // 1: row, 2: column, 3: (0: max, 1: min)
		
		StringTokenizer st = null;
		int num ;
		// 입력받으면서 최대 최소값 구하기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			// 줄마다 최대 최소구하기
			for (int j = 0; j < 3; j++) {
				num = Integer.parseInt(st.nextToken());
				// 0열
				if(j==0) {
					dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j+1][0])+num; // 최대
					dp[i][j][1] = Math.min(dp[i-1][j][1], dp[i-1][j+1][1])+num; // 최소
				}
				// 1열
				else if(j==1) {
					dp[i][j][0] = Math.max(Math.max(dp[i-1][j][0], dp[i-1][j+1][0]), dp[i-1][j-1][0])+num;
					dp[i][j][1] = Math.min(Math.min(dp[i-1][j][1], dp[i-1][j+1][1]), dp[i-1][j-1][1])+num;
				}
				// 2열
				else {
					dp[i][j][0] = Math.max(dp[i-1][j-1][0], dp[i-1][j][0])+num;
					dp[i][j][1] = Math.min(dp[i-1][j-1][1], dp[i-1][j][1])+num;
				}
			}
		}
		
		int max = Math.max(Math.max(dp[N][1][0], dp[N][2][0]), dp[N][0][0]);
		int min = Math.min(Math.min(dp[N][1][1], dp[N][2][1]), dp[N][0][1]);
		
		System.out.printf("%d %d%n", max, min);
	}

}
