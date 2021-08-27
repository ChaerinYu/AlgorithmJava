package SWEA;

import java.util.Scanner;

public class Solution_0827_SWEA_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			int res = 0;
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			// 누적합 구하기
			// N = 7, 4
			for (int i = 0; i < N; i++) {
				int start = Math.abs(N/2-i);
				for (int j = start; j < N-start; j++) {
					res += map[i][j];
				}
			}
			
			System.out.println("#"+t+" "+res);
		}
	}
}
