package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1149. RGB 거리
 * @author ChaerinYu
 * 
 * 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
	1번 집의 색은 2번 집의 색과 같지 않아야 한다.
	N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
	i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
 * 입력
 * 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 
 * 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 
 * 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
 * 
 * 출력
 * 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
 */
public class BOJ_1149 {

	static int N; // 집 수
	static int[][] house; // 각 집 각 색상 비용
	
	static int[] dp;
	static int prevColor, currColor;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		// 각 집 별, 색상 가격
		house = new int[N+1][3];
		int red, green, blue;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			red = Integer.parseInt(st.nextToken());
			green = Integer.parseInt(st.nextToken());
			blue = Integer.parseInt(st.nextToken());
			
			house[i][0] = red;
			house[i][1] = green;
			house[i][2] = blue;
		}

		dp = new int[3];
		int redhouse, greenhouse, bluehouse;
		// 집 개수 만큼 for문 돌린다.
		for (int i = 1; i <= N; i++) {
			// index 0는 값이 0이므로 무시해도 됨
			redhouse = dp[0];
			greenhouse = dp[1];
			bluehouse = dp[2];
			
			// 색상 수 만큼 for문 돌린다.
			for (int j = 0; j < 3; j++) {
				// 이전 집이 green 또는 blue house (최소 가격의 집) 일 때, 현재 집의 red 가격 입력
				if(j==0)
					dp[j] = (greenhouse > bluehouse ? bluehouse : greenhouse) + house[i][j]; 
				// 이전 집이 red 또는 blue house (최소 가격의 집) 일 때, green 가격 입력
				else if(j==1)
					dp[j] = (redhouse > bluehouse ? bluehouse : redhouse) + house[i][j];
				// 이전 집이 red 또는 green house (최소 가격의 집) 일 때, blue 가격 입력
				else
					dp[j] = (redhouse > greenhouse ? greenhouse : redhouse) + house[i][j];
			}
		}
		
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			res = Math.min(dp[i], res);
		}
		System.out.println(res);
	}
	
	/*
	static void pick() {
		int total = 0;
		for (int i = 1; i <= N; i++) {
			// R, G, B
			for (int j = 0; j < 3; j++) {
				if(dp[i] >= house[i][j] && prevColor != j) {
					dp[i] = house[i][j];
					currColor = j;
				}
			}
			total += dp[i];
			prevColor = currColor;
		}
		System.out.println(total);
	}
	*/
}

/**
3
26 40 83
49 60 57
13 89 99

96
**/