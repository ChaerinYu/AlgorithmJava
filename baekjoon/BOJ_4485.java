package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 4485. 녹색 옷 입은 애가 젤다지?
 * @author Chaerin Yu
 * dijkstra
 */
public class BOJ_4485 {

	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static final int INF = Integer.MAX_VALUE;
	
//	static int T; // 테스트 케이스 수
	static int N; // 동굴의 크기 (2 ≤ N ≤ 125)
	static int[][] cave; //동굴
	
	static int[][] rupees; // 뺏기는 루피
	
	static int res; // w
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		int index = 0;
		while(true) {
			N = Integer.parseInt(br.readLine()); // 동굴 크기
			if(N==0) break; // 전체 입력 종료
			
			// 동굴 입력
			cave = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					cave[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// Dijkstra
			rupees = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(rupees[i], INF);
			}
			
			res = Integer.MAX_VALUE;
			bfs(0, 0, cave[0][0]);
			
			sb.append("Problem ").append(++index).append(": ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int sr, int sc, int rupee) {
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			// rupee 오름차순
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
			
		});
		
		queue.offer(new int[] {sr, sc, rupee}); // (y, x), 도둑루피
		rupees[sr][sc] = rupee;
		
		int[] current; int cr, cc, cRupee;
		while (!queue.isEmpty()) {
			current = queue.poll();
			cr = current[0]; cc = current[1]; cRupee = current[2];
			// 젤다 있는 곳 도착
			if(cr==N-1 && cc==N-1) {
				if(cRupee<res) res = cRupee;
				return;
			}
				
			int nr, nc;
			for (int i = 0; i < 4; i++) {
				nr = cr+delta[i][0];
				nc = cc+delta[i][1];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				if(rupees[nr][nc]>cRupee+cave[nr][nc]) {
					rupees[nr][nc] = cRupee+cave[nr][nc];
					queue.offer(new int[] {nr, nc, cRupee+cave[nr][nc]});
				}
			}
		}
	}
	private static String src = "3\r\n" + 
			"5 5 4\r\n" + 
			"3 9 1\r\n" + 
			"3 2 7\r\n" + 
			"5\r\n" + 
			"3 7 2 0 1\r\n" + 
			"2 8 0 9 1\r\n" + 
			"1 2 1 8 1\r\n" + 
			"9 8 9 2 0\r\n" + 
			"3 6 5 1 5\r\n" + 
			"7\r\n" + 
			"9 0 5 1 1 5 3\r\n" + 
			"4 1 2 1 6 5 3\r\n" + 
			"0 7 6 1 6 8 5\r\n" + 
			"1 1 7 8 3 2 3\r\n" + 
			"9 4 0 7 6 4 1\r\n" + 
			"5 8 3 2 4 8 3\r\n" + 
			"7 4 8 4 8 3 4\r\n" + 
			"0";
}
