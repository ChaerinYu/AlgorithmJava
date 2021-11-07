package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2021.11.07
 * 2606. 바이러스
 * @author Chaerin Yu
 */
public class BOJ_2606 {

	static int N; // 컴퓨터 수 (100 이하)
	static int M; // 컴퓨터 쌍 수 
	static List<ArrayList<Integer>> list;
	
	static int answer; // 정답
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 컴퓨터 수
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		M = Integer.parseInt(br.readLine()); // 컴퓨터 쌍 수
		
		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		// 1번 컴퓨터를 통해 웜 바이러스에 걸리는 컴퓨터의 수
		answer = 0;
		virus(1);
		
		System.out.println(answer);
	}

	private static void virus(int computer) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(computer);
		visited[computer] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for (Integer next : list.get(now)) {
				if(!visited[next]) {
					answer++;
					queue.offer(next);
					visited[next] = true;
				}
			}
		}
	}
	
	
}
