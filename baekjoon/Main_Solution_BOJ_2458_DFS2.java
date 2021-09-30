package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 키 순서
 * @author user
 * DFS refactoring
 */
public class Main_Solution_BOJ_2458_DFS2 {

	static int N, M, adj[][], radj[][]; // 나보다 큰 애들, 나보다 작은 애들 인접행렬
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
			
		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 간선 정보 수
		adj = new int[N+1][N+1];
		radj = new int[N+1][N+1];
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adj[from][to] = radj[to][from] = 1; // from보다 to가 키가 크다.
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			cnt = 0;
			dfs(i, adj, new boolean[N+1]);  // 자신보다 큰 학생 탐색
			dfs(i, radj, new boolean[N+1]); // 자신보다 작은 학생 탐색
			if(cnt==N-1) ++ans;
		}
		System.out.println(ans);
	}
	
	// 자신보다 큰/작은 학생따라 탐색
	private static void dfs(int cur, int[][] adj, boolean[] visited) {
		visited[cur] = true;
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i] && adj[cur][i] == 1) {
				++cnt; // 시작 학생 수 안 세기 위해서 for문 밖이 아닌 if문 안에서 세준다. 
				dfs(i, adj, visited);
			}
		}
	}
}
