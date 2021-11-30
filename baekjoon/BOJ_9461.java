package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 2021.11.30
 * @author Chaerin Yu
 * 9461. 파도반 수열
 * 범위를 잘 확인하자 ㅎㅎ^^
 */
public class BOJ_9461 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		long[] P = new long[101];
		P[1] = P[2] = P[3] = 1;
		P[4] = P[5] = 2;
		for (int i = 6; i <= 100; i++) {
			P[i] = P[i-5]+P[i-1];
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(P[N]).append("\n");
		}
		
		System.out.print(sb.toString());
	}

}
