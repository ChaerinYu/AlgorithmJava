package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=980&sca=2020
 * 1707 : 달팽이사각형
 */
public class jo_1707 {

	private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 정사각형크기
		int[][] square = new int[N][N]; // 정사각형
		
		// 정사각형의 크기 n(1부터 100사이의 정수)
		if(N<1 || N>100) {
			return;
		} else {
			int nr = 0, nc = 0;
			int tempR = 0, tempC = 0;
			int n = 1;
			int w = 0; // 방향
			while(true) {
				square[nr][nc] = n++;
				nr += dir[w][0];
				nr += dir[w][1];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
					
				}
				break;
			}
			for (int i = 0; i < N; i++) {
				
			}
		}
	}

}
