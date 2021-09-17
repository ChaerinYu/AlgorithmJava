package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 14502. 연구소
 * @author ChaerinYu
 * 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.
 * 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
 */
public class BOJ_14502 {
	
	static int N, M; // 세로, 가로
	static int[][] lab; // 연구소
	static int[][] copyLab; // 연구소
	static ArrayList<int[]> virus; // 바이러스 위치 저장
	static ArrayList<int[]> empty; // 빈 공간 저장
	static ArrayList<int[]> virtualWall; // 벽
	static int res; // 정답
	
	static final int[][] delta = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		// 연구소 입력
		lab = new int[N][M];
		virus = new ArrayList<int[]>();
		empty = new ArrayList<int[]>();
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				lab[r][c] = Integer.parseInt(st.nextToken());
				// 바이러스 위치 저장
				if(lab[r][c] == 2) {
					virus.add(new int[] {r, c});
				}
				// 빈 공간 저장
				else if(lab[r][c] == 0) {
					empty.add(new int[] {r, c});
				}
			}
		}
		
		// 빈 공간으로 조합만들기
		res = Integer.MIN_VALUE;
		comb(0, 0);
		/*
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				// 빈 공간에 벽 세워보기
				if(lab[r][c] == 0) {
					lab[r][c] = 1;
					// 바이러스 위치마다 
					for (int[] virusCoord : virus) {
						int virusR = virusCoord[0];
						int virusC = virusCoord[1];
						copyLabMap();
						bfs(virusR, virusC);
						res = Integer.max(res, countEmpty());
//						System.out.println();
//						print();
					}
					lab[r][c] = 0; // 원복
				}
				
			}
		}
		*/
		System.out.println(res);
	}
	
	static void bfs(int virusR, int virusC) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		
		q.offer(new int[] {virusR, virusC});
		visited[virusR][virusC] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = delta[i][0]+curr[0];
				int nc = delta[i][1]+curr[1];
				// 범위 체크
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				// 방문 체크, 빈 공간 체크
				if(!visited[nr][nc] && copyLab[nr][nc] == 0) {
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
					copyLab[nr][nc] = 2; // 바이러스 확산
				}
			}
		}
	}
	
	/**
	 * combination 3개
	 */
	static void comb(int start, int cnt) {
		// 무조건 벽 3 개 설치
		if(cnt == 3) {
			copyLabMap(); // map 복사
			
			// 바이러스 확산
			for (int[] virusCoord : virus) {
				int virusR = virusCoord[0];
				int virusC = virusCoord[1];
				bfs(virusR, virusC);
			}
			
			// 빈 공간 최대값 구하기
			res = Math.max(res, countEmpty());
			return;
		}
		
		// for문 1번 쓰는 게 훨씬 빠르다. 156836KB 380ms
		for (int i = start; i < N*M; i++) {
			int r = i/M;
			int c = i%M;
			if(lab[r][c]==0) {
				lab[r][c] ^= 1; //XOR
				comb(i+1, cnt+1);
				lab[r][c] ^= 1;
			}
		}
		/*
		// 외부 for문 1번 당 내부 for문의 초기화와 종료 조건을 계속 테스트
		// 296616kb 972ms
		for (int r = start; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(lab[r][c] == 0) {
					lab[r][c] = 1;
					comb(cnt+1);
					lab[r][c] = 0;
				}
			}
		}
		*/
	}
	
	/**
	 * lab -> copyLab 복사
	 */
	static void copyLabMap() {
		copyLab = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				copyLab[r][c] = lab[r][c];
			}
		}
	}
	
	/**
	 * 
	 * @return 빈공간 return
	 */
	static int countEmpty() {
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(copyLab[r][c] == 0) cnt++;
			}
		}
		return cnt;
	}
	/**
	 * 
	 */
	static void print() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.printf(copyLab[r][c]+" ");
			}
			System.out.println();
		}
	}
	
	
	private static String src = "7 7\r\n" + 
			"2 0 0 0 1 1 0\r\n" + 
			"0 0 1 0 1 2 0\r\n" + 
			"0 1 1 0 1 0 0\r\n" + 
			"0 1 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 1 1\r\n" + 
			"0 1 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0 0";
}
