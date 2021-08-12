package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 3040. 백설 공주와 일곱 난쟁이
 */
public class BOJ_3040 {
	
	private static final int DWALF_NUM = 9; // 들어온 난쟁이 수
	private static int[] DWALFS; // 난쟁이
	
	private static int sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		DWALFS = new int[DWALF_NUM];
		for (int i = 0; i < DWALF_NUM; i++) {
			DWALFS[i] = Integer.parseInt(br.readLine());
			sum += DWALFS[i];
		}
		
		for (int i = 0; i < DWALF_NUM; i++) {
			for (int j = i+1; j < DWALF_NUM; j++) {
				if(sum-100 == DWALFS[i]+DWALFS[j]) {
					DWALFS[i] = 100;
					DWALFS[j] = 100;
				}
			}
		}
		
		for (int i = 0; i < DWALF_NUM; i++) {
			if(DWALFS[i] != 100)
				System.out.println(DWALFS[i]);
		}
	}
}
