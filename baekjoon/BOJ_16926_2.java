package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 16926. 배열 돌리기 1
 * min(N, M) mod 2 = 0 <- 무조건 사각형 존재
 */
public class BOJ_16926_2 {

	private static int N, M; // map 배열 크기 가로 세로
	private static int R; // 회전 수
	
	private static int[][] map;
	private static int[][] temp;

	private static int[] dr = {1, 0, -1,  0};
	private static int[] dc = {0, 1,  0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);
		
		map = new int[N+1][M+1];
		temp = new int[N+1][M+1];
		// map 값 입력
		StringTokenizer st = null; 
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 1; c <= M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				temp[r][c] = map[r][c];
			}
		}
		
		// 회전
		while(R-->0) {
			rotate(1);

			// clone
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= M; c++) {
					temp[r][c] = map[r][c];
				}
			}
		}
		
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				System.out.print(map[r][c]+ " ");
			}
			System.out.println();
		}
	}
	
	private static void rotate(int idx) {
		for (int i = 1; i <= N/2; i++) {

			int idxD = 0; int idxR = i, idxC = i;
			while(idxD<4) {
				int nr = idxR+dr[idxD];
				int nc = idxC+dc[idxD];
				
				if(nr<i || nr>N-(i-1) || nc<i || nc>M-(i-1)) {
					idxD++;
					continue;
				}
				map[nr][nc] = temp[idxR][idxC];
				idxR = nr;
				idxC = nc;
			}
		}
	}
}