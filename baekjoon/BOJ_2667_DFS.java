package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Study week 4
 * 2667. 단지번호 붙이기
 * @author ChaerinYu
 * DFS
 */
public class BOJ_2667_DFS {

	static final int[][] delta = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static int N; // 지도의 크기
	static int[][] map;
	
	static int totalTown;
	static int[] res ; // dfs
	
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src)); // 제출 시 주석 처리
		
		N = Integer.parseInt(br.readLine()); // 지도 크기
		
		// 지도 데이터 입력
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			String[] temp = br.readLine().split("");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(temp[c]);
			}
		}
		// 2. dfs
		boolean[][] visited = new boolean[N][N]; // 방문 체크
		res = new int[N*N]; // 각 단지내 집 수 - N*N/2 할 경우 런타임 에러 발생
		totalTown = 0; // 단지 수
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 0이 아니고 아직 방문 안 한 경우 (아직 라벨링 안 한 경우)
				if(map[r][c] != 0 && !visited[r][c]) {
					totalTown++; // 단지 수
					dfs(r, c, visited, totalTown);
				}
			}
		}
		sb.append(totalTown).append("\n");
		// 오름차순 정렬
		for (int i = 0; i < totalTown; i++) {
			for (int j = i+1; j < totalTown; j++) {
				if(res[i]>res[j]) {
					int temp = res[i];
					res[i] = res[j];
					res[j] = temp;
				}
			}
		}
		// 단지 수 만큼만 출력하기
		for (int i = 0; i < totalTown; i++) {
			sb.append(res[i]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	/**
	 * 
	 * @param sr 시작 Y좌표
	 * @param sc 시작 X좌표 
	 * @param visited 방문 체크
	 * @param number 단지 라벨링
	 */
	static void dfs(int sr, int sc, boolean[][] visited, int number) {
		res[number-1]++; // 단지 내 집 수 카운팅
		
		map[sr][sc] = number; // 단지 라벨링
		visited[sr][sc] = true; // 방문 체크
		
		int nr = 0, nc = 0;
		for (int i = 0; i < delta.length; i++) {
			nr = sr+delta[i][0];
			nc = sc+delta[i][1];
			// 범위 체크
			if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
			
			if(!visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc, visited, number);
			}
		}
	}
	
	
	private static String src = "7\r\n" + 
			"0110100\r\n" + 
			"0110101\r\n" + 
			"1110101\r\n" + 
			"0000111\r\n" + 
			"0100000\r\n" + 
			"0111110\r\n" + 
			"0111000";
}
