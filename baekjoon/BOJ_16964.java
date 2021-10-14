package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Study week 6
 * 16964. DFS 스페셜 저지
 * @author ChaerinYu
 * 주어진 순서에 기반하여 현재 그래프의 정점들을 정렬
 * 2021.10.14
 * 어려워..
 */
public class BOJ_16964 {
	
	static int N; // 정점 수
	static ArrayList<Integer> edges[]; // 트리의 간선 정보
	static int[] order;  // DFS 방문순서
	static int[] dfsOrder;  // DFS 주어진 순서 값을 저장
	
	static int idx;
	static boolean flag; // 방문 순서 올바른지
	
	static Set<Integer> hash = new HashSet<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); // 정점 수
		
		edges = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			edges[i] = new ArrayList<Integer>();
		}
		// 간선 정보입력
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			edges[from].add(to);
			edges[to].add(from);
		}
		// DFS 방문순서 입력
		st = new StringTokenizer(br.readLine());
		order = new int[N];
		dfsOrder = new int[N+1];
		for (int i = 0; i < N; i++) {
			order[i] = Integer.parseInt(st.nextToken());
			dfsOrder[order[i]] = i+1;
		}

		// 시작정점 1이 아닌 경우
		if(order[0] != 1) {
			System.out.println(0);
			return;
		}
		
		
		// 저장된 순서 값 기반으로 graph 정점 재정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(edges[i], new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(dfsOrder[o1], dfsOrder[o2]);
				}
				
			});
		}
		
		// 시작 정점은 1
		flag = false;
		idx = 0;
		dfs(1, new boolean[N+1]);
		
		// 입력으로 주어진 DFS 방문 순서가 올바른 순서면 1, 아니면 0을 출력한다.
		if(flag) System.out.println(0);
		else System.out.println(1);
	}

	private static void dfs(int node, boolean[] visited) {
		if(node != order[idx++]) {
			flag = true;
			return;
//			System.out.println(0);
//			System.exit(0);
		}
		visited[node] = true;
		
		for (Integer next : edges[node]) {
			if(!visited[next]) {
				dfs(next, visited);
			}
			
		}
	}
}
