package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;
/**
 * 17144. 미세먼지 안녕!
 * @author ChaerinYu
 * 둘째 줄부터 R개의 줄에 Ar,c (-1 ≤ Ar,c ≤ 1,000)가 주어진다. 공기청정기가 설치된 곳은 Ar,c가 -1이고, 나머지 값은 미세먼지의 양이다.
 * 26676KB 316ms
 */
public class BOJ_17144_210924 {

	static final int[][] delta = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	
	static int R, C, T; // 세로, 가로, 시간 (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000)
	static int[][] map;
	static int[] purifier; // 공기청정기 위치 - 항상 1열에 존재하므로 1차원 배열 사용
	
	static int res;
	
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 세로
		C = Integer.parseInt(st.nextToken()); // 가로
		T = Integer.parseInt(st.nextToken()); // 시간
		
		map = new int[R][C]; // 방 정보
		int idx = 0;
		purifier = new int[2]; // 공기청정기 위치 (r)
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1) purifier[idx++] = r; // 공기청정기 위치 저장
			}
		}
		
		// 입력 끝
		int[][] copyMap;
		for (int i = 0; i < T; i++) {
			copyMap = copy();
			spread(copyMap); // 미세먼지 확산
//			System.out.println("미세먼지확산 후");
//			print();
			// 공기청정기
			on(false); // 반시계방향 순환
//			System.out.println("반시계 후");
//			print();
			on(true); // 시계방향 순환
//			System.out.println("시계 후");
//			print();
		}
		
		getDustSum();
		
		sb.append(res).append("\n");
		System.out.println(sb);
	}
	
	static void print() {

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
	}
	/**
	 * 공기청정기 작동
	 * @param flag: 반시계(위)/시계(아래)
	 */
	private static void on(boolean flag) {
		// 반시계
		if(!flag) {
			int idx = purifier[0];
			// 1열 (0열)
			for (int r = idx-1; r > 0; r--) {
				map[r][0] = map[r-1][0];
			}
			// 0행
			for (int c = 0; c < C-1; c++) {
				map[0][c] = map[0][c+1];
			}
			// C열(C-1)
			for (int r = 0; r < idx; r++) {
				map[r][C-1] = map[r+1][C-1];
			}
			// idx행
			for (int c = C-1; c > 1; c--) {
				map[idx][c] = map[idx][c-1];
			}
			map[idx][1] = 0; // 공기청정기 지나서 옴
		}
		// 시계
		else {
			int idx = purifier[1];
			// 1열 (0열)
			for (int r = idx+1; r < R-1; r++) {
				map[r][0] = map[r+1][0];
			}
			// R-1행
			for (int c = 0; c < C-1; c++) {
				map[R-1][c] = map[R-1][c+1];
			}
			// C열(C-1)
			for (int r = R-1; r > idx; r--) {
				map[r][C-1] = map[r-1][C-1];
			}
			// idx행
			for (int c = C-1; c > 1; c--) {
				map[idx][c] = map[idx][c-1];
			}
			map[idx][1] = 0; // 공기청정기 지나서 옴
		}
	}

	/**
	 * 미세먼지 확산
	 * @param copyMap: map 사본
	 */
	private static void spread(int[][] copyMap) {
		int nr, nc;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				
				if(copyMap[r][c] < 1) continue; // 미세먼지 없는 경우 continue
				
				// 있으면 사방탐색하여 미세먼지 확산
				int spreadCnt=0;
				for (int i = 0; i < 4; i++) {
					nr = r+delta[i][0];
					nc = c+delta[i][1];
					
					// 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
					if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
					if(map[nr][nc] == -1) continue;
					
					map[nr][nc] += copyMap[r][c]/5; // 확산되는 양은 Ar,c/5이고 소수점은 버린다.
					spreadCnt++; // 확산된 방향의 개수
				}
				map[r][c] -= copyMap[r][c]/5*spreadCnt; // (r, c)에 남은 미세먼지의 양
			}
		}
	}

	/**
	 * map 복사 (map 사본)
	 * @return copyMap
	 */
	private static int[][] copy() {
		int[][] copyMap = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				copyMap[r][c] = map[r][c];
			}
		}
		return copyMap;
	}


	/**
	 * 미세먼지 합산
	 */
	private static void getDustSum() {
		res = 0; // 미세먼지 양
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c]<0) continue; // 공기청정기 제외
				res += map[r][c];
			}
		}
	}

	private static String src = "7 8 50\r\n" + 
			"0 0 0 0 0 0 0 9\r\n" + 
			"0 0 0 0 3 0 0 8\r\n" + 
			"-1 0 5 0 0 0 22 0\r\n" + 
			"-1 8 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 10 43 0\r\n" + 
			"0 0 5 0 15 0 0 0\r\n" + 
			"0 0 40 0 0 0 20 0";
}
