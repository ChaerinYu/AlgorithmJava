package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * Study week 4
 * 2178. 미로 탐색
 * @author Chaerin Yu
 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 
 * 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 * 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 * bfs 	13884KB 164ms
 */
public class BOJ_2178_BFS {
	
	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	static int N, M; // 세로, 가로
	static int[][] maze; // 미로
	
	static int res; // 답
	
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
		
		res = 0;
		bfs(0, 0);
		
		sb.append(res).append("\n");
		System.out.println(sb);
	}
	
	static void bfs(int sr, int sc) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		
		queue.offer(new int[] {sr, sc, 1});
		visited[sr][sc] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int cnt = current[2];
			
			if(current[0]==N-1 && current[1]==M-1) {
				res = cnt;
				return;
			}
			
			// 4방 탐색
			for (int i = 0; i < 4; i++) {
				int nr = current[0]+delta[i][0];
				int nc = current[1]+delta[i][1];
				
				if(nr<0 || nc<0 || nr>=N || nc>= M) continue; // 범위 벗어남
				if(maze[nr][nc] == 0) continue; // 이동할 수 없는 칸
				
				if(!visited[nr][nc]) {
					queue.offer(new int[] {nr, nc, cnt+1});
					visited[nr][nc] = true;
				}
			}
		}
		
	}
	
	private static String src = "4 6\r\n" + 
			"101111\r\n" + 
			"101010\r\n" + 
			"101011\r\n" + 
			"111011";
}
