package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * [D3] 2805. 농작물 수확하기
 * Math.abs 사용
 */
public class SWEA_2805_2 {

	private static int answer; // answer
	
	private static int T; // test case
	private static int N; // FARM SIZE
	private static int[][] farms;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			farms = new int[N][N];
			
			for(int r=0; r<N; r++) {
				String[] temp = br.readLine().split("");
				for(int c=0; c<N; c++) {
					farms[r][c] = Integer.parseInt(temp[c]);
				}
			}
			
			answer = 0;
			for(int r=0; r<N; r++) {
				int temp = (int) Math.abs(N/2-r);
				for(int c=temp; c<N-temp; c++)
					answer += farms[r][c];
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}

}
