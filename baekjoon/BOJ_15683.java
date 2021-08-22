package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/** 
 * 15683. 감시
 * @author user
 * 1번 CCTV는 한 쪽 방향만 감시할 수 있다. 
 * 2번과 3번은 두 방향을 감시할 수 있는데, 2번은 감시하는 방향이 서로 반대방향이어야 하고, 3번은 직각 방향이어야 한다. 
 * 4번은 세 방향, 5번은 네 방향을 감시할 수 있다.
 * 
 * CCTV는 회전시킬 수 있는데, 회전은 항상 90도 방향으로 해야 하며, 감시하려고 하는 방향이 가로 또는 세로 방향이어야 한다.
 * 지도에서 0은 빈 칸, 6은 벽, 1~5는 CCTV의 번호이다. 방향에 따라 감시할 수 있는 영역을 '#' => 나는 이 문제에서 9로 할 거
 * CCTV의 방향을 적절히 정해서, 사각 지대의 최소 크기를 구하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 사무실의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 8)
 * 둘째 줄부터 N개의 줄에는 사무실 각 칸의 정보가 주어진다. 0은 빈 칸, 6은 벽, 1~5는 CCTV를 나타내고, 문제에서 설명한 CCTV의 종류이다. 
 * CCTV의 최대 개수는 8개를 넘지 않는다.
 */
public class BOJ_15683 {

	// cctv 좌표, cctv 번호
	static class CCTV {
		int y;
		int x;
		int cctvNo;
		
		public CCTV(int y, int x, int cctvNo) {
			super();
			this.y = y;
			this.x = x;
			this.cctvNo = cctvNo;
		}
		
	}
	
	static ArrayList<CCTV> cctvList = new ArrayList<CCTV>();
	static int R, C; // 행렬
//	static int[][] office; // 사무실^^
	static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 // delta 조합해서 CCTV 방향을 조작한다.
	static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 입력
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[][] office = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				office[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// office마다 CCTV위치 확보해서 해당 위치의 CCTV 감시 방향마다 사각지대 개수 COUNT
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// 빈 칸 또는 벽이 아니면 사각지대 최소값 찾으러 go
				if(office[r][c] != 0 && office[r][c] != 6) {
					cctvList.add(new CCTV(r, c, office[r][c]));
				}
			}
		}
		answer = Integer.MAX_VALUE;
		go(office, 0);
		
		System.out.println(answer);
	}
	static void print(int[][] t) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(t[r][c]+ " ");
			}
			System.out.println();
		}
	}
	/**
	 * 
	 * @param office: 현재 사각지대 체크된 사무실 map
	 * @param count: cctv 세기
	 * @return 사각지대 체크된 office map
	 */

	static void go(int[][] office, int count) {
		
		if(count == cctvList.size()) {
			print(office);
			System.out.println();
			answer = Math.min(answer, findBlindNum(office));
			return;
		}
		
		CCTV curCCTV = cctvList.get(count);
		
		int[][] tempMap = new int[R][C];
		
		if(curCCTV.cctvNo == 1) {
			// CCTV 1번의 경우 4방으로 회전 다 해봐야 한다.
			for (int i = 0; i < 4; i++) {
				tempMap = new int[R][C];
				// 사무실 map을 복사해온다.
				tempMap = copyOfficeMap(tempMap, office);
				
				// delta 경우의 수 1가지
				tempMap = checkCCTVpath(tempMap, curCCTV.y, curCCTV.x, i);
				go(tempMap, count+1);
			}
		}
		else if(curCCTV.cctvNo == 2) {
			// delta 경우의 수 2가지 (0, 1), (2, 3)
			// CCTV 2번의 경우 좌우 상하
			for (int i = 0; i < 2; i++) {
				tempMap = new int[R][C];
				// 사무실 map을 복사해온다.
				tempMap = copyOfficeMap(tempMap, office);
				
				// 상, 우
				tempMap = checkCCTVpath(tempMap, curCCTV.y, curCCTV.x, i*2);
				tempMap = checkCCTVpath(tempMap, curCCTV.y, curCCTV.x, i*2+1);
				
				go(tempMap, count+1);
			}
		}
		else if(curCCTV.cctvNo == 3) {
			// CCTV 3번의 경우 90도
			// delta 경우의 수 4가지 (0, 2), (0, 3), (1, 2), (1, 3)
			for (int i = 0; i < 4; i++) {
				tempMap = new int[R][C];

				// 사무실 map을 복사해온다.
				tempMap = copyOfficeMap(tempMap, office);
				
				tempMap = checkCCTVpath(tempMap, curCCTV.y, curCCTV.x, i/2);
				tempMap = checkCCTVpath(tempMap, curCCTV.y, curCCTV.x, (i%2)+2);
				
				go(tempMap, count+1);
			}
		}
		else if(curCCTV.cctvNo == 4) {

			// CCTV 4번의 경우 ㅗ
			// delta 경우의 수 4가지 (0, 1, 2), (0, 1, 3), (0, 2, 3), (1, 2, 3)
			for (int i = 0; i < 4; i++) {
				tempMap = new int[R][C];

				// 사무실 map을 복사해온다.
				tempMap = copyOfficeMap(tempMap, office);
				
				tempMap = checkCCTVpath(tempMap, curCCTV.y, curCCTV.x, i%4);
				tempMap = checkCCTVpath(tempMap, curCCTV.y, curCCTV.x, (i+1)%4);
				tempMap = checkCCTVpath(tempMap, curCCTV.y, curCCTV.x, (i+2)%4);

				go(tempMap, count+1);
			}
		}
		else if(curCCTV.cctvNo == 5) {
			tempMap = new int[R][C];

			// CCTV 5번의 경우 + delta 경우의 수 1
			// 사무실 map을 복사해온다.
			tempMap = copyOfficeMap(tempMap, office);
			
			tempMap = checkCCTVpath(tempMap, curCCTV.y, curCCTV.x, 0);
			tempMap = checkCCTVpath(tempMap, curCCTV.y, curCCTV.x, 1);
			tempMap = checkCCTVpath(tempMap, curCCTV.y, curCCTV.x, 2);
			tempMap = checkCCTVpath(tempMap, curCCTV.y, curCCTV.x, 3);

			go(tempMap, count+1);
		}

	}
	
	/**
	 * CCTV 경로(9) 체크
	 * @param tempMap
	 * @param cr
	 * @param cc
	 * @param idx
	 * @return
	 */
	static int[][] checkCCTVpath(int[][] tempMap, int cr, int cc, int idx) {

		int nr = cr, nc = cc;
		
		while(true) {
			nr += delta[idx][0];
			nc += delta[idx][1];
			
			if(nr>=R || nr<0 || nc>=C || nc<0 || tempMap[nr][nc]==6) break; // office 크기 벗어나면 끝
			
			if(tempMap[nr][nc] == 0) tempMap[nr][nc] = 9; // cctv 감시 영역을 9라고 한다.
		}
		
		return tempMap;
	}
	
	/**
	 * 
	 * @param temp office map
	 * @return 사각지대 수
	 */
	static int findBlindNum(int[][] temp) {
		int cnt = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// 0인 곳은 cctv 감시에 벗어나는 곳
				if(temp[r][c] == 0) cnt++;
			}
		}
		return cnt;
	}

	/**
	 * office map 복사
	 * @param temp copy map
	 * @param office original office
	 * @return copy office map
	 */
	static int[][] copyOfficeMap(int[][] temp, int[][] office) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				temp[r][c] = office[r][c];
			}
		}
		return temp;
	}
}
