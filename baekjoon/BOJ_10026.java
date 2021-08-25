package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 10026. 적록색약
 * @author ChaerinYu
 * 
 * [입력]
 * 첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100) 둘째 줄부터 N개 줄에는 그림이 주어진다.
 * 
 * [출력]
 * 적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
 * 
 * Graph BFS
 */
public class BOJ_10026 {

	static int N; // 구역 크기
	static char[][] map; // 구역
	static int res1, res2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		// 구역 입력
		for (int r = 0; r < N; r++) {
			char[] row = br.readLine().toCharArray();
			for (int c = 0; c < N; c++) {
				map[r][c] = row[c];
			}
		}
		
		// 적록색약 없는 사람과 적록색약인 사람의 구역
		res1 = 0; res2 = 0;
		bfs(false); // 적록색약 없는 사람
		bfs(true);  // 적록색약인 사람
		
		System.out.println(res1+" "+res2);
		
	}
	
	/**
	 * 구역이 몇 개인지 찾아보자
	 * @param blind: 적록색약인지 아닌지 체크
	 */
	static void bfs(boolean blind) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N]; // 방문 했는지
		
		// 사방탐색
		int[][] delta = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
				if(visited[r][c]) continue; // 이미 방문한 좌표면 continue
				
				// 아직 방문 안한 좌표 queue에 넣기, 방문 체크
				queue.offer(new int[] {r, c});
				visited[r][c] = true;
				
				while(!queue.isEmpty()) {
					int[] current = queue.poll(); // 꼭대기 0: r, 1: c
					
					for (int i = 0; i < delta.length; i++) {
						int nr = current[0]+delta[i][0];
						int nc = current[1]+delta[i][1];
						
						// 범위 벗어나거나 방문한 위치라면 넘어간다.
						if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
						if(visited[nr][nc]) continue;
						
						// 아직 방문 안했고 현재 위치 색상과 인접 위치 색상과 동일한 경우
						if(!visited[nr][nc]) {
							// 적록색약인 경우, green과 red 구분을 못하므로 or 조건 추가해줬다.
							if(blind) {
								if(!visited[nr][nc]) {
									if((map[nr][nc] == map[current[0]][current[1]])
									|| (map[nr][nc] == 'R' && map[current[0]][current[1]] == 'G') 
									|| (map[nr][nc] == 'G' && map[current[0]][current[1]] == 'R')
									) {
										queue.offer(new int[] {nr, nc});
										visited[nr][nc] = true;
									}
								}
							}
							// 적록색약이 아닌 경우, 동일 색상 조건
							else {
								if(map[nr][nc] == map[current[0]][current[1]]) {
									queue.offer(new int[] {nr, nc});
									visited[nr][nc] = true;
								}
							}
						}
					}
					// queue가 비었다는 건 다른 색상을 마주한 경우
					if(queue.size() == 0) {
						// 적록색약인 경우의 변수와 아닌 경우의 변수
						if(blind) res2++;
						else res1++;
					}
				}
			}
		}
	}
}
