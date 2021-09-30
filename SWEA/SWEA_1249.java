package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [D4] 1249. [S/W 문제해결 응용] 4일차 - 보급로
 * @author ChaerinYu
 * BFS Dijkstra PriorityQueue
 */
public class SWEA_1249 {

	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static final int INF = 10000;
	
	static int N; // 전쟁지역 크기
	static char[][] map; // 전쟁 지역 지도
	
	static int[][] memo; // 각 위치에서의 최소 이동 값 저장
	
	static int res;
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine()); // 지역 크기
			
			map = new char[N][N]; // 도로 파손 깊이 입력
			memo = new int[N][N]; // dijkstra INF로 초기화
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				Arrays.fill(memo[i], INF); // Dijkstra
			}
			
			res = INF;
			bfs(0, 0, map[0][0]-'0'); // 좌표, 도로 파손 깊이(char이므로 -'0')
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int sr, int sc, int move) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			
			// 깊이 오름차순
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		pq.offer(new int[] {sr, sc, move});
		memo[sr][sc] = move;
		
		while(!pq.isEmpty()) {
			// cur[0]: 행, cur[1]: 열, cur[2]: 현재 위치 까지 오는데 걸린 최소 시간
			int[] cur = pq.poll(); 
			
			// 도착지 도착
			if(cur[0]==N-1 && cur[1]==N-1) {
				if(res>cur[2]) res = cur[2];
				return;
			}
			
			// 사방 탐색
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+delta[d][0];
				int nc = cur[1]+delta[d][1];
				
				// 범위 초과
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				
				// Dijkstra
				if(memo[nr][nc] > cur[2]+map[nr][nc]-'0') {
					memo[nr][nc] = cur[2]+map[nr][nc]-'0';
					pq.offer(new int[] {nr, nc, memo[nr][nc]});
				}
			}
		}
	}
	
	private static String src = "4\r\n" + 
			"4\r\n" + 
			"0100\r\n" + 
			"1110\r\n" + 
			"1011\r\n" + 
			"1010\r\n" + 
			"6\r\n" + 
			"011001\r\n" + 
			"010100\r\n" + 
			"010011\r\n" + 
			"101001\r\n" + 
			"010101\r\n" + 
			"111010\r\n" + 
			"8\r\n" + 
			"01333212\r\n" + 
			"03121302\r\n" + 
			"01220112\r\n" + 
			"02003220\r\n" + 
			"13323020\r\n" + 
			"13010121\r\n" + 
			"23120012\r\n" + 
			"02322220\r\n" + 
			"16\r\n" + 
			"0206460224525365\r\n" + 
			"7023575224275214\r\n" + 
			"6425623777722006\r\n" + 
			"0765310064242506\r\n" + 
			"2225130736071465\r\n" + 
			"1636631536526462\r\n" + 
			"2360526344774660\r\n" + 
			"3405577132301540\r\n" + 
			"7165346240542031\r\n" + 
			"4262232557363016\r\n" + 
			"7234140421152030\r\n" + 
			"6045404006644766\r\n" + 
			"4756013250436773\r\n" + 
			"7637362260335020\r\n" + 
			"4032027275655464\r\n" + 
			"1427757462324460";
}
