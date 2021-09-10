package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 1967. 트리의 지름
 * @author ChaerinYu
 * 트리에 존재하는 모든 경로들 중에서 가장 긴 것의 길이
 */
public class BOJ_1967 {

	static int N; // 노드 수 
//	static Node[] vertex;
	static ArrayList<ArrayList<Node>> vertexes = new ArrayList<ArrayList<Node>>();
	static int[] dp; // 해당 노드에서의 가장 긴 경로의 길이
	
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
		
		// 노드마다 체크
		dp = new int[N+1];
//		for (int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N+1];
			int temp = dfs(1, visited);
//		}
		int res = 0;
		for (int i = 1; i <= N; i++) {
			res = Math.max(res, dp[i]);
		}
		System.out.println(res);
	}
	
	static int dfs(int index, boolean[] visited) {
		
//		if(visited[index]) {
//			return dp[index];
//		}
		
		visited[index] = true;
		
		int max = 0;
		for (int i = 0; i < vertexes.get(index).size(); i++) {
			Node next = vertexes.get(index).get(i);
			if(!visited[next.next]) dfs(next.next,visited);
			if(max<=dp[next.next]) {
				dp[index] = next.weight;
			}
//				max = Math.max(max, next.weight);
		}
//		dp[index] += max;
		System.out.println("index: "+index+", "+dp[index]);
		return dp[index];
	}
	
	static class Node {
//		int vertex;
		int next;
		int weight;

		public Node(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}
		
//		public Node(int vertex, Node link, int weight) {
//			this.vertex = vertex;
//			this.link = link;
//			this.weight = weight;
//		}
		
	}
}
