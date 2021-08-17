package SWEA;

import java.util.HashSet;
import java.util.Scanner;

/*
 * 1974. 스도쿠 검증
 */
public class Solution_0812_SWEA_1974 {

	static int[][] map = new int[9][9];
	static HashSet<Integer> set = new HashSet<>();
	static int res = 1; // 0: 스도쿠가 아니다. 1: 스도쿠가 맞다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			res = 1; 
			// 입력
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 판단
			solve();
			
			// 출력
			System.out.println("#"+t+" "+res);
		}
	}
	
	static void solve() {
		// 가로 체크
		for (int i = 0; i < 9; i++) {
			set.clear();
			for (int j = 0; j < 9; j++) {
				set.add(map[i][j]);
			}
			if(set.size() != 9) {
				res = 0;
				return;
			}
		}
		// 세로 체크
		for (int i = 0; i < 9; i++) {
			set.clear();
			for (int j = 0; j < 9; j++) {
				set.add(map[j][i]);
			}
			if(set.size() != 9) {
				res = 0;
				return;
			}
		}
		// 작은 사각형 체크
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// 작은 사각형 set에 삽입
				set.clear();
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						set.add(map[3*i+k][3*j+l]);
					}
				}
				// set 판단
				if(set.size() != 9) {
					res = 0;
					return;
				}
			}
		}
	}

}
