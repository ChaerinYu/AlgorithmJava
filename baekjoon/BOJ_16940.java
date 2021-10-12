package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Study week 6
 * 16940. BFS 스페셜 저지
 * @author ChaerinYu
 * 2021.10.11
 */
public class BOJ_16940 {

	static int N; // 정점 수
	static ArrayList<Integer> edges[]; // 간선
	
//	static int[] parents; // 부모
//	static Queue<Integer> order; // 방문순서가 저장된 큐
	static int[] order;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); // 정점 수
		
		// 간선 arrayList 초기화
		edges = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			edges[i] = new ArrayList<Integer>();
		}
		
		// 간선 정보 입력
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			edges[from].add(to);
			edges[to].add(from);
		}
		
		// 주어진 방문 순서
		st = new StringTokenizer(br.readLine());
//		order = new LinkedList<Integer>();
		order = new int[N+1];
		for (int i = 0; i < N; i++) {
//			order.add(Integer.parseInt(st.nextToken()));
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		// 시작정점 1이 아닌 경우
		if(order[0] != 1) {
			System.out.println(0);
			return;
		}
		
		boolean flag = bfs(1); // 이 문제에서 시작 정점은 1이다.
		
		if(flag)
			System.out.println(1);
		else
			System.out.println(0);
	}

	private static boolean bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.add(start);
		visited[start] = true;
		
//		System.out.print(start+" ");
		Set<Integer> set = new HashSet<Integer>(); // 정점 번호 저장할 set
		int idx = 1;
		while(!queue.isEmpty()) {
			set.clear();
			int now = queue.poll();
			
			// 현재 정점의 인접 정점 확인
			for (int next : edges[now]) {
				if(!visited[next]) {
					visited[next] = true;
					set.add(next); // 방문해야 하는 애들 set에 저장
				}
			}
			int size = set.size();
			for (int i = idx; i < idx+size; i++) {
				// 지금 방문할 순서의 정점
				// set에 없는 경우 지금 방문할 순서의 정점이 현재 정점과 인접하지 않음
				if(set.contains(order[i])) {
					queue.add(order[i]);
				} else {
					return false;
				}
			}
			idx += size;
			
		}
		return true;
	}
	
}
