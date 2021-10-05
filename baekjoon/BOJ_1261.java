package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Study week 5
 * 1261. 알고스팟
 * @author Chaerin Yu
 * 0은 빈 방을 의미하고, 1은 벽을 의미한다.
 */
public class BOJ_1261 {

	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int N, M; // 미로 크기 - 세로, 가로 1 ≤ N, M ≤ 100
	static int[][] map; // 미로
	static int wallCnt; // 벽 수
	
	static int res; // 정답
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		
		wallCnt = 0;
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			char[] temp = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				map[r][c] = temp[c] - '0';
				
				if(map[r][c]==1) wallCnt++; // 벽 수 세기
			}
		}
		
		// (0, 0) -> (N-1, M-1) 가기 위해 최소 몇 개 벽 부수어야 하는지?
		res = Integer.MAX_VALUE;
		bfs(0, 0);
		
		sb.append(res);
		System.out.println(sb);
	}
	
	static void bfs(int sr, int sc) {
		boolean[][] visited = new boolean[N][M]; // 좌표 방문 여부
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
//		Queue<int[]> queue = new LinkedList<int[]>();
//		System.out.println(wallCnt);
		visited[sr][sc] = true;
		queue.offer(new int[] {sr, sc, 0});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			// N-1, M-1 도착
			if(current[0]==N-1 && current[1]==M-1) {
				if(res>current[2]) res = current[2]; // 벽 수
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = current[0]+delta[d][0];
				int nc = current[1]+delta[d][1];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M ) continue;
				
				if(visited[nr][nc]) continue;
				// 벽이 있는 경우, 벽을 부신 후 넘어가야 함
				if(map[nr][nc]==1) {
					if(current[2]<wallCnt) {
						queue.offer(new int[] {nr, nc, current[2]+1});
					}
				}
				else {
					queue.offer(new int[] {nr, nc, current[2]});
				}
				
				visited[nr][nc] = true;
				
			}
		}
	}
}
