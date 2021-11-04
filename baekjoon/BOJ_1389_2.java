package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1389. 케빈 베이컨의 6단계 법칙
 * @author Chaerin Yu
 * BFS
 */
public class BOJ_1389_2 {

	static int N, M; // 유저 수, 친구관계 수
	static int[][] friends;
	
	static int answer; // 케빈 베이컨 합
	static int person; // 케빈 베이컨 합이 최소인 사람
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 유저 수
		M = Integer.parseInt(st.nextToken()); // 친구관계 수
		
		friends = new int[N][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			
			friends[from][to] = 1;
			friends[to][from] = 1;
		}
		
		answer = Integer.MAX_VALUE;
		person = 0;
		for (int i = 0; i < N; i++) {
			bfs(i);
		}
		
		System.out.println(person);
	}

	private static void bfs(int n) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		queue.offer(n);
		visited[n] = true;
		
		int[] conn = new int[N];
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < N; i++) {
				if(!visited[i] && friends[now][i] > 0) {
					conn[i] = conn[now]+1;
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		int temp = 0;
		for (int i = 0; i < N; i++) {
			temp += conn[i];
		}
		if(answer > temp) {
			answer = temp;
			person = n+1;
		}
	}
	
}
