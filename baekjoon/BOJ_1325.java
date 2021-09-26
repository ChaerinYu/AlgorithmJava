package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1325. 효율적인 해킹
 * @author Chaerin Yu
 * bfs 306548KB 10836ms
 */
public class BOJ_1325 {

	static int N, M; // N개의 컴퓨터, M개의 신뢰 관계
	static ArrayList<ArrayList<Integer>> reliable; // 신뢰관계
	
	static int hackCnt; // 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 횟수
	static ArrayList<Integer> computers; // 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터 번호
	
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // N개의 컴퓨터
		M = Integer.parseInt(st.nextToken()); // M개의 신뢰관계
		
		// 신뢰관계 입력
		reliable = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			reliable.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			reliable.get(to).add(from);
		}
		
		hackCnt = 0;
		computers = new ArrayList<Integer>();
		bfs();
		
//		sb.append(hackCnt).append("\n");
		for (Integer computer : computers) {
			sb.append(computer).append(" ");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue<Integer> queue; // = new LinkedList<Integer>();
		boolean[] visited; // = new boolean[N+1];

		for (int i = 1; i <= N; i++) {
			queue = new LinkedList<Integer>();
			visited = new boolean[N+1];
			
			queue.offer(i); // 시작
			visited[i] = true;
			
			int cnt = 0; // 해킹할 수 있는 수
			while(!queue.isEmpty()) {
				int current = queue.poll();
				// 신뢰관계있는지 체크
				for (Integer computer : reliable.get(current)) {
					if(!visited[computer]) {
						cnt++;
						visited[computer] = true;
						queue.offer(computer);
					}
				}
			}
			if(cnt>hackCnt) {
				hackCnt = cnt;
				computers.removeAll(computers);
				computers.add(i);
			} else if(cnt==hackCnt) {
				computers.add(i);
			}
		}
		
	}
}
