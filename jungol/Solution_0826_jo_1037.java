package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1037. 오류교정
 * @author user
 *
 */
public class Solution_0826_jo_1037 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		
		StringTokenizer st = null;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 로직 구현
		int y = 0, x = 0;
		int cnt1 = 0, cnt2 = 0; // 행의 오류 개수, 열의 오류 개수
		for (int i = 1; i <= N; i++) {
			// 가로 합, 세로 합 구하기
			int sum1 = 0, sum2 = 0;
			for (int j = 1; j <= N; j++) {
				sum1 += map[i][j]; // 행의 합, 행의 위치 i
				sum2 += map[j][i]; // 열의 합, 열의 위치 i
			}
			if(sum1 % 2 != 0) { // 잘못된 행
				y = i;
				cnt1++;
			}
			if(sum2 % 2 != 0) { // 잘못된 열
				x = i;
				cnt2++;
			}
		}
		// 출력
		if(cnt1 == 0 && cnt2 == 0) {
			System.out.println("OK");
		} else if(cnt1 == 1 && cnt2 == 1) {
			System.out.printf("Change bit (%d,%d)%n", y, x);
		} else {
			System.out.println("Corrupt");
		}
	}

}
