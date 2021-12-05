package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 1238. 파티
 * @author user
 * 가장 오래 걸리는 학생의 소요시간
 */
public class BOJ_1238_2 {

	static final int INF = Integer.MAX_VALUE;
	
	static int N, M, X, dist[]; // N명의 학생, M개의 단방향 도로, 파티마을, 시간
	static ArrayList<Road>[] fromPartyList; // X에서 마을로
//	static ArrayList<Road>[] toPartyList; // 마을에서 X로
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 학생 수 (1~1000)
		M = Integer.parseInt(st.nextToken()); // 단방향 도로 수 (1~10000)
		X = Integer.parseInt(st.nextToken()); // 파티 개최 마을
		
		fromPartyList = new ArrayList[N+1];
//		toPartyList = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			fromPartyList[i] = new ArrayList<Road>();
//			toPartyList[i] = new ArrayList<Road>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			fromPartyList[start].add(new Road(next, dist));
//			toPartyList[next].add(new Road(start, dist));
		}
		
		int res = 0;
		int[] xToi = dijkstra(X);
		for (int i = 1; i <= N; i++) {
			if(i==X) continue;
			int[] iTox = dijkstra(i);
			int temp = iTox[X] + xToi[i];
			if(res < temp) res = temp;
		}
		System.out.println(res);
	}

	// 
	private static int[] dijkstra(int start) {
		PriorityQueue<Road> queue = new PriorityQueue<Road>(new Comparator<Road>() {
			@Override
			public int compare(Road o1, Road o2) {
				return Integer.compare(o1.dist, o2.dist);
			}
		}); // 소요시간 짧은 거 부터
		boolean[] visited = new boolean[N+1]; // 동네 방문 여부
		
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		queue.offer(new Road(start, 0));
		
		while(!queue.isEmpty()) {
			
			Road now = queue.poll();
			int next = now.next;
			
			if(now.dist > dist[now.next]) continue;
			
			if(visited[next]) continue;
			visited[next] = true;
			
			for (Road road : fromPartyList[next]) {
				if(!visited[road.next] && dist[road.next] > now.dist + road.dist) {
					dist[road.next] = now.dist + road.dist;
					queue.offer(new Road(road.next, now.dist + road.dist));
				}
			}
		}
		
		return dist;
	}

	public static class Road {
		int next;
		int dist;
		
		public Road(int next, int dist) {
			this.next = next;
			this.dist = dist;
		}
		
	}
}
