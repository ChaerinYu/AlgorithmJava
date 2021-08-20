package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1247. [S/W 문제해결 응용] 3일차 - 최적 경로
 * @author user
 * 
 * 시간이 너무 걸리는데 더 줄이는 방법 없을까.
 * 
 * 회사에서 출발해서 이들을 모두 방문하고 집에 돌아가는 경로 중 총 이동거리가 가장 짧은 경로를 찾는 프로그램을 작성하라.
 * 
 * 고객의 수 N은 2≤N≤10 이다.
 * 그리고 회사의 좌표, 집의 좌표를 포함한 모든 N+2개의 좌표는 서로 다른 위치에 있으며 좌표의 값은 0이상 100 이하의 정수로 이루어진다.
 * 
 * 가장 첫줄은 전체 테스트케이스의 수이다.
 * 이후, 두 줄에 테스트 케이스 하나씩이 차례로 주어진다.
 * 각 테스트 케이스의 첫째 줄에는 고객의 수 N이 주어진다. 둘째 줄에는 회사의 좌표,집의 좌표, N명의 고객의 좌표가 차례로 나열된다.
 * 좌표는 (x,y)쌍으로 구성되는데 입력에서는 x와 y가 공백으로 구분되어 제공된다.
 */
public class SWEA_1247 {

	static int cx, cy; // 회사
	static int hx, hy; // 집
	static int N; // 고객 수
	static int[][] customers; // 고객 
	
	static boolean[][] visited; // 방문여부
	
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			res = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine()); // 고객 수
			
			customers = new int[N][2]; // 고객 배열 크기 초기화
			visited = new boolean[101][101];
			
			st = new StringTokenizer(br.readLine(), " ");
			// 회사, 집, 고객 좌표 입력
			cx = Integer.parseInt(st.nextToken());
			cy = Integer.parseInt(st.nextToken());
			hx = Integer.parseInt(st.nextToken());
			hy = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
			}
			
			go(cx, cy, 0);
			
			System.out.println("#"+t+" "+res);
		}
		
	}
	
	static void go(int x, int y, int dist) {
		
		// 집 도착
		if(x==hx && y==hy) {
			res = Math.min(res, dist);
			return;
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int nx = customers[i][0];
			int ny = customers[i][1];
			// 방문한 집이면 방문 안하기
			if(visited[nx][ny]) {
				cnt++;
				
				if(cnt == N) { // 고객 집 다 방문 했으면
					dist += Math.abs(x-hx)+Math.abs(y-hy); // 마지막 고객과 집 거리
					go(hx, hy, dist); // 집으로 가기
				}
				
				continue;
			}
			// 방문 체크
			visited[nx][ny] = true;
			dist += Math.abs(nx-x)+Math.abs(ny-y); // 거리
			
			go(customers[i][0], customers[i][1], dist); // 고객님 집으로 가기
			
			// 초기화
			visited[nx][ny] = false;
			dist -= Math.abs(nx-x)+Math.abs(ny-y); // 거리
		}
		
		return;
	}

}
