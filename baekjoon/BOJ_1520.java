package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 시간초과
 * 1520. 내리막 길
 * @author ChaerinYu
 * 한 칸은 한 지점을 나타내는데 각 칸에는 그 지점의 높이가 쓰여 있으며, 
 * 각 지점 사이의 이동은 지도에서 상하좌우 이웃한 곳끼리만 가능하다.
 * 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽 아래 지점까지 항상 내리막길로만 이동하는 경로의 개수를 구하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에는 지도의 세로의 크기 M과 가로의 크기 N이 빈칸을 사이에 두고 주어진다. 
 * 이어 다음 M개 줄에 걸쳐 한 줄에 N개씩 위에서부터 차례로 각 지점의 높이가 빈 칸을 사이에 두고 주어진다. 
 * M과 N은 각각 500이하의 자연수이고, 각 지점의 높이는 10000이하의 자연수이다.
 * 
 * 출력
 * 첫째 줄에 이동 가능한 경로의 수 H를 출력한다. 모든 입력에 대하여 H는 10억 이하의 음이 아닌 정수이다.
 */
public class BOJ_1520 {

	static int M, N; // 지도 크기
	static int[][] map; // 지도
	
	static int[][] dp; // 해당 칸 까지의 count
	
	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int nr, nc;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		
		// 지도 크기
		map = new int[M][N];
		dp = new int[M][N];
		for (int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
//		map[0][0] = 1;
		go(0, 0); // (0, 0)부터 시작
		
		System.out.println(dp[M-1][N-1]);
	}
	
	// 내리막길만 찾아서 가자
	static void go(int r, int c) {
		// 도착하면 return
		if(r==M-1 & c==N-1) {
			dp[r][c]++;
			return;
		}
		
		// 상하좌우 확인
		for (int i = 0; i < delta.length; i++) {
			nr = r+delta[i][0];
			nc = c+delta[i][1];
			// 지도 범위 벗어나면 continue
			if(nr<0 || nc<0 || nr>=M || nc>=N) {
				continue;
			}
			// 인접한 지점이 나보다 크거나 같으면 안 감
			if(map[r][c] <= map[nr][nc]) continue;
			
			if(map[r][c] > map[nr][nc]) {
				System.out.println("r, c: "+r+c);
				
//				if(dp[r][c] < dp[nr][nc]) {
//					go(nr, nc);
//					continue;
//				}
				
				dp[r][c]++;
				go(nr, nc);
			}
		}
	}
}
/***
 * 
 * 
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10

3
*/