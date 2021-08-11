package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 16926. 배열 돌리기 1
 * min(N, M) mod 2 = 0 <- 무조건 사각형 존재
 */
public class BOJ_16926 {

	private static int N, M; // map 배열 크기 가로 세로
	private static int R; // 회전 수
	
	private static int[][] map;
	private static int[][] temp;
	
//	private static int[] dr = {0,  1, 0, -1};
//	private static int[] dc = {-1, 0, 1,  0};
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
			for (int i = 1; i <= N/2; i++) {
//				rotate(i, i);

				int idxD = 0; int idxR = i, idxC = i;
				while(idxD<4) {

					int nr = idxR+dr[idxD];
					int nc = idxC+dc[idxD];
					
					if(nr<i || nr>N-(i-1) || nc<i || nc>M-(i-1)) {
						idxD++;
						continue;
					}
//					int tempD = map[nr][nc];
					
					map[nr][nc] = temp[idxR][idxC];
					idxR = nr;
					idxC = nc;
				}
			}

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
	/*
	// 이거 쓰면 시간초과 ㅡㅡ
	private static void rotate(int idxR, int idxC) {
		int dir = 0;
		// 상 변  r: idxR					, c: idxC, .., M-(idxC-1)
		// 하 변  r: N-(idxR-1)			, c: idxC, .., M-(idxC-1)
		// 좌 변  r: idxR, ..., N-(idxR-1)	, c: idxC
		// 우 변  r: idxR, ..., N-(idxR-1)	, c: M-(idxC-1)
		
		
		for (int r = idxR; r <= N-(idxR-1); r++) {
			for (int c = idxC; c <= M-(idxC-1); c++) {
				
				if(r == idxR && c > idxC) {
					// 좌
					dir = 0;
				} else if (r < N-(idxR-1) && c == idxC) {
					// 하
					dir = 1;
				} else if (r == N-(idxR-1) && c < M-(idxC-1)) {
					// 우
					dir = 2;
				} else if (r > idxR && c == M-(idxC-1)) {
					// 상
					dir = 3;
				} else {
					continue;
				}
				
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				map[nr][nc] = temp[r][c];
			}
		}
	}
	*/
}