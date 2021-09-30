package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1249. 보급로
 * @author user
 * BFS+PriorityQueue
 * 31,488 kb 128 ms
 */
public class Solution_SWEA_1249_PQ {

	static int N, map[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				char[] ch = in.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = ch[j]-'0';
				}
			}
			
			
			System.out.println("#"+tc+" "+dijkstra(0, 0));
		}
	}

	private static int dijkstra(int startR, int startC) {
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N];
		
		// 최소값이 갱신되도록 큰 값으로 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = INF;
			}
		}
		
		PriorityQueue<int[]> pQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			// 원소 삽입, 삭제 될 때마다 정렬이 되므로 비용 오름차순으로 정렬해주도록 한다.
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		
		
		// 시작은 출발지부터! 출발지->출발지 비용은 0
		minTime[startR][startC] = 0;
		pQueue.offer(new int[] {startR, startC, minTime[startR][startC]});
		
		int r = 0, c = 0, minCost = 0, nr, nc;
		while (true) {
			
			// step 1
			int[] cur = pQueue.poll();
			r = cur[0];
			c = cur[1];
			minCost = cur[2];

			// pq는 원소를 삭제하지 않고 삽입만 하기 때문에, 방문한 정점은 continue로 넘겨준다.
			// 이 부분은 안해도 되지만! 하는 게 좋다
			if(visited[r][c]) continue;
			
			visited[r][c] = true;
			
			// 이 과정을 계속하면 모든 최단거리를 구할 수 있음. 하지만 우리는 도착지까지만
			if(r == N-1 && c == N-1) {
				return minCost;
			}
			
			// step 2: step1에서 선택된 정점을 경유지로해서 인접정점 따져보기
			// 이 문제에서는 인접정점이 4방 정점
			for (int d = 0; d < 4; d++) {
				nr = r+dr[d];
				nc = c+dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]
						// minCost: r, c까지 오는데 걸리는 시간
						&& minTime[nr][nc]>minCost+map[nr][nc]) {
					minTime[nr][nc] = minCost+map[nr][nc];
					pQueue.offer(new int[] {nr, nc, minTime[nr][nc]});
				}
			}
			
		}
	}

}
