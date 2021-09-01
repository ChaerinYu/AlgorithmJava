package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Study week 1
 * 11725. 트리의 부모 찾기
 * @author Chaerin Yu
 * 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
 * 첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
 * 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
 * --> BFS: Queue 사용
 */
public class BOJ_11725_BFS {

	static int N; // 노드 수
	static ArrayList<ArrayList<Integer>> adjList; // linked
	static int[] parents; // 각 노드 부모 저장하는 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		adjList = new ArrayList<ArrayList<Integer>>();
		// 초기화
		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		// 입력
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			adjList.get(node1).add(node2);
			adjList.get(node2).add(node1);
		}
		
		parents = new int[N+1]; // 각 노드 부모 저장하는 배열
		bfs(1); // 루트 노드부터 시작한다.
		
		// 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
	}
	
	// BFS로 부모 찾기
	static void bfs(int index) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(index);
		visited[index] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for (int i = 0; i < adjList.get(current).size(); i++) {
				int next = adjList.get(current).get(i);
				// 방문 안 했으면 방문하기
				if(!visited[next]) {
					parents[next] = current; // 내 자식에게 나를 부모로 임명
					
					queue.offer(next);
					visited[next] = true;
				}
			}
		}
	}
}
