package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 키 순서
 * @author user
 * DFS DP Memoization
 */
public class Solution_SWEA_5643_DFS3_Memo {

	static int N, M, adj[][]; // 인접행렬
	
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
			
			// memoization -1인 경우 탐색 아직 안 함. 0이상인 경우 탐색 함 (나보다 큰 학생 수)
			for (int i = 1; i <= N; i++) {
				adj[i][0] = -1;
			}
			for (int i = 1; i <= N; i++) {
				if(adj[i][0] == -1) dfs(i); // 자신보다 큰 학생 탐색 (아직 탐색이 안 된 학생만)
			}
			// 위에서 탐색한 결과를 토대로 자신보다 작은 학생수 카운트
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adj[0][j] += adj[i][j]; // 자신보다 작은 학생 수 카운트
				}
			}
			
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				if(adj[0][i]+adj[i][0] == N-1) ++ans;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	// 자신보다 큰/작은 학생따라 탐색
	private static void dfs(int cur) {
		
		for (int i = 1; i <= N; i++) {
			if(adj[cur][i] == 1) { // 자신보다 큰 학생이면
				if(adj[cur][0]==-1) { // 탐색 전
					dfs(i);
				}
				// 자신보다 큰 학생을 탐색 완료한 상태 (메모가 되어 있으면 탐색 안하고 바로 내려옴)
				if(adj[i][0]>0) { // i보다 큰 학생이 존재하는 상황
					// i의 인접행렬의 상태를 cur에 반영
					for (int j = 1; j <= N; j++) {
						// 나보다 큰 학생보다 큰 학생들 정보를 나와의 관계에서도 키가 더 크다고 입력
						if(adj[i][j]==1) adj[cur][j] = 1; 
					}
				}
				
			}
		}
		// cur학생 기준으로 자기보다 큰 모든 학생들 cur학생의 인접행렬에 입력 완료
		
		int cnt = 0;
		for (int j = 1; j <= N; j++) {
			cnt += adj[cur][j]; // 어차피 0 아님 1 이므로 더하면 됨
		}
		adj[cur][0] = cnt; // cur보다 큰 학생 수 0 행(사용 안하는 중->memo로 사용)에 입력
	}
}
