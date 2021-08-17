package baekjoon;

import java.util.Scanner;

/**
 * 2567. 색종이
 * @author user
 *
 */
public class Solution_0817_boj_2567 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100+1][100+1]; // 왼쪽, 위는 0열, 0행이 있어서 괜찮지만 오른쪽, 아래는 없으므로 테두리 용으로 필요하다.
		int N = sc.nextInt();
		
		int x, y;
		int res = 0;
		for (int n = 0; n < N; n++) {
			x = sc.nextInt();
			y = sc.nextInt();
			for (int i = x; i < x+10; i++) {
				for (int j = y; j < y+10; j++) {
					map[i][j] = 1; // 색종이 덮인 곳: 1 아닌 곳: 0
				}
			}
		}
		// 판단
		// 상하좌우 0 개수 세기
		for (int i = 1; i <= 100; i++) { // 100 말고 99써도 됨
			for (int j = 1; j <= 100; j++) {
				if(map[i][j] == 1) {
					// 상 0 검사
					if(map[i-1][j] == 0) {
						res++;
					}
					// 하 0 검사
					if(map[i+1][j] == 0) {
						res++;
					}
					// 좌 0 검사
					if(map[i][j-1] == 0) {
						res++;
					}
					// 우 0 검사
					if(map[i][j+1] == 0) {
						res++;
					}
				}
			}
		}
		// 출력
		System.out.println(res);
	}

}
