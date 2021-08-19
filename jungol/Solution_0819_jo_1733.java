package jungol;

import java.util.Scanner;

/**
 * 1733 : 오목
 * @author user
 *
 */
public class Solution_0819_jo_1733 {
	
	static int[][] map;
	static int res;
	static int x, y;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		map = new int[19 + 2][19 + 2]; // 
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 구현
		res = 0;
		solve();
		// 출력
		System.out.println(res);
		if(res != 0) {
			System.out.println(x+" "+y);
		}
	}
	
	static void solve() {
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				
				if(map[i][j] == 0) {
					continue;
				}
				
				// |, \, ㅡ, / 연속적 검사
				int cnt = 1; // 연속된 돌의 갯수를 세는 목적
				int k = 1;
				if(map[i][j] != map[i-1][j]) {
					while(map[i][j] == map[i+k][j]) {
						cnt++;
						k++;
					}
				}
				if(cnt == 5) {
					// 오목이네
					res = map[i][j];
					x = i; y = j;
					return;
				}
//				\ 연속적 검사
				cnt = 1; // 연속된 돌의 갯수를 세는 목적
				k = 1;
				if(map[i][j] != map[i-1][j-1]) {
					while(map[i][j] == map[i+k][j+k]) {
						cnt++;
						k++;
					}
				}
				if(cnt == 5) {
					// 오목이네
					res = map[i][j];
					x = i; y = j;
					return;
				}
//				ㅡ 연속적 검사
				cnt = 1; // 연속된 돌의 갯수를 세는 목적
				k = 1;
				if(map[i][j] != map[i][j-1]) {
					while(map[i][j] == map[i][j+k]) {
						cnt++;
						k++;
					}
				}
				if(cnt == 5) {
					// 오목이네
					res = map[i][j];
					x = i; y = j;
					return;
				}
//				/ 우상향 대각선 검사 ** 주의
				cnt = 1; // 연속된 돌의 갯수를 세는 목적
				k = 1;
				if(map[i][j] != map[i+1][j-1]) {
					while(map[i][j] == map[i-k][j+k]) {
						cnt++;
						k++;
					}
				}
				if(cnt == 5) {
					// 오목이네
					res = map[i][j];
					x = i; y = j;
					return;
				}
			}
		}
	}
}
