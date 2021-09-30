package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 2021.09.30
 * kruskal + pq
 * @author user
 *
 */
public class Solution_SWEA_3124_Kruskal {

	static int T, V, E;
	static PriorityQueue<Edge> pq;
	static int[] repres;
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
			
			pq = new PriorityQueue<>();
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				pq.offer(new Edge(a, b, c));
			}
			
			totalCost = edgeCnt = 0;
			
			// 전체를 독립적 그룹으로 만들자
			makeSet();
			
			while(!pq.isEmpty()) {
				Edge head = pq.poll();
				
				union(head.nodeA, head.nodeB, head.cost);
				// 연결은 최대 V-1개까지만
				if(edgeCnt==V-1) break;
			}
			
			sb.append("#").append(tc).append(" ").append(totalCost).append("\n");
		}
		System.out.println(sb);
	}
	
	// 요소들을 독립된 집합으로 분리시킨다.
	static void makeSet() {
		repres = new int[V+1];
		for (int i = 1; i < repres.length; i++) {
			repres[i] = i; // 자기 자신이 자기 그룹의 대표자
		}
	}
	
	// a가 속한 그룹의 대표자를 반환한다.
	static int findSet(int a) {
		if(repres[a]==a) return a;
		return repres[a] = findSet(repres[a]); // path compression
	}
	
	// a가 속한 집합과 b가 속한 집합을 합한다.
	static void union(int a, int b, int cost) {
		a = findSet(a);
		b = findSet(b);
		
		if(a != b) {
			repres[a] = b;
			totalCost += cost;
			edgeCnt++;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int nodeA, nodeB, cost;

		public Edge(int nodeA, int nodeB, int cost) {
			super();
			this.nodeA = nodeA;
			this.nodeB = nodeB;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}

	private static String src = "1\r\n" + 
			"3 3\r\n" + 
			"1 2 1\r\n" + 
			"2 3 2\r\n" + 
			"1 3 3";
}
