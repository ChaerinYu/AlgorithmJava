package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1210. [S/W 문제해결 기본] 2일차 - Ladder1
 */
public class SWEA_1210 {

	static final int SIZE = 100;
	static int[][] ladder;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			int t = Integer.parseInt(br.readLine()); // test case number
			
			// 사다리 값 입력 
			ladder = new int[SIZE][SIZE];
			int destX = 0, destY = 0;
			for (int y = 0; y < SIZE; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < SIZE; x++) {
					ladder[y][x] = Integer.parseInt(st.nextToken());
					if(ladder[y][x] == 2) {
						destX = x;
						destY = y;
					}
				}
			}
			
			int r = destY-1, c = destX; // 2 제외하고 시작한다 (윗줄올라가서 시작)
			int direction = 0; // 0 up 1 left 2 right --> 이 부분 생각못해서 무한루프돌아감 ㅠㅠ
			while(true) {
				if(ladder[r][c] != 1) continue;
				
				// 도착하면 break
				if(r == 0) {
					break;
				}
				
				// 우선순위: 좌우 > 상
				if(r>0) {
					// 좌
					if(c-1 >= 0 && ladder[r][c-1] == 1 && direction != 2) {
						direction = 1;
						c--;
					}
					// 우
					else if(c+1 < SIZE && ladder[r][c+1] == 1 && direction != 1) {
						direction = 2;
						c++;
					}
					// 상
					else if(r-1 >=0 && ladder[r-1][c] == 1) {
						direction = 0;
						r--;
					}
				}
			}
			System.out.println("#"+tc+" " + c);
			
		}
	}

}
