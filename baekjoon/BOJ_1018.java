package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2021.11.12
 * 1018. 체스판 다시 칠하기
 * @author chaerin yu
 * https://st-lab.tistory.com/101
 */
public class BOJ_1018 {
	
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열

		// 입력
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		answer = 64; // 8*8 최대값
		// 첫 번째 칸이 B or W로 시작하는지
		for (int r = 0; r < N-7; r++) {
			for (int c = 0; c < M-7; c++) {
				match(r, c, map);
			}
		}
		
		System.out.println(answer);
	}

	/**
	 * 체스판 제대로 칠해져 있는지 체크
	 * @param r : 시작 위치
	 * @param c : 시작 위치
	 * @param map : 체스판
	 */
	private static void match(int r, int c, char[][] map) {
		int lastR = r + 8;
		int lastC = c + 8;
		
		char turn = map[r][c];
		int cnt = 0;
		for (int i = r; i < lastR; i++) {
			for (int j = c; j < lastC; j++) {
				
				// 다른 색상 있는 경우
				if(turn != map[i][j]) {
					cnt++;
				}
				// 다음 칸 넘어갈 때 색이 바뀌어야 함
				turn = turn=='B'?'W':'B';
				
			}
			turn = turn=='B'?'W':'B';
		}
		
		// 첫 번째 칸 색 기준으로 할 때와
		// 첫 번째 칸 색과 다른 색 기준으로 할 때
		cnt = cnt>(64-cnt)? 64-cnt:cnt;
		
		if(answer > cnt) answer = cnt;
	}
}
