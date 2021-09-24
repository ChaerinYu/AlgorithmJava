package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * Study week 4
 * 2178. 미로 탐색
 * @author Chaerin Yu
 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 
 * 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 * 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 * dfs dijkstra 14576KB 688ms
 */
public class BOJ_2178_dijkstra {
	
	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	static int N, M; // 세로, 가로
	static int[][] maze; // 미로
	
	static int res; // 답
	static int[][] dp; // 최소 방문 수 저장
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		maze = new int[N][M]; // 미로 초기화
		for (int r = 0; r < N; r++) {
			String[] tempArr = br.readLine().split("");
			for (int c = 0; c < M; c++) {
				maze[r][c] = Integer.parseInt(tempArr[c]);
			}
		}
		
		dp = new int[N][M];
		for (int r = 0; r < N; r++) {
			Arrays.fill(dp[r], N*M);
		}
		dp[0][0] = 0; // 출발점 체크
		res = Integer.MAX_VALUE;
		dfs(0, 0, 1);
		
		sb.append(res).append("\n");
		System.out.println(sb);
	}
	
	static void dfs(int sr, int sc, int cnt) {
		// (N, M) 위치 도착 시
		if(res<cnt) return;
		if(sr==N-1 && sc==M-1) {
			res = Math.min(res, cnt);
			return;
		}
		
		// 4방 탐색
		for (int i = 0; i < 4; i++) {
			int nr = sr+delta[i][0];
			int nc = sc+delta[i][1];
			
			if(nr<0 || nc<0 || nr>=N || nc>= M) continue; // 범위 벗어남
			if(maze[nr][nc] == 0) continue; // 이동할 수 없는 칸
			
			if(dp[nr][nc]>dp[sr][sc]+1) {
				dp[nr][nc] = dp[sr][sc]+1;
				dfs(nr, nc, cnt+1);
			}
		}
	}
	
	private static String src = "7 7\r\n" + 
			"1011111\r\n" + 
			"1110001\r\n" + 
			"1000001\r\n" + 
			"1000001\r\n" + 
			"1000001\r\n" + 
			"1000001\r\n" + 
			"1111111";
}
