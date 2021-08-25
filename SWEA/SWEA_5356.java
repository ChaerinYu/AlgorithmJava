package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_5356 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			char[][] words = new char[5][15];
			
			// char[][] 초기화
			for (int i = 0; i < 5; i++) {
				Arrays.fill(words[i], ' ');
			}
			// 입력
			for (int r = 0; r < 5; r++) {
				char[] row = br.readLine().toCharArray();
				for (int c = 0; c < row.length; c++) {
					words[r][c] = row[c];
				}
			}
			
			// 출력
			System.out.print("#"+tc+" ");
			for (int c = 0; c < 15; c++) {
				for (int r = 0; r < 5; r++) {
					// ' ' 일 때 continue
					if(words[r][c] == ' ') continue;
					System.out.print(words[r][c]);
				}
			}
			System.out.println();
		}
	}

}
