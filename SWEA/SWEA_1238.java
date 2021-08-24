package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * [D4] 1238. [S/W 문제해결 기본] 10일차 - Contact
 * @author user
 * Graph BFS 너비 우선 탐색
 * 연락망 크기가 최대 100 이므로, 인접행렬을 사용해도 된다.
 * 보통 이런 문제는 인접리스트를 사용하는걸 권장한다. (시간복잡도)
 */
public class SWEA_1238 {

	static final int SIZE = 100;
	static int maxN = 0, maxCnt = 0; // 최대 숫자, 연결망 깊이
	static int[][] network; // 연결망: 인접행렬 - 가중치 별도로 없어서 연결되면 1 아니면 0
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			
			String[] input = br.readLine().split(" ");
			
			int N = Integer.parseInt(input[0]); // 입력 받는 데이터 길이
			int start = Integer.parseInt(input[1]); // 시작점
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			network = new int[SIZE+1][SIZE+1];
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				network[from][to] = 1;
			}
			bfs(start);
			
			System.out.println("#"+tc+" "+maxN);
		}
	}
	
	private static void bfs(int start) {
		// 큐 생성하여, 시작 정점을 큐에 입력한다.
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[SIZE+1];
		
		queue.offer(start);
		visited[start] = true; // 방문한 정점 체크

		// 큐가 비어있지 않는 이상
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			int curLevelMax = 0; // 현재 level에서의 최대값
			while(queueSize-- > 0) {
				int curr = queue.poll();
				// level 깊이
				maxCnt++;
				curLevelMax = Math.max(curLevelMax, curr);
				
				for (int j = 0; j < SIZE+1; j++) {
					
					// 아직 방문 안한 정점이면서 연결(인접)되어 있는 경우
					if(!visited[j] && network[curr][j] == 1) {
						queue.offer(j); // 다음 방문을 queue에 넣기
						visited[j] = true; // 다음 방문 정점 check
					}
					
				}
			}
			// 해당 level의 최대 번호 저장
			maxN = curLevelMax;
		}
	}
	
}
