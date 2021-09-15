package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1600. 말이 되고픈 원숭이
 * 
 * @author ChaerinYu 
 * 0은 아무것도 없는 평지, 1은 장애물을 뜻한다. 장애물이 있는 곳으로는 이동할 수 없다.
 * 시작점과 도착점은 항상 평지이다. W와 H는 1이상 200이하의 자연수이고, K는 0이상 30이하의 정수이다.
 */
public class BOJ_1600 {

	static int K, W, H; // 말의 이동법 수, 가로, 세로
	static int[][] map;

	static int res;
//	final static int[][] delta = {{ 0, 1 }, { 1, 0 }};
	final static int[][] delta = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };
	final static int[][] horseDelta = { 
										{ -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }
									  , { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }
									  };

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		//br = new BufferedReader(new StringReader(src));
		StringTokenizer st = null;

		K = Integer.parseInt(br.readLine()); // 가능한 말의 이동 법 회수
		st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken()); // 가로
		H = Integer.parseInt(st.nextToken()); // 세로

		map = new int[H][W]; // 여행길 초기화
		// 입력
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		res = Integer.MAX_VALUE; // ...이거 때문에 계속 틀렸었다..
		res = -1;
		// 출발점
		bfs(0, 0, K);

		System.out.println(res);
	}

	static void bfs(int r, int c, int k) {
		Queue<int[]> q = new LinkedList<int[]>();
		// 가로, 세로, 말 걸음 사용 횟수 체크
		boolean[][][] visited = new boolean[H][W][K+1];
		
		visited[r][c][k] = true;
		q.offer(new int[] {r, c, 0, k});
		
		while(!q.isEmpty()) {
			int[] current = q.poll();

			int move = current[2];
			int nk = current[3];
			
			if(current[0]==H-1&&current[1]==W-1) {
				res = move;
                return;
//				break;
			}
			
			// 원숭이 이동걸음
			for (int i = 0; i < 4; i++) {
				int nr = current[0] + delta[i][0];
				int nc = current[1] + delta[i][1];
				// 범위 체크, 방문 체크, 장애물 체크
				if (nr<0 || nr>=H || nc<0 || nc>=W || visited[nr][nc][nk] || map[nr][nc] == 1) {
					continue;
				}
				
				q.offer(new int[] {nr, nc, move+1, nk});
				visited[nr][nc][nk] = true;

			}

			// 말 이동걸음
			if (nk > 0) {

				for (int i = 0; i < 8; i++) {
					int nr = current[0] + horseDelta[i][0];
					int nc = current[1] + horseDelta[i][1];
					// 범위 체크, 방문 체크, 장애물 체크
					if (nr<0 || nr>=H || nc<0 || nc>=W || visited[nr][nc][nk-1] || map[nr][nc] == 1) {
						continue;
					}
					q.offer(new int[] {nr, nc, move+1, nk-1});
					visited[nr][nc][nk-1] = true;
				}
			}
		}
//		System.out.println(res);
	}
	

//	private static String src = "1\r\n" + 
//			"4 4\r\n" + 
//			"0 0 0 0\r\n" + 
//			"1 0 0 0\r\n" + 
//			"0 0 1 0\r\n" + 
//			"0 1 0 0"; // 4
	private static String src = "1\r\n" + 
			"5 5\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 1 1\r\n" + 
			"0 0 0 1 0"; // 6
}
/**
3
4 5
0 1 1 1
1 1 0 1
1 1 1 1
1 1 1 0
1 1 1 0

답: 3
*/