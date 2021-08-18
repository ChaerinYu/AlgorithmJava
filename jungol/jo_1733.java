package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1733. 오목
 * @author user
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1006&sca=99&sfl=wr_subject&stx=%EC%98%A4%EB%AA%A9
 * 1 검정알 2 흰알 0 빈칸
 * 하지만 여섯 알 이상이 연속적으로 놓인 경우에는 이긴 것이 아니다.
 */
public class jo_1733 {

	static int[][] map = new int[20][20];
//	static int[][] d = {{-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}, {0, -1}, {0, 1}};
	static int[][] d = {{1, 0}, {0, 1}, {1, 1}, {-1, 1}}; // 1,1 부터 시작하므로 4가지 경우로 x6만 따진다.
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 바둑알 입력
		StringTokenizer st = null;
		for (int r = 1; r < map.length; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 1; c < map.length; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean flag = false; 
		outerloop:
			for (int r = 1; r < map.length; r++) {
				for (int c = 1; c < map.length; c++) {
				// 바둑알 있는 경우
				if(map[r][c] != 0) {
					int idx = 0;
					deltaLoop: 
					for (int i = 0; i < d.length; i++) {
						for (int j = 1; j < 5; j++) {
							int nr = r+d[i][0]*j, nc = c+d[i][1]*j;
							flag = false;
							// map 벗어나면 안됨
							if(nr<1 || nc< 1 || nr>=20 || nc>=20) continue deltaLoop;
							// 5개 연속으로 같은 색의 바둑알인지?
							if(map[nr][nc] != map[r][c]) continue deltaLoop;
							
							flag = true;
							idx = i;
						}
						if(flag) {
							// 6번째까지 같으면 out
							int lastCheckR = r+d[idx][0]*5, lastCheckC = c+d[idx][1]*5;
							if(lastCheckR>=1 && lastCheckC >= 1 && lastCheckR<20 && lastCheckC<20 
									&& map[lastCheckR][lastCheckC] == map[r][c]) continue;
							lastCheckR = r+d[idx][0]*(-1); lastCheckC = c+d[idx][1]*(-1);
							if(lastCheckR>=1 && lastCheckC >= 1 && lastCheckR<20 && lastCheckC<20 
									&& map[lastCheckR][lastCheckC] == map[r][c]) continue;
							
							// 여기까지 왔으면 6개 온 경우
							sb.append(map[r][c]).append("\n");
							sb.append(r).append(" ").append(c);
							break outerloop;
						}
					}
				}
			}
		}
		if(flag)
			System.out.println(sb);
		else
			System.out.println(0);
	}
}
