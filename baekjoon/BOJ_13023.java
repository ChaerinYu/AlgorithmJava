package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Study week 5
 * 13023. ABCDE
 * @author Chaerin Yu
 * DFS
 */
public class BOJ_13023 {

	static int N, M; // 사람 수, 친구 관계 수 5 ≤ N ≤ 2000, 1 ≤ M ≤ 2000
	static ArrayList<ArrayList<Integer>> relation; // 관계
	
	static boolean isCycle = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// cycle 있으면 1 아니면 0 출력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람 수
		M = Integer.parseInt(st.nextToken()); // 친구 관계 수
		
		relation = new ArrayList<>(); // 관계
		for (int i = 0; i < N; i++) {
			relation.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			relation.get(from).add(to);
			relation.get(to).add(from);
		}
		
		// DFS
		for (int i = 0; i < N; i++) {
			boolean[] visited = new boolean[N];
			dfs(i, 0, visited);
			if(isCycle) {
				sb.append(1);
				break;
			}
		}
		if(!isCycle) sb.append(0);
		
		System.out.println(sb);
	}
	
	private static void dfs(int index, int cnt, boolean[] visited) {
		// N-1이 아닌 4 (A, B, C, D, E -> 총 4개의 연결관계)
		if(cnt == 4) {
			isCycle = true;
			return;
		}
		
		visited[index] = true;
		for (int person : relation.get(index)) {
			if(!visited[person]) {
				visited[person] = true;
				dfs(person, cnt+1, visited);
			}
		}
		visited[index] = false;
	}

}
