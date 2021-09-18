package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * Study week 2
 * TODO!!!!!!!!
 * 14391. 종이 조각
 * @author ChaerinYu
 * 참고 - 풀이 방법 2가지
 * https://coder-in-war.tistory.com/entry/BOJ-JAVA14391-%EC%A2%85%EC%9D%B4-%EC%A1%B0%EA%B0%81
 */
public class BOJ_14391 {

	static final int[][] delta = {{1, 0}, {0, 1}};
	static int N, M; // 세로, 가로  (1 ≤ N, M ≤ 4)
	static int[][] paper; // 종이
	
	static boolean[][] visited;
	
	static int res; // 정답
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		// 종이 조각 입력
		paper = new int[N][M];
		for (int r = 0; r < N; r++) {
			char[] charArr = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				paper[r][c] = charArr[c]-'0';
			}
		}
		
		visited = new boolean[N][M];
		res = 0;
		dfs(0);
		
		System.out.println(res);
	}
	
	static void dfs(int idx) {
		if(idx == N*M) {
			int sum = 0, temp = 0;
			// 가로로 자르기
			for (int r = 0; r < N; r++) {
				temp = 0;
				for (int c = 0; c < M; c++) {
					// 잘림 (하나의 집합)
					if(visited[r][c]) {
						temp = temp*10 + paper[r][c];
					} else {
						// 새로운 종이조각 시작 필요 
						sum += temp;
						temp = 0;
					}
				}
				sum += temp;
			}
			// 가로로 안자르고 남은 종이들 세로로 자르기
			for (int c = 0; c < M; c++) {
				temp = 0;
				for (int r = 0; r < N; r++) {
					// 안잘림
					if(!visited[r][c]) {
						temp = temp*10 + paper[r][c];
					} else {
						sum += temp;
						temp = 0;
					}
				}
				sum += temp;
			}
			res = Math.max(res, sum);
			return;
		}
		
		int r = idx/N;
		int c = idx%M;
		
		visited[r][c] = true; // 가로 자르기
		dfs(idx+1);
		visited[r][c] = false; // 세로 자르기
		dfs(idx+1);
	}
	
	private static String src = "4 3\r\n" + 
			"001\r\n" + 
			"010\r\n" + 
			"111\r\n" + 
			"100";
}
