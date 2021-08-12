package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 부분집합
 * 3040. 백설 공주와 일곱 난쟁이
 */
public class BOJ_3040_2 {
	
	private static final int DWALF_NUM = 9; // 들어온 난쟁이 수
	private static int[] DWALFS; // 난쟁이
	private static boolean[] isSelected; // subset 원소 선택/비선택
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		DWALFS = new int[DWALF_NUM];
		for (int i = 0; i < DWALF_NUM; i++) {
			DWALFS[i] = Integer.parseInt(br.readLine());
		}
		
		isSelected = new boolean[DWALF_NUM];
		subset(0);
		
	}
	
	private static void subset(int cnt) {
		if(DWALF_NUM == cnt) {
			int sum = 0; int scnt = 0;
			for (int i = 0; i < cnt; i++) {
				if(isSelected[i]) {
					scnt++;
					sum += DWALFS[i];
				}
			}
			// 7명의 난쟁이와 총 합 100 인지 확인하기
			if(sum == 100 && scnt == 7) {
				for (int j = 0; j < DWALF_NUM; j++) {
					if(isSelected[j]) System.out.println(DWALFS[j]);
				}
			}
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);

		isSelected[cnt] = false;
		subset(cnt+1);
		
	}
}
