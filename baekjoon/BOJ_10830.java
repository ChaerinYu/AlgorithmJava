package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10830. 행렬 제곱
 * @author Chaerin Yu
 * 
 */
public class BOJ_10830 {

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
//		answer = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				// MOD로 나눈 나머지값 저장한다.
				// 각 원소를 1,000으로 나눈 나머지를 출력해야하므로 입력할 때 부터 모듈러연산을 해준다.
				// ((a % n)*(b % n)) % n => (a*b)%n 
				matrix[i][j] = Integer.parseInt(st.nextToken()) % MOD;
//				answer[i][j] = matrix[i][j];
			}
		}
		
		answer = make(matrix, B);
//		answer = new int[N][N];
//		int temp = 0;
//		for (int m = 0; m <= B; m++) {
//			for (int i = 0; i < N; i++) {
//				temp = 0;
//				for (int j = 0; j < N; j++) {
//					for (int k = 0; k < N; k++) {
//						temp += matrix[i][k]*matrix[k][j];
//						temp %= MOD;
//					}
//					answer[i][j] = temp;
//				}
//			}
//		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(answer[i][j]%MOD).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	private static int[][] make(int[][] matrixArr, long b2) {
		// 1일 때
		if(b2 == 1) return matrixArr;
		
		// 행렬 분할하여 연산
		int[][] temp = make(matrixArr, b2 / 2);
		temp = multiply(temp, temp);
		
		// 홀수 인 경우, 기존 값 한 번 더 곱해준다.
		if(b2 % 2 == 1) temp = multiply(temp, matrix);
		
		return temp;
	}

	private static int[][] multiply(int[][] m1, int[][] m2) {
		int[][] res = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
					res[i][j] %= MOD; // 모듈러 연산 해준다. (모듈러 연산 덧셈)
				}
			}
		}
		return res;
	}
}
