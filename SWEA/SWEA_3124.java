package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * [D4] 3124. 최소 스패닝 트리
 * @author ChaerinYu
 * 최소 스패닝 트리를 계산하는 알고리즘으로 Prim's algorithm과 Kruskal's algorithm이 있다.
 * Prim's algorithm을 이용할 경우, 자료구조 힙(heap)을 이용해야 한다.
 * Kruskal's algorithm을 이용할 경우, Disjoint Set(서로소 집합) 혹은 Union-Find 알고리즘을 이용해야 한다.
 */
public class SWEA_3124 {

	static int T, V, E; // 테스트 개수, 정점, 간선 
	static Node[] list;
	static int[] parents; // 부모원소 관리
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			list = new Node[E];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				list[i] = new Node(from, to, weight);
			}
			Arrays.sort(list);
			make();
			
			int cnt = 0; // 간선 수
			long res = 0; // 최소 값
			for (Node node : list) {
				
				if(union(node.start, node.end)) {
					res += node.weight;
					
					if(++cnt == V-1) break;
				}
			}
			System.out.println("#"+tc+" "+res);
		}
		
	}
	
	private static void make() {
		// 배열 생성
		parents = new int[V+1];
		
		// 자기 자신을 대표자로 만듦
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	// 대표자 찾기
	private static int find(int a) {
		if(a==parents[a]) return a; 
		return parents[a] = find(parents[a]);
	}
	// 두 원소를 하나의 집합으로 합치기
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	static class Node implements Comparable<Node>{
		int start;
		int end; // 연결된 점
		int weight; // 가중치
		
		public Node(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// 음수도 케어함
			return Integer.compare(this.weight, o.weight);
		}
	}
}
/**
1
3 3
1 2 1
2 3 2
1 3 3

#1 3
*/