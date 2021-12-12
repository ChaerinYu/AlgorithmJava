package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 2638. 치즈
 * @author Chaerin Yu
 * Study 14week
 */
public class BOJ_2638 {

	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int N, M, map[][]; // 세로, 가로, 모눈종이
	static ArrayList<int[]> cheeseList;
	static int cheeseCnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		map = new int[N+1][M+1];
		cheeseCnt = 0;
		cheeseList = new ArrayList<int[]>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 치즈
				if(map[i][j] == 1) {
					cheeseList.add(new int[] {i, j});
					cheeseCnt++;
				}
			}
		}
		
		
		for (int i = 0; i < cheeseList.size(); i++) {
			int[] cheese = cheeseList.get(i);
			if(map[cheese[0]][cheese[1]] == 1) {
				bfs(cheese[0], cheese[1]);
			}
		}
		
	}

	private static void bfs(int sr, int sc) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N+1][M+1];
		
		queue.offer(new int[] {sr, sc});
		visited[sr][sc] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for (int d = 0; d < delta.length; d++) {
			}
		}
	}
}
