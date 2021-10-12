package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Two Dots
 * @author Chaerin Yu
 * Study week 6
 * 2021.10.11
 */
public class BOJ_16929 {

	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int N, M; // 게임판의 크기 2 ≤ N, M ≤ 50
	static char[][] map; // 게임판
	
	static boolean isCycle; // 사이클 여부
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // R
		M = Integer.parseInt(st.nextToken()); // C
		
		// 게임판 입력
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 게임판 칸마다 dfs 실행
		loop: 
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				isCycle = false;
				dfs(r, c, r, c, new boolean[N][M], 1);
				// 사이클 존재하는 경우 for문 나가기
				if(isCycle) break loop;
			}
		}
		
		if(isCycle) System.out.println("Yes");
		else System.out.println("No");
	}

	/**
	 * DFS
	 * @param rr 근본이 되는 시작 칸 Y좌표 (main에서 시작한 칸)
	 * @param rc 근본이 되는 시작 칸 X좌표 (main에서 시작한 칸)
	 * @param sr y좌표
	 * @param sc x좌표
	 * @param visited 방문여부
	 * @param depth 깊이여부 (사이클 가능한 최소 점 개수: 4개)
	 */
	private static void dfs(int rr, int rc, int sr, int sc, boolean[][] visited, int depth) {
		if(isCycle) return;
		visited[sr][sc] = true; // 방문체크
		
		// 인접한 칸 체크
		for (int i = 0; i < delta.length; i++) {
			int nr = sr + delta[i][0];
			int nc = sc + delta[i][1];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M) continue; // 범위 체크
			if(map[nr][nc] != map[sr][sc]) continue; // 같은 색 체크
			
			// 방문 안한 경우, 방문하기
			if(!visited[nr][nc]) {
				dfs(rr, rc, nr, nc, visited, depth+1);
			} else {
				// 사이클 점 4개 이상이고 main에서 시작한 좌표와 동일한 경우
				if(rr == nr && rc == nc && depth>=4) {
					isCycle = true;
					return;
				}
			}
		}
	}
}
