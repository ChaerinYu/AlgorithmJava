package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @since 2021. 9. 16.
 * @see
 * @perf 106,120 kb , 3,109 m
 *        96,944 kb     407 ms
 * @category #
 * @고려사항
 * @입력사항
 * @출력사항
 */

public class SWEA_D6_1263_사람네트워크 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T, N;
	static int[][] graph;
	static int INF = 987654321;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));

		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			graph = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					graph[r][c] = Integer.parseInt(tokens.nextToken());
					// 연결 불가하다면 무한대로 처리해주자.
					if (graph[r][c] == 0) {
						graph[r][c] = INF;
					}
				}
			}
			/*
			// 그래프 확인
			for(int [] row: graph) {
				System.out.println(Arrays.toString(row));
			}
			*/
			//int result = floyd();
			int result = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				result = Math.min(result, bfsSum(i));
			}

			output.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(output);
	}

	/**
	 * start에서 시작해서 모든 노드를 방문하는데 걸리는 시간? 단계?
	 * 
	 * @param start
	 * @return
	 */
	static int bfsSum(int start) {
		int sum = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		visited[start] = true;
		q.offer(start);

		int depth = 1;
		int found = 1;
		while (!q.isEmpty()) {
			// depth가 단계에 따라 증가되어야 하기 때문에
			int size = q.size();
			while (size-- > 0) {
				Integer head = q.poll();
				// 연결 지점 탐색
				for (int c = 0; c < N; c++) {
					// 연결되어있고.. 미방문이면.. 가보기..
					if (!visited[c] && graph[head][c] == 1) {
						visited[c] = true;
						q.offer(c);
						sum += depth;
						found++;
						if(found==N) {
							return sum;
						}
					}
				}
			}// size
			depth++;
		}

		return sum;
	}

	static int floyd() {
		// 경유지 k를 거쳐서 출발지 i에서 목적지 j로 가는 비용을 계산
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				// 출발점==경유지는 관심이 없다~~
				if (i == k) {
					continue;
				}
				for (int j = 0; j < N; j++) {
					// 경유지==목적지는 관심 없다~~
					if (k == j) {
						continue;
					}
					// 경유해서 가는 비용이 더 적다면 바꿔주자.!!!!
					if (graph[i][k] + graph[k][j] < graph[i][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		int minCC = Integer.MAX_VALUE;
		for (int r = 0; r < N; r++) {
			int sum = 0;
			for (int c = 0; c < N; c++) {
				if (r != c) {
					sum += graph[r][c];
				}
			}
			minCC = Math.min(sum, minCC);
		}
		return minCC;
	}

	// REMOVE_START
	private static String src = "2\r\n" +
			"5 0 1 1 0 0 1 0 1 1 1 1 1 0 0 0 0 1 0 0 0 0 1 0 0 0\r\n" +
			"5 0 0 1 1 0 0 0 1 0 0 1 1 0 0 1 1 0 0 0 1 0 0 1 1 0";
	// REMOVE_END
}
