package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 4013. [모의 SW 역량테스트] 특이한 자석
 * @author ChaerinYu
 * 각 자석별 빨간색 화살표 위치 날 N일 때, S일 때 점수
 * 
 * 1번 자석 N: 0, S: 1
 * 2번 자석 N: 0, S: 2
 * 3번 자석 N: 0, S: 4
 * 4번 자석 N: 0, S: 8
 * 
 */
public class SWEA_4013_2 {

	static final int R = 4, C = 8; 	// 세로, 가로

	static int K; 					// 자석 회전시키는 횟수, K 는 1 이상 20 이하의 정수이다. ( 1 ≤ K ≤ 20 )
	static int[][] magnet; 			// 자석 정보
	static int[][] rotate; 			// 자석 회전 정보
	
	static boolean[] completed;     // 회전 완료 확인
	static int res;
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	public static void main(String[] args) throws Exception {
//		br = new BufferedReader(new StringReader(src));
		System.setIn(new FileInputStream("src/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			K = Integer.parseInt(br.readLine()); // 자석 회전시키는 수
			
			magnet = new int[R][C];
			// 1 번 자석부터 4 번 자석까지 각각 8 개 날의 자성정보
			// 날의 자성은 N 극이 0 으로, S 극이 1 로 주어진다.
			// 빨간색 화살표 위치의 날부터 시계방향 순서대로 주어진다.
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					magnet[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 자석의 회전 정보
			rotate = new int[K][2];
			for (int k = 0; k < K; k++) {
				// 회전시키려는 자석의 번호, 회전방향
				st = new StringTokenizer(br.readLine());
				rotate[k][0] = Integer.parseInt(st.nextToken())-1; // 자석번호, 인덱스 0부터 시작하니까 -1
				rotate[k][1] = Integer.parseInt(st.nextToken());   // 회전방향
				
				completed = new boolean[R]; // 회전 할 때마다 회전 확인 reset
				run(rotate[k][0], rotate[k][1], completed);
			}

			res = 0;
			getScores();
//			run();

			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	// 자석 회전 정보대로 자석 돌리기
	private static void run(int magnetNo, int dir, boolean[] completed) {
		// 회전 완료
		completed[magnetNo] = true;

		// 회전 시키려는 자석의 왼쪽 돌리기
		rotateNeighbor(true, magnetNo, dir, completed);
		// 회전 시키려는 자석의 오른쪽 돌리기
		rotateNeighbor(false, magnetNo, dir, completed);
		
		// 자석 돌리기
		rotateMagnet(magnetNo, dir);
		
	}

	/**
	 * 총 점
	 */
	private static void getScores() {
		for (int i = 0; i < R; i++) {
			if(magnet[i][0]==1) {
				res += (1<<i);
			}
		}
	}

	/**
	 * 
	 * @param magnetNo: 마그넷
	 * @param dir: 회전 방향
	 * @param count: 회전 수
	 */
	private static void rotateNeighbor(boolean leftRotate, int magnetNo, int dir, boolean[] completed) {

		// 회전 시키려는 자석의 왼쪽 돌리기
		if(leftRotate) {
			if(magnetNo-1<0) return;
			if(!completed[magnetNo-1] && magnet[magnetNo][6] != magnet[magnetNo-1][2]) {
				run(magnetNo-1, dir*(-1), completed);
			}
		}
		// 회전 시키려는 자석의 오른쪽 돌리기
		else {
			if(magnetNo+1>=R) return;
			if(!completed[magnetNo+1] && magnet[magnetNo][2] != magnet[magnetNo+1][6]) {
				run(magnetNo+1, dir*(-1), completed);
			}
		}
	}

	/**
	 * 자석 돌리기
	 * @param magnetNo: 자석 번호
	 * @param dir: 회전 방향, 1: 시계, -1: 반시계
	 */
	private static void rotateMagnet(int magnetNo, int dir) {
		// 반시계
		if(dir!=1) {
			int temp = magnet[magnetNo][0]; // 자석 저장
			for (int i = 1; i < C; i++) {
				magnet[magnetNo][i-1] = magnet[magnetNo][i];
			}
			magnet[magnetNo][C-1] = temp;
		}
		// 시계
		else {
			int temp = magnet[magnetNo][C-1]; // 자석 저장
			for (int i = C-2; i >= 0; i--) {
				magnet[magnetNo][i+1] = magnet[magnetNo][i];
			}
			magnet[magnetNo][0] = temp;
		}
	}
	
	
}
