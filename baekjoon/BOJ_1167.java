package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1167. 트리의 지름
 * @author ChaerinYu
 * BOJ_1967과 유사
 * 트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 
 * 트리의 지름을 구하는 프로그램을 작성하시오.
 */
public class BOJ_1167 {

	static int V; // 트리의 정점 개수 (2 ≤ V ≤ 100,000)
	static ArrayList<ArrayList<Node>> trees = new ArrayList<ArrayList<Node>>();;
	
	static int diameter; // 지름
	static int wNode; // 가장 깊은 노드 중 가중치가 가장 큰 노드
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		V = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= V; i++) {
			trees.add(new ArrayList<Node>());
		}
		
		// 먼저 정점 번호가 주어지고, 이어서 연결된 간선의 정보를 의미하는 정수가 두 개씩 주어지는데, 
		// 하나는 정점번호, 다른 하나는 그 정점까지의 거리이다. 
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int currNode = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				
				int num = Integer.parseInt(st.nextToken());
				if(num==-1) break; // 각 줄의 마지막에는 -1이 입력으로 주어진다.
				int weight = Integer.parseInt(st.nextToken());
				
				trees.get(currNode).add(new Node(num, weight));
				trees.get(num).add(new Node(currNode, weight));
			}
		}
		
		boolean[] visited = new boolean[V+1];
		diameter = 0;
		dfs(1, 0, visited);
		
		visited = new boolean[V+1];
		diameter = 0;
		dfs(wNode, 0, visited);
		
		System.out.println(diameter);
	}
	
	static void dfs(int v, int w, boolean[] visited) {
		if(visited[v]) return;
		// 방문체크
		visited[v] = true;

		// 지름 업데이트
		if(diameter < w) {
			diameter = w;
			wNode = v;
		}
		
		for (Node n : trees.get(v)) {
			int next = n.next;
			int weight = n.weight;
			
			if(!visited[next]) {
				dfs(next, w+weight, visited);
			}
		}
	}
	
	static class Node {
		
		int next;
		int weight;
		
		public Node(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}		
		
	}
}
