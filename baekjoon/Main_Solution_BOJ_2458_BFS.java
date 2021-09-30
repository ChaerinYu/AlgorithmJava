package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 키 순서
 * @author user
 * BFS
 */
public class Main_Solution_BOJ_2458_BFS {

	static int N, M, adj[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 간선 정보 수
		adj = new int[N+1][N+1];
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adj[from][to] = 1; // from보다 to가 키가 크다.
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if(gtBFS(i)+ltBFS(i) == N-1) ++ans;
		}
		System.out.println(ans);
	}
	
	// 자신보다 큰 학생따라 탐색
	private static int gtBFS(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && adj[cur][i] == 1) {
					queue.offer(i);
					visited[i] = true;
					++cnt;
				}
			}
		}
		return cnt;
	}
	// 자신보다 작은 학생따라 탐색
	private static int ltBFS(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && adj[i][cur] == 1) {
					queue.offer(i);
					visited[i] = true;
					++cnt;
				}
			}
		}
		return cnt;
	}
}
