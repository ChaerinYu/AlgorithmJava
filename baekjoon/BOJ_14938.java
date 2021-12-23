package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Study 16week
 * @author Chaerin Yu
 * 2021.12.24
 * 서강그라운드 
 * 플로이드 와샬
 */
public class BOJ_14938 {

	final static int INF = 1_000_000_000;
	
	static int n, m, r; // 지역, 수색범위, 길 개수
	static int[] items; // 각 구역 아이템 수
	static int[][] map;

	static class Node {
		int data; // 연결된 지역
		int dist; // 거리
		
		public Node(int data, int dist) {
			this.data = data;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 지역 개수 1 ≤ n ≤ 100
		m = Integer.parseInt(st.nextToken()); // 수색 범위 1 ≤ m ≤ 15
		r = Integer.parseInt(st.nextToken()); // 길 개수 1 ≤ r ≤ 100
		
		items = new int[n+1]; // 각 구역에 있는 아이템 수
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		map = new int[n+1][n+1]; // 지역-지역 길 길이
		for (int i = 0; i <= n; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int loc1 = Integer.parseInt(st.nextToken()); // 지역1
			int loc2 = Integer.parseInt(st.nextToken()); // 지역2
			int dist = Integer.parseInt(st.nextToken()); // 길이
			
			// 양방향
			map[loc1][loc2] = map[loc2][loc1] = dist;
		}
		
		
		// 플로이드 와샬
		// 경유해서 가는 게 더 빠른 경우 경유값으로 업뎃
		for (int k = 1; k <= n; k++) { // 경유지
			for (int i = 1; i <= n; i++) {
				if(k==i) continue;
				for (int j = 1; j <= n; j++) {
					if(i==j) continue;
					if(map[i][k] + map[k][j] < map[i][j]) map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int temp = 0; // j for문에서 자기자신 더해주므로 0부터 시작
			for (int j = 1; j <= n; j++) {
				// 수색범위인 경우만 temp에 더해준다.
				if(map[i][j] <= m) temp += items[j];
			}
			// 최대인 경우 업데이트
			if(temp > ans) ans = temp;
		}
		System.out.println(ans);
	}
}
