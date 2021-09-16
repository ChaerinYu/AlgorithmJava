package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * [D6] 1263. [S/W 문제해결 응용] 8일차 - 사람 네트워크2
 * @author ChaerinYu
 * 플로이드 와샬 알고리즘 floyd-warshall
 * bfs
 * 
 */
public class SWEA_1263 {

	static int T, N; // 테스트 케이스 수, 사람 수
	static int[][] arr;
	static int MAX;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] strarr = br.readLine().split(" ");
			N = Integer.parseInt(strarr[0]); // 사람 수
			
			int idx = 1; MAX = N*N;
			arr = new int[N][N]; // array 입력
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(strarr[idx++]);
					if(r!=c && arr[r][c] == 0) arr[r][c] = MAX; // 최대값 입력
//					if(r==c) arr[r][c]=0; // 자기자신 0
				}
			}
			
			// 플로이드 와샬 알고리즘 경유지 출발지 도착지
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
//					if(i==k) continue; // 경유지와 출발지가 같은 경우 continue -> continue안하는게 더 빠름
					for (int j = 0; j < N; j++) {
//						if(j==k || j==i) continue; // 경유지와 도착지가 같은 경우 또는 출발지와 경유지 같은 경우 무시
						if(arr[i][j] > arr[i][k]+arr[k][j]) {
							arr[i][j] = arr[i][k]+arr[k][j];
						}
//						arr[i][j] = Math.min(arr[i][k]+arr[k][j], arr[i][j]);
//						res = Math.min(res, arr[i][j]);
					}
				}
			}
			
			int res = MAX;
			// row별로 계산
			for (int i = 0; i < N; i++) {
				int temp = 0;
				for (int j = 0; j < N; j++) {
					temp += arr[i][j];
				}

				if(res>temp) {
					res = temp;
				}
			}

			System.out.println("#"+tc+" "+res);
			
		}
	}
}
