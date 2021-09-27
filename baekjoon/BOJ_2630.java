package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 2630. 색종이 만들기
 * @author Chaerin Yu
 * divide and conquer
 * 하얀색 색종이의 개수를 출력하고, 둘째 줄에는 파란색 색종이의 개수를 출력한다.
 */
public class BOJ_2630 {

	static int N; // 한 변의 길이 2, 4, 8, 16, 32, 64, 128 중 하나
	static int[][] paper; // 색상
	
	static int white, blue; // 0: white, 1: blue
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		
		N = Integer.parseInt(br.readLine()); // 변 길이
		
		// 색상 입력
		paper = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		white = 0;
		blue = 0;
		dc(0, 0, N);
		
		sb.append(white).append("\n");
		sb.append(blue);
		
		System.out.println(sb);
	}
	
	static void dc(int r, int c, int size) {
		int sum = 0;
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				sum += paper[i][j];
			}
		}
		
		if(sum == size*size) {
			// 파란색
			blue++;
		} else if(sum == 0) {
			// 하얀색
			white++;
		} else {
			// 섞인 경우
			dc(r, c, size/2);
			dc(r, c+size/2, size/2);
			dc(r+size/2, c, size/2);
			dc(r+size/2, c+size/2, size/2);
		}
		
		return;
	}
}
