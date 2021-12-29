package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1051. 	숫자 정사각형
 * @author Chaerin Yu
 * 2021.12.29
 */
public class BOJ_1051 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		int min = R > C ? C : R;
		int len = min;
		for (int i = 0; i < R; i++) {
			String temp[] = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		outer: while(len>0) {
			for (int i = 0; i < R; i++) {
				if(i+len > R) break;
				for (int j = 0; j < C; j++) {
					if(j+len > C) break;
					if(map[i][j] == map[i][j+len-1] && map[i][j+len-1] == map[i+len-1][j] && map[i+len-1][j] == map[i+len-1][j+len-1]) {
						break outer;
					}
				}
			}
			
			len--;
		}
		
		System.out.println(len*len);
	}

}
