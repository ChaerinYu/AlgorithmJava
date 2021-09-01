package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Study week 1
 * 11725. 트리의 부모 찾기
 * @author Chaerin Yu
 * 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
 * 첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
 * 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
 * --> DFS Node class 선언
 */
public class BOJ_11725_2 {

	
	static class Node {
		int vertex; // 인접정점 인덱스
		Node link; // 다음 node
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}
	
	static int N; // 노드 수
	static Node[] adjList;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		adjList = new Node[N+1];
		
		// 입력
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			adjList[node1] = new Node(node2, adjList[node1]);
			adjList[node2] = new Node(node1, adjList[node2]);
		}
		
		// 방문 여부 체크
		boolean[] visited = new boolean[N+1];
		parents = new int[N+1];
		dfs(1, visited);
		
		// 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
	}
	
	// DFS로 부모 찾기
	static void dfs(int index, boolean[] visited) {
		visited[index] = true;
		
		for (Node temp = adjList[index]; temp != null; temp = temp.link) {
			int next = temp.vertex;
			if(!visited[next]) {
				parents[next] = index;
				dfs(next, visited);
			}
		}
	}
}
