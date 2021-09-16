package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 9205. 맥주 마시면서 걸어가기
 * @author ChaerinYu
 * Floyd Warshall, BFS 둘 다 가능
 * 첫째 줄에 테스트 케이스의 개수 t가 주어진다. (t ≤ 50)
 * 각 테스트 케이스의 첫째 줄에는 맥주를 파는 편의점의 개수 n이 주어진다. (0 ≤ n ≤ 100).
 * 다음 n+2개 줄에는 상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표가 주어진다. 각 좌표는 두 정수 x와 y로 이루어져 있다. (두 값 모두 미터, -32768 ≤ x, y ≤ 32767)
 * 송도는 직사각형 모양으로 생긴 도시이다. 두 좌표 사이의 거리는 x 좌표의 차이 + y 좌표의 차이 이다. (맨해튼 거리)
 */
public class BOJ_9205 {

	static int t, n; // test case 수, 편의점 수
	static int[][] stores; // 집+편의점+락페스티벌
	static boolean isSad;
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[n+2];
		
		q.offer(0); // home
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			// 현재 위치가 페스티벌인 경우
			if(current==n+1) {
				isSad = false; // happy
				return;
			}
			int distX, distY;
			// 집 제외하고 시작 (집 포함해도 상관 없음)
			for (int i = 1; i < n+2; i++) {
				distX = Math.abs(stores[i][0]-stores[current][0]);
				distY = Math.abs(stores[i][1]-stores[current][1]);
				// 50m당 맥주 한 캔 클리어하므로 1000보다 작아야 함
				if(!visited[i] && distX+distY<=1000) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		isSad = true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		StringTokenizer st = null;
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine()); // 편의점 수
			
			// 편의점 입력
			stores = new int[n+2][2]; // 0: 집, n+1: 페스티벌
			for (int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				stores[i][0] = Integer.parseInt(st.nextToken());
				stores[i][1] = Integer.parseInt(st.nextToken());
			}
			
			isSad = false; // 초기화
			bfs();
			
			if(isSad)
				System.out.println("sad");
			else 
				System.out.println("happy");
		}
	}
	
}
