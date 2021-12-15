package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 2638. 치즈
 * @author Chaerin Yu
 * Study 14week
 * 2636과 유사
 */
public class BOJ_2638 {

	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int N, M, map[][]; // 세로, 가로, 모눈종이
//	static ArrayList<int[]> cheeseList; // 안써도 됨..
	static int cheeseCnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		map = new int[N][M];
		cheeseCnt = 0;
//		cheeseList = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 치즈
				if(map[i][j] == 1) {
//					cheeseList.add(new int[] {i, j});
					cheeseCnt++;
				}
			}
		}
		
		int time = 0;
		// 치즈 개수 0이 될 때 까지
		while(cheeseCnt != 0) {
			bfs(0, 0);
			time++;
		}
		System.out.println(time);
	}

	private static void bfs(int sr, int sc) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N+1][M+1];
		
		queue.offer(new int[] {sr, sc});
		visited[sr][sc] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			if(cheeseCnt == 0) return;
			
			// 사방 탐색
			for (int d = 0; d < delta.length; d++) {
				int nr = now[0]+delta[d][0];
				int nc = now[1]+delta[d][1];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				
				if(visited[nr][nc]) continue;
				// 공기
				if(map[nr][nc]==0) {
					// 모눈종이의 맨 가장자리에는 치즈가 놓이지 않음 ((0, 0) 포함)
					// 0일 때에만 queue에 넣으므로 자동으로 외부 공기만 queue로 들어간다.
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
				// 치즈
				else {
					map[nr][nc]++;
				}
			}
		}
		
		// map 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 2인 경우는 외부공기와 한 면만 접한 경우
				if(map[i][j] == 2) map[i][j] = 1;
				// 3이상인 경우 외부공기와 두 면 이상 접한 경우
				if(map[i][j] >= 3) {
					map[i][j] = 0;
					cheeseCnt--;
				}
			}
		}
	}
}
