package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 21.09.30
 * 1953. [모의 SW 역량테스트] 탈주범 검거
 * @author ChaerinYu
 * 0: 없음, 1: 상하좌우, 2: 상하, 3: 좌우, 4: 상우, 5: 하우, 6: 하좌, 7: 상좌
 * (5 ≤ N, M ≤ 50) (1 ≤ L ≤ 20)
 * 지하 터널 지도에는 반드시 1개 이상의 터널이 있음이 보장
 * 맨홀 뚜껑은 항상 터널이 있는 위치에 존재
 * 
 * 오늘의 교훈: 문제를 잘 읽자^^
 */
public class SWEA_1953_탈주범검거 {
	
	// 사방 - 상하좌우
	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	// 터널 구조물 타입
	static final int[][] tunnel = {{}, {0,1,2,3}, {0,1}, {2,3}, {0,3}, {1,3}, {1,2}, {0,2}};
	// 터널 구조물에 맞는 페어 터널 - 방향[0]에 따른 가능한 터널 구조물[1]
	static final int[][] pair = {{1,2,5,6},{1,2,4,7},{1,3,4,5},{1,3,6,7}};
	
	
	static int N, M, R, C, L; // 세로, 가로, 맨홀 뚜껑 위치(R, C), 탈출 후 소요시간
	static int[][] underground; // 지하
	
	static int res;
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	// main안에 선언 하는 거 보다 static으로 선언 시 시간 많이 먹는다.
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
//		br = new BufferedReader(new StringReader(src));
//		System.setIn(new FileInputStream("src/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 세로
			M = Integer.parseInt(st.nextToken()); // 가로
			R = Integer.parseInt(st.nextToken()); // 맨홀뚜껑위치 R
			C = Integer.parseInt(st.nextToken()); // 맨홀뚜껑위치 C
			L = Integer.parseInt(st.nextToken()); // 시간
			
			// 지하도 입력
			underground = new int[N][M];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					underground[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			res = 0;
			bfs(R, C, L-1); // 경과 0시간 -> 도달할 수 있는 지점 0이므로 L-1
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	
	/**
	 * @param sr 시작 좌표 
	 * @param sc 시작 좌표
	 * @param sl 남은 시간
	 */
	private static void bfs(int sr, int sc, int sl) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		
		queue.offer(new int[] {sr, sc, sl});
//		visited[sr][sc] = true; // 방문 안 한다.
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1], l = cur[2];
			
			visited[r][c] = true;
			
			// 터널 구조물 종류
			int kind = underground[r][c];
			// 터널 종류에 따라 연결가능한 방향이 다르다.
			
			for (int d = 0; d < tunnel[kind].length; d++) {
				int nr = r+delta[tunnel[kind][d]][0];
				int nc = c+delta[tunnel[kind][d]][1];
				
				// 범위 초과
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				
				if(!visited[nr][nc] && underground[nr][nc] != 0) {

					boolean flag = false;
					
					for (int i = 0; i < pair[tunnel[kind][d]].length; i++) {
						// nr, nc가 현재 터미널 타입의 페어 타입인지 체크 -> 하나라도 맞으면 연결 가능
						if(underground[nr][nc] == pair[tunnel[kind][d]][i]) {
							flag = true;
							break;
						}
					}
					
					if(flag && l-1 >= 0) {
						// 연결 가능함 -> 이동 가능 -> l-1
						queue.offer(new int[] {nr, nc, l-1});
						visited[nr][nc] = true;
					}
					
				}
			}
		}
		
		// 방문한 위치 카운트
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(visited[r][c]) res++;
			}
		}
	}

//	private static String src = "";
}
