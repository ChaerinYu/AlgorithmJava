package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 2021.09.30
 * Prim
 * @author user
 *
 */
public class Solution_SWEA_3124_Prim {

	static int T, V, E;
	
	static LinkNode[] graph;
	static long totalCost;
	static int edgeCnt;
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new LinkNode[V+1];
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				// 무향의 그래프
				graph[a] = new LinkNode(b, c, graph[a]);
				graph[b] = new LinkNode(a, c, graph[b]);
			}
			
			totalCost = prim();
			sb.append("#").append(tc).append(" ").append(totalCost).append("\n");
		}
		System.out.println(sb);
	}
	
	static long prim() {
		PriorityQueue<LinkNode> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		// 임의의 한 점을 출발 점으로 잡는다.
		pq.offer(new LinkNode(1, 0)); // 출발점까지 가는 비용은 당연히 0원 (여기서 출발하니까)
		
		int visitedCnt = 0;
		long sum = 0;
		while(!pq.isEmpty()) {
			// 1. 대장 가져오기
			LinkNode head = pq.poll();
			
			// 방문 처리
			if(visited[head.i]) continue;
			
			visited[head.i] = true;
			// 2. 사용해보기 - 정답?
			sum += head.cost;
			// pq에는 이미 방문한 정점들에 대한 것들이 무수히 있을 수 있다.
			if(visitedCnt++ == V-1) return sum;
			
			// 3. 자식 노드 탐색하기
			LinkNode pre = graph[head.i];
			while(pre != null) {
				if(!visited[pre.i]) {
					// 담기만 할 뿐 방문 처리는 하지 않는다.
					pq.add(new LinkNode(pre.i, pre.cost));
				}
				pre = pre.pre;
			}
		}
		return sum;
	}
	
	static class LinkNode implements Comparable<LinkNode>{
		int i;
		int cost;
		LinkNode pre;
		
		public LinkNode(int i, int cost, LinkNode pre) {
			super();
			this.i = i;
			this.cost = cost;
			this.pre = pre;
		}

		public LinkNode(int i, int cost) {
			this(i, cost, null);
		}

		@Override
		public int compareTo(LinkNode o) {
			return Integer.compare(this.cost, o.cost);
		}
		
		
	}

	private static String src = "1\r\n" + 
			"3 3\r\n" + 
			"1 2 1\r\n" + 
			"2 3 2\r\n" + 
			"1 3 3";
}
