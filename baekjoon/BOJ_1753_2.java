package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
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
 * PriorityQueue
 */
public class BOJ_1753_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken()); // 정점 수 
		int E = Integer.parseInt(st.nextToken()); // 간선 수
		int start = Integer.parseInt(br.readLine()); // 시작점
		final int INF = Integer.MAX_VALUE;
		
		ArrayList<int[]>[] edges = new ArrayList[V+1]; // 가중치 간선 저장
        for(int i=0;i<=V;i++) edges[i] = new ArrayList<int[]>(); // 초기화
        
		// 간선정보
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); // 가중치
			
			edges[from].add(new int[]{to, w});
		}
		
		int[] distance = new int[V+1]; // 시작점에서 index까지의 거리
		boolean[] visited = new boolean[V+1]; // 방문 여부
		
		Arrays.fill(distance, INF); // 최소값을 구하기 위해 INF 입력
		distance[start] = 0; // 시작위치는 자기 자신이므로 거리가 0
		
		////// PriorityQueue 사용: 우선순위에 따라서 큐 내부 값의 배치가 변경된다.
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
			
		});
		// 방문 여부 확인
//		boolean[] visited = new boolean[V+1];
		// queue에 시작 node 넣어준다.
		queue.add(new int[] {start, 0});
		distance[start] = 0; // 시작점 0 저장 (시작점->시작점 가중치 0)
		
		while(!queue.isEmpty()) {
			
			int[] current = queue.poll(); // 현재 노드, 가중치가 최소인 정점 선택
			
			int next = current[0];
			// 방문한 정점일 경우 탈출;
			if(visited[next]) continue;
			
			// 방문하지 않은 정점이면 방문 처리
			visited[next] = true;
			
			// 선택된 정점의 인접 정점 확인
			for(int[] node: edges[next]) {
				// 저장되어 있는 최소 가중치보다 현재 정점에서~인접 정점으로 갈때 가중치가 작으면 갱신
				// 최소 가중치가 갱신되면, queue 넣어줌.
				/*
				if(distance[node[0]] > distance[next] + node[1]) {
					distance[node[0]] = distance[next] + node[1];
					queue.add(new int[] {node[0], distance[node[0]]});
				}
				*/
				// 방문 아직 안했고, 기존 시작점에서의 거리가 현재 정점 가중치+다음(인접) 정점보다 크면 갱신
				if(!visited[node[0]] && distance[node[0]] > current[1]+node[1]) {
					distance[node[0]] = current[1] + node[1];
					// priorityqueue에 추가해서 다음 방문 가능하도록
					queue.add(new int[] {node[0], current[1]+node[1]});
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
