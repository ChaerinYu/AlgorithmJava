package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Study week 4
 * 1167. 트리의 지름
 * @author Chaerin Yu
 * DFS 
 * 어떤 트리에서 지름의 길이가 최대가 될 때 두 노드는 모두 leaf노드이다.
 */
public class BOJ_1167_2 {

	static int V; // 정점 수
	static ArrayList<ArrayList<Node>> trees = new ArrayList<ArrayList<Node>>(); // 연결된 트리
	
	static int leaf; // 가중치 가장 큰 리프노드
	static int res; // 답
	static boolean[] visited; // 방문여부 (dfs에서 사용)
	
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		V = Integer.parseInt(br.readLine()); // 정점 수

		// tree 배열 초기화
		for (int i = 0; i <= V; i++) {
			trees.add(new ArrayList<Node>());
		}
		
		// tree 데이터 입력
		for (int i = 0; i < V-1; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			while(st.hasMoreElements()) {
				int next = Integer.parseInt(st.nextToken());
				if(next==-1) break; // 각 줄의 마지막에는 -1이 입력으로 주어진다.
				int weight = Integer.parseInt(st.nextToken());
				
				// 임의의 두 점 사이의 거리
				trees.get(index).add(new Node(next, weight));
				trees.get(next).add(new Node(index, weight));
			}
		}
		
		// 지름의 길이가 가장 길기 위해서는 시작을 가장 끝에서부터(리프노드, 루트와 가장 먼) 시작해야 한다.
		visited = new boolean[V+1];
		res = 0;
		leaf = 0;
		dfs(1, 0); // 시작은 상관 없으니 1부터 시작 (가중치가 큰 리프 노드 찾는 게 우선)
		// 여기서 멈추면 특정 노드(루트노드)와 리프노드 길이 중 가장 거리가 큰 경우의 값이 구해진다.
		
		// 가중치 가장 큰 리프노드부터 시작한 가장 긴 지름 찾기
		visited = new boolean[V+1];
		res=0;
		dfs(leaf, 0);
		
		sb.append(res).append("\n");
		System.out.println(sb);
	}
	/**
	 * DFS
	 * @param start 시작(현재) index 위치
	 * @param d 지름 합
	 */
	static void dfs(int start, int d) {
		// 방문한 경우 return
		if(visited[start]) return;
		visited[start] = true;
		
		// 가장 큰 가중치 업데이트
		if(d>res) {
			leaf = start; // 리프노드 찾을 때만 유효한 코드이지만 가장 긴 지름 구할 때 영향 없으므로 그냥 같은 메소드로 구현함
			res = d; // 가장 큰 지름 업데이트
		}
		
		// foreach로 바꾸기
		for (Node node : trees.get(start)) {
			int next = node.next;
			int weight = node.weight;
			
			if(!visited[next]) {
				dfs(next, d+weight);
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
	

	private static String src = "12\r\n" + 
			"1 2 3 3 2 -1\r\n" + 
			"2 1 3 4 5 -1\r\n" + 
			"3 1 2 5 11 6 9 -1\r\n" + 
			"4 2 5 7 1 8 7 -1\r\n" + 
			"5 3 11 9 15 10 4 -1\r\n" + 
			"6 3 9 11 6 12 10 -1\r\n" + 
			"7 4 1 -1\r\n" + 
			"8 4 7 -1\r\n" + 
			"9 5 15 -1\r\n" + 
			"10 5 4 -1\r\n" + 
			"11 6 6 -1\r\n" + 
			"12 6 10 -1";
}
