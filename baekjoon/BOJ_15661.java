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
		if(cnt == N/2) {
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
		
		for (int i = start; i <= N; i++) {
//			 start가 아닌 i로 할 경우 
//			 team1: {1,2,3}, team2: {4,5,6}
//			 team2: {1,2,3}, team1: {4,5,6}
//			 --> 중복 발생하므로 start로 해줌
			// 위 방식대로 하면 틀렸습니다 뜸 ㅠㅠ
			team1[cnt] = i;
			paired[i] = true; // 방문 체크
			combination(i+1, cnt+1, paired);
			paired[i] = false; // 방문 체크 해지
		}
	}
	
	private static String src = "20\r\n" + 
			"0 3 4 5 2 4 3 4 4 2 4 5 2 2 5 3 5 5 4 5\r\n" + 
			"4 0 5 5 3 5 4 1 3 3 4 3 4 4 1 4 5 5 2 5\r\n" + 
			"1 4 0 1 2 5 3 4 5 1 3 2 4 5 4 4 2 3 3 5\r\n" + 
			"5 1 5 0 5 3 1 2 4 4 2 5 4 2 1 3 5 4 5 1\r\n" + 
			"1 3 5 1 0 4 1 3 5 5 1 5 2 3 1 4 3 5 5 4\r\n" + 
			"1 1 3 1 1 0 3 1 5 4 4 2 4 1 2 3 5 2 3 5\r\n" + 
			"5 5 3 4 5 2 0 5 2 4 4 1 3 2 3 2 3 2 5 1\r\n" + 
			"1 1 4 5 1 1 3 0 5 1 5 2 5 5 4 3 5 3 2 1\r\n" + 
			"2 1 5 3 3 2 2 4 0 1 1 4 5 3 5 5 2 2 5 2\r\n" + 
			"2 4 4 3 3 5 3 2 3 0 4 2 1 3 1 3 4 2 5 3\r\n" + 
			"4 5 5 2 4 2 3 1 3 2 0 4 4 5 2 1 5 3 3 1\r\n" + 
			"4 5 4 5 4 1 4 4 2 2 2 0 1 1 5 4 1 4 1 4\r\n" + 
			"4 4 2 1 3 5 4 4 5 4 3 1 0 3 2 4 5 2 4 3\r\n" + 
			"2 5 2 2 3 1 3 5 4 4 5 3 4 0 3 1 1 2 2 1\r\n" + 
			"4 5 3 1 3 3 2 1 4 3 3 2 5 1 0 2 5 2 3 3\r\n" + 
			"3 2 4 5 3 3 5 3 2 1 5 2 1 2 4 0 2 4 5 5\r\n" + 
			"5 5 4 1 3 2 2 5 1 2 2 3 2 4 3 4 0 3 3 5\r\n" + 
			"2 1 4 5 4 5 1 2 4 2 5 5 1 3 5 3 3 0 5 4\r\n" + 
			"2 5 2 1 2 1 3 4 4 5 3 4 1 5 1 1 2 5 0 1\r\n" + 
			"3 4 5 5 5 1 5 2 4 1 5 5 2 5 1 5 2 4 3 0";
}
