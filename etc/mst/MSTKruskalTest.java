package etc.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MSTKruskalTest {

	static class Edge implements Comparable<Edge>{
		
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return this.weight - o.weight; // 가중치가 다 양수인 경우 (간선 부호가 모두 같은 경우)
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static int[] parents; // 부모원소를 관리(트리처럼 사용)
	
	private static void make() {
		
		// 배열 생성
		parents = new int[V];
		
		// 모든 원소를 자신을 대표자로 만듦
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	// a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if(a==parents[a]) return a; // 자신이 대표자
		// 자신이 속한 집합의 대표자를 자신의 부모로 바꾼다. path compression
		return parents[a] = find(parents[a]);
	}
	
	// 두 원소를 하나의 집합으로 합치기 (대표자를 이용해서 합침)
	// return값을 가질 필요는 없지만 
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false; // 이미 같은 집합으로 합치지 않음
		
		// 오른쪽(b) 대표를 왼쪽(a) 대표로
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	static int V, E;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 간선 리스트 작성
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(start, end, weight);
		}
		
		Arrays.sort(edgeList); // 오름차순
		
		make(); // 모든 정점을 각각의 집합으로 만들고 출발
		
		// 간선 하나씩 시도하며 트리 만들어 감
		int cnt = 0, result = 0; // cnt 간선 수, result 최소 값
		for (Edge edge : edgeList) {
			// edge의 start, end를 union(연결)해봐~
			// true면 합칠 수 있음
			if(union(edge.start, edge.end)) {
				result += edge.weight;
				// 최소 간선 다 쓴 경우
				if(++cnt == V-1) break; // 신장트리 완성!
			}
		}
		System.out.println(result);
	}

}

/**5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

output==>10

7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51

output==>175
*/