package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * Floyd-Warshall
 * 플로이드 와샬
 * 2021.12.15
 * @author Chaerin Yu
 * 경유지-출발지-도착지
 */
public class BOJ_11403 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i = 0; i < N; i++) { // 경유지
			for (int j = 0; j < N; j++) { // 출발지
				if(i==j) continue;
				for (int k = 0; k < N; k++) { // 도착지
//					if(j==k) continue;
					if(graph[j][i] == 1 && graph[i][k] == 1) graph[j][k] = 1;
				}
			}
		}
		

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(graph[i][j]).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

}
