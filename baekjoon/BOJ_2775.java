package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2021.11.20
 * @author Chaerin Yu
 * 부녀회장이 될테야
 */
public class BOJ_2775 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] people = new int[15][15]; // 층x호
		for (int i = 0; i < people.length; i++) {
			people[0][i] = i; // 0층 i호
			people[i][1] = 1; // i층 1호
		}
		for (int i = 1; i < people.length; i++) {
			for (int j = 2; j < people.length; j++) {
				people[i][j] = people[i-1][j] + people[i][j-1]; // 이전 층 같은 호 + 같은 층 이전 호
			}
		}
		
		
		int T = Integer.parseInt(br.readLine()); // test case
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine()); // 층
			int n = Integer.parseInt(br.readLine()); // 호
			
			sb.append(people[k][n]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
