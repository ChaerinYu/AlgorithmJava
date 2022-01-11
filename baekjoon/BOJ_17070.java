package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 17070. 파이프 옮기기 1
 * @author Chaerin Yu
 * 2022.01.11
 * study 17week 재귀
 */
public class BOJ_17070 {

	static int N; // 집 크기
	static int[][] home; // 집
	
	static int res; // 정답
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 집 크기 3 ≤ N ≤ 16
		
		home = new int[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		res = 0;
		// (0, 1)에서 가로방향 시작
		go(0, 1, 0);
		
		System.out.println(res);
	}

	private static void go(int r, int c, int dir) {
		if(r == N-1 && c == N-1) {
			res++;
			return;
		}
		
		if(dir == 0) {
			// 가로방향인 경우, 오른쪽 또는 대각선으로 이동 가능
			if(c+1 < N && home[r][c+1] == 0) {
				go(r, c+1, 0);
			}
		} else if(dir == 1) {
			// 세로방향인 경우, 아래 또는 대각선으로 이동 가능
			if(r+1 < N && home[r+1][c] == 0) {
				go(r+1, c, 1);
			}
		} else if(dir == 2) {
			// 대각선방향인 경우, 오른쪽, 아래, 대각선으로 이동 가능
			if(c+1 < N && home[r][c+1] == 0) {
				go(r, c+1, 0);
			}
			if(r+1 < N && home[r+1][c] == 0) {
				go(r+1, c, 1);
			}
		}
		if(r+1 < N && c+1 < N && home[r+1][c] == 0 && home[r][c+1] == 0 && home[r+1][c+1] == 0) {
			go(r+1, c+1, 2);
		}
	}

}
