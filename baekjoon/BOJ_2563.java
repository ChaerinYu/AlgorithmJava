package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2563. 색종이 
 */
public class BOJ_2563 {
	// 모눈종이
	private static int[][] arr = new int[101][101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 색종이 수
		
		StringTokenizer st = null;
		int[][] papers = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			papers[i][0] = Integer.parseInt(st.nextToken());
			papers[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			int baseX = papers[i][0], baseY = papers[i][1];
			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 10; y++) {
					// 모눈종이에 1x1마다 체크한다.
					arr[baseX+x][baseY+y] = 1;
				}
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if(arr[i][j] == 1) answer++;
			}
		}
		
		System.out.println(answer);
	}

}
