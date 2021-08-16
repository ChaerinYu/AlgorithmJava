package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 조합
 * 3040. 백설 공주와 일곱 난쟁이
 */
public class BOJ_3040_4 {
	
	private static final int DWALF_NUM = 9; // 들어온 난쟁이 수
	private static int[] DWALFS; // 난쟁이

	private static int[] TRUE_DWALFS; // 난쟁이
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		DWALFS = new int[DWALF_NUM];
		for (int i = 0; i < DWALF_NUM; i++) {
			DWALFS[i] = Integer.parseInt(br.readLine());
		}
		
		TRUE_DWALFS = new int[7];
		combination(0, 0);
		
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == 7) {
			int totalSum = 0;
			for (int i = 0; i < TRUE_DWALFS.length; i++) {
				totalSum += TRUE_DWALFS[i];
			}
			if(totalSum == 100) {
				for (int i = 0; i < TRUE_DWALFS.length; i++) {
					System.out.println(TRUE_DWALFS[i]);
				}
			}
			return;
		}
		
		for (int i = start; i < DWALF_NUM; i++) {
			TRUE_DWALFS[cnt] = DWALFS[i];
			combination(cnt+1, i+1);
		}
	}
}
