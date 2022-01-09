package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1080. 행렬
 * 2022.01.09
 * Study week 17
 * @author Chaerin Yu
 *
 */
public class BOJ_1080 {

	static int N, M; // 행렬 크기
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		
		// 2 1
		// 01
		// 01
		// 3x3 안되지만 바꿀 필요가 없는 경우 0으로 출력해줘야 한다.  
//		// 부분집합 크기가 3x3이므로 무조건 안 된다.
//		if(N < 3 || M < 3) {
//			System.out.println(-1);
//			System.exit(0);
//		}
		
		// a matrix
		boolean[][] aMatrix = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if('1' == arr[j]) aMatrix[i][j] = true;
			}
		}
		
		// b matrix
		boolean[][] bMatrix = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if('1' == arr[j]) bMatrix[i][j] = true;
			}
		}
		
		int res = 0;
		for (int i = 0; i <= N-3; i++) {
			for (int j = 0; j <= M-3; j++) {
				if(bMatrix[i][j] != aMatrix[i][j]) {
					res++;
					for (int n = i; n < i+3; n++) {
						for (int m = j; m < j+3; m++) {
							aMatrix[n][m] = !aMatrix[n][m];
						}
					}
				}
			}
		}
		
		// 다 전환하고 난 뒤에 값들이 다른 경우 바꿀수 없는 경우
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(aMatrix[i][j] != bMatrix[i][j]) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		
		System.out.println(res);
	}

}
