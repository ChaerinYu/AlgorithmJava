package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 10163. 색종이
 * @author user
 *
 */
public class BOJ_10163 {
	
	static final int SIZE = 1000;
	static int[][] paper; // 색종이
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 색종이 수 
		
		StringTokenizer st = null;
		int rMax = 0, cMax = 0;
		paper = new int[SIZE+1][SIZE+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int rSize = Integer.parseInt(st.nextToken());
			int cSize = Integer.parseInt(st.nextToken());
			
			rMax = Math.max(rMax, r+rSize);
			cMax = Math.max(cMax, c+cSize);
			
			for (int j = r; j < r+rSize; j++) {
				for (int k = c; k < c+cSize; k++) {
					paper[j][k] = i;
				}
			}
		}
		
		for (int n = 1; n <= N; n++) {
			int res = 0;
			for (int i = 0; i < rMax; i++) {
				for (int j = 0; j < cMax; j++) {
					if(paper[i][j] == n)
						res++;
				}
			}
			System.out.println(res);
		}
	}
}
