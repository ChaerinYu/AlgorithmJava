package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 키 순서
 * @author user
 * DFS
 */
public class Solution_SWEA_5643_DFS {

	static int N, M, adj[][];
	static int gtCnt, ltCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			
			N = Integer.parseInt(in.readLine()); // 학생 수
			M = Integer.parseInt(in.readLine()); // 간선 정보 수
			adj = new int[N+1][N+1];
			
			StringTokenizer st = null;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adj[from][to] = 1; // from보다 to가 키가 크다.
			}
			
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				gtCnt = ltCnt = 0;
				gtDFS(i, new boolean[N+1]);
				ltDFS(i, new boolean[N+1]);
				if(gtCnt+ltCnt==N-1) ++ans;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	// 자신보다 큰 학생따라 탐색
	private static void gtDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i] && adj[cur][i] == 1) {
				++gtCnt; // 시작 학생 수 안 세기 위해서 for문 밖이 아닌 if문 안에서 세준다. 
				gtDFS(i, visited);
			}
		}
	}
	// 자신보다 작은 학생따라 탐색
	private static void ltDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i] && adj[i][cur] == 1) {
				++ltCnt; // 시작 학생 수 안 세기 위해서 for문 밖이 아닌 if문 안에서 세준다. 
				gtDFS(i, visited);
			}
		}
	}
}
