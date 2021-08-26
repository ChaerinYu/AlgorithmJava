package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * [D3] 7236. 저수지의 물의 총 깊이 구하기
 * @author ChaerinYu
 * 
 */
public class SWEA_7236 {

	// 8방 탐색
	static final int[][] d = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int t = Integer.parseInt(br.readLine()); // test case
		
		int n; // 크기
		char[][] map; // 저수지
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine()); // 저수지 크기
			map = new char[n][n];
			
			for (int r = 0; r < n; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < n; c++) {
					map[r][c] = st.nextToken().charAt(0);
				}
			}
			
			int max = Integer.MIN_VALUE;
			outer:
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					// 물 인 경우, 물 깊이 구하기
					int wNum = 0, gNum = 0;
					if(map[r][c] == 'W') {
						
						for (int i = 0; i < d.length; i++) {
							int nr = r+d[i][0];
							int nc = c+d[i][1];
							// 범위 벗어나면 continue
							if(nr<0 || nc<0 || nr>=n || nc>=n) continue;
							
							if(map[nr][nc]=='W') wNum++;
							else gNum++;
							
						}
						// 주변이 모두 ground일 경우, 물 깊이는 1
						if(gNum == 8) wNum = 1;
						
						max = Math.max(max, wNum);
						// 8개 인 경우가 제일 최대이므로 그냥 for문을 나와버린다.
						if(max==8) break outer;
					}
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
