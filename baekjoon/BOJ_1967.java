package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * Study week 2
 * 1967. 트리의 지름
 * @author ChaerinYu
 * 트리에 존재하는 모든 경로들 중에서 가장 긴 것의 길이
 * https://jaimemin.tistory.com/531
 */
public class BOJ_1967 {

	static int N; // 노드 수 
	static ArrayList<ArrayList<Node>> vertexes = new ArrayList<ArrayList<Node>>();
	static int res; // 정답 (가장 긴 지름)
	static int wNode; // 가장 먼 노드
	
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N+1; i++) {
			vertexes.add(new ArrayList<Node>());
		}
		// 노드 개수 -1 만큼
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v = Integer.parseInt(st.nextToken()); // 노드
			int next = Integer.parseInt(st.nextToken()); // 연결된 노드
			int w = Integer.parseInt(st.nextToken()); // 가중치
			
			vertexes.get(v).add(new Node(next, w));
			vertexes.get(next).add(new Node(v, w));
		}
		
		// 가장 깊은 노드 중 가중치가 가장 큰 노드를 찾는다.
		// 찾은 노드를 기준 정점으로 잡고, 다시 한번 가장 가중치가 큰(가장 먼) 노드를 찾는다.
		res = 0;
		visited = new boolean[N+1];
		dfs(1, 0);
		visited = new boolean[N+1];
		res = 0;
		dfs(wNode, 0);
		
//		System.out.println(wNode);
		System.out.println(res);
	}
	
	static void dfs(int index, int dist) {

		if(visited[index]) return;
		
		visited[index] = true;
		
		// 지름 업데이트
		if(res<dist) {
			res = dist;
			wNode = index;
		}
		
		for (Node vertice : vertexes.get(index)) {
			int next = vertice.next;
			int weight = vertice.weight;
			
			if(!visited[next]) {
				dfs(next, dist+weight);
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
