package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * [D3] 4615. 재미있는 오셀로 게임
 */
public class SWEA_4615_2 {

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
				map[pr][pc] = ps; // 내가 지금 턴에 두는 위치
				for (int d = 0; d < dr.length; d++) {
					int tempt = 1;
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
//							boolean checked = false;
//							while(temptt!=0 || (nnr==pr && nnc==pc)) {
//								nnr = pr+br[d]*temptt;
//								nnc = pc+bc[d]*temptt;
//								if(map[nnr][nnc] == 0) {
//									checked = true;
//									break;
//								}
//								temptt--;
//							}
//							
//							if(!checked) {
//								temptt = tempt-1;
								while(temptt!=0 || (nnr==pr && nnc==pc)) {
									nnr = pr+br[d]*temptt;
									nnc = pc+bc[d]*temptt;
									map[nnr][nnc] = ps; // 사이 값들은 다 내가 두는 돌 색상과 동일하게 변경한다.
									temptt--;
								}
//							}
						}
						
						tempt++;
					}
				}
//				for (int ii = 1; ii <= N; ii++) {
//					for (int jj = 1; jj <= N; jj++) {
//						System.out.print(map[ii][jj]+" ");
//					}
//					System.out.println();
//				}
			}
			
			int black = 0, white = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
//					System.out.print(map[i][j]+" ");
					if(map[i][j] == 1) black++;
					else if(map[i][j] == 2) white++;
				}
//				System.out.println();
			}
			
			System.out.println("#"+test_case+" "+black+" "+white);
		}
	}

}
