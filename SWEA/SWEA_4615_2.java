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
	
	// 8방 탐색 -> 처음에는 건너편부터 고려하면 되겠다 생각해서 아래와 같이 변수 선언.. 여기서 부터 잘못됐음을..ㅠ
//	private static int[] dr = {-2, -2, -2,  0, 0,  2, 2, 2};
//	private static int[] dc = {-2,  0,  2, -2, 2, -2, 0, 2};
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
			
			int pr, pc, ps;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(reader.readLine(), " ");
				
				pr = Integer.parseInt(st.nextToken()); // 좌표 row 
				pc = Integer.parseInt(st.nextToken()); // 좌표 column
				ps = Integer.parseInt(st.nextToken()); // 돌(색상)
				
				
				map[pr][pc] = ps; // 내가 지금 턴에 두는 위치
				for (int d = 0; d < br.length; d++) {
					boolean flag = false; // 건너편(+(2+a))에 나와 동일한 색상의 돌이 있는지 구분값
					int tempt = 1;
					int nr, nc;
					while(true) {
						nr = pr+br[d]*tempt;
						nc = pc+bc[d]*tempt;
						
						// map 범위 체크, 현재위치와 건너편 사이에 빈 칸 있으면 안 됨
						if(nr<1 || nr>N || nc<1 || nc>N || map[nr][nc] == 0) { 
							break;
						}
						// 나와 동일한 색상의 돌을 찾으면 break
						if(map[nr][nc] == ps) {
							flag = true;
							break;
						}
						
						tempt++;
					}
					
					// 같은 컬러 만난 경우
					if(flag) {
						int nnr=0, nnc=0;
						// 돌 색상을 현재 순서의 돌 색상과 동일하게 바꿔준다.
						for (int a = 1; a < tempt; a++) {
							nnr = pr+br[d]*a;
							nnc = pc+bc[d]*a;
							map[nnr][nnc] = ps;
						}
					}
				}
			}
			
			int black = 0, white = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j] == 1) black++;
					else if(map[i][j] == 2) white++;
				}
			}
			
			System.out.println("#"+test_case+" "+black+" "+white);
		}
	}

}
