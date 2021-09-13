package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * 1238. 파티
 * @author ChaerinYu
 * dijkstra
 */
public class BOJ_1238 {
	static final int INFINITY = Integer.MAX_VALUE;

	static int N, M, X; // 마을(사람) 수, 단방향 도로 수, 파티열린 마을
	static ArrayList<ArrayList<Node>> town = new ArrayList<>();
	static int[] distances; // 파티 마을 가기 위한 각 마을의 최단 거리
	static boolean[] visited;
	
	static int toDistance; // 최장 거리
	static int fromDistance; // 최장 거리
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= N; i++) {
			town.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// 단방향 !
			town.get(from).add(new Node(to, weight));
		}
		
		int res = 0;
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			int[] iToX = dijkstra(i);
			visited = new boolean[N+1];
			int[] xToI = dijkstra(X);
			res = Math.max(res, iToX[X]+xToI[i]);
		}
		System.out.println(res);
	}
	
	static int[] dijkstra(int start) {

		distances = new int[N+1];
		Arrays.fill(distances, INFINITY); // 배열 초기화 -> 각 정점부터 최소비용저장 배열 초기화
		
		distances[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int next = current.next;
			
			if(visited[next]) continue;
			visited[next] = true;
			
			for (Node node : town.get(next)) {
				if(!visited[node.next] && distances[node.next] > current.weight+node.weight) {
					distances[node.next] = current.weight + node.weight;
					// priorityqueue에 추가해서 다음 방문 가능하도록
					pq.add(new Node(node.next, current.weight+node.weight));
				}
			}
		}
		return distances;
	}
	
	static class Node implements Comparable<Node> {
		int next;
		int weight;
		
		public Node(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}
}
