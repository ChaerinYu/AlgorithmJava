package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * 2458. 키 순서
 * 
 * @author ChaerinYu
 * SWEA 5643 동일 
 * 플로이드 와샬
 */
public class BOJ_2458 {

	static final int INF = 500 * 500;
	static int N, M; // 학생 수, 비교 횟수 (2 ≤ N ≤ 500) (0 ≤ M ≤ N*(N-1)/2)

	static int[][] compareList;

	static int res; // 정답

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 비교 횟수

		// 비교한 결과 리스트 초기화
		compareList = new int[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {

				if (r == c)
					continue;
				compareList[r][c] = INF;

			}
		}

		for (int i = 0; i < M; i++) {
			// 번호가 a인 학생이 번호가 b인 학생보다 키가 작은 것을 의미
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			compareList[a][b] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (k == i)
					continue;
				for (int j = 1; j <= N; j++) {
					if (i == j || k == j)
						continue;
					// i->j: k를 경유하면 알 수 있는 지 체크
					if (compareList[i][j] > compareList[i][k] + compareList[k][j]) {
						compareList[i][j] = compareList[i][k] + compareList[k][j];
					}
				}
			}
		}

		res = 0;
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			flag = false;
			for (int j = 1; j <= N; j++) {

				// 자기자신 pass
				if(i==j) continue;
				// 서로 비교 안 한 경우 (알 수 없는 경우)
				if (compareList[i][j] == INF && compareList[j][i] == INF) {
					flag = true;
					break;
				}

			}
			if (!flag)
				res++;
		}

		sb.append(res).append("\n");
		System.out.print(sb);
	}

	private static String src = "1\r\n" + "6\r\n" + "6\r\n" + "1 5\r\n" + "3 4\r\n" + "5 4\r\n" + "4 2\r\n" + "4 6\r\n"
			+ "5 2\r\n";
}
