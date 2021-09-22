package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Study week 4
 * 2667. 단지번호 붙이기
 * @author ChaerinYu
 * BFS
 */
public class BOJ_2667 {

	static final int[][] delta = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static int N; // 지도의 크기
	static int[][] map;
	
	static int totalTown;
	static ArrayList<Integer> res ; // bfs
	
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
		
		// 1. bfs
		boolean[][] visited = new boolean[N][N]; // 방문 체크
		res = new ArrayList<Integer>(); // 단지내 집 수
		totalTown = 0; // 단지 수
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 0이 아니고 아직 방문 안 한 경우 (아직 라벨링 안 한 경우)
				if(map[r][c] != 0 && !visited[r][c]) {
					totalTown++;
					res.add(bfs(r, c, visited));
				}
			}
		}
		
		sb.append(totalTown).append("\n");
		Collections.sort(res); // 오름차순 정렬
		for (int num : res) {
			sb.append(num).append("\n");
		}
		System.out.println(sb);
		
	}
	
	/**
	 * BFS
	 * @param sr 시작 y좌표
	 * @param sc 시작 x좌표
	 * @param visited 방문여부 체크
	 */
	static int bfs(int sr, int sc, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		// 시작 좌표 저장
		queue.offer(new int[] {sr, sc});
		visited[sr][sc] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			int nr = current[0], nc = current[1];
			for (int i = 0; i < delta.length; i++) {
				nr = current[0]+delta[i][0];
				nc = current[1]+delta[i][1];
				// 범위 체크
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				// 아직 방문 안 했고 집이 있는 경우
				if(!visited[nr][nc] && map[nr][nc] != 0) {
					queue.offer(new int [] {nr, nc});
					visited[nr][nc] = true;
				}
			}
			cnt++; // 단지 내 집 수 카운팅
		}
		return cnt;
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
