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
			square[0][0] = 1; // 시작값은 넣어주고 시작한다. 
			while(true) {
				if(n == N*N) break; // 정사각형에 숫자 다 입력한 경우 while문 종료
				
				// 정사각형 범위 안에 입력할 수 있는지 확인한다.
				tempR = nr+dir[w][0];
				tempC = nc+dir[w][1];
				if(tempR < 0 || tempR >= N || tempC < 0 || tempC >= N || square[tempR][tempC] != 0) {
					w = (w+1)%4;
					continue;
				}
				
				// 정사각형 값 입력
				nr += dir[w][0];
				nc += dir[w][1];
				square[nr][nc] = ++n;
			}
			
			// 정사각형 그리기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					System.out.print(square[r][c]+" ");
				}
				System.out.println();
			}
		}
	}

}
