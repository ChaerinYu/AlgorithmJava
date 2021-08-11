package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * [D3] 4615. 재미있는 오셀로 게임
 * 보드는 4x4, 6x6, 8x8(가로, 세로 길이) 크기를 사용한다. 처음 플레이는 정가운데 2개씩 배치하고 시작한다.
 * XXXX
 * XWBX
 * XBWX
 * XXXX
 * (B : 흑돌, W : 백돌). 그리고 흑, 백이 번갈아가며 돌을 놓는다.
 * 단, 자신이 놓을 돌과 자신의 돌 사이에 상대편의 돌이 있을 경우에만 그 곳에 돌을 놓을 수 있고, 그 때의 상대편의 돌은 자신의 돌로 만들 수 있다.
 * (여기에서 "사이"란 가로/세로/대각선을 의미한다.)
 * 
	첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
	각 테스트 케이스의 첫 번째 줄에는 보드의 한 변의 길이 N과 플레이어가 돌을 놓는 횟수 M이 주어진다. N은 4, 6, 8 중 하나이다.
	그 다음 M줄에는 돌을 놓을 위치와 돌의 색이 주어진다.
	돌의 색이 1이면 흑돌, 2이면 백돌이다.
	만약 3 2 1이 입력된다면 (3, 2) 위치에 흑돌을 놓는 것을 의미한다.
	돌을 놓을 수 없는 곳은 입력으로 주어지지 않는다.

	각 테스트 케이스마다 게임이 끝난 후 보드 위의 흑돌, 백돌의 개수를 출력한다.
	흑돌이 30개, 백돌이 34인 경우 30 34를 출력한다.
 */
public class SWEA_4615 {

	private static int N; // 보드 한 변 길이 (4, 6, 8)
	private static int M; // 플레이어가 돌을 놓는 횟수
	private static int[][] map;
	
	// 8방 탐색
	private static int[] dr = {-2, -2, -2,  0, 0,  2, 2, 2};
	private static int[] dc = {-2,  0,  2, -2, 2, -2, 0, 2};
	// 8방 사이 값
	private static int[] br = {-1, -1, -1,  0, 0,  1, 1, 1};
	private static int[] bc = {-1,  0,  1, -1, 1, -1, 0, 1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine()); // TEST CASE

		StringTokenizer st = null;
		for(int test_case=1; test_case<=T; test_case++) {
			st = new StringTokenizer(reader.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N+1][N+1];
			// 처음 플레이는 정가운데 2개씩 배치하고 시작한다.
			map[N/2][N/2+1] = 1;
			map[N/2+1][N/2] = 1;
			map[N/2][N/2] = 2;
			map[N/2+1][N/2+1] = 2;
			
			int pr, pc, ps, es;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(reader.readLine(), " ");
				
				pr = Integer.parseInt(st.nextToken()); // 좌표 row 
				pc = Integer.parseInt(st.nextToken()); // 좌표 column
				ps = Integer.parseInt(st.nextToken()); // 돌(색상)
				
				// es: 적의 돌 색상
				if(ps == 1) es = 2;
				else es = 1; 
				
				int nr, nc; // 건너편 돌 위치
				int tr, tc; // 사이에 있는 위치 - 놓여진 돌 색상 확인
				map[pr][pc] = ps; // 내가 지금 턴에 두는 위치
				for (int d = 0; d < dr.length; d++) {
					int tempt = 2; // 건너편부터 시작한다.
					boolean done = false;
					while(true) {
						nr = pr+br[d]*tempt;
						nc = pc+bc[d]*tempt;
						
						if(nr<1 || nr>N || nc<1 || nc>N || map[nr][nc] == 0) {
							break;
						}
						
						// 건너편이 나와 같으면 멈춘다.
						int temptt = tempt-1;
						if(map[nr][nc] == ps) {
							int nnr=0, nnc=0;
							boolean checked = false;
							while(temptt!=0 || (nnr==pr && nnc==pc)) {
								nnr = pr+br[d]*temptt;
								nnc = pc+bc[d]*temptt;
								if(map[nnr][nnc] == 0) {
									checked = true;
									break;
								}
//								map[nnr][nnc] = ps; // 사이 값들은 다 내가 두는 돌 색상과 동일하게 변경한다.
								temptt--;
//								nnr = pr+br[d]*temptt;
//								nnc = pc+bc[d]*temptt;
							}
							
							if(!checked) {
								temptt = tempt-1;
								while(temptt!=0 || (nnr==pr && nnc==pc)) {
									nnr = pr+br[d]*temptt;
									nnc = pc+bc[d]*temptt;
									map[nnr][nnc] = ps; // 사이 값들은 다 내가 두는 돌 색상과 동일하게 변경한다.
									temptt--;
								}
							}
//							map[nnr][nnc] = ps; // 사이 값들은 다 내가 두는 돌 색상과 동일하게 변경한다.
							// 여기까지 진행했으면 이미 돌을 둔 경우 이므로
							// while문 나가면 for문도 나가게 해준다.
//							done = true;
//							break;
						}
						
//						if(map[nr][nc] == ps) {
//							int nnr = pr+br[d]*(tempt-1);
//							int nnc = pc+bc[d]*(tempt-1);
//							
//							map[nnr][nnc] = ps; // 사이 값들은 다 내가 두는 돌 색상과 동일하게 변경한다.
//							// 여기까지 진행했으면 이미 돌을 둔 경우 이므로
//							// while문 나가면 for문도 나가게 해준다.
////							done = true;
////							break;
//						}
						
						tempt++;
					}
//					if(done) {
//						break;
//					}
				}
				for (int ii = 1; ii <= N; ii++) {
					for (int jj = 1; jj <= N; jj++) {
						System.out.print(map[ii][jj]+" ");
					}
					System.out.println();
				}
			}
			
			int black = 0, white = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					System.out.print(map[i][j]+" ");
					if(map[i][j] == 1) black++;
					else if(map[i][j] == 2) white++;
				}
				System.out.println();
			}
			
			System.out.println("#"+test_case+" "+black+" "+white);
		}
	}

}

//				for(int d=0; d<dr.length; d++) {
//					int temptt = 2;
//					while(true) {
//						nr = pr+dr[d]*temptt;
//						nc = pc+dc[d]*temptt;
//						
//						// 범위 넘거나 건너편 내 돌 아니면(---아무 돌도 없으면) continue
//						if(nr<1 || nr>N || nc<1 || nc>N) { // || map[nr][nc] == 0) {
//							break;
//						}
//	
//						map[nr][nc] = ps; // 사이에 있는 돌 색상
//						temptt++;
//					}
//					
//					for (int r = pr, c = pc; r <= nr && c <= nc; r++, c++) {
//						map[r][c] = ps;
//					}
//					
////					// 사이에 있는 돌 모두 다 색상 변경해야 한다.
////					int tempt = 1;
////					while(true) {
////
////						tr = pr+br[d]*tempt;
////						tc = pc+bc[d]*tempt;
////
////						if(tr<1 || tr>N || tc<1 || tc>N) break;
////						
//////						if(map[tr][tc] != es) continue outer; // 
////						if(map[tr][tc] == 0) continue; // 사이에 놓여진 돌이 없으면 넘긴다.
////						
////						map[tr][tc] = ps; // 적의 돌 색상 변경 
////						
////						tempt++;
//////						break;
////					}
//					
//					
//					for (int ii = 1; ii <= N; ii++) {
//						for (int jj = 1; jj <= N; jj++) {
//							System.out.print(map[ii][jj]+" ");
//						}
//						System.out.println();
//					}
//					
//					break;
//				}