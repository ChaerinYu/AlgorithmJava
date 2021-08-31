package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Study week 1
 * 4963. 섬의 개수
 * @author ChaerinYu
 * BFS
 */
public class BOJ_4963 {

	static int R, C; // MAP 크기
	static int[][] map;
	
	static int res = 0;
	
	// 8방 탐색
	final static int[][] delta = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
	static int[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true) {
			res = 0;
			st = new StringTokenizer(br.readLine(), " ");
			C = Integer.parseInt(st.nextToken()); // width
			R = Integer.parseInt(st.nextToken()); // height
			// 0 0 입력 시 종료
			if(R==0 && C==0) {
				break;
			}
			
			map = new int[R][C];
			visited = new int[R][C];
			// map 입력
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 섬 연결하기
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c] != 0 && visited[r][c] == 0) {
						res ++;
						findIsland(r, c, res); // 섬에 번호 부여
					}
				}
			}
			
			System.out.println(res);
			
		}
	}
	
	/**
	 * 섬 연결하기 BFS
	 * @param row: 섬 row 위치
	 * @param col: 섬 col 위치
	 * @param num: 섬 번호
	 */
	static void findIsland(int row, int col, int num) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[]{row, col});
		
		visited[row][col] = num; // 섬에 번호 부여
		
		while(!queue.isEmpty()) {
//			System.out.println(queue.poll()[0]+","+queue.poll()[1]);
			int[] current = queue.poll();
//			int tempR = current[0];
//			int tempC = current[1];
			
			for (int i = 0; i < 8; i++) {
				int nr = current[0]+delta[i][0];
				int nc = current[1]+delta[i][1];
				
				if(nr<0 || nc<0 || nr>=R || nc>= C) continue;
				// 아직 번호가 매겨지지 못한 섬
				if(map[nr][nc] == 1 && visited[nr][nc] == 0) {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = num;
				}
			}
			
		}
	}
}
