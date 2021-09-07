package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 17144. 미세먼지 안녕!
 * @author Chaerin Yu
 * 
 * 첫째 줄에 R, C, T (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000) 가 주어진다.
 * 둘째 줄부터 R개의 줄에 Ar,c (-1 ≤ Ar,c ≤ 1,000)가 주어진다. 
 * 공기청정기가 설치된 곳은 Ar,c가 -1이고, 나머지 값은 미세먼지의 양이다. 
 * -1은 2번 위아래로 붙어져 있고, 가장 윗 행, 아랫 행과 두 칸이상 떨어져 있다.
 * 
 * 첫째 줄에 T초가 지난 후 구사과 방에 남아있는 미세먼지의 양을 출력한다.
 */
public class BOJ_17144 {

	static int[][] map;
	static int[][] tempMap;
	
	static int R, C, T; // 행, 열, 초
	
	static int[] aircleaner = new int[2]; // 공기청정기 위치 (위 아래)
	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 행, 열, 초
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		tempMap = new int[R][C];
		
		// 구사과 방 미세먼지/공기청정기 입력하기
		int airIndex = 0;
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				// 공기청정기 위치 저장
				if(map[r][c] == -1) {
					aircleaner[airIndex] = r;
					airIndex++;
				}
			}
		}
		
		// T초 동안 반복
		for (int t = 0; t < T; t++) {
			clearTempMap();
			
			spreadDust();
			print();
			cleanAir(aircleaner[1],true);
			print();
			cleanAir(aircleaner[0],false);
			
			copyTempToReal();
		}
		
		System.out.println(getTotalDust());
	}
	
	/**
	 * 미세먼지 확산
	 */
	static void spreadDust() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// 미세먼지라면
				if(map[r][c] > 0) {
					
					int spreadCnt = 0; // 해당 칸에서의 확산 수
					for (int i = 0; i < 4; i++) {
						int nr = delta[i][0] + r;
						int nc = delta[i][1] + c;
						// 범위 벗어나거나 공기청정기라면 continue
						if(nr<0 || nc<0 || nr>=R || nc>=C || map[nr][nc] == -1) continue;
						
						spreadCnt++;
						tempMap[nr][nc] += map[r][c]/5; // 인접
					}
					// 자기자신
					tempMap[r][c] += map[r][c]-((map[r][c]/5)*spreadCnt);
					
				}
			}
		}
	}
	
	/**
	 * 공기청정기 작동
	 * 공기청정기 위: 반시계
	 * 공기청정기 아래: 시계
	 */
	static void cleanAir(int airR, boolean clock) {
		int temp = 0, turn = 1;
		if(clock) {
			
			while(true) {
				
				// 오른
				temp = tempMap[airR][C-1];
				for (int c = C-1; c > 2; c--) {
					tempMap[airR][c] = tempMap[airR][c-1];
				}
				// 아래
				tempMap[airR+1][C-1] = temp;
				temp = tempMap[R-1][C-1];
				for (int r = R-1; r > airR; r--) {
					tempMap[r][C-1] = tempMap[r-1][C-1];
				}
				// 왼
				tempMap[R-1][C-2] = temp;
				temp = tempMap[R-1][0];
				for (int c = 1; c < C-1; c++) {
					tempMap[airR][c] = tempMap[airR][c-1];
				}
				break;
			}
			
		}
		else {
			
		}
		
		
		/*
		// 시계방향 -> 아래에 있는 공기청정기
		if(clock) {

			// up ↑
			// 공기청정기 무시하고 시작
//			tempMap[airR][C-1] = map[airR][C-2];
			for (int r = R-2; r > airR; r--) {
				tempMap[r][0] = tempMap[r+1][0];
			}
//			tempMap[R-1][0] = tempMap[R-1][1];
			
			// left ←
//			tempMap[airR][C-1] = map[airR-1][C-1];
			for (int c = C-1; c > 1; c--) {
				tempMap[airR][c] = tempMap[airR][c-1];
			}
			tempMap[airR][1] = 0; // 공기청정기 지나서 옴
			
			// down ↓
//			tempMap[airR][C-1] = map[airR][C-2];
			for (int r = airR+2; r < R; r++) {
				tempMap[r][C-1] = tempMap[r-1][C-1];
			}
			
			// right →
//			tempMap[airR][0] = map[airR+1][0];
			for (int c = 2; c < C; c++) {
				tempMap[R-1][c] = tempMap[R-1][c-1];
			}
			
			
		}
		// 반시계방향 -> 위에 있는 공기청정기
		else {
			
			// down ↓
			for (int r = 1; r < airR; r++) {
				tempMap[r][0] = tempMap[r-1][0];
			}
			
			// left ←
			for (int c = C-2; c >= 0; c--) {
				tempMap[0][c] = tempMap[0][c+1];
			}
			
			// up ↑
			for (int r = R-2; r > 0; r--) {
				tempMap[r][C-1] = tempMap[r+1][C-1];
			}
			
			// right → 공기청정기 무시하고 시작
			for (int c = 2; c < C; c++) {
				tempMap[airR][c] = tempMap[airR][c-1];
			}
		}
		*/
	}
	
	static void print() {
		System.out.println("tempMap");
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(tempMap[r][c]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 미세먼지양 구하기
	 */
	static int getTotalDust() {
		int result = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				result += map[r][c];
			}
		}
		return result;
	}
	
	/**
	 * tempMap -> map으로 복사하기
	 */
	static void copyTempToReal() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] = tempMap[r][c];
			}
		}
	}
	/**
	 * tempMap 초기화
	 */
	static void clearTempMap() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				tempMap[r][c] = 0;
			}
		}
		// 공기청정기 위치
		for (int i = 0; i < aircleaner.length; i++) {
			tempMap[aircleaner[i]][0] = -1;
		}
	}
}
