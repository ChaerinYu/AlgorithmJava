package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 1992. 쿼드트리
 * @author Chaerin Yu
 *
 */
public class BOJ_1992 {

	static int N; // 영상 크기
	static char[][] map; // 영상
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 영상 크기
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		divideAndConquer(0, 0, N);
		
		System.out.println(sb.toString());
	}

	private static void divideAndConquer(int r, int c, int size) {
		
		if(size == 1) {
			sb.append(map[r][c]);
			return;
		}
		
		int half = size/2;
		char start = map[r][c];
		
		boolean flag = false;
		outer: 
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(map[i][j] != start) {
					flag = true;
					break outer;
				}
			}
		}
		
		if(flag) {
			sb.append("(");
			divideAndConquer(r, c, half);
			divideAndConquer(r, c+half, half);
			divideAndConquer(r+half, c, half);
			divideAndConquer(r+half, c+half, half);
			sb.append(")");
		} else {
			sb.append(start-'0');
		}
		
		
	}
}
