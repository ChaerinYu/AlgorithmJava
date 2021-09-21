package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Study week 3
 * 7562. 나이트의 이동
 * @author Chaerin Yu
 * 1. ( queue -> y좌표, x좌표, 방문 회수 ) 방식으로 풀이
 * 2. queue size while문 추가해서 풀이
 */
public class BOJ_7562 {
	// final 정의 잘 하자 ㅠㅠ
	static final int[][] delta = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};

	static int T, I; // 테스트 케이스 수, 체스판 길이
	static int[][] map; // 체스판
	
	static int res;
	
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(br.readLine());
		int sr, sc, dr, dc;
		for (int tc = 1; tc <= T; tc++) {
			res = 0;
			
			I = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			dr = Integer.parseInt(st.nextToken());
			dc = Integer.parseInt(st.nextToken());
			
			// 1. ( queue -> y좌표, x좌표, 방문 회수 ) 방식으로 풀이로 할 경우, if문 필요 없음
			// 2 방식으로 풀이할 경우 if문 필수!
			if(sr != dr || sc != dc)
				bfs(sr, sc, dr, dc);
			
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
	

	/**
	 * 
	 * @param sr 출발 y좌표
	 * @param sc 출발 x좌표
	 * @param dr 도착 y좌표
	 * @param dc 도착 x좌표
	 */
	// queue size while문 추가해서 풀이
	static void bfs(int sr, int sc, int dr, int dc) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[I][I];
		
		// y좌표, x좌표, 방문회수
		queue.offer(new int[] {sr, sc});
		visited[sr][sc] = true;
		
		int cnt = 0; 
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			while(queueSize-- > 0) {
				int[] current = queue.poll();
				
				for (int i = 0; i < delta.length; i++) {
					int nr = current[0]+delta[i][0]; // y좌표
					int nc = current[1]+delta[i][1]; // x좌표
					
					if(nr<0 || nc<0 || nr>=I || nc>=I) continue;
					if(nr==dr && nc==dc) {
						res = ++cnt;
						return;
					}
					if(!visited[nr][nc]) {
						queue.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				} // delta end
			}
			cnt++;
		} // queue empty end
	}
	
	// queue -> y좌표, x좌표, 방문 회수
	/*
	static void bfs(int sr, int sc, int dr, int dc) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[I][I];
		
		// y좌표, x좌표, 방문회수
		queue.offer(new int[] {sr, sc, 0});
		visited[sr][sc] = true;
		
//		int cnt = 0; 
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			int nv = current[2]; // 방문 회수
			if(current[0]==dr && current[1]==dc) {
				res = nv;
				return;
			}
			
			for (int i = 0; i < delta.length; i++) {
				int nr = current[0]+delta[i][0]; // y좌표
				int nc = current[1]+delta[i][1]; // x좌표
				
				if(nr<0 || nc<0 || nr>=I || nc>=I) continue;
//					if(nr==dr && nc==dc) break;
				if(!visited[nr][nc]) {
					queue.offer(new int[] {nr, nc, nv+1});
					visited[nr][nc] = true;
				}
			} // delta end
		} // queue empty end
        return;
	}
	*/
	
	private static String src = "3\r\n" + 
			"8\r\n" + 
			"0 0\r\n" + 
			"7 0\r\n" + 
			"100\r\n" + 
			"0 0\r\n" + 
			"30 50\r\n" + 
			"10\r\n" + 
			"1 1\r\n" + 
			"1 1";
}
