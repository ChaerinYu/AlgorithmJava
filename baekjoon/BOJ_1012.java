package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {

	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int T, M, N, K; // 테스트 케이스 수, 가로, 세로, 배추 위치
	static int[][] map; // 밭
	static int[][] loc; // 배추 위치 저장
	
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			K = Integer.parseInt(st.nextToken()); // 배추 수
			
			map = new int[N][M];
			loc = new int[K][2];
			int row = 0, col = 0;
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				
				col = Integer.parseInt(st.nextToken());
				row = Integer.parseInt(st.nextToken());
				
				map[row][col]=1;
				loc[k][0] = row;
				loc[k][1] = col;
			}
			
			answer = 0;
			bfs(loc[0][0], loc[0][1]);
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void bfs(int r, int c) {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {
			int[] cabbage = {loc[i][0], loc[i][1]};
			if(visited[cabbage[0]][cabbage[1]]) continue;

			
			queue.offer(new int[] {cabbage[0], cabbage[1]});
			visited[cabbage[0]][cabbage[1]] = true;
			

			while(!queue.isEmpty()) {
				int[] now = queue.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = now[0]+delta[d][0];
					int nc = now[1]+delta[d][1];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] != 1) continue;
					
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
			
			answer++;
		}
		
	}
	
}
