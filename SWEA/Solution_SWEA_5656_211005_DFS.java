package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 완전탐색
 * 2021.10.5
 * 5656. [모의 SW 역량테스트] 벽돌 깨기
 * @author user
 * DFS
 * 중복순열 시간복잡도 최대 12^4
 */
public class Solution_SWEA_5656_211005_DFS {
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	static int N, W, H, min;
	
	static int res;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		StringTokenizer st = null;
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 구슬 쏘는 횟수
			W = Integer.parseInt(st.nextToken()); // 가로
			H = Integer.parseInt(st.nextToken()); // 세로
			
			int[][] map = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			go(0, map);
			System.out.println("#"+tc+" "+min);
		}
	}
	
	// 중복 순열로 구슬 던짐
	private static void go(int cnt, int[][] map) {
		
		// 구슬 다 던짐
		if(cnt==N) {
			// 남아있는 벽돌 수 카운트 최소값 갱신
			int result = getRemain(map);
			min = Math.min(result, min);
			
			return;
		}
		
		int[][] newMap = new int[H][W];
		for (int c = 0; c < W; c++) { // 0열부터 마지막 열까지 시도
			// c열에 구슬이 던져졌을 때 위에서 처음 만나는 벽돌 찾기
			int r = 0;
			while(r<H && map[r][c]==0) r++; // 마지막 행까지 벽돌 만날 때까지
			
			if(r==H) { // 해당 열에 깰 수 있는 벽돌이 없는 경우 (해당 열 모두 빈칸)
				go(cnt+1, map); // 다음 구슬 던지기
			} else { // 맞은 벽돌이 있는 경우
				
				// 이전 cnt까지의 map 상태를 복사해서 사용
				copy(map, newMap);
				
				// 맞은 벽돌 및 주변 벽돌 함께 제거 처리 (연쇄적 처리)
				boom(newMap, r, c, newMap[r][c]);
				
				// 제거된 벽돌들 내리기
				down1(newMap);
				
				// 다음 구슬 던지기
				go(cnt+1, newMap);
			}
		}
		
	}
	
	private static int getRemain(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j]>0) count++;
			}
		}
		return count;
	}


	/**
	 * arrayList 사용해서 부숴지지 않은 벽돌 이동하기
	 */
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static void down1(int[][] map) {
		for (int c = 0; c < W; c++) {
			int r;
			for (r = H-1; r >= 0; r--) {
				if(map[r][c]>0) {
					list.add(map[r][c]);
					map[r][c] = 0; // 벽돌이 있던 자리는 빈칸으로
				}
			} // 부서지지 않은 벽돌만 리스트에 담기
			
			// 리스트에 있는 벽돌 제일 아래 행부터 채우기
			r = H;
			for (int b : list) {
				map[--r][c] = b;
			}
			list.clear();
		}
	}

	private static void down(int[][] map) {
		// 아래 행부터 시작해서 빈칸을 찾는다.
		for (int c = 0; c < W; c++) {
			int r = H-1;
			while(r > 0) {
				if(map[r][c] == 0) { // 빈칸이면 벽돌 내리기
					int nr = r-1; // 자신의 직전 행부터 탐색
					while(nr>0 && map[nr][c]==0) {
						nr--;
					}
					
					map[r][c] = map[nr][c]; // 현재 빈칸에는 자신의 위쪽으로 처음 만나는  벽돌로 내리기
					map[nr][c] = 0; // 내린 벽돌 자리는 빈칸으로
				}
				--r; // 위로 올라가자
			}
		}
	}

	private static void boom(int[][] map, int r, int c, int cnt) { // cnt: r, c위치의 벽돌 숫자
		// DFS로 함께 부숴질 벽돌 처리
		map[r][c] = 0; // 현 위치의 벽돌 제거 처리
		if(cnt==1) return; // 현 위치의 벽돌 숫자가 1이면 주변 연쇄작용 없으므로 리턴
		
		for (int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			
			for (int k = 1; k < cnt; k++) {
				nr += dr[d];
				nc += dc[d];
				if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]!=0) {
					boom(map, nr, nc, map[nr][nc]); // boom 호출하는 부분과 동일하게 재귀 코드도 동일하게 진행한다.
					// 따라서 map[r][c] = 0;도 boom 재귀 호출 시 메소드 처음에서 수정해준다.
				}
			}
		}
		
	}

	/*
	 * map 복사
	 */
	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
}
