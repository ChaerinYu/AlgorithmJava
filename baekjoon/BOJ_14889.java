package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Study Week 3
 * 14889. 스타트와 링크
 * @author Chaerin Yu
 *
 */
public class BOJ_14889 {
	
	static int N; // 사람 수
	static int[][] synergy; // 서로 팀 됐을 때의 시너지
	
	static int[] team1; // team1
	
	static int res = 0; // 정답
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src)); // 제출 시 주석처리
		
		N = Integer.parseInt(br.readLine()); // 사람 수 
		synergy = new int[N+1][N+1]; // 능력치
		team1 = new int[N/2];
		
		// 서로 팀 됐을 때의 능력치 입력
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				synergy[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		res = Integer.MAX_VALUE;
		combination(1, 0);
		
		System.out.println(res);
	}
	
	/**
	 * N명중 N/2명 조합
	 * @param start
	 * @param cnt
	 */
	static void combination(int start, int cnt) {
		if(cnt==N/2) {
			Set<Integer> team1Set = new HashSet<Integer>();
			for (int i = 0; i < N/2; i++) {
				team1Set.add(team1[i]);
			}
			int team1Synergy = 0;
			int team2Synergy = 0;
			int[] team2 = new int[N/2];
			int idx = 0;
			// 1~N
			for (int i = 1; i <= N; i++) {
				// team2 팀원 입력 team1 배열에 있는 숫자가 아닌 경우
				if(!team1Set.contains(i)) {
					team2[idx++] = i;
				}
			}
//			System.out.println(N);
			// team1 synergy
			for (int i = 0; i < N/2; i++) {
				for (int j = i+1; j < N/2; j++) {
					team1Synergy += synergy[team1[j]][team1[i]];
					team1Synergy += synergy[team1[i]][team1[j]];
				}
			}
			// team2 synergy
			for (int i = 0; i < N/2; i++) {
				for (int j = i+1; j < N/2; j++) {
					team2Synergy += synergy[team2[i]][team2[j]];
					team2Synergy += synergy[team2[j]][team2[i]];
				}
			}
			res = Math.min(res, Math.abs(team1Synergy-team2Synergy));
			return;
		}
		
		for (int i = start; i <= N; i++) {
			team1[cnt] = start;
			
			combination(i+1, cnt+1);
		}
	}
	
	private static String src = "8\r\n" + 
			"0 5 4 5 4 5 4 5\r\n" + 
			"4 0 5 1 2 3 4 5\r\n" + 
			"9 8 0 1 2 3 1 2\r\n" + 
			"9 9 9 0 9 9 9 9\r\n" + 
			"1 1 1 1 0 1 1 1\r\n" + 
			"8 7 6 5 4 0 3 2\r\n" + 
			"9 1 9 1 9 1 0 9\r\n" + 
			"6 5 4 3 2 1 9 0";
}
