package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2636. 치즈
 * 
 * @author ChaerinYu
 */
public class BOJ_2636 {

	static int R, C; // 가로, 세로
	static int[][] map; // 판

	static int remainCheese, cnt; // 남아있는 치즈, 현재 치즈 개수 카운팅
	static int time; // 치즈 사라지는 시간
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } }; // 4방 탐색

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src)); // 제출할 때 주석처리
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken()); // 세로
		C = Integer.parseInt(st.nextToken()); // 가로

		map = new int[R][C];
		cnt = 0;
		// 사각형모양 판 입력
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				// 치즈 개수 카운팅
				if (map[r][c] == 1)
					cnt++;
			}
		}

		while (cnt != 0) {
			time++; // 시간 +1
			remainCheese = cnt; // 현재 남아있느 치즈 update
			bfs(0, 0); // 치즈가 없는 곳으로 탐색
		}
		System.out.println(time);
		System.out.println(remainCheese);
	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[R][C];

		visited[r][c] = true;
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] current = q.poll();

			int nr, nc;
			for (int i = 0; i < delta.length; i++) {
				nr = current[0] + delta[i][0];
				nc = current[1] + delta[i][1];
				// 범위 체크
				if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc])
					continue;
				// 공기 주변이 cheese인 경우 녹아서 사라질 치즈
				if (map[nr][nc] == 1) {
					map[nr][nc] = 0;
					cnt--;
				} else {
					q.offer(new int[] { nr, nc });
				}
				visited[nr][nc] = true;
			}

		}

	}

	private static String src = "13 12\r\n" + "0 0 0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0 0 1 1 0 0 0\r\n" + "0 1 1 1 0 0 0 1 1 0 0 0\r\n" + "0 1 1 1 1 1 1 0 0 0 0 0\r\n"
			+ "0 1 1 1 1 1 0 1 1 0 0 0\r\n" + "0 1 1 1 1 0 0 1 1 0 0 0\r\n" + "0 0 1 1 0 0 0 1 1 0 0 0\r\n"
			+ "0 0 1 1 1 1 1 1 1 0 0 0\r\n" + "0 0 1 1 1 1 1 1 1 0 0 0\r\n" + "0 0 1 1 1 1 1 1 1 0 0 0\r\n"
			+ "0 0 1 1 1 1 1 1 1 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0 0 0";
}
