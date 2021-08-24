package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1753. 최단경로
 * @author user
 * 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 
 * 단, 모든 간선의 가중치는 10 이하의 자연수이다.
 * 
 * 첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1≤V≤20,000, 1≤E≤300,000) 
 * 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 둘째 줄에는 시작 정점의 번호 K(1≤K≤V)가 주어진다. 
 * 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 
 * 이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다. 
 * 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.
 * 
 */
public class BOJ_1753 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken()); // 정점 수 
		int E = Integer.parseInt(st.nextToken()); // 간선 수
		int start = Integer.parseInt(br.readLine()); // 시작점
		final int INF = Integer.MAX_VALUE;
		
//		int[][] edges = new int[V+1][V+1]; // 간선의 정보 -> 시간초과 발생
		ArrayList<int[]>[] edges = new ArrayList[V+1]; // 가중치 간선 저장
        for(int i=0;i<=V;i++) edges[i] = new ArrayList<int[]>(); // 초기화
        
		// 간선정보
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); // 가중치
			
			edges[from].add(new int[]{to, w});
//			matrix[from][to] = w;
		}
		
		int[] distance = new int[V+1]; // 시작점에서 index까지의 거리
		boolean[] visited = new boolean[V+1]; // 방문 여부
		
		Arrays.fill(distance, INF); // 최소값을 구하기 위해 INF 입력
		distance[start] = 0; // 시작위치는 자기 자신이므로 거리가 0
		
		int current = -1;
		for (int i = 1; i <= V; i++) {
			int min = INF;
			current = -1;
			// 방문하지 않은 정점 중 최소 가중치 정점으로
			for (int j = 1; j <= V; j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j]; // 최소 가중치 업데이트
					current = j; // 정점 업데이트
				}
			}
			
			// 관련된 접점 없는 경우
			if(current == -1) break;
			visited[current] = true; // 선택 정점 방문 처리
			
			for (int j = 0; j < edges[current].size(); j++) {
				// 방문 아직 안했고, 인접해 있고, distance > min+인접값
				int to = edges[current].get(j)[0];
				int w = edges[current].get(j)[1];
				if(!visited[to] && distance[to]>min+w) {
						distance[to] = min+w;
				}
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if(!visited[i]) sb.append("INF\n");
			else sb.append(distance[i]).append("\n");
		}
		System.out.println(sb);
	}
}
