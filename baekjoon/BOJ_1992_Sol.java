package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1992. 쿼드트리
 * @author user
 *
 */
public class BOJ_1992_Sol {
	
	static int N; // map 크기
	static int[][] map; 
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = row.charAt(j)-'0';
			}
		}

		recursive(0, 0, N);
		System.out.println(sb);
	}
	
	static void recursive(int sr, int sc, int size) {
		if(size == 1) {
			sb.append(map[sr][sc]);
			return;
		}
		
		boolean zero = true, one = true;
		for (int r = sr; r < sr+size; r++) {
			for (int c = sc; c < sc+size; c++) {
				if(map[r][c] != 0) zero = false;
				else one = false;
			}
		}
		
		if(zero) sb.append(0);
		else if(one) sb.append(1);
		else {
			sb.append("(");
			recursive(sr, sc, size/2); // 2사분면
			recursive(sr, sc+size/2, size/2); // 1사분면
			recursive(sr+size/2, sc, size/2); // 3사분면
			recursive(sr+size/2, sc+size/2, size/2); // 4사분면
			sb.append(")");
		}
		return;
	}
	
}
