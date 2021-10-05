package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;
/**
 * Study week 4
 * 15661. 링크와 스타트
 * @author ChaerinYu
 * 14889. 스타트와 링크와 유사 - 짝수만 가능
 */
public class BOJ_15661 {

	static int N; // 사람 수
	static int[][] synergy; // 서로 팀 됐을 때의 시너지
	static int[] team1;

	static boolean[][] visited; // 서로 팀 됐는지 체크
	static int res = 0; // 정답
	
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src)); // 제출 시 주석처리
		
		N = Integer.parseInt(br.readLine()); // 사람 수 
		synergy = new int[N+1][N+1]; // 능력치
		
		// 서로 팀 됐을 때의 능력치 입력
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				synergy[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		res = Integer.MAX_VALUE;
//		visited = new boolean[N+1][N+1];
		boolean[] paired = new boolean[N+1];
		team1 = new int[N/2];
		combination(1, 0, paired);
		
		sb.append(res).append("\n");
		System.out.println(sb);
	}
	
	static void combination(int start, int cnt, boolean[] paired) {
		// team1: a, team2: b,c 와 team1: b, c, team1: a 동일하지만 다 돌아감. -> 시간 문제
		if(cnt == N) {
			int team1Sum = 0, team2Sum = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i==j) continue;
					if(paired[i] && paired[j]) {
						team1Sum += synergy[i][j];
						continue;
					}
					if(!paired[i] && !paired[j]) {
						team2Sum += synergy[i][j];
						continue;
					}
				}
			}
			res = Math.min(res, Math.abs(team1Sum-team2Sum));
			return;
		}
		
		// for문 사용시 불필요한 호출횟수 증가
		// 링크팀 선수 
		paired[cnt] = true; // 방문 체크
		combination(start+1, cnt+1, paired);
		// 스타트팀 선수 
		paired[cnt] = false; // 방문 체크 해지
		combination(start+1, cnt+1, paired);
		
	}
	
	private static String src = "6\r\n" + 
			"0 6 1 2 3 4\r\n" + 
			"6 0 5 6 7 8\r\n" + 
			"9 10 0 1 1 1\r\n" + 
			"11 12 1 0 1 1\r\n" + 
			"13 14 1 1 0 1\r\n" + 
			"15 16 1 1 1 0";
}
