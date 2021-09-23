package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * 2021.09.23
 * 1681. 해밀턴 순환회로
 * @author ChaerinYu
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=954&sca=99&sfl=wr_subject&stx=%ED%95%B4%EB%B0%80%ED%84%B4
 */
public class jo_1681 {

	static int N; // 배달 장소 수 (1≤N≤12)이 주어진다. 이때, 출발지(회사)는 1번이다.
	static int[][] map; // 방문 비용 (단방향)
	
	static int ans; // 정답
	static boolean[] visited; // 방문한 집 체크
	
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src)); // 제출 시 주석 처리
		
		N = Integer.parseInt(br.readLine()); // 배달 장소 수 입력
		
		map = new int[N+1][N+1]; // 방문 비용
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N+1];
		visited[1] = true;
		ans = Integer.MAX_VALUE;
		dfs(1, 1, 0);
		
		if(ans==Integer.MAX_VALUE) ans = 0;
		
		sb.append(ans).append("\n");
		System.out.println(sb);
	}
	
	/**
	 * 
	 * @param start 출발지
	 * @param vCnt 방문한 집 수
	 * @param cost 누적 방문 비용
	 */
	static void dfs(int start, int vCnt, int cost) {
		// 이 부분 안하면 시간초과 문제 발생
		if(cost>ans) return;
		
		// 방문한 집 수 전체 집 수일 경우
		if(vCnt>=N) {
			if(map[start][1]==0) return;
			cost += map[start][1];
			ans = Math.min(ans, cost);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(visited[i]) continue; // 방문한 경우 pass
			if(map[start][i]==0) continue; // 0인 경우 갈 수 없는 경우
			
			visited[i] = true;
			dfs(i, vCnt+1, cost+map[start][i]);
			visited[i] = false;
		}
	}
	
	private static String src = "6\r\n" + 
			"0 93 23 32 39 46 \r\n" + 
			"0 0 7 58 59 13 \r\n" + 
			"40 98 0 14 33 98 \r\n" + 
			"3 39 0 0 13 16 \r\n" + 
			"51 25 19 88 0 47 \r\n" + 
			"65 81 63 0 6 0 ";
}
