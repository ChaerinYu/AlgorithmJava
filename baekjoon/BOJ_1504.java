package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 1504. 특정한 최단 경로
 * @author Chaerin Yu
 * bfs X, dijkstra
 * Study 14week
 */
public class BOJ_1504 {

	static final int INF = 200_000_000;
	static int N, E, V1, V2; // 정점 개수, 간선 개수, 반드시 거쳐야하는 정점 2개
	static ArrayList<Node>[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점
		E = Integer.parseInt(st.nextToken()); // 간선
		
		list = new ArrayList[N+1]; // 정점 거리
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int vertex = Integer.parseInt(st.nextToken()); // 정점
			int next = Integer.parseInt(st.nextToken()); // 연결된 정점 
			int dist = Integer.parseInt(st.nextToken()); // 거리
			
			// 이렇게 할 경우, list NULL인 경우 존재 -> line 29처럼 해줘야 한다.
//			if(list[vertex] == null)
//				list[vertex] = new ArrayList<Node>();
//			if(list[next] == null)
//				list[next] = new ArrayList<Node>();
			
			// 방향성이 없는 그래프
			list[vertex].add(new Node(next, dist));
			list[next].add(new Node(vertex, dist));
		}
		
		// 거쳐야 하는 정점 v1, v2
		st = new StringTokenizer(br.readLine());
		V1 = Integer.parseInt(st.nextToken()); // 정점1
		V2 = Integer.parseInt(st.nextToken()); // 정점2
		
		int res1 = dijkstra(1, V1) + dijkstra(V1, V2) + dijkstra(V2, N); // 1->V1 + V1->V2 + V2->N
		int res2 = dijkstra(1, V2) + dijkstra(V2, V1) + dijkstra(V1, N); // 1->V2 + V2->V1 + V1->N
		
		int ans = res1 > res2 ? res2 : res1;
		ans = ans >= INF ? -1 : ans;
		
		System.out.println(ans);
	}
	
	
	/**
	 * 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다. 
	 * @return
	 */
	private static int dijkstra(int start, int dest) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.dist, o2.dist);
			}
		});
		pq.offer(new Node(start, 0));
		
//		boolean[] visited = new boolean[N+1]; // 방문여부 체크용
		
		int[] sum = new int[N+1];
		Arrays.fill(sum, INF);
		sum[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll(); // 현재 위치
			int nextVertex = now.next;
			
			if(sum[nextVertex] < now.dist) continue; // 다음 정점의 최소 비용이 현재 비용보다 저렴한 경우 continue
			
//			if(visited[nextVertex]) continue;
//			visited[nextVertex] = true;
			
			for (Node next : list[nextVertex]) {
//				if(!visited[next.next] && sum[next.next] > sum[nextVertex]+next.dist) {
				if(sum[next.next] > sum[nextVertex]+next.dist) {
					sum[next.next] = sum[nextVertex]+next.dist;
					pq.add(new Node(next.next, sum[next.next]));
				}
			}
		}
		return sum[dest];
	}

	public static class Node {
		int next;
		int dist;
		
		public Node(int next, int dist) {
			this.next = next;
			this.dist = dist;
		}
		
	}
	
	// implements 방법도 자주 사용해보기
	public static class Node1 implements Comparable<Node>{
		int next;
		int dist;
		
		public Node1(int next, int dist) {
			this.next = next;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.dist, o.dist);
		}
	}
}
