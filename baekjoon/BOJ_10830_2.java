package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10830. 행렬 제곱
 * @author Chaerin Yu
 * 반복문
 */
public class BOJ_10830_2 {

	static final int MOD = 1_000;
	static int N ; // 행렬 크기
	static long B; // 제곱 수
	static int[][] matrix, answer; // 행렬
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 행렬크기 2 ≤ N ≤  5
		B = Long.parseLong(st.nextToken()); // 제곱 수 1 ≤ B ≤ 100,000,000,000
		
		matrix = new int[N][N]; // 각 원소는 1,000보다 작거나 같은 자연수 or 0
		answer = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				// MOD로 나눈 나머지값 저장한다.
				matrix[i][j] = Integer.parseInt(st.nextToken()) % MOD;
			}
			answer[i][i] = 1; // 단위행렬
		}
		
		while(B > 0) {
			// 홀수일 때에만 
			if(B%2 == 1) {
				answer = multiply(answer, matrix);
			}
			// 제곱행렬로 갱신
			matrix = multiply(matrix, matrix);
			B/=2;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(answer[i][j]%MOD).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	private static int[][] multiply(int[][] m1, int[][] m2) {
		int[][] res = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
					res[i][j] %= MOD;
				}
			}
		}
		return res;
	}
}
