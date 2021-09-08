package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * Study week 2
 * 11724.연결 요소의 개수
 * @author ChaerinYu
 * 
 * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 
 * 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 
 * 같은 간선은 한 번만 주어진다.
 * 
 * 첫째 줄에 연결 요소의 개수를 출력한다.
 */
public class BOJ_11724 {

	static int N, M; // 정점의 개수, 간선의 개수
	static ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
	
	static int res = 0;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 정점
		M = Integer.parseInt(st.nextToken()); // 간선
		
		// arraylist 초기화
		for (int i = 0; i <= N; i++) {
			nodes.add(new ArrayList<Integer>());
		}
		
		// 입력
		int from = 0, to = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			nodes.get(from).add(to);
			nodes.get(to).add(from);
		}
		
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			// 아직 방문 안 한 정점만 간다.
			if(!visited[i]) {
				dfs(i);
				res++;
			}
		}
		System.out.println(res);
	}
	
	static void dfs(int index) {
		if(visited[index]) {
			return;
		}
		visited[index] = true;
		
		for (int i = 0; i < nodes.get(index).size(); i++) {
			int next = nodes.get(index).get(i);
			// 방문한 정점이면 넘어간다.
			if(visited[next]) continue;
			
//			visited[next] = true;
			dfs(next);
		}
	}
}
