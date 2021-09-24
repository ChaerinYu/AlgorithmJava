package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 7576. 토마토
 * @author ChaerinYu
 *  정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 *  토마토가 하나 이상 있는 경우만 입력으로 주어진다.
 *  여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 
 *  만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 */
public class BOJ_7576 {

	static final int[][] delta = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static int N, M; // 세로, 가로  2 ≤ M,N ≤ 1,000
	static int[][] box; // 토마토 상자
	static ArrayList<int[]> ripen;
	
	static int res;
	
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		
		// 박스 입력
		box = new int[N][M];
		ripen = new ArrayList<int[]>();
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				box[r][c] = Integer.parseInt(st.nextToken());
				if(box[r][c] == 1) {
					ripen.add(new int[] {r, c});
				}
			}
		}
		// 입력 끝
//		res = Integer.MAX_VALUE;
		res = 0;
		bfs();
		
//		if(res == Integer.MAX_VALUE) res = -1;
		if(!isAllRipen()) res = -1;
		sb.append(res).append("\n");
		System.out.println(sb);
	}
	
	static boolean isAllRipen() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				// 안 익은 거 하나라도 있는 경우 false return
				if(box[r][c]==0) return false;
			}
		}
		return true;
	}
	
	static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		
		// 익은 토마토들 queue에 넣어준 상태로 시작한다.
		for (int k = 0; k < ripen.size(); k++) {
			int r = ripen.get(k)[0];
			int c = ripen.get(k)[1];
			
			queue.offer(new int[] {r, c, 0}); // y좌표, x좌표, 날짜count
			visited[r][c] = true;
		}
			
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int cnt = current[2];
			// 시간 갱신 - 이 부분 안하면 틀림
			if(res < cnt) res = cnt;
			// 인접 토마토
			for (int i = 0; i < 4; i++) {
				int nr = current[0]+delta[i][0];
				int nc = current[1]+delta[i][1];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(box[nr][nc] !=0) continue; // 안 익은 토마토 아닌 경우
				if(visited[nr][nc]) continue; // 방문한 토마토 칸 경우
//				System.out.println(nr+", "+nc);
				
				queue.offer(new int[] {nr, nc, cnt+1});
				box[nr][nc] = 1;
				visited[nr][nc] = true;
			}
			
		}
	}
	
	private static String src = "6 5\r\n" + 
			"1 0 0 0 0 0\r\n" + 
			"-1 -1 -1 -1 -1 -1\r\n" + 
			"-1 0 0 0 0 0\r\n" + 
			"-1 0 0 1 0 0\r\n" + 
			"-1 0 0 0 0 0";
}
